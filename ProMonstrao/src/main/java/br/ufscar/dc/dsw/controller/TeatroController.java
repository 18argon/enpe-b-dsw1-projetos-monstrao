package br.ufscar.dc.dsw.controller;

//Java
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Servlet
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Models
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Teatro;
import br.ufscar.dc.dsw.domain.Site;
import br.ufscar.dc.dsw.domain.Promocao;

//DAO's
import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.dao.PromocaoDAO;

//Utils
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/teatros/*")
public class TeatroController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private PromocaoDAO daoPromo;

    Long id_teatro;
    
    @Override
    public void init() {
        daoPromo = new PromocaoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
    	Teatro teatro = (Teatro) request.getSession().getAttribute("teatroLogado");
    	Erro erros = new Erro();
    	    
    	id_teatro = teatro.getId();        	    

    	if (usuario == null) {    		
    		response.sendRedirect(request.getContextPath());
    		return;
    	} else if (!usuario.getPapel().equals("TEATRO")) {    		
    		erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [TEATRO] tem acesso a essa página");
    		request.setAttribute("mensagens", erros);
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    		rd.forward(request, response);
    		return;
    	}
    	
    	 String action = request.getPathInfo();
         if (action == null) {
             action = "";
         }

         try {
             switch (action) {
             	case "/formInsercaoPromo":
             		apresentaFormInsertPromo(request, response);
             		break;
             	case "/inserePromo":
             		insere(request, response);
             		break;
             	case "/formListaPromo":
             		apresentaFormListaPromo(request, response);
             		break;
                 default:
                     apresentaFormIndex(request, response);
                     break;
             }
         } catch (RuntimeException | IOException | ServletException e) {
             throw new ServletException(e);
         }	
    }
    
    private void apresentaFormIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/teatro/index.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormInsertPromo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setAttribute("sites", getSites());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/teatro/insertPromo.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormListaPromo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Promocao> listaPromocoes = daoPromo.getAllIdTeatro(id_teatro);
        request.setAttribute("listaPromocoes", listaPromocoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/teatro/listaPromo.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");      
        
        String nome_peca = request.getParameter("nome_peca");
        Float preco_peca = Float.parseFloat(request.getParameter("preco_peca"));
        String data_peca = request.getParameter("data_peca");                     

        Long id_site = Long.parseLong(request.getParameter("id_site"));
        //Site site = new SiteDAO().get(id_site);

        Promocao promocao = new Promocao(id_teatro, id_site, nome_peca, preco_peca, data_peca);
        
        daoPromo.insert(promocao);
        response.sendRedirect("index");
    }
    
    private Map<Long, String> getSites() {
        Map<Long, String> sites = new HashMap<>();
        for (Site site : new SiteDAO().getAll()) {
            sites.put(site.getId(), site.getNome());
        }
        return sites;
    }
    
    /*private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/teatro/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Teatro teatro = dao.get(id);
        request.setAttribute("teatro", teatro);        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/teatro/formulario.jsp");
        dispatcher.forward(request, response);
    }
       
    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
        List<Teatro> listaTeatros = dao.getAll();
        request.setAttribute("listaTeatros", listaTeatros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/teatro/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //TODO: Precisa de pegar o id da tb_usuário também!
        String cnpj = request.getParameter("cnpj");
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
      
        Teatro teatro = new Teatro(cnpj, nome, cidade);
        dao.insert(teatro);
        response.sendRedirect("lista");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Teatro teatro = new Teatro(id);
        dao.delete(teatro);
        response.sendRedirect("lista");
    }*/
    
}
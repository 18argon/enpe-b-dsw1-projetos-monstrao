package br.ufscar.dc.dsw.controller;

//Java
import java.io.IOException;
import java.util.List;

//Servlet
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Models
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Site;

//DAO's
import br.ufscar.dc.dsw.dao.PromocaoDAO;

//Utils
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/sites/*")
public class SiteController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private PromocaoDAO daoPromo;

    Long id_site;
    
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
    	Site site = (Site) request.getSession().getAttribute("siteLogado");
    	Erro erros = new Erro();
    	
    	id_site = site.getId(); 
    	
    	if (usuario == null) {    		
    		response.sendRedirect(request.getContextPath());
    		return;
    	} else if (!usuario.getPapel().equals("SITE")) {    		
    		erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [SITE] tem acesso a essa página");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/site/index.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormListaPromo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Promocao> listaPromocoes = daoPromo.getAllIdSite(id_site);
        request.setAttribute("listaPromocoes", listaPromocoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/site/listaPromo.jsp");
        dispatcher.forward(request, response);
    }
    
}
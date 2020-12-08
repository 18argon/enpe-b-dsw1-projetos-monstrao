package br.ufscar.dc.dsw.controller;

//Java
import java.io.IOException;

//Servlet
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Models
import br.ufscar.dc.dsw.domain.Usuario;

//DAO's

//Utils
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/admins/*")
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
    	Erro erros = new Erro();
    	
    	if (usuario == null) {    		
    		response.sendRedirect(request.getContextPath());
    		return;
    	} else if (!usuario.getPapel().equals("ADMIN")) {    		
    		erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [ADMIN] tem acesso a essa página");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/index.jsp");
        dispatcher.forward(request, response);
    }
    
}
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
import br.ufscar.dc.dsw.domain.Teatro;

//DAO's
import br.ufscar.dc.dsw.dao.TeatroDAO;

@WebServlet(name = "Index", urlPatterns = { "/indexc.jsp" })
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	
	private TeatroDAO dao;

    @Override
    public void init() {
        dao = new TeatroDAO();
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		if (request.getParameter("l1") != null) {
			switch (request.getParameter("l1")) {
				case ("listaTodos"): {
					List<Teatro> listaTeatros = dao.getAll();
		        	request.setAttribute("listaTeatros", listaTeatros);
		        	RequestDispatcher dispatcher = request.getRequestDispatcher("/listaTeatro.jsp");
		        	dispatcher.forward(request, response);
		        	break;
				}
				case ("listaTodosCidade"): {
		        	break;
				}
			}
	        
		}
		
	}	
}
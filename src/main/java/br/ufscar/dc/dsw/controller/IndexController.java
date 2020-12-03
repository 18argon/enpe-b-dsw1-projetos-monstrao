package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(name = "Index", urlPatterns = { "/index.jsp" })
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("Tem POST\n");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		System.out.print("Tem GET\n");
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		out.println("<html>\r\n"
				+ "<head>\r\n"
				+ "    <meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h2>ProMonstrão</h2>\r\n"
				+ "    <a href=\"./login.jsp\">Login</a> \r\n"
				+ "	\r\n"
				+ "    <button type=\"button\" onclick=\"alert('LISTADO TODOS OS TEATROS!')\">R3: BOTAO DE LISTAR TODOS OS TEATROS (asc Nome)</button>\r\n"
				+ "    <button type=\"button\" onclick=\"alert('LISTADO TODOS OS TEATROS COM CIDADES!')\">R4: BOTAO DE LISTAR TODOS OS TEATROS e Cidades(asc Cidades)</button>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
	}
}
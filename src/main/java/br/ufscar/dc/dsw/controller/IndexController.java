package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(name = "IndexController", urlPatterns = { "/index.jsp", "/logout.jsp" })
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {					
		doGet(request, response);
	}
	
	//login=teste&senha=teste&bOK=Entrar

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {		
			Erro erros = new Erro();
			if (request.getParameter("bOK") != null) {
				String login = request.getParameter("login");
				String senha = request.getParameter("senha");
				if (login == null || login.isEmpty()) {
					erros.add("Login não informado!");
				}
				if (senha == null || senha.isEmpty()) {
					erros.add("Senha não informada!");
				}
				if (!erros.isExisteErros()) {
					System.out.print("Sem erro\n");
					UsuarioDAO dao = new UsuarioDAO();
					Usuario usuario = dao.getbyLogin(login);
					if (usuario != null) {
						System.out.print("Usuário não é null");
						if (usuario.getSenha().equals(senha)) {
							request.getSession().setAttribute("usuarioLogado", usuario);
							if (usuario.getPapel().equals("ADMIN")) {
								response.sendRedirect("admin/");
							}
							if (usuario.getPapel().equals("TEATRO")) {
								response.sendRedirect("teatro/");
							} 
							if (usuario.getPapel().equals("SITE")) {
								response.sendRedirect("site/");
							} 
							return;
						} else {
							System.out.print("Null");
							erros.add("Senha inválida!");
						}
					} else {
						erros.add("Usuário não encontrado!");
					}
				}
			}
			request.getSession().invalidate();
			request.setAttribute("mensagens", erros);
			
			String URL = "/login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(URL);
			rd.forward(request, response);
		}
		catch (Exception e) {
			System.out.print("Tem erro\n");
		}
	}
}
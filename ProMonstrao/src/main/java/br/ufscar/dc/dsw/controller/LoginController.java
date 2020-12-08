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
import br.ufscar.dc.dsw.domain.Teatro;
import br.ufscar.dc.dsw.domain.Site;

//DAO's
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.dao.SiteDAO;

//Utils
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(name = "Login", urlPatterns = { "/logando.jsp", "/logout.jsp" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {			
		doGet(request, response);
	}

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
					UsuarioDAO dao = new UsuarioDAO();
					Usuario usuario = dao.getbyLogin(login);
					if (usuario != null) {
						if (usuario.getSenha().equals(senha)) {
							request.getSession().setAttribute("usuarioLogado", usuario);
							if (usuario.getPapel().equals("ADMIN")) {
								response.sendRedirect("admins/");
							}
							if (usuario.getPapel().equals("TEATRO")) {			
								TeatroDAO teatroDao = new TeatroDAO();
								Teatro teatro = teatroDao.get(usuario.getId());								
								request.getSession().setAttribute("teatroLogado", teatro);
								response.sendRedirect("teatros/");
							} 
							if (usuario.getPapel().equals("SITE")) {
								SiteDAO siteDao = new SiteDAO();
								Site site = siteDao.get(usuario.getId());								
								request.getSession().setAttribute("siteLogado", site);
								response.sendRedirect("sites/");
							} 
							return;
						} else {
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
			System.out.print(e.toString());
		}
		
	}
}
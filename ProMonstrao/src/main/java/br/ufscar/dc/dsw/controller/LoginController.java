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

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
        if (usuarioLogado != null) {
            response.sendRedirect(request.getContextPath());
            return;
        }

        Erro errors = new Erro();

        if (request.getParameter("bOK") != null) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (email == null || email.isEmpty()) {
                errors.add("Login não informado!");
            }
            if (password == null || password.isEmpty()) {
                errors.add("Senha não informada!");
            }
            if (!errors.isExisteErros()) {
                UsuarioDAO dao = new UsuarioDAO();
                Usuario usuario = dao.getByEmail(email);
                if (usuario != null) {
                    if (usuario.getSenha().equals(password)) {
                        request.getSession().setAttribute("usuarioLogado", usuario);
/*
                        if (usuario.getPapel().equals("ADMIN")) {
                            response.sendRedirect("admin/");
                        }
                        if (usuario.getPapel().equals("TEATRO")) {
                            response.sendRedirect("teatro/");
                        }
                        if (usuario.getPapel().equals("SITE")) {
                            response.sendRedirect("site/");
                        }
*/
                        response.sendRedirect(request.getContextPath());
                        return;
                    } else {
                        errors.add("Senha inválida!");
                    }
                } else {
                    errors.add("Usuário não encontrado!");
                }
            }
        }
        request.getSession().invalidate();
        request.setAttribute("mensagens", errors);

        String URL = "/WEB-INF/login.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(URL);
        rd.forward(request, response);
    }

    //login=teste&senha=teste&bOK=Entrar


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");

        if (usuario != null) {
            response.sendRedirect(request.getContextPath());
            return;
        }

        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
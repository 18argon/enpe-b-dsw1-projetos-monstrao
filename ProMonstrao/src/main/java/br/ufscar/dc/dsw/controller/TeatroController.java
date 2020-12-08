package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.domain.Teatro;

@WebServlet(urlPatterns = "/teatro/*")
public class TeatroController extends HttpServlet {

    private static final long serialVersionUID = 1L;


    private TeatroDAO teatroDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        teatroDAO = new TeatroDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("submit") != null) {
            String action = request.getPathInfo();
            action = action != null ? action : "";
            if (action.equals("/cadastrar")) {
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                String nome = request.getParameter("nome");
                String endereco = request.getParameter("cnpj");
                String telefone = request.getParameter("cidade");

                Teatro teatro = teatroDAO.getByEmail(email);
                if (teatro != null) {
                    request.getRequestDispatcher("/WEB-INF/jsp/teatro/cadastrar.jsp")
                            .forward(request, response);
                    return;
                }

                teatro = new Teatro(email, nome, endereco, telefone);
                teatroDAO.insert(teatro, senha);
            } else if (action.equals("/editar")) {
                long id = Long.parseLong(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String cnpj = request.getParameter("cnpj");
                String cidade = request.getParameter("cidade");
                Teatro teatro = new Teatro(id, null, nome, cnpj, cidade);
                teatroDAO.update(teatro);
            }

        }
        response.sendRedirect(request.getContextPath() + "/teatro");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getPathInfo();
        action = action != null ? action : "";

        if (action.equals("") || action.equals("/")) {
            list(request, response);
        } else if (action.equals("/cadastrar")) {
            request.getRequestDispatcher("/WEB-INF/jsp/teatro/cadastrar.jsp")
                    .forward(request, response);
        } else if (action.equals("/editar")) {
            String idParam = request.getParameter("id");
            Long id = parseInt(idParam);
            if (id != null) {
                Teatro teatro = teatroDAO.getById(id);
                if (teatro == null) {
                    redirectToNotFound(request, response);
                }
                request.setAttribute("teatro", teatro);
                request.getRequestDispatcher("/WEB-INF/jsp/teatro/editar.jsp")
                        .forward(request, response);
            } else {
                redirectToNotFound(request, response);
            }
        } else if (action.equals("/deletar")) {
            String idParam = request.getParameter("id");
            Long id = parseInt(idParam);
            if (id != null) teatroDAO.delete(id);
            response.sendRedirect(request.getContextPath() + "/teatro");
        } else {
            redirectToNotFound(request, response);
        }

    }

    private Long parseInt(String param) {
        if (param == null || param.isEmpty()) {
            return null;
        }
        try {
            return Long.parseLong(param);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Teatro> lista = teatroDAO.getAll();
        request.setAttribute("listaTeatros", lista);
        request.getRequestDispatcher("/WEB-INF/jsp/teatro/index.jsp")
                .forward(request, response);
    }

    private void redirectToNotFound(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/not-found.jsp")
                .forward(request, response);
    }
}
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.domain.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/promocao/*"})
public class PromocaoController extends HttpServlet {

    PromocaoDAO promocaoDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        promocaoDAO = new PromocaoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        action = action != null ? action : "";

        if (action.equals("") || action.equals("/")) {
            List<Promocao> lista = promocaoDAO.getAll();
            request.setAttribute("listaPromocao", lista);
            request.getRequestDispatcher("/WEB-INF/jsp/promocao/index.jsp")
                    .forward(request, response);
        } else if (action.equals("/site")) {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
            long idSite = usuario.getId();
            List<Promocao> lista = promocaoDAO.getBySite(idSite);
            request.setAttribute("listaPromocao", lista);
            request.getRequestDispatcher("/WEB-INF/jsp/promocao/site/index.jsp")
                    .forward(request, response);
        } else if (action.equals("/teatro")) {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
            List<Promocao> lista = promocaoDAO.getByTeatro(usuario.getId());
            request.setAttribute("listaPromocao", lista);
            request.getRequestDispatcher("/WEB-INF/jsp/promocao/teatro/index.jsp")
                    .forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/jsp/not-found.jsp")
                    .forward(request, response);
        }
    }
}

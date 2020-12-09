package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.dao.SiteDao;
import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.domain.Site;
import br.ufscar.dc.dsw.domain.Teatro;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.ParamParser;

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
    SiteDao siteDao;
    TeatroDAO teatroDao;

    @Override
    public void init() throws ServletException {
        super.init();
        promocaoDAO = new PromocaoDAO();
        siteDao = new SiteDao();
        teatroDao = new TeatroDAO();
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
        } else if (action.equals("/site/cadastrar")) {
            List<Teatro> teatros = teatroDao.getAll();
            request.setAttribute("teatros", teatros);
            request.getRequestDispatcher("/WEB-INF/jsp/promocao/site/cadastrar.jsp")
                    .forward(request, response);
        } else if (action.equals("/teatro")) {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
            List<Promocao> lista = promocaoDAO.getByTeatro(usuario.getId());
            request.setAttribute("listaPromocao", lista);
            request.getRequestDispatcher("/WEB-INF/jsp/promocao/teatro/index.jsp")
                    .forward(request, response);
        } else if (action.equals("/teatro/cadastrar")) {
            List<Site> sites = siteDao.getAll();
            request.setAttribute("sites", sites);
            request.getRequestDispatcher("/WEB-INF/jsp/promocao/teatro/cadastrar.jsp")
                    .forward(request, response);
        } else if (action.equals("/site/deletar")) {
            String idParam = request.getParameter("id");
            Long id = ParamParser.parseLong(idParam);
            if (id != null) promocaoDAO.delete(id);
            response.sendRedirect(request.getContextPath() + "/promocao/site");
        } else if (action.equals("/teatro/deletar")) {
            String idParam = request.getParameter("id");
            Long id = ParamParser.parseLong(idParam);
            if (id != null) promocaoDAO.delete(id);
            response.sendRedirect(request.getContextPath() + "/promocao/teatro");
        } else if (action.equals("/site/editar")) {
            String idParam = request.getParameter("id");
            Long id = ParamParser.parseLong(idParam);
            if (id != null) {
                Promocao promocao = promocaoDAO.getById(id);
                if (promocao == null) {
                    redirectToNotFound(request, response);
                    return;
                }

                List<Teatro> teatros = teatroDao.getAll();
                request.setAttribute("promocao", promocao);
                request.setAttribute("teatros", teatros);

                request.getRequestDispatcher("/WEB-INF/jsp/promocao/site/editar.jsp")
                        .forward(request, response);
            } else {
                redirectToNotFound(request, response);
            }
        } else if (action.equals("/teatro/editar")) {
            String idParam = request.getParameter("id");
            Long id = ParamParser.parseLong(idParam);
            if (id != null) {
                Promocao promocao = promocaoDAO.getById(id);
                if (promocao == null) {
                    redirectToNotFound(request, response);
                    return;
                }
                List<Site> sites = siteDao.getAll();

                request.setAttribute("promocao", promocao);
                request.setAttribute("sites", sites);

                request.getRequestDispatcher("/WEB-INF/jsp/promocao/teatro/editar.jsp")
                        .forward(request, response);
            } else {
                redirectToNotFound(request, response);
            }
        } else {
            request.getRequestDispatcher("WEB-INF/jsp/not-found.jsp")
                    .forward(request, response);
        }
    }

    private void redirectToNotFound(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/not-found.jsp")
                .forward(request, response);
    }
}

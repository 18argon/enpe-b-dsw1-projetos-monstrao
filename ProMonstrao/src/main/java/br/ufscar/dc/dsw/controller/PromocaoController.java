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
import java.util.ArrayList;
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
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
            long idSite = usuario.getId();
            List<Promocao> lista = new ArrayList<>();
            if (usuario.getPapel().equals("SITE")) {
                lista = promocaoDAO.getBySite(idSite);
            } else if (usuario.getPapel().equals("TEATRO")) {
                lista = promocaoDAO.getByTeatro(idSite);
            }
            request.setAttribute("listaPromocao", lista);
            request.getRequestDispatcher("/WEB-INF/jsp/promocao/index.jsp")
                    .forward(request, response);
        } else if (action.equals("/cadastrar")) {
            List<Site> sites = siteDao.getAll();
            request.setAttribute("sites", sites);
            request.getRequestDispatcher("/WEB-INF/jsp/promocao/cadastrar.jsp")
                    .forward(request, response);
        } else {
            redirectToNotFound(request, response);
        }
    }

    private void redirectToNotFound(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/not-found.jsp")
                .forward(request, response);
    }
}

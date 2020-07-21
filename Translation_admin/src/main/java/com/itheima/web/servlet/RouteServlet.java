package com.itheima.web.servlet;

import com.github.pagehelper.PageInfo;
import com.itheima.Service.Impl.RouteServiceImpl;
import com.itheima.Service.RouteService;
import com.itheima.entity.Route;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();

    protected void listByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strpage = request.getParameter("page");
        if (strpage == null) {
            strpage = "1";
        }
        int page = Integer.parseInt(strpage);
        String rname = request.getParameter("rname");
        PageInfo PageBean = routeService.findListByPage(page, rname);
        request.setAttribute("PageBean", PageBean);
        request.setAttribute("rname", rname);
        request.getRequestDispatcher("/pages/route/route_list.jsp").forward(request, response);
    }

    protected void delRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        routeService.deleteByRid(rid);
        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }
}

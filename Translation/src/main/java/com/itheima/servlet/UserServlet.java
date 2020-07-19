package com.itheima.servlet;

import com.itheima.entity.User;
import com.itheima.exception.CustomerErrorMsgException;
import com.itheima.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends BaseServlet {
    private UserService service=new UserService();

    /**
     * 退出的方法  点击退出销毁会话域session 然后重定向到首页
     * @param request
     * @param response
     * @throws IOException
     */
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    /**
     * 改变登陆头的信息
     * @param request
     * @param response
     */
    private void getLoginUserData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user !=null){
            String name = user.getName();
            out.print(name);
        }else {
            out.print("none");
        }
    }

    /**
     * 登录页面的servlet
     * @param request
     * @param response
     * @throws IOException
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String vcode = (String) session.getAttribute("vcode");
        String check = request.getParameter("check");
        session.removeAttribute("vocde");
        if(!check.equals(vcode)){
            out.print("验证码错误");
            session.removeAttribute("vocde");
        }else {//否则验证码正确然后调用service层的login
            try {
                User user = service.login(username, password);
                session.setAttribute("user",user);//把用户的信息传入
                out.print("success");
            } catch (CustomerErrorMsgException e) {
                String message = e.getMessage();//获取message
                out.print(message);
            }
        }
    }


    /**
     * 注册页面的servlet
     * @param request
     * @param response
     * @throws IOException
     */
    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain;charset=utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        //获取的是验证码里面的值
        String vcode = (String) session.getAttribute("vcode");//网页的验证码
        String check = request.getParameter("check");//用户输入的验证码
        session.removeAttribute("vcode");
        if (!check.equalsIgnoreCase(vcode)){
            //如果不相同返回失败
            out.print("验证失败");
        }else {
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            int row = service.register(user);
            if(row>0){
                out.print("success");
            }else {
                out.print("注册失败,请重试");
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

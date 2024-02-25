package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);

        if (session==null || session.getAttribute("user")==null){
            response.sendRedirect("/login.jsp");
        }
        else{
            response.sendRedirect("/user/hello.jsp");
        }
    }

    @Override
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");

        for (int i = 0; i < Users.getInstance().getUsers().size(); i++) {
            if (Users.getInstance().getUsers().get(i).equals(login) && !password.isEmpty()){
                HttpSession httpSession = httpServletRequest.getSession();
                httpSession.setAttribute("user", login);
                httpServletResponse.sendRedirect("/user/hello.jsp");
            }else {
                httpServletRequest.setAttribute("error", "Invalid login or password");
                httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
            }
        }

    }

}

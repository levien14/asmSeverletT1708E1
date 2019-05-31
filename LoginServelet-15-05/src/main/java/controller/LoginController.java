package controller;

import entity.Student;
import model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("loggedUser") == null){
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        StudentModel studentModel = new StudentModel();
        System.out.println(username + " : " + password);

        if (studentModel.checkLogin(username,password)){
            HttpSession session = req.getSession();
            session.setAttribute("loggedUser",username);
            ArrayList<Student> studentArrayList = studentModel.findAll();
            session.setAttribute("ListStudent", studentArrayList);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);

        }else{
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}

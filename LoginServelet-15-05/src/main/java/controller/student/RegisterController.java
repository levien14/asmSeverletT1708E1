package controller.student;

import entity.student.Student;
import model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        StudentModel studentModel = new StudentModel();
        student.setRollnumber(req.getParameter("rollnumber"));
        student.setFullname(req.getParameter("fullname"));
        student.setGender(Integer.parseInt(req.getParameter("gender")));
        student.setIdCard(req.getParameter("idCard"));
        student.setDob(req.getParameter("dob"));
        student.setPhonenumber(req.getParameter("phoneNumber"));
        student.setEmail(req.getParameter("email"));
        student.setStatus(Integer.parseInt(req.getParameter("status")) );
        student.setAddress(req.getParameter("address"));
        System.out.println(student.getEmail());
        if (studentModel.register(student)){
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else {
            resp.getWriter().println("Not register");
        }
    }
}

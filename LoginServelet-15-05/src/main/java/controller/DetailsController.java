package controller;

import entity.Student;
import model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentModel studentModel = new StudentModel();
        Student student = new Student();
        String rollnumber = req.getParameter("detailsRollNumber");
        student  = studentModel.findByID(rollnumber);

        if (student != null){
            req.setAttribute("detailsStudentInfor",student);
            req.getRequestDispatcher("/details.jsp").forward(req,resp);
        }else{
            resp.getWriter().println("Sinh vien nay hien tai ko co");
        }
    }
}

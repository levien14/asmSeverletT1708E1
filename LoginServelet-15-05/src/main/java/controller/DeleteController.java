package controller;

import entity.Student;
import model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteController extends HttpServlet {
    StudentModel studentModel = new StudentModel();
    Student student = new Student();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        student = studentModel.findByID(req.getParameter("deleteRollNumber"));

        if (student != null){
            req.setAttribute("deleteStudentInfor",student);
            req.getRequestDispatcher("/delete.jsp").forward(req,resp);
        }else{
            System.out.println("SV" + req.getParameter("deleteRollNumber") + " Khong ton tai");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        student.setRollnumber(req.getParameter("deleteRollNumber"));

        if (studentModel.delete(student)){
            resp.getWriter().println("Delete ok");
        }else {
            resp.getWriter().println("delete khong thanh cong.");
        }
    }
}

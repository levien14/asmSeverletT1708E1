package controller.student;

import entity.student.Student;
import model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditController extends HttpServlet {
    StudentModel studentModel = new StudentModel();
    Student student = new Student();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rollnumber = req.getParameter("editRollNumber");
        student  = studentModel.findByID(rollnumber);

        if (student != null){
            req.setAttribute("editStudentInfor",student);
            req.getRequestDispatcher("/studentView/edit.jsp").forward(req,resp);
        }else{
            resp.getWriter().println("Sinh vien nay hien tai ko co");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        student.setRollnumber(req.getParameter("rollNumber"));
        student.setFullname(req.getParameter("fullname"));
        student.setDob(req.getParameter("dob"));
        student.setEmail(req.getParameter("email"));
        student.setAddress(req.getParameter("address"));
        student.setPhonenumber(req.getParameter("phonenumber"));
        student.setIdCard(req.getParameter("idcard"));
        student.setGender(Integer.parseInt(req.getParameter("gender")));
        student.setStatus(Integer.parseInt(req.getParameter("status")));
        student.setMediumScore(Float.parseFloat(req.getParameter("medium")));
        //student.setStatus(Student.Status.STUDYING);
        if (studentModel.update(student)){
            resp.getWriter().println("Ok");
        }else{
            resp.getWriter().println("Not Ok");
        }


    }
}

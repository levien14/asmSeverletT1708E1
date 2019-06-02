package controller.subject;

import entity.subject.SubjectInfor;
import model.SubjectModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterSubjectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("subject_id"));
        req.getRequestDispatcher("/subjectView/register-subject.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubjectModel subjectModel = new SubjectModel();

        SubjectInfor subjectInfor = new SubjectInfor();
        subjectInfor.setId(req.getParameter("subjectID"));
        subjectInfor.setName(req.getParameter("subjectName"));
        subjectInfor.setStatus(Integer.parseInt(req.getParameter("subjectStatus")));

        if (subjectModel.register(subjectInfor)){
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/subjectView/register-subject.jsp").forward(req,resp);
        }

    }
}

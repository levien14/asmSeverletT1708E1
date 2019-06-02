package controller.subject;

import entity.subject.SubjectInfor;
import model.StudentModel;
import model.SubjectModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/subject/edit")
public class EditController extends HttpServlet {
    SubjectModel subjectModel = new SubjectModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id= req.getParameter("subject_id");
        SubjectInfor subjectInfor =  subjectModel.findSubjectById(id);
        HttpSession session = req.getSession();
        session.setAttribute("subject_edit",subjectInfor);
        req.getRequestDispatcher("/subjectView/edit-subject.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubjectInfor subjectInfor = new SubjectInfor();
        System.out.println(req.getParameter("status_subject"));
        subjectInfor.setId(req.getParameter("id_subject"));
        subjectInfor.setName(req.getParameter("name_subject"));
        subjectInfor.setStatus(Integer.parseInt(req.getParameter("status_subject")));

        if (subjectModel.editSubject(subjectInfor)){
            req.getRequestDispatcher("/subjectView/list-subject.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/subjectView/edit-subject.jsp").forward(req,resp);
        }

    }
}

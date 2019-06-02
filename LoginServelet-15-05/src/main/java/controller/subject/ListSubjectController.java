package controller.subject;

import entity.subject.SubjectInfor;
import model.SubjectModel;

import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/subject/list")
public class ListSubjectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubjectModel subjectModel = new SubjectModel();
        ArrayList<SubjectInfor> inforArrayList  = subjectModel.findAllSubject();
        HttpSession  session = req.getSession();
        session.setAttribute("list_subject",inforArrayList);
        req.getRequestDispatcher("/subjectView/list-subject.jsp").forward(req,resp);
    }
}

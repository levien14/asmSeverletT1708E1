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

@WebServlet(urlPatterns = "/subject/delete")
public class DeleteController extends HttpServlet {
    SubjectModel subjectModel = new SubjectModel();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id= req.getParameter("subject_id");

        if (subjectModel.deleteSubject(id)){
            req.getRequestDispatcher("/subjectView/list-subject.jsp").forward(req,resp);
        }else {
            resp.getWriter().println("Not Oke");
        }

    }


}

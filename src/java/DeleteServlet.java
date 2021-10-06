
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //kanw allagh typou apo string se int dioti apo to html page pernw string kai h bash exei int 
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        BooksDao.delete(id);
        response.sendRedirect("ViewServlet");
    }

}

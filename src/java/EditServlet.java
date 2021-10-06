
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Update Book</h1>");
        //kanw allagh typou apo string se int dioti apo to html page pernw string kai h bash exei int 
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        Books books = BooksDao.getBooksById(id);

        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='" + books.getID() + "'/></td></tr>");
        out.print("<tr><td>Title:</td><td><input type='text' name='Title' value='" + books.getTitle() + "'/></td></tr>");
        out.print("<tr><td>Author:</td><td><input type='text' name='Author' value='" + books.getAuthor() + "'/></td></tr>");
        out.print("<tr><td>Stock:</td><td><input type='int' name='Stock' value='" + books.getStock() + "'/></td></tr>");
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }

}

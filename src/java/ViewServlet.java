
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<a href='index.html'>Add New Book Entry</a>");
        out.println("<h1>Books List</h1>");

        List<Books> list = BooksDao.getAllBooks();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>ID</th><th>Title</th><th>Author</th><th>Stock</th><th>Edit</th><th>Delete</th></tr>");

        for (Books e : list) {
            out.print("<tr><td>"
                    + e.getID() + "</td><td>"
                    + e.getTitle() + "</td><td>"
                    + e.getAuthor() + "</td><td>"
                    + e.getStock() + "</td><td><a href='EditServlet?id="
                    + e.getID() + "'>edit</a></td><td><a href='DeleteServlet?id="
                    + e.getID() + "'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();
    }
}


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //kanw allagh typou apo string se int dioti apo to html page pernw string kai h bash exei int 
        String sid = request.getParameter("ID");
        int ID = Integer.parseInt(sid);
        out.println("<a href='index.html'>Add New Book Entry</a>");
        out.println("<h1>Books List</h1>");

        Books books = BooksDao.getBooksById(ID);
        out.print("<table border='1' width='80%'");
        out.print("<tr><th>ID</th><th>Title</th><th>Author</th><th>Stock</th></tr>");
        out.print("<tr><td>"
                + books.getID() + "</td><td>"
                + books.getTitle() + "</td><td>"
                + books.getAuthor() + "</td><td>"
                + books.getStock() + "</tr>");
        out.close();

    }
}

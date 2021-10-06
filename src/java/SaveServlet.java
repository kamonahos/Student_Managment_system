
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String sID = request.getParameter("ID");
        String Title = request.getParameter("Title");
        String Author = request.getParameter("Author");
        String sStock = request.getParameter("Stock");
        int Stock = Integer.parseInt(sStock);
        int ID = Integer.parseInt(sID);

        Books books = new Books();
        books.setID(ID);
        books.setTitle(Title);
        books.setAuthor(Author);
        books.setStock(Stock);

        int status = BooksDao.save(books);
        if (status > 0) {
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        } else {
            out.println("Sorry! unable to save record");
        }
        out.close();
    }

}

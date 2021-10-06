
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //kanw allagh typou apo string se int dioti apo to html page pernw string kai h bash exei int kai sto id kai sto stock
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        String sStock = request.getParameter("Stock");
        int Stock = Integer.parseInt(sStock);

        String Title = request.getParameter("Title");
        String Author = request.getParameter("Author");

        Books books = new Books();
        books.setID(id);
        books.setTitle(Title);
        books.setAuthor(Author);
        books.setStock(Stock);

        int status = BooksDao.update(books);
        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("Sorry! unable to update record");
        }

        out.close();
    }
}

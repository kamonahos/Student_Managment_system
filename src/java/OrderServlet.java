
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//kanw allagh typou apo string se int dioti apo to html page pernw string kai h bash exei int 
        String sid = request.getParameter("ID");
        int ID = Integer.parseInt(sid);
//dhmioyrgw mia metablhth sCopies p pernaw afou allaxw typo se int thn timh Copies (pou einai o arithmos antitupwn p thelei o pelaths sthn Order.html)
        String sCopies = request.getParameter("Copies");
        int Copies = Integer.parseInt(sCopies);

        out.println("<a href='index.html'>Add New Book Entry</a>");
        out.println("<h1>Books List</h1>");

        int avCopies = 0;
//pernaw sthn metablhth avCopies thn timh Stock tou sugekrimenou bibliou bash ID
        Books books = BooksDao.getBooksById(ID);
        avCopies = books.getStock();
        books.getTitle();
        books.getAuthor();
        //kanw elegxo an yparxei apothema
        if ((avCopies - Copies) >= 0) {
            out.println("order ok");
            books.setStock(avCopies - Copies);
            int status = BooksDao.update(books);
            if (status > 0) {
                response.sendRedirect("ViewServlet");
            } else {
                out.println("Sorry! unable to update record");
            }
        } else {
            out.println("No stock available");
        }

        out.close();

    }
}

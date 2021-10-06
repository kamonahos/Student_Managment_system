
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDao {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //3. Create the connection
            //Use your dbname, dbusername and password
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "kamonahos", "root");
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return con;
    }

    //dhmiourgw tiw methodous pou tha kalesw sta upoloipa servlets etsi wste h epikoinwnia na ginei apo to BooksDao servlet mono
    public static int save(Books books) {
        int status = 0;
        Connection con = BooksDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Books(ID, Title, Author, Stock) VALUES (?, ?, ?, ?)");
            ps.setInt(1, books.getID());
            ps.setString(2, books.getTitle());
            ps.setString(3, books.getAuthor());
            ps.setInt(4, books.getStock());
            status = ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
        return status;
    }

    public static int update(Books books) {
        int status = 0;
        Connection con = BooksDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Books SET Title=?, Author=?, Stock=? WHERE ID=?");
            ps.setString(1, books.getTitle());
            ps.setString(2, books.getAuthor());
            ps.setInt(3, books.getStock());
            ps.setInt(4, books.getID());
            status = ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        Connection con = BooksDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM books WHERE id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
        return status;
    }

    public static Books getBooksById(int ID) {
        Books books = new Books();
        Connection con = BooksDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE ID=?");
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                books.setID(rs.getInt(1));
                books.setTitle(rs.getString(2));
                books.setAuthor(rs.getString(3));
                books.setStock(rs.getInt(4));
            }
            con.close();
        } catch (SQLException ex) {
        }
        return books;
    }

    public static List<Books> getAllBooks() {
        List<Books> list = new ArrayList<>();
        Connection con = BooksDao.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Books WHERE Stock<>0");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Books books = new Books();
                books.setID(rs.getInt(1));
                books.setTitle(rs.getString(2));
                books.setAuthor(rs.getString(3));
                books.setStock(rs.getInt(4));
                list.add(books);
            }
            con.close();
        } catch (SQLException ex) {

        }
        return list;
    }

}


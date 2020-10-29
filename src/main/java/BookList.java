import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/BookList")
public class BookList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            ResultSet bookSet = ExecuteQuery.exeQuery("select * from books");

            ArrayList<Book> bookList = new ArrayList<>();
            while(bookSet.next()){
                Book temp = new Book();
                temp.setIsbn(bookSet.getInt(1));
                temp.setName(bookSet.getString(2));
                temp.setAuthor(bookSet.getString(3));
                temp.setAmount(bookSet.getInt(4));
                bookList.add(temp);
            }

            request.setAttribute("resultset",bookList);
            request.getRequestDispatcher("/book-list.jsp").forward(request, response);


        } catch (Exception e) {
            System.out.println("User.java [Error] Exception");
            e.printStackTrace();
        }

    }
}

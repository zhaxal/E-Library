import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/ChangeBook")
public class ChangeBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String bookName = null;
            bookName = request.getParameter("bookName");
            String author = null;
            author = request.getParameter("author");
            String amount = null;
            amount = request.getParameter("amount");

            HttpSession session = request.getSession();
            int isbn = Integer.parseInt(request.getParameter("id"));
            int user_id = (int) session.getAttribute("id");
            ResultSet set = ExecuteQuery.exeQuery("select * from books where isbn="+isbn);

            while(set.next()){
                session.setAttribute("isbn",isbn);
                session.setAttribute("bookName",set.getString(2));
                session.setAttribute("author",set.getString(3));
                session.setAttribute("amount",set.getString(4));
            }
            if (bookName != null || author != null || amount != null){
                if (bookName != ""){
                    UpdateQuery.updQuery("update books set name='"+bookName+"' where isbn="+isbn);
                }

                if (author != ""){
                    UpdateQuery.updQuery("update books set author='"+author+"' where isbn="+isbn);
                }

                if (amount != ""){
                    UpdateQuery.updQuery("update books set amount='"+amount+"' where isbn="+isbn);
                }
                response.sendRedirect("BookList");
            }else{
                request.getRequestDispatcher("/book-change.jsp").forward(request, response);
            }


        } catch (Exception e) {
            System.out.println("User.java [Error] Exception");
            e.printStackTrace();
        }
    }
}

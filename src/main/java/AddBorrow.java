import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/AddBorrow")
public class AddBorrow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            int isbn = Integer.parseInt(request.getParameter("id"));
            int user_id = (int) session.getAttribute("id");
            ResultSet set = ExecuteQuery.exeQuery("select * from books where isbn="+isbn);
            ResultSet borrowSet = ExecuteQuery.exeQuery("select * from borrow where isbn='"+isbn+"' and user_id="+user_id);
            if(!borrowSet.next()) {
                Book temp = new Book();
                while (set.next()) {

                    temp.setName(set.getString(2));
                    temp.setAuthor(set.getString(3));
                    temp.setAmount(set.getInt(4));

                }
                int amount = temp.amount;
                if (amount > 0) {
                    amount = amount - 1;
                    UpdateQuery.updQuery("update books set amount='" + amount + "' where isbn=" + isbn);

                    UpdateQuery.updQuery("insert into borrow(`isbn`,`name`,`author`,`user_id`) values('" + isbn + "','" + temp.name + "','" + temp.author + "','" + user_id + "')");
                    response.sendRedirect("BookList");
                }
            }else{
                response.sendRedirect("BookList");
            }
        } catch (Exception e) {
            System.out.println("User.java [Error] Exception");
            e.printStackTrace();
        }
    }
}

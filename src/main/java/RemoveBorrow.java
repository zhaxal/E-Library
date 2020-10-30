import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/RemoveBorrow")
public class RemoveBorrow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            int isbn = Integer.parseInt(request.getParameter("id"));
            int user_id = (int) session.getAttribute("id");
            ResultSet set = ExecuteQuery.exeQuery("select * from books where isbn="+isbn);
            int amount = 0;
            while(set.next()){
                amount = set.getInt(4);
            }
            amount = amount + 1;
            UpdateQuery.updQuery("update books set amount='"+amount+"' where isbn="+isbn);
            UpdateQuery.updQuery("delete from borrow where isbn='"+isbn+"' and user_id="+user_id);
            response.sendRedirect("Borrow");


        } catch (Exception e) {
            System.out.println("User.java [Error] Exception");
            e.printStackTrace();
        }
    }
}

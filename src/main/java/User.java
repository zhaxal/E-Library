import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/User")
public class User extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession(false);
        int id;
        System.out.println(request.getParameter("id")+" user_id");
        if(request.getParameter("id")!= null){
            id = Integer.parseInt(request.getParameter("id"));
        }else{
            id = (int) session.getAttribute("id");
        }
            session.setAttribute("id_user",id);

        try {

            ResultSet user_detail = ExecuteQuery.exeQuery("SELECT * FROM user WHERE id='" + id + "'");
            while (user_detail.next()) {
                session.setAttribute("username2", user_detail.getString(2));
                session.setAttribute("name2", user_detail.getString(3));
                session.setAttribute("email2", user_detail.getString(4));
            }


            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("User.java [Error] Exception");
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/ChangeUser")
public class ChangeUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = null;
            username = request.getParameter("username");
            String name = null;
            name = request.getParameter("name");
            String email = null;
            email = request.getParameter("email");


            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));
            ResultSet set = ExecuteQuery.exeQuery("select * from user where id="+id);

            while(set.next()){
                session.setAttribute("id1",id);
                session.setAttribute("username1",set.getString(2));
                session.setAttribute("name1",set.getString(3));
                session.setAttribute("email1",set.getString(4));
            }
            if (username != null || name != null || email != null){
                if (username != ""){
                    UpdateQuery.updQuery("update user set name='"+username+"' where id="+id);
                }

                if (name != ""){
                    UpdateQuery.updQuery("update user set name='"+name+"' where id="+id);
                }

                if (email != ""){
                    UpdateQuery.updQuery("update user set email='"+email+"' where id="+id);
                }
                response.sendRedirect("UserList");
            }else{
                request.getRequestDispatcher("/user-change.jsp").forward(request, response);
            }


        } catch (Exception e) {
            System.out.println("User.java [Error] Exception");
            e.printStackTrace();
        }
    }
}

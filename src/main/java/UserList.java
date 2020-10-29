import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/UserList")
public class UserList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            ResultSet userSet = ExecuteQuery.exeQuery("select * from user");

            ArrayList<Users> userList = new ArrayList<>();
            while(userSet.next()){
                Users temp = new Users();
                temp.setId(userSet.getInt(1));
                temp.setUsername(userSet.getString(2));
                temp.setName(userSet.getString(3));
                temp.setEmail(userSet.getString(4));
                temp.setPassword(userSet.getString(5));
                temp.setIsAdmin(userSet.getInt(6));
                userList.add(temp);
            }

            request.setAttribute("resultset",userList);
            request.getRequestDispatcher("/user-list.jsp").forward(request, response);


        } catch (Exception e) {
            System.out.println("User.java [Error] Exception");
            e.printStackTrace();
        }

    }
}

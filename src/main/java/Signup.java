import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet("/Signup")
public class Signup extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            String username_checkq = "select * from user where username='" + username + "'";
            ResultSet username_checkrs = ExecuteQuery.exeQuery(username_checkq);
            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                request.setAttribute("error", "true");
                request.setAttribute("error_msg", "Please fill all the fields");
                doGet(request, response);
            } else if (username_checkrs.next()) {
                request.setAttribute("error", "true");
                request.setAttribute("error_msg", "Username already exists");
                doGet(request, response);
            } else {
                String s = "insert into user(`id`, `username`, `name`, `email`, `password_hash`, `isAdmin`) values(NULL,'" + username + "','" + name + "','" + email + "','" + password + "','"+0+"')";
                out.print(s);
                int i = UpdateQuery.updQuery(s);
                if (i > 0) {
                    String str = "SELECT id FROM user ORDER BY id DESC LIMIT 1";
                    ResultSet user_idrs = ExecuteQuery.exeQuery(str);
                    user_idrs.first();
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("id", user_idrs.getInt(1));
                    session.setAttribute("name", name);
                    session.setAttribute("login", "true");
                    response.sendRedirect("User");
                }
            }
        } catch (Exception e) {
            System.out.println("Signup.java [Error] Exception");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/user-signup.jsp");
        rd.forward(request, response);
    }



}

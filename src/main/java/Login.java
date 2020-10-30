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

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.print(request.getAttribute("error") + "else");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            String check = "select * from user where username='" + username + "' and password_hash='" + password + "'";
            ResultSet login_check = ExecuteQuery.exeQuery(check);
            if (login_check.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("id", login_check.getInt(1));
                session.setAttribute("name", login_check.getString(3));
                session.setAttribute("login", "true");
                session.setAttribute("email",login_check.getString(4));
                session.setAttribute("isAdmin",login_check.getInt(6));
                response.sendRedirect("User");
            } else {
                System.out.println("error");
                request.setAttribute("error", "true");
                request.setAttribute("error_msg", "Invalid username/password");
                doGet(request, response);
            }
        } catch (Exception e) {
            System.out.println("Login.java [Error] Exception");
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.print(request.getAttribute("error") + "get");

        RequestDispatcher rd = request.getRequestDispatcher("/user-login.jsp");
        rd.forward(request, response);
    }
}

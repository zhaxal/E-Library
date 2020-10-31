import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/Borrow")
public class Borrow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            int id;
            if(request.getParameter("id")!= null){
                id = Integer.parseInt(request.getParameter("id"));
            }else{
                id = (int) session.getAttribute("id");
            }

            ResultSet bookSet = ExecuteQuery.exeQuery("select * from borrow where user_id="+id);

            ArrayList<Book> bookList = new ArrayList<>();
            while(bookSet.next()){
                Book temp = new Book();
                temp.setIsbn(bookSet.getInt(1));
                temp.setName(bookSet.getString(2));
                temp.setAuthor(bookSet.getString(3));
                bookList.add(temp);
            }

            request.setAttribute("resultset",bookList);
            request.getRequestDispatcher("/borrow-list.jsp").forward(request, response);


        } catch (Exception e) {
            System.out.println("User.java [Error] Exception");
            e.printStackTrace();
        }
    }
}

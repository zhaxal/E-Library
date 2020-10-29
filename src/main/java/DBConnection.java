import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    public static Connection createConnection() {
        Connection con = null;



        driver= "com.mysql.jdbc.Driver";

        url= "jdbc:mysql://localhost/assignment3";

        user= "root";

        password= "aserty1234";


        try {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                System.out.println("DBConnection.java [Error] unable to load driver class!");
                System.exit(1);
            }
            con = DriverManager.getConnection(url, user, password);
            System.out.println("DBConnection.java [Info] Connection successful");
        } catch (SQLException sqe) {
            System.out.println("DBConnection.java [Error] While Creating connection to database");
            sqe.printStackTrace();
        }
        return con;
    }



}



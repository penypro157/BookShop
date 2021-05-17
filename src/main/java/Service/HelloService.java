package Service;

import Repository.EntityManagerHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@ManagedBean(name = "helloService")
@RequestScoped
public class HelloService {

    private String DB_URL = "jdbc:sqlserver://localhost:1434;"
            + "databaseName=BookShop;";
    private String USER_NAME = "huyledeptrai";
    private String PASSWORD = "123456";

    public String convert(String input) {
        try {
        EntityManagerFactory emf = EntityManagerHelper.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            if(em.isOpen()){
                System.out.println("DMM");
            } 
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            if(conn.isValid(2)){
            System.out.println("is opened");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "";
        }
        return "HELLO: " + input.toUpperCase();
    }

    public static Connection getSQLServerConnection()
            throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "simplehr";
        String userName = "sa";
        String password = "1234";

        return getSQLServerConnection(hostName, sqlInstanceName,
                database, userName, password);
    }

    // Trường hợp sử dụng SQLServer.
    // Và thư viện SQLJDBC.
    public static Connection getSQLServerConnection(String hostName,
            String sqlInstanceName, String database, String userName,
            String password) throws ClassNotFoundException, SQLException {
        // Khai báo class Driver cho DB SQLServer
        // Việc này cần thiết với Java 5
        // Java6 tự động tìm kiếm Driver thích hợp.
        // Nếu bạn dùng Java6, thì ko cần dòng này cũng được.
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // Cấu trúc URL Connection dành cho SQLServer
        // Ví dụ:
        // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
                + ";instance=" + sqlInstanceName + ";databaseName=" + database;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}

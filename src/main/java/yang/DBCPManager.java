package yang;

import com.yang.model.Book;
import org.apache.commons.dbcp.BasicDataSource;
import java.sql.*;

public class DBCPManager {

    static private DBCPManager instance; // 唯一实例
    static private BasicDataSource ds = new BasicDataSource();

    private DBCPManager() {
        ds = setupDataSource();
    }

    private static BasicDataSource setupDataSource() {
        try {
            ds.setDriverClassName("com.mysql.jdbc.Driver");
            ds.setUrl("jdbc:mysql://localhost:3306/BOOKSHELF");
            ds.setUsername("yang");
            ds.setPassword("123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    static synchronized public DBCPManager getInstance() {
        if (instance == null) {
            instance = new DBCPManager();
        }
        return instance;
    }

    public void free(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Connection getConnection() {
        if (ds != null) {
            try {
                Connection conn = ds.getConnection();
                return conn;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int insert(Book book) {
        String sql = "INSERT INTO BOOK(ISBN, NAME, PRICE, AUTHOR)"
                + " VALUES (?, ?, ?, ?)";  // 插入数据的sql语句

        Statement stmt = null;
        ResultSet reset = null;
        DBCPManager db = DBCPManager.getInstance();
        Connection conn = db.getConnection();

        if (conn == null) {
            System.out.println("conn==null");
        }

        try {
            conn = db.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, book.getIsbn());
            st.setString(2, book.getName());
            st.setDouble(3, book.getPrice());
            st.setString(4, book.getAuthor());
            int count = st.executeUpdate();  // 执行插入操作的sql语句，并返回插入数据的个数

            System.out.println("向 BOOK 表中插入 " + count + " 条数据"); //输出插入操作的处理结果
            return count;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            db.free(reset, stmt, conn);
        }
    }
}
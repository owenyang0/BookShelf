package yang;

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
            ds.setUsername("root");
            ds.setPassword("");


        } catch (Exception e) {
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
        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
            } finally {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException e) {
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
            }
        }
        return null;
    }

    public static int insert(int isbn, String name, double price, String author) {
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
            st.setInt(1, isbn);
            st.setString(2, name);
            st.setDouble(3, price);
            st.setString(4, author);
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
package yang;

import java.sql.*;

/**
 * Created by yang on 4/24/14.
 */
public class Conn {
    static Connection conn;
    static Statement st;

    /* 获取数据库连接的函数*/
    public static Connection getConnection() {
        Connection con = null;  //创建用于连接数据库的Connection对象
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BOOKSHELF", "yang", "123456");// 创建数据连接

        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
        return con; //返回所建立的数据库连接
    }

    /* 插入数据记录，并输出插入的数据记录数*/
    public static int insert(String isbn, String name, double price, String author) {
        conn = getConnection(); // 首先要获取连接，即连接到数据库
        String sql = "INSERT INTO BOOK(ISBN, NAME, PRICE, AUTHOR)"
                + " VALUES (?, ?, ?, ?)";  // 插入数据的sql语句
        try {

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, isbn);
            st.setString(2, name);
            st.setDouble(3, price);
            st.setString(4, author);

            int count = st.executeUpdate();  // 执行插入操作的sql语句，并返回插入数据的个数

            System.out.println("向 BOOK 表中插入 " + count + " 条数据"); //输出插入操作的处理结果

            conn.close();   //关闭数据库连接
            return count;

        } catch (SQLException e) {
            System.out.println("插入数据失败" + e.getMessage());
            return -1;
        }
    }
}
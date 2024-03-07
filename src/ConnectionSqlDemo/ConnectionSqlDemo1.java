package ConnectionSqlDemo;
import java.sql.*;

public class ConnectionSqlDemo1 {
   public  static void main(String[] args) throws ClassNotFoundException,SQLException {
            // TODO 自动生成的方法存根
             //1、加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、提供JDBC的url用于连接参数
            String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password1 = "root";


            //3.1、创建数据库连接
            Connection conn = DriverManager.getConnection(url, username, password1);
	   /*3.2创建Satement,PreparedStatement执行SQL语句
	     或创建Statement不带参数的SQL语句
	    */
            String selectSQL = "select * from student;";
            Statement stmt =  (Statement) conn.createStatement();
            //3.3执行查询SQL语句   ——读  返回的是结果集 ResultSet  ;写  返回的是整型 int
            ResultSet rs = stmt.executeQuery(selectSQL);
            while(rs.next()) {
                //1、通过下标读取，从1开始
                int number = rs.getInt("number");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String password = rs.getString("password");


                System.out.println(number+""+name+""+age+""+password);

            }


            //4、关闭数据库
            System.out.println(conn);
            conn.close();
        }
    }


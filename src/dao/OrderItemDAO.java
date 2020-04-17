package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.OrderItem;
import bean.User;
 
public class OrderItemDAO {
 
    public void insert(OrderItem oi) {
 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
            Connection c = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=cart", "sa", "sa");
 
            String sql = "insert into orderItem (pid,num,oid) values (?,?,?)";
 
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, oi.getProduct().getId());
            ps.setInt(2, oi.getNum());
            ps.setInt(3, oi.getOrder().getId());
            
            ps.execute(); 
            
            ps.close();
 
            c.close();
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
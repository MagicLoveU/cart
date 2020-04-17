package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Order;
import bean.User;
 
public class OrderDAO {
 
    public void insert(Order o) {
 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
            Connection c = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=cart", "sa", "sa");
 
            String sql = "set nocount on;insert into order_ (uid) values (?)";
 
            PreparedStatement ps = c.prepareStatement(sql);
 
            ps.setInt(1, o.getUser().getId());
            
            ps.execute();

            sql = "select top 1 id from order_ order by id desc";
 
            ps = c.prepareStatement(sql);
 
            ResultSet rs = ps.executeQuery(); 
            if (rs.next()){
            	o.setId(rs.getInt(1));
            }
 
            ps.close();
 
            c.close();
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
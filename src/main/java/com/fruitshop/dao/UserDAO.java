package com.fruitshop.dao;
import com.fruitshop.config.DBConnection;
import com.fruitshop.model.User;
import java.sql.*;
public class UserDAO {
 public User login(String u,String p) throws SQLException {
  String q="SELECT id,username,role FROM users WHERE username=? AND password=? AND active=1";
  try(Connection c=DBConnection.getConnection(); PreparedStatement s=c.prepareStatement(q)){
   s.setString(1,u); s.setString(2,p); try(ResultSet r=s.executeQuery()){ if(r.next()) return new User(r.getInt(1),r.getString(2),r.getString(3)); }
  } return null;
 }
}
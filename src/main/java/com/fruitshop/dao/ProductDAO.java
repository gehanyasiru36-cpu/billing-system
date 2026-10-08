package com.fruitshop.dao;
import com.fruitshop.config.DBConnection;
import com.fruitshop.model.Product;
import java.sql.*; import java.util.*;
public class ProductDAO {
 public List<Product> findAll() throws SQLException {
  List<Product> a=new ArrayList<>(); String q="SELECT id,code,name,unit,buying_price,selling_price,stock,reorder_level FROM products WHERE active=1 ORDER BY name";
  try(Connection c=DBConnection.getConnection(); PreparedStatement s=c.prepareStatement(q); ResultSet r=s.executeQuery()){
   while(r.next()) a.add(new Product(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getDouble(5),r.getDouble(6),r.getDouble(7),r.getDouble(8)));
  } return a;
 }
 public void save(String code,String name,String unit,double buy,double sell,double stock,double reorder) throws SQLException {
  String q="INSERT INTO products(code,name,unit,buying_price,selling_price,stock,reorder_level) VALUES(?,?,?,?,?,?,?)";
  try(Connection c=DBConnection.getConnection(); PreparedStatement s=c.prepareStatement(q)){
   s.setString(1,code);s.setString(2,name);s.setString(3,unit);s.setDouble(4,buy);s.setDouble(5,sell);s.setDouble(6,stock);s.setDouble(7,reorder);s.executeUpdate();
  }
 }
}
package com.fruitshop.ui;
import com.fruitshop.model.User; import com.fruitshop.dao.ProductDAO; import com.fruitshop.model.Product;
import javax.swing.*; import javax.swing.table.DefaultTableModel; import java.awt.*;
public class DashboardFrame extends JFrame {
 User user; JTable table=new JTable(); DefaultTableModel model;
 public DashboardFrame(User u){user=u;setTitle("Fruit Shop Billing System - Dashboard");setSize(1100,700);setLocationRelativeTo(null);setDefaultCloseOperation(EXIT_ON_CLOSE);
  JPanel side=new JPanel();side.setLayout(new GridLayout(8,1,6,6)); side.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
  String[] btn={"Dashboard","POS Billing","Products","Customers","Suppliers","Sales Reports","Users","Logout"};
  for(String x:btn){JButton b=new JButton(x);side.add(b); if(x.equals("Products")) b.addActionListener(e->loadProducts()); if(x.equals("POS Billing")) b.addActionListener(e->new BillingFrame().setVisible(true)); if(x.equals("Logout")) b.addActionListener(e->{dispose();new LoginFrame().setVisible(true);});}
  JPanel center=new JPanel(new BorderLayout(10,10)); JLabel h=new JLabel("Welcome, "+u.username()+"  |  Role: "+u.role());h.setFont(new Font("SansSerif",Font.BOLD,22));center.add(h,BorderLayout.NORTH);
  JPanel cards=new JPanel(new GridLayout(1,4,10,10)); for(String s:new String[]{"Today's Sales","Products","Low Stock","Customers"}){JPanel c=new JPanel(new BorderLayout());c.setBorder(BorderFactory.createTitledBorder(s));JLabel v=new JLabel("0",SwingConstants.CENTER);v.setFont(new Font("SansSerif",Font.BOLD,26));c.add(v);cards.add(c);}center.add(cards,BorderLayout.CENTER);
  model=new DefaultTableModel(new Object[]{"ID","Code","Product","Unit","Buy","Sell","Stock","Reorder"},0);table.setModel(model);center.add(new JScrollPane(table),BorderLayout.SOUTH);
  add(side,BorderLayout.WEST);add(center,BorderLayout.CENTER);loadProducts();
 }
 void loadProducts(){try{model.setRowCount(0);for(Product p:new ProductDAO().findAll())model.addRow(new Object[]{p.id(),p.code(),p.name(),p.unit(),p.buyingPrice(),p.sellingPrice(),p.stock(),p.reorderLevel()});}catch(Exception e){JOptionPane.showMessageDialog(this,e.getMessage());}}
}
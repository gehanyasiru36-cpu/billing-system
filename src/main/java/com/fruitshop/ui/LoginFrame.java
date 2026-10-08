package com.fruitshop.ui;
import com.fruitshop.dao.UserDAO; import com.fruitshop.model.User;
import javax.swing.*; import java.awt.*;
public class LoginFrame extends JFrame {
 JTextField user=new JTextField(); JPasswordField pass=new JPasswordField();
 public LoginFrame(){ setTitle("Fruit Shop Billing - Login"); setSize(420,300); setLocationRelativeTo(null); setDefaultCloseOperation(EXIT_ON_CLOSE);
  JPanel p=new JPanel(new GridBagLayout()); GridBagConstraints g=new GridBagConstraints(); g.insets=new Insets(8,8,8,8); g.fill=GridBagConstraints.HORIZONTAL;
  JLabel title=new JLabel("FRUIT SHOP POS",SwingConstants.CENTER); title.setFont(new Font("SansSerif",Font.BOLD,24));
  g.gridx=0;g.gridy=0;g.gridwidth=2;p.add(title,g); g.gridwidth=1;
  g.gridy++;p.add(new JLabel("Username"),g);g.gridx=1;p.add(user,g);g.gridx=0;g.gridy++;p.add(new JLabel("Password"),g);g.gridx=1;p.add(pass,g);
  JButton b=new JButton("LOGIN");g.gridx=0;g.gridy++;g.gridwidth=2;p.add(b,g); add(p);
  b.addActionListener(e->doLogin());
 }
 void doLogin(){ try{ User u=new UserDAO().login(user.getText(),new String(pass.getPassword())); if(u!=null){dispose();new DashboardFrame(u).setVisible(true);} else JOptionPane.showMessageDialog(this,"Invalid username or password"); }catch(Exception ex){JOptionPane.showMessageDialog(this,"Database error: "+ex.getMessage());}}
}
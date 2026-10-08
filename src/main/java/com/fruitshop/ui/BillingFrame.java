package com.fruitshop.ui;
import javax.swing.*; import javax.swing.table.DefaultTableModel; import java.awt.*;
public class BillingFrame extends JFrame {
 DefaultTableModel m=new DefaultTableModel(new Object[]{"Code","Product","Qty","Price","Total"},0); JTable t=new JTable(m); JLabel total=new JLabel("Total: Rs. 0.00");
 public BillingFrame(){setTitle("POS Billing");setSize(900,600);setLocationRelativeTo(null);
  JPanel top=new JPanel(new GridLayout(1,5,8,8)); JTextField code=new JTextField(), name=new JTextField("Apple"), qty=new JTextField("1"), price=new JTextField("600"); JButton add=new JButton("Add Item");
  top.add(new JLabel("Code"));top.add(code);top.add(name);top.add(qty);top.add(price); add(top,BorderLayout.NORTH);
  add(new JScrollPane(t),BorderLayout.CENTER); JPanel bottom=new JPanel(new BorderLayout()); JButton remove=new JButton("Remove");JButton pay=new JButton("Complete Sale");bottom.add(remove,BorderLayout.WEST);bottom.add(total,BorderLayout.CENTER);bottom.add(pay,BorderLayout.EAST);add(bottom,BorderLayout.SOUTH);
  add.addActionListener(e->{try{double q=Double.parseDouble(qty.getText()),p=Double.parseDouble(price.getText());m.addRow(new Object[]{code.getText(),name.getText(),q,p,q*p});calc();}catch(Exception x){JOptionPane.showMessageDialog(this,"Enter valid quantity and price");}});
  remove.addActionListener(e->{int r=t.getSelectedRow();if(r>=0)m.removeRow(r);calc();});pay.addActionListener(e->{JOptionPane.showMessageDialog(this,"Sale completed (connect SaleDAO for persistence).");});
 }
 void calc(){double x=0;for(int i=0;i<m.getRowCount();i++)x+=Double.parseDouble(m.getValueAt(i,4).toString());total.setText(String.format("Total: Rs. %.2f",x));}
}
package com.fruitshop;
import com.fruitshop.ui.LoginFrame;
public class Main { public static void main(String[] args) {
 javax.swing.SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
} }
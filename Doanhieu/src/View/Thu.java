package View;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package thu;
//
//import com.sun.xml.internal.bind.v2.TODO;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.ImageIcon;
//import javax.swing.JCheckBox;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
//
///**
// *
// * @author Minh Hieu
// */
//public class Thu implements ActionListener {
//
//    private ImagePanel panel1;
//     private JPanel panel2;
//
//    public Thu() {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(Thu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        JFrame jf = new JFrame("Đăng Nhập");
//        jf.setIconImage(new ImageIcon("D:\\java\\Thu\\1.png").getImage());
//        jf.setSize(300, 370);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setResizable(false);
//        jf.setLayout(null);
//        jf.getContentPane().setBackground(Color.decode("#FAFAFA"));
//        panel1 = new ImagePanel(new ImageIcon("C:\\Users\\User\\Desktop\\1.png").getImage());
//        
//        panel2 = new JPanel();
//        panel2.setLayout(new GridLayout(3, 2));
//        JLabel name = new JLabel("User name:");
//        panel2.add(name);
//        name.setFont(new Font("TimesRoman", Font.BOLD, 15));
//        JTextField NameT1 = new JTextField();
//        panel2.add(NameT1);
//        JLabel pass = new JLabel("Password");
//         pass.setFont(new Font("TimesRoman", Font.BOLD, 15));
//        panel2.add(pass);
//        
//        JTextField NameT2 = new JTextField();
//        panel2.add(NameT2);
//        JLabel check = new JLabel("");
//        JCheckBox checkpass = new JCheckBox("Hiện Mật Khẩu");
//        checkpass.setFont(new Font("TimesRoman", Font.PLAIN, 10));
//        panel2.add(check);
//        panel2.add(checkpass);
//        panel2.setBounds(45, 90, 200, 70);
//      
//        JButton Ok = new JButton("Đăng Nhập");
//        Ok.setForeground(Color.decode("#00CC99"));
//        Ok.setFont(new Font("TimesRoman", Font.BOLD, 14));
//        Ok.setSize(110, 40);
//        Ok.setLocation(95, 200);
//        JLabel dangnhap = new JLabel("Đăng Nhập");
//        dangnhap.setFont(new Font("TimesRoman", Font.BOLD, 18));
//        dangnhap.setForeground(Color.decode("#009999"));
//        dangnhap.setLocation(100, 30);
//        dangnhap.setSize(110, 30);
//        ImageIcon img = new ImageIcon("C:\\Users\\User\\Desktop\\1.png");
//        JLabel hinh = new JLabel();
//        hinh.setLocation(0, 0);
//        hinh.setSize(300, 350);
//        hinh.setIcon(img);
//        jf.add(hinh);
//        jf.add(Ok);
//        jf.add(dangnhap);
//        panel1.add(panel2);
//        jf.add(panel2);
//        jf.setLocationRelativeTo(null);
//        jf.setVisible(true);
//
//    }
//
//    public static void main(String[] args) throws IOException {
////         TODO code application logic here
//        try {
//  String dbURL = "jdbc:sqlserver://localhost;databaseName=DOANJava;user=sa;password=123";
//    Connection conn = DriverManager.getConnection(dbURL);
//    if (conn != null) {
//      System.out.println("Connected");
//      String sql="select PASSWORD from DANGNHAP where IDUSER='hieu'";
//        PreparedStatement stm=conn.prepareStatement(sql);
//        ResultSet rs=stm.executeQuery();
//        
//        while(rs.next()){
//         if(rs.getString("PASSWORD").equals("1"));
//         {
//         System.out.println("Thanh cong");
//         }
//        
//        }
//      DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//      System.out.println("Driver name: " + dm.getDriverName());
//      System.out.println("Driver version: " + dm.getDriverVersion());
//      System.out.println("Product name: " + dm.getDatabaseProductName());
//      System.out.println("Product version: " + dm.getDatabaseProductVersion()); 
//    }
//   } catch (SQLException ex) {
//     System.err.println("Cannot connect database, " + ex);
//   }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    class ImagePanel extends JPanel {
//
//        private Image img;
//
//        public ImagePanel(String img) {
//            this(new ImageIcon(img).getImage());
//        }
//
//        public ImagePanel(Image img) {
//            this.img = img;
//            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
//            setPreferredSize(size);
//            setMinimumSize(size);
//            setMaximumSize(size);
//            setSize(size);
//            setLayout(null);
//        }
//
//        public void paintComponent(Graphics g) {
//            g.drawImage(img, 0, 0, null);
//        }
//    }
//}

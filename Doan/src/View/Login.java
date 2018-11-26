/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.LoginControl;
import Model.UserModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Minh Hieu
 */
public class Login {

    private JPanel panel2;

    /**
     *
     */
    public Login() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Thu.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFrame jf = new JFrame("Đăng Nhập");
//        jf.setIconImage(new ImageIcon("D:\\java\\Thu\\1.png").getImage());
        jf.setSize(300, 370);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
//      jf.getContentPane().setBackground(Color.decode("#FAFAFA"));
//      panel1 = new ImagePanel(new ImageIcon("C:\\Users\\User\\Desktop\\1.png").getImage());

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 2));
        JLabel name = new JLabel("User name:");
        panel2.add(name);
        name.setFont(new Font("TimesRoman", Font.BOLD, 15));
        JTextField userid = new JTextField();
        panel2.add(userid);
        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("TimesRoman", Font.BOLD, 15));
        panel2.add(pass);

        JTextField password = new JTextField();
        panel2.add(password);
        JLabel check = new JLabel("");
        JCheckBox checkpass = new JCheckBox("Hiện Mật Khẩu");
        checkpass.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        panel2.add(check);
        panel2.add(checkpass);
        panel2.setBounds(45, 90, 200, 70);

        JButton buttonDangnhap = new JButton("Đăng Nhập");
        buttonDangnhap.setForeground(Color.decode("#00CC99"));
        buttonDangnhap.setFont(new Font("TimesRoman", Font.BOLD, 14));
        buttonDangnhap.setSize(110, 40);
        buttonDangnhap.setLocation(95, 200);
        JLabel dangnhap = new JLabel("Đăng Nhập");
        dangnhap.setFont(new Font("TimesRoman", Font.BOLD, 18));
        dangnhap.setForeground(Color.decode("#009999"));
        dangnhap.setLocation(100, 30);
        dangnhap.setSize(110, 30);
        buttonDangnhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserModel user = new UserModel(userid.getText(), password.getText());
                try {
                    if ( LoginControl.requestLogin(user)) {
                        jf.dispose();
                        try {
                            new ManHinhChinh(userid.getText());
                        } catch (IOException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Lỗi sai tài khoản hoặc mật khẩu");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
//        ImageIcon img = new ImageIcon("C:\\Users\\User\\Desktop\\1.png");
//        JLabel hinh = new JLabel();
//        hinh.setLocation(0, 0);
//        hinh.setSize(300, 350);
//        hinh.setIcon(img);
//
//        jf.add(hinh);
        jf.add(buttonDangnhap);

        jf.add(dangnhap);
//        panel1.add(panel2);

        jf.add(panel2);

        jf.setLocationRelativeTo(
                null);
        jf.setVisible(
                true);
    }

}

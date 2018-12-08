/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.NHANVIENModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import View.Login;
import View.ManHinhChinh;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Minh Hieu
 */
public class LoginControl {

    private static Connection connection;


    public void ketnoi(ActionEvent e, NHANVIENModel userModel) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        Login fr = (Login) SwingUtilities.getRoot(component);
        try {
            if (LoginControl.requestLogin(userModel) == true) {
                try {
                    fr.dispose();
                    ManHinhChinh manHinhChinh = new ManHinhChinh("HH");
                } catch (IOException ex) {
                    Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Lỗi sai tài khoản hoặc mật khẩu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void AnHienPass(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        Login fr = (Login) SwingUtilities.getRoot(component);
       if (fr.getCheckBox().isSelected()) {
                fr.getCheckBox().setText("Ẩn Mật Khẩu");
                fr.getPassword().setEchoChar((char) 0);
            } else {
                fr.getCheckBox().setText("HiệnMật Khẩu");
                 fr.getPassword().setEchoChar('*');
            }

    }
    public static boolean requestLogin(NHANVIENModel user) throws SQLException {
        connection = MSSQLControl.getConnect();
        try {
            String sql = "select MatKhau from NHANVIEN where MaNV='" + user.getMaNV()+ "'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (rs.getString("MatKhau").equals(user.getMatKhau())) {
                    System.out.println("ok");
                    connection.close();
                    return true;
                }

            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.toString());
            connection.close();
        }
        return false;
    }

}

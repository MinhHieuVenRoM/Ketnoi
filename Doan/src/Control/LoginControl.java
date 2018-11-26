/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.UserModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import View.Login;

/**
 *
 * @author Minh Hieu
 */
public class LoginControl {

    private static Connection connection;

    public static boolean requestLogin(UserModel user) throws SQLException {
        connection = MyMSSQLControl.getConnect();
        try {
            String sql = "select PASSWORD from DANGNHAP where IDUSER='" + user.getName() + "'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("PASSWORD"));
                System.out.println(user.getPassword());
                if (rs.getString("PASSWORD").equals(user.getPassword())) {
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

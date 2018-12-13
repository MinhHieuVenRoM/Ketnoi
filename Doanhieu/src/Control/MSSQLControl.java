/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh Hieu
 */
public class MSSQLControl {

    public static final String DATABASE_NAME = "QLCuaHangTienLoi";
    public static final String SERVER_NAME = "DESKTOP-EBT5L5N";

    public static Connection getConnect() throws SQLException {
        Connection connection = null;
        try {

            String dbURL = "jdbc:sqlserver://" + SERVER_NAME + ":1433;databaseName=" + DATABASE_NAME + ";integratedSecurity=true;";
//            String dbURL = "jdbc:sqlserver://localhost::1433;databaseName=QLCuaHangTienLoi;user=sa;password=123";
//            String dbURL = "jdbc:sqlserver://localhost;databaseName=DOANJava;user=sa;password=123";
            connection = DriverManager.getConnection(dbURL);
        } catch (SQLException ex) {
            System.out.println("SQL Exception:" + ex.toString());
            Logger.getLogger(MSSQLControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}

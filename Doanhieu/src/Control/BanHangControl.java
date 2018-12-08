/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.LOAISANPHAMModel;
import Model.SANPHAMModel;
import Model.UserModel;
import View.BanHang;
import View.Login;
import View.ManHinhChinh;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Minh Hieu
 */
public class BanHangControl {

    private static Connection connection;
    private DefaultTableModel defaultTableModelSanPham, defaultTableModel2;
    private String ma = "", ten = "", donvi = "", gia = "";
    private ArrayList<SANPHAMModel> DSSP;
    private ArrayList<LOAISANPHAMModel> Dsloai;

    public BanHangControl() {
    }

    public void QuayLai(ActionEvent e, String NhanVien) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        BanHang fr = (BanHang) SwingUtilities.getRoot(component);
        try {
            fr.dispose();
            ManHinhChinh manHinhChinh = new ManHinhChinh("HH");
        } catch (IOException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String Timkiem(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        BanHang fr = (BanHang) SwingUtilities.getRoot(component);
        String maloai = "TẤT CẢ";
        for(LOAISANPHAMModel loai:Dsloai){
        if(fr.getCbbLoai().getSelectedItem().toString().equals(loai.getTENLOAI()))
            maloai=loai.getMALOAI();
        }
        themspvaobangsp(maloai);
        return maloai;
    }

    public String[] Layloaisanpham() throws SQLException {
        LOAISANPHAMModel loai = new LOAISANPHAMModel();
        loai.layDanhsachloaisanpham();
        String[] ds = new String[loai.demSoloaisanpham() + 1];
        Dsloai = loai.getDsloai();
        int i = 1;
        ds[0] = "TẤT CẢ";
        for (LOAISANPHAMModel tam : Dsloai) {

            ds[i] = tam.getTENLOAI();
            i++;
        }

        return ds;

    }

    public void LaySanPhamTuTable(MouseEvent e) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        BanHang fr = (BanHang) SwingUtilities.getRoot(component);
        int row = fr.getJt().rowAtPoint(e.getPoint());
        int col = fr.getJt().columnAtPoint(e.getPoint());
        int numcols = defaultTableModelSanPham.getColumnCount();
        for (int i = 0; i < numcols; i++) {
            String str = (String) defaultTableModelSanPham.getValueAt(row, i);
            if (i == 0) {
                ma = str;
            }
            if (i == 1) {
                ten = str;
            }
            if (i == 2) {
                gia = str;
            }
            if (i == 3) {
                donvi = str;
            }
            fr.getNameT1().setText(ma);

        }
    }

    public void themthuoctinhbangsp() {
        defaultTableModelSanPham = new DefaultTableModel();
        defaultTableModelSanPham.addColumn("Mã Hàng");
        defaultTableModelSanPham.addColumn("Tên Hàng");
        defaultTableModelSanPham.addColumn("Giá");
        defaultTableModelSanPham.addColumn("Đơn vị");
        defaultTableModelSanPham.addColumn("Loại");
        defaultTableModelSanPham.addColumn("Số Lượng Tồn");
    }

    public DefaultTableModel themspvaobangsp(String tenloai) throws SQLException {
        themthuoctinhbangsp();
        DSSP = new ArrayList<>();
        SANPHAMModel Sanpham = new SANPHAMModel();
        DSSP = Sanpham.layDanhSachSpDeban();
        defaultTableModelSanPham.setRowCount(0);
        for (SANPHAMModel sp : DSSP) {
            Vector v = new Vector();
            if (tenloai.equals("TẤT CẢ") == true) {

                v.add(sp.getMASP());
                v.add(sp.getTENSP());
                v.add(String.valueOf(sp.getDONGIABAN()));
                v.add(sp.getDONVI());
                v.add(sp.getMALOAI());
                v.add(String.valueOf(sp.getSOLUONGTON()));
                defaultTableModelSanPham.addRow(v);
            } else {

                v.add(sp.getMASP());
                v.add(sp.getTENSP());
                v.add(String.valueOf(sp.getDONGIABAN()));
                v.add(sp.getDONVI());
                v.add(sp.getMALOAI());
                v.add(String.valueOf(sp.getSOLUONGTON()));
                
                if (sp.getMALOAI().equals(tenloai)) {
                    defaultTableModelSanPham.addRow(v);
                }

            }

        }
        return defaultTableModelSanPham;
    }

    public DefaultTableModel themthuoctinhbangspduocchon() {
        defaultTableModel2 = new DefaultTableModel();
        defaultTableModel2.addColumn("Mã Hàng");
        defaultTableModel2.addColumn("Tên Hàng");
        defaultTableModel2.addColumn("Giá");
        defaultTableModel2.addColumn("Đơn vị");
        defaultTableModel2.addColumn("Số lượng");
        defaultTableModel2.addColumn("Tổng");
        return defaultTableModel2;
    }

    public void themspvaobangspchon(int sl) {

        Vector v = new Vector();
        v.add(ma);
        v.add(ten);
        v.add(gia);
        v.add(donvi);
        v.add(sl);
        int tam = Integer.parseInt(gia) * sl;
        v.add(tam);
        defaultTableModel2.addRow(v);

    }
}

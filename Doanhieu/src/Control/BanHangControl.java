/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.HOADONModel;
import Model.LOAISANPHAMModel;
import Model.SANPHAMModel;
import Model.NHANVIENModel;
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
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Minh Hieu
 */
public class BanHangControl {

    private static Connection connection;
    private DefaultTableModel defaultTableModelSanPham, defaultTableModelbanhang;
    private String ma = "", ten = "", donvi = "", gia = "", soluong = "", tong = "";
    private ArrayList<SANPHAMModel> DSSP;
    private ArrayList<LOAISANPHAMModel> Dsloai;
    private ArrayList<NHANVIENModel> DSnhanvien;
    private ArrayList<HOADONModel> DShoadon;
    private int vitrihangtableban, vitrihangtablesp;

    public BanHangControl() {
    }

    public void QuayLai(ActionEvent e, String NhanVien, int capbac) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        BanHang fr = (BanHang) SwingUtilities.getRoot(component);
        try {
            fr.dispose();
            ManHinhChinh manHinhChinh = new ManHinhChinh(NhanVien, capbac);
        } catch (IOException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void thanhtoanHoaDon(ActionEvent e, String MAHD, JTable banhangJTable) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        connection = MSSQLControl.getConnect();
        Statement statement = connection.createStatement();
        BanHang fr = (BanHang) SwingUtilities.getRoot(component);
        int numcols = banhangJTable.getColumnCount();
        int row = banhangJTable.getRowCount();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < numcols; j++) {
                String tam = (String) banhangJTable.getValueAt(i, j);
                if (j == 0) {
                    ma = tam;
                }
                if (j == 1) {
                    ten = tam;
                }
                if (j == 2) {
                    gia = tam;
                }
                if (j == 4) {
                    soluong = tam;
                }

            }
            String sql = "insert into CHITIETHOADON values('" + MAHD + "','" + ma + "','" + soluong + "',null,null)";
            statement.executeUpdate(sql);
        }
        connection.close();
    }

    public String Timkiem(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        BanHang fr = (BanHang) SwingUtilities.getRoot(component);
        String maloai = "TẤT CẢ";
        for (LOAISANPHAMModel loai : Dsloai) {
            if (fr.getCbbLoai().getSelectedItem().toString().equals(loai.getTENLOAI())) {
                maloai = loai.getMALOAI();
            }
        }
        themspvaobangsp("SP001", maloai);
        return maloai;
    }

    public void themHoadonmoi(ActionEvent e, String thoigian) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        BanHang fr = (BanHang) SwingUtilities.getRoot(component);
        
        HOADONModel hd = new HOADONModel();
        ArrayList<HOADONModel> danhsachtam = hd.layDanhsachhoadon();

        int size = danhsachtam.size();
        String MAHD = danhsachtam.get(size - 1).getMAHD();
        String chuoisohdtam = MAHD.substring(2, 5);//cắt chuỗi từ vị trí 2->(5-1)
        int temp = Integer.parseInt(chuoisohdtam);//lấy sohd cuối cùng

        if (temp < 9) {
            fr.getMahd().setText("HD00" + (temp + 1));
        }
        if (temp >= 9 && temp < 99) {
            fr.getMahd().setText("HD0" + (temp + 1));
        }
        if (temp >= 99) {
            fr.getMahd().setText("HD" + (temp + 1));
        }
        NHANVIENModel nv = new NHANVIENModel();
        DSnhanvien = nv.layThongtinnhanvien();
        String manv = null;
        for (NHANVIENModel tam : DSnhanvien) {
            if (tam.getTenNV().equals(fr.getNhanvien().getSelectedItem().toString())) {
                manv=tam.getMaNV();
            }
        }

        connection = MSSQLControl.getConnect();
        Statement statement = connection.createStatement();
        String sql = "insert into HOADON values('" + fr.getMahd().getText() + "','" + thoigian + "','" + manv + "',null)";
        statement.executeUpdate(sql);
        connection.close();
    }

    public String[] Layloaisanpham() throws SQLException, ClassNotFoundException {
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

    public String[] layDsnhanvien() throws SQLException, ClassNotFoundException {
        DSnhanvien = new ArrayList<>();
        NHANVIENModel nv = new NHANVIENModel();
        DSnhanvien = nv.layThongtinnhanvien();
        String[] ds = new String[nv.demSonhanvien()];

        int i = 0;
        for (NHANVIENModel tam : DSnhanvien) {

            ds[i] = tam.getTenNV();
            i++;
        }

        return ds;

    }

    public void LaySanPhamTuTable(MouseEvent e) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        BanHang fr = (BanHang) SwingUtilities.getRoot(component);
        int row = fr.getJt().rowAtPoint(e.getPoint());
        vitrihangtablesp = row;
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
            fr.gettextmasp().setText(ma);

        }
    }

    public void chinhsuSoluong(MouseEvent e) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        BanHang fr = (BanHang) SwingUtilities.getRoot(component);
        int row = fr.getTbban().rowAtPoint(e.getPoint());
        vitrihangtableban = row;
        int col = fr.getTbban().columnAtPoint(e.getPoint());
        int numcols = defaultTableModelbanhang.getColumnCount();
        String str = (String) defaultTableModelbanhang.getValueAt(row, 4);
        fr.getTextSl().setText(str);
        for (int i = 0; i < numcols; i++) {
            String tam = (String) defaultTableModelbanhang.getValueAt(row, i);
            if (i == 0) {
                ma = tam;
            }
            if (i == 1) {
                ten = tam;
            }
            if (i == 2) {
                gia = tam;
            }
            if (i == 3) {
                donvi = tam;
            }
            if (i == 4) {
                soluong = tam;
            }
            if (i == 5) {
                tong = tam;
            }

        }

    }

    public void suaSoluong(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        BanHang fr = (BanHang) SwingUtilities.getRoot(component);
        int array[];
        array = fr.getTbban().getSelectedRows();
        for (int i = 0; i < array.length; i++) {
            defaultTableModelbanhang.removeRow(array[i]);
        }
        Vector z = new Vector();
        z.add(ma);
        z.add(ten);
        z.add(gia);
        z.add(donvi);
        z.add(fr.getTextSl().getText());
        int tongdongia = Integer.parseInt(gia) * Integer.parseInt(fr.getTextSl().getText());
        z.add(String.valueOf(tongdongia));
        defaultTableModelbanhang.insertRow(vitrihangtableban, z);

    }

    public void xoaSanphamdachon(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
        Component component = (Component) e.getSource();
        BanHang fr = (BanHang) SwingUtilities.getRoot(component);
        int array[];
        array = fr.getTbban().getSelectedRows();
        for (int i = 0; i < array.length; i++) {
            defaultTableModelbanhang.removeRow(array[i]);
        }
    }

    public void themthuoctinhbangsp() {
        defaultTableModelSanPham = new DefaultTableModel();
        defaultTableModelSanPham.addColumn("Mã SP");
        defaultTableModelSanPham.addColumn("Tên Sản Phẩm");
        defaultTableModelSanPham.addColumn("Giá");
        defaultTableModelSanPham.addColumn("Đơn vị");
        defaultTableModelSanPham.addColumn("Loại");
//        defaultTableModelSanPham.addColumn("Số Lượng Tồn");
    }

    public DefaultTableModel themspvaobangsp(String masp, String tenloai) throws SQLException, ClassNotFoundException {
        themthuoctinhbangsp();
        DSSP = new ArrayList<>();
        SANPHAMModel Sanpham = new SANPHAMModel();
        DSSP = Sanpham.layDanhSachSpDeban();

        defaultTableModelSanPham.setRowCount(0);
        for (SANPHAMModel sp : DSSP) {
            Vector v = new Vector();
            if (masp.isEmpty()) {
                if (tenloai.equals("TẤT CẢ") == true) {
                    v.add(sp.getMASP());
                    v.add(sp.getTENSP());
                    v.add(String.valueOf(sp.getDONGIABAN()));
                    v.add(sp.getDONVI());
                    v.add(sp.getMALOAI());
                    
//                    v.add(String.valueOf(sp.getSOLUONGTON()));
                    defaultTableModelSanPham.addRow(v);
                } else {
                    if (sp.getMALOAI().equals(tenloai)) {
                        v.add(sp.getMASP());
                        v.add(sp.getTENSP());
                        v.add(String.valueOf(sp.getDONGIABAN()));
                        v.add(sp.getDONVI());
                        v.add(sp.getMALOAI());
//                        v.add(String.valueOf(sp.getSOLUONGTON()));
                        defaultTableModelSanPham.addRow(v);
                    }
                }
            } else {
                if (sp.getMASP().equals(masp)) {
                    v.add(sp.getMASP());
                    v.add(sp.getTENSP());
                    v.add(String.valueOf(sp.getDONGIABAN()));
                    v.add(sp.getDONVI());
                    v.add(sp.getMALOAI());
//                    v.add(String.valueOf(sp.getSOLUONGTON()));
                    defaultTableModelSanPham.addRow(v);
                }
            }
        }
        return defaultTableModelSanPham;
    }

    public DefaultTableModel themthuoctinhbangspduocchon() {
        defaultTableModelbanhang = new DefaultTableModel();
        defaultTableModelbanhang.addColumn("Mã SP");
        defaultTableModelbanhang.addColumn("Tên Sản Phẩm");
        defaultTableModelbanhang.addColumn("Giá");
        defaultTableModelbanhang.addColumn("Đơn vị");
        defaultTableModelbanhang.addColumn("Số lượng");
        defaultTableModelbanhang.addColumn("Tổng");
        return defaultTableModelbanhang;
    }

    public void themspvaobangspchon(String sl) {
        if (sl.isEmpty() || sl == null) {
            JOptionPane.showMessageDialog(null, "Chưa nhập số lượng", "Lỗi nhập", 1);
        } else {
            if (kiemtraTrungsanphamkhithemchon() == true) {
                Vector v = new Vector();
                v.add(ma);
                v.add(ten);
                v.add(gia);
                v.add(donvi);
                v.add(sl);
                int tam = Integer.parseInt(gia) * Integer.parseInt(sl);
                v.add(String.valueOf(tam));
                defaultTableModelbanhang.addRow(v);
            } else {
                JOptionPane.showMessageDialog(null, "Sản phẩm đã được chọn", "Lỗi nhập", 1);
            }
        }
    }

    public boolean kiemtraTrungsanphamkhithemchon() {
        int numcols = defaultTableModelbanhang.getColumnCount();
        for (int j = 0; j < defaultTableModelbanhang.getRowCount(); j++) {
            for (int i = 0; i < numcols; i++) {
                String str = (String) defaultTableModelbanhang.getValueAt(j, i);
                if (ma.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String tinhtongTienthanhtoan() {
        int tongtien = 0;
        for (int j = 0; j < defaultTableModelbanhang.getRowCount(); j++) {
            String str = (String) defaultTableModelbanhang.getValueAt(j, 5);
            tongtien = tongtien + Integer.parseInt(str);
        }
        if (String.valueOf(tongtien).equals("0")) {
            return null;
        }
        return String.valueOf(tongtien);
    }

}

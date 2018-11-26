/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.MyMSSQLControl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Minh Hieu
 */
public class ORDER {

    private DefaultTableModel defaultTableModelSanPham, defaultTableModel2;
    private JPanel panel1, panel2;
    private JTable jt, tbban;
    private JTextField NameT1, textkh;
    private boolean trangthaithem;
        private Connection connection;

    private String ma = "", ten = "", donvi = "", gia = "";

    public ORDER(String tennhanvien) throws SQLException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Thu.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFrame jf = new JFrame("Đăng Nhập");
        jf.setIconImage(new ImageIcon("D:\\java\\Thu\\1.png").getImage());
        jf.setSize(1000, 660);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);

        JButton quaylaiButton = new JButton("Quay lại");
        quaylaiButton.setBounds(10, 20, 80, 30);
        quaylaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jf.dispose();
                    new ManHinhChinh(tennhanvien);
                } catch (IOException ex) {
                    Logger.getLogger(Quanlytinthongcanhan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jf.add(quaylaiButton);
        //panel
        panel1 = new JPanel();
        panel1.setLayout(null);
        JLabel name = new JLabel("Mã hàng");
        name.setBounds(5, 10, 50, 25);
        NameT1 = new JTextField();
        NameT1.setBounds(60, 10, 100, 25);
        String[] dsmhStrings = {"Tất cả","Nước", "Bánh", "Đồ ăn nhanh"};
        JComboBox cbb = new JComboBox(dsmhStrings);
        cbb.setBounds(190, 10, 125, 25);
        cbb.setSelectedIndex(0);
        JButton timkiem = new JButton("Tìm");
        timkiem.setBounds(330, 10, 55, 25);
       
        panel1.add(name);       
        panel1.add(NameT1);   
        panel1.add(cbb);
        panel1.add(timkiem);
        panel1.setBounds(15, 70, 390, 38);
        panel1.setBackground(Color.decode("#99CCCC"));
        jf.add(panel1);

        JLabel hoadon = new JLabel("Hóa Đơn");
        hoadon.setFont(new Font("TimesRoman", Font.CENTER_BASELINE, 35));
        hoadon.setBounds(370, 0, 150, 70);
        hoadon.setForeground(Color.decode("#009999"));
        jf.add(hoadon);
        //panel2
        panel2 = new JPanel();
        panel2.setLayout(null);

        JLabel mahang = new JLabel("Mã hàng");
        mahang.setBounds(14, 14, 75, 25);
        textkh = new JTextField();
        textkh.setBounds(90, 14, 360, 25);

        JLabel sohd = new JLabel("Số HĐ");
        sohd.setBounds(320, 65, 33, 17);
        JTextField hd = new JTextField();
        hd.setBounds(376, 60, 69, 25);

        JLabel Nv = new JLabel("Nhân Viên");
        Nv.setBounds(14, 100, 76, 25);

        JComboBox nhanvien = new JComboBox();
        nhanvien.addItem("Minh Hiếu");
        nhanvien.addItem("Văn Thịnh");
        nhanvien.addItem("Mỹ Ngọc");
        nhanvien.addItem("Mỹ Duyên");
        nhanvien.setBounds(90, 100, 200, 25);
        JLabel ngay = new JLabel("Ngày");
        ngay.setBounds(14, 63, 28, 17);
        JDateChooser a = new JDateChooser();
        a.setBounds(150, 60, 150, 25);
        JTextField gio = new JTextField();
        gio.setBounds(90, 60, 55, 25);

        //lay gio
        Date today = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String s = dateFormat.format(today.getTime());
        gio.setText(s);
        panel2.add(gio);

        panel2.add(a);
        panel2.add(sohd);
        panel2.add(hd);
        panel2.add(Nv);
        panel2.add(nhanvien);
        //bang hang hoa
        tbban = new JTable();
        themthuoctinhbangspduocchon();
        tbban.setModel(defaultTableModel2);
        JScrollPane jScrollPaneban = new JScrollPane(tbban);
        jScrollPaneban.setBounds(0, 130, 500, 250);
        panel2.setBounds(480, 70, 500, 510);
        panel2.setBackground(Color.decode("#99CCCC"));

        panel2.add(jScrollPaneban);
        panel2.add(mahang);
        panel2.add(textkh);
        panel2.add(ngay);

        JLabel tongtien = new JLabel("Tổng tiền");
        tongtien.setBounds(14, 393, 75, 25);
        JTextField texttongtien = new JTextField();
        texttongtien.setBounds(100, 393, 184, 25);
        panel2.add(tongtien);
        panel2.add(texttongtien);

        JLabel tiendua = new JLabel("Tiền Khách Đưa");
        tiendua.setBounds(14, 433, 87, 25);
        JTextField texttiendua = new JTextField();
        texttiendua.setBounds(100, 433, 184, 25);
        panel2.add(tiendua);
        panel2.add(texttiendua);

        JLabel tienthua = new JLabel("Tiền Thừa");
        tienthua.setBounds(14, 470, 94, 25);
        JTextField texttienthua = new JTextField();
        texttienthua.setBounds(101, 470, 184, 25);
        panel2.add(tienthua);
        panel2.add(texttienthua);

        JLabel giamgia = new JLabel("Giảm giá");
        giamgia.setBounds(297, 393, 55, 25);
        JTextField textgiamgia = new JTextField();
        textgiamgia.setBounds(352, 393, 90, 25);
        panel2.add(giamgia);
        panel2.add(textgiamgia);

        JComboBox cbbloaigiamgia = new JComboBox();
        cbbloaigiamgia.addItem("$");
        cbbloaigiamgia.addItem("%");
        cbbloaigiamgia.setBounds(450, 393, 40, 25);
        panel2.add(cbbloaigiamgia);
        jf.add(panel2);

        JButton Thanhtoan = new JButton();
        Thanhtoan.setBounds(342, 433, 138, 60);
        Thanhtoan.setText("Thanh Toán");
        panel2.add(Thanhtoan);

        JButton taohoadon = new JButton();
        taohoadon.setBounds(407, 80, 70, 60);
        taohoadon.setMargin(new Insets(5, 5, 5, 5));
        taohoadon.setText("<html><center>" + "Tạo Mới" + "<br>" + "Hóa Đơn" + "</center></html>");
        jf.add(taohoadon);

        JLabel Soluong = new JLabel("Số lượng");
        Soluong.setBounds(420, 220, 60, 20);
        JTextField textSl = new JTextField();
        textSl.setText("");

        textSl.setBounds(407, 250, 70, 25);
        jf.add(Soluong);
        jf.add(textSl);

        JButton them = new JButton();
        them.setBounds(407, 290, 70, 32);
        them.setText("Thêm >>");
        them.setMargin(new Insets(0, -5, 0, 0));
        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textSl.getText() != "") {
                    themspvaobangspchon(ma, ten, donvi, Integer.parseInt(gia), Integer.parseInt(textSl.getText()));
                }
            }
        });
        jf.add(them);
        JButton giam = new JButton();
        giam.setBounds(407, 335, 70, 32);
        giam.setText("<< Giảm");
        giam.setMargin(new Insets(0, -5, 0, 0));
        jf.add(giam);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Menu");
        JMenu editMenu = new JMenu("Nhân viên");
        JMenu aboutMenu = new JMenu("Liên hệ");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);
        themspvaobangsp();
        jt = new JTable(defaultTableModelSanPham);
        jt.getModel().addTableModelListener(jt);
        JScrollPane jScrollPane = new JScrollPane(jt);

        jScrollPane.setBounds(15, 110, 390, 470);
        jf.add(jScrollPane);
        themvaoban();
        jf.setJMenuBar(menuBar);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public void themvaoban() {

        jt.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //JOptionPane.showInputDialog("thong bao");
                int row = jt.rowAtPoint(e.getPoint());
                int col = jt.columnAtPoint(e.getPoint());
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
                        donvi = str;
                    }
                    if (i == 3) {
                        gia = str;
                    }
                    NameT1.setText(ma);
                    //a+=str;
                }
                //JOptionPane.showInputDialog(a);

                //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

    }

    public void themthuoctinhbangsp() {
        defaultTableModelSanPham = new DefaultTableModel();
        defaultTableModelSanPham.addColumn("Mã Hàng");
        defaultTableModelSanPham.addColumn("Tên Hàng");
        defaultTableModelSanPham.addColumn("Loại");
        defaultTableModelSanPham.addColumn("Giá");
        defaultTableModelSanPham.addColumn("Đơn vị");
    }

    public void themthuoctinhbangspduocchon() {
        defaultTableModel2 = new DefaultTableModel();
        defaultTableModel2.addColumn("Mã Hàng");
        defaultTableModel2.addColumn("Tên Hàng");
        defaultTableModel2.addColumn("Đơn vị");
        defaultTableModel2.addColumn("Giá");
        defaultTableModel2.addColumn("Số lượng");
        defaultTableModel2.addColumn("Tổng");
    }

    public void themspvaobangsp() throws SQLException {
        themthuoctinhbangsp();
        connection = MyMSSQLControl.getConnect();
        Statement statement = connection.createStatement();
            String sql = "select * from SanPham";
            ResultSet resultSet = statement.executeQuery(sql);
            defaultTableModelSanPham.setRowCount(0);
            while(resultSet.next()){
                Vector v = new Vector();
                v.add(resultSet.getString("ID"));
                v.add(resultSet.getString("Tensp"));
                v.add(resultSet.getString("MALOAI"));
                v.add(resultSet.getString("Gia"));
                v.add(resultSet.getString("DONVI"));
                defaultTableModelSanPham.addRow(v);
            }
            System.out.println("Load Staff Database success!");
            connection.close();
        }

    

    public void themspvaobangspchon(String ma, String ten, String donvi, int gia, int sl) {
        themthuoctinhbangsp();
        Vector v = new Vector();
        v.add(ma);
        v.add(ten);
        v.add(donvi);
        v.add(gia);
        v.add(sl);
        double tam = gia * sl;
        v.add(tam);
        defaultTableModel2.addRow(v);

    }

}

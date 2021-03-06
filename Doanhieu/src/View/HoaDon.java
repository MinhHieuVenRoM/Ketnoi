/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class HoaDon {

    private JButton jbQuayLai;
    private JLabel jlQLDT;

    HoaDon(String tennhanvien) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JFRAME
        JFrame jf = new JFrame("Quản lý Hóa đơn");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(1000, 650);
        jf.setLayout(null);
        jf.setResizable(false);

        //button QUAY LAI
        jbQuayLai = new JButton("Quay lại");
        jbQuayLai.setForeground(Color.decode("#00CC99"));
        jbQuayLai.setSize(107, 76);
        jbQuayLai.setLocation(17, 14);
        jbQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                try {
                    new CHINH_DOANHTHU(tennhanvien);
                } catch (IOException ex) {
                    Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jf.add(jbQuayLai);

        //BANG QUAN LY HÓA ĐƠN
        jlQLDT = new JLabel("BẢNG QUẢN LÝ HÓA ĐƠN");
        jlQLDT.setFont(new Font("TimesRoman", Font.BOLD, 29));
        jlQLDT.setLocation(328, 26);
        jlQLDT.setSize(403, 64);
        jf.add(jlQLDT);

        JPanel QLHD = new JPanel();
        QLHD.setBounds(17, 121, 967, 485);
        QLHD.setLayout(null);
        QLHD.setBackground(Color.decode("#99CCCC"));

        //------------------------------------------------
        //Khung nhập
        JPanel QLHD_Nhap = new JPanel();
        QLHD_Nhap.setLayout(null);
        QLHD_Nhap.setBounds(21, 25, 920, 185);
        //QLHD_Nhap.setBackground(Color.decode("#99CCCC"));

        JLabel jlngay = new JLabel("Ngày");
        jlngay.setBounds(186, 25, 42, 38);
        QLHD_Nhap.add(jlngay);
        JTextField jtngay = new JTextField();
        jtngay.setBounds(228, 31, 104, 25);
        jtngay.setPreferredSize(new Dimension(104, 25));
        QLHD_Nhap.add(jtngay);

        //label tháng + textfield tháng
        JLabel jlthang = new JLabel("Tháng");
        jlthang.setBounds(374, 25, 52, 38);
        QLHD_Nhap.add(jlthang);
        JTextField jtthang = new JTextField();
        jtthang.setBounds(426, 31, 114, 25);
        jtthang.setPreferredSize(new Dimension(114, 25));
        QLHD_Nhap.add(jtthang);

        //label năm + textfield năm
        JLabel jlnam = new JLabel("Năm");
        jlnam.setBounds(574, 25, 41, 38);
        QLHD_Nhap.add(jlnam);
        JTextField jtnam = new JTextField();
        jtnam.setBounds(615, 31, 132, 25);
        jtnam.setPreferredSize(new Dimension(132, 25));
        QLHD_Nhap.add(jtnam);

        //label HOẶC
        JLabel jlhoac = new JLabel("HOẶC");
        jlhoac.setBounds(439, 78, 42, 38);
        QLHD_Nhap.add(jlhoac);

        //label Từ ngày
        JLabel jltungay = new JLabel("Từ ngày");
        jltungay.setBounds(164, 124, 64, 38);
        QLHD_Nhap.add(jltungay);
        //date picker
        JDateChooser jdtn = new JDateChooser();
        jdtn.setBounds(226, 131, 140, 26);
        QLHD_Nhap.add(jdtn);

        //label Đến ngày
        JLabel jldenngay = new JLabel("Đến ngày");
        jldenngay.setBounds(551, 124, 64, 38);
        QLHD_Nhap.add(jldenngay);
        //date picker
        JDateChooser jddn = new JDateChooser();
        jddn.setBounds(616, 131, 140, 26);
        QLHD_Nhap.add(jddn);

        //button Tìm kiếm
        JButton jbTimKiem = new JButton("Tìm Kiếm");
        jbTimKiem.setForeground(Color.decode("#009999"));
        jbTimKiem.setBounds(798, 71, 88, 52);
        QLHD_Nhap.add(jbTimKiem);

        QLHD.add(QLHD_Nhap);

        //-------------------------------------------------
        //Tạo bảng
        JTable jtable = new JTable();

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Số hóa đơn");
        defaultTableModel.addColumn("Thời gian");
        defaultTableModel.addColumn("Nhân viên tính tiền");
        defaultTableModel.addColumn("Tổng tiền");
        jtable.setModel(defaultTableModel);
        JScrollPane jScrollPane = new JScrollPane(jtable);

        jScrollPane.setBounds(175, 244, 610, 169);
        QLHD.add(jScrollPane);

        jf.add(QLHD);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
}

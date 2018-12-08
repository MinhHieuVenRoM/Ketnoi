/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class TinhLuong {
        TinhLuong(String tennhanvien)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TinhLuong.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JFRAME
        JFrame jf = new JFrame("Quản lý Doanh Thu");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(1000, 650);
        jf.setLayout(null);
        jf.setResizable(false);
        
        //button QUAY LAI
        JButton jbQuayLai = new JButton("Quay lại");
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
        
        //BANG QUAN LY TÍNH LƯƠNG
        JLabel jlQLTL = new JLabel("BẢNG QUẢN LÝ TÍNH LƯƠNG");
        jlQLTL.setFont(new Font("TimesRoman", Font.BOLD, 29));
        jlQLTL.setLocation(328, 26);
        jlQLTL.setSize(403, 64);
        jf.add(jlQLTL);

        JPanel QLTL = new JPanel();
        QLTL.setBounds(17, 121, 967, 485);
        QLTL.setLayout(null);
        QLTL.setBackground(Color.decode("#99CCCC"));
        
        //------------------------------------------------
        //Khung nhập
        JPanel QLTL_Nhap = new JPanel();
        QLTL_Nhap.setLayout(null);
        QLTL_Nhap.setBounds(29, 25, 912, 95);
        //QLHD_Nhap.setBackground(Color.decode("#99CCCC"));
        
        JLabel jlmanv = new JLabel("Mã NV");
        jlmanv.setBounds(164, 24, 55, 38);
        QLTL_Nhap.add(jlmanv);
        JComboBox jcmanv = new JComboBox();
        jcmanv.addItem("NV001");
        jcmanv.addItem("NV002");
        jcmanv.addItem("NV003");
        jcmanv.addItem("NV004");
        jcmanv.setBounds(219,30,104,25);
        QLTL_Nhap.add(jcmanv);
        
        //label tháng + textfield tháng
        JLabel jlthang = new JLabel("Tháng");
        jlthang.setBounds(374, 25, 52, 38);
        QLTL_Nhap.add(jlthang);
        JTextField jtthang = new JTextField();
        jtthang.setBounds(426, 31, 114, 25);
        jtthang.setPreferredSize(new Dimension(114, 25));
        QLTL_Nhap.add(jtthang);

        //label năm + textfield năm
        JLabel jlnam = new JLabel("Năm");
        jlnam.setBounds(574, 25, 41, 38);
        QLTL_Nhap.add(jlnam);
        JTextField jtnam = new JTextField();
        jtnam.setBounds(615, 31, 132, 25);
        jtnam.setPreferredSize(new Dimension(132, 25));
        QLTL_Nhap.add(jtnam);
        
        //button Tính lương
        JButton jbTinhLuong = new JButton("Tính lương");
        jbTinhLuong.setForeground(Color.decode("#009999"));
        jbTinhLuong.setBounds(778, 18, 97, 52);
        QLTL_Nhap.add(jbTinhLuong);

        QLTL.add(QLTL_Nhap);
        
        //-------------------------------------------------
        //Tạo bảng
                
        JTable jtable = new JTable();
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Ngày");
        defaultTableModel.addColumn("Tổng giờ làm");
        defaultTableModel.addColumn("Hệ số lương");
        defaultTableModel.addColumn("Tiền thưởng");
        defaultTableModel.addColumn("TỔNG LƯƠNG");
        jtable.setModel(defaultTableModel);
        JScrollPane jScrollPane = new JScrollPane(jtable);
        
        jScrollPane.setBounds(175, 165, 610, 227);
        QLTL.add(jScrollPane);
        
        
        
        jf.add(QLTL);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
    
}

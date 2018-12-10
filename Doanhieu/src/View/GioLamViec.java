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
public class GioLamViec {
    GioLamViec(String tennhanvien)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GioLamViec.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(Thu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jf.add(jbQuayLai);
        
        //BANG QUAN LY GIỜ LÀM VIỆC
        JLabel jlQLGLV = new JLabel("BẢNG QUẢN LÝ GIỜ LÀM VIỆC");
        jlQLGLV.setFont(new Font("TimesRoman", Font.BOLD, 29));
        jlQLGLV.setLocation(328, 26);
        jlQLGLV.setSize(453, 64);
        jf.add(jlQLGLV);

        JPanel QLGLV = new JPanel();
        QLGLV.setBounds(17, 121, 967, 485);
        QLGLV.setLayout(null);
        QLGLV.setBackground(Color.decode("#99CCCC"));
        
        //------------------------------------------------
        //Khung nhập
        JPanel QLGLV_Nhap = new JPanel();
        QLGLV_Nhap.setLayout(null);
        QLGLV_Nhap.setBounds(20, 25, 513, 385);
        //QLHD_Nhap.setBackground(Color.decode("#99CCCC"));
        
        JLabel jlmanv = new JLabel("Mã NV");
        jlmanv.setBounds(37, 42, 55, 38);
        QLGLV_Nhap.add(jlmanv);
        JComboBox jcmanv = new JComboBox();
        jcmanv.addItem("NV001");
        jcmanv.addItem("NV002");
        jcmanv.addItem("NV003");
        jcmanv.addItem("NV004");
        jcmanv.setBounds(92,48,104,25);
        QLGLV_Nhap.add(jcmanv);
        
        //label Ngày
        JLabel jlngay = new JLabel("Ngày");
        jlngay.setBounds(264, 43, 52, 38);
        QLGLV_Nhap.add(jlngay);
        //date picker
        JDateChooser jdngay = new JDateChooser();
        jdngay.setBounds(316, 48, 174, 26);
        QLGLV_Nhap.add(jdngay);
        
        //label giờ bắt đầu + textfield giờ bắt đầu
        JLabel jlgbd = new JLabel("Giờ bắt đầu");
        jlgbd.setBounds(14, 87, 78, 38);
        QLGLV_Nhap.add(jlgbd);
        JTextField jtgbd = new JTextField("hh:mm");
        jtgbd.setBounds(92, 93, 104, 25);
        jtgbd.setPreferredSize(new Dimension(104, 25));
        QLGLV_Nhap.add(jtgbd);
        
        //label giờ kết thúc + textfield giờ kết thúc
        JLabel jlgkt = new JLabel("Giờ kết thúc");
        jlgkt.setBounds(238, 87, 78, 38);
        QLGLV_Nhap.add(jlgkt);
        JTextField jtgkt = new JTextField("hh:mm");
        jtgkt.setBounds(316, 93, 104, 25);
        jtgkt.setPreferredSize(new Dimension(104, 25));
        QLGLV_Nhap.add(jtgkt);
        
        //button Thêm
        JButton jbThem = new JButton("THÊM");
        jbThem.setFont(new Font("TimesRoman", Font.BOLD, 17));
        jbThem.setForeground(Color.decode("#009999"));
        jbThem.setBounds(151, 184, 174, 77);
        QLGLV_Nhap.add(jbThem);

        QLGLV.add(QLGLV_Nhap);
        
        //-------------------------------------------------
        //Tạo bảng
                
        JTable jtable = new JTable();
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã NV");
        defaultTableModel.addColumn("Tên NV");
        defaultTableModel.addColumn("Ngày");
        defaultTableModel.addColumn("Giờ làm");
        jtable.setModel(defaultTableModel);
        JScrollPane jScrollPane = new JScrollPane(jtable);
        
        jScrollPane.setBounds(555, 25, 389, 385);
        QLGLV.add(jScrollPane);
        
        
        
        jf.add(QLGLV);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
}

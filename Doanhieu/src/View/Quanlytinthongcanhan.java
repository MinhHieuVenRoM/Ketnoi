/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Minh Hieu
 */
public class Quanlytinthongcanhan {

    private JPanel panel1, panel2, panel11, panel12;
    JFrame jf;
    JTabbedPane tabbedPane;

    public Quanlytinthongcanhan() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Thu.class.getName()).log(Level.SEVERE, null, ex);
        }
        jf = new JFrame("Quản lý thông tin cá nhân");
        jf.setSize(1000, 650);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);

        JLabel name = new JLabel("Quản Lý Thông Tin Cá Nhân");
        name.setBounds(400, 10, 250, 40);
        name.setForeground(Color.red);
        name.setFont(new Font("TimesRoman", Font.BOLD, 18));
        jf.add(name);
        tabbedPane = new JTabbedPane();
        /* create 2 JPanel, which is content of tabs */

        panel1 = new JPanel();
        panel1.setLayout(null);

        JLabel manv = new JLabel("*Mã Nhân viên:");
        manv.setBounds(10, 10, 90, 30);
        JTextField textmanv = new JTextField();
        textmanv.setBounds(100, 10, 110, 25);
        JLabel hoten = new JLabel("Họ và tên");
        hoten.setBounds(220, 10, 110, 30);
        JTextField texthoten = new JTextField();
        texthoten.setBounds(280, 10, 160, 25);

        JLabel ngaysinh = new JLabel("Ngày Sinh");
        ngaysinh.setBounds(10, 50, 100, 25);
        JDateChooser datengay = new JDateChooser();
        datengay.setBounds(100, 50, 150, 25);

        JLabel ngayvaolam = new JLabel("Ngày vào làm");
        ngayvaolam.setBounds(10, 100, 100, 25);
        JDateChooser datengayvaolam = new JDateChooser();
        datengayvaolam.setBounds(100, 100, 150, 25);

        JLabel chucvu = new JLabel("*Chức vụ");
        chucvu.setBounds(260, 100, 110, 30);
        JTextField textchucvu = new JTextField();
        textchucvu.setBounds(310, 100, 130, 25);

        JLabel tendangnhap = new JLabel("*Tên đăng nhập");
        tendangnhap.setBounds(10, 160, 110, 30);
        JTextField texttendangnhap = new JTextField();
        texttendangnhap.setBounds(100, 160, 130, 25);

        JLabel chuthichJLabel = new JLabel("Chú thích");
        chuthichJLabel.setBounds(10, 220, 110, 30);

        JTextArea ghichu = new JTextArea();
        ghichu.setBounds(10, 250, 500, 250);

        panel11 = new JPanel();
        panel11.setLayout(null);

        JLabel thongtinthang = new JLabel("Thông tin tháng:");
        thongtinthang.setBounds(100, 5, 150, 30);
        thongtinthang.setFont(new Font("TimesRoman", Font.BOLD, 15));
        thongtinthang.setForeground(Color.red);

        JLabel manvt = new JLabel("*Mã Nhân viên:");
        manvt.setBounds(5, 50, 100, 30);
        JTextField textmanvt = new JTextField();
        textmanvt.setBounds(100, 50, 100, 25);

        JLabel Luongcb = new JLabel("Lương cơ bản:");
        Luongcb.setBounds(5, 100, 100, 30);
        JTextField textluongcb = new JTextField();
        textluongcb.setBounds(100, 100, 120, 25);

        JLabel thuong = new JLabel("Thưởng:");
        thuong.setBounds(5, 150, 100, 30);
        JTextField textthuong = new JTextField();
        textthuong.setBounds(100, 150, 120, 25);

        JLabel hesoluong = new JLabel("*Hệ số lương");
        hesoluong.setBounds(5, 200, 100, 30);
        JTextArea areaheso = new JTextArea();
        areaheso.setBounds(100, 200, 70, 30);

        JLabel tongthuong = new JLabel("Tổng Lương:");
        tongthuong.setBounds(5, 250, 100, 30);
        JTextField textTong = new JTextField();
        textTong.setBounds(100, 250, 120, 25);

        panel11.add(tongthuong);
        panel11.add(textTong);
        panel11.add(hesoluong);
        panel11.add(areaheso);
        panel11.add(thongtinthang);
        panel11.add(manvt);
        panel11.add(textmanvt);
        panel11.add(Luongcb);
        panel11.add(thuong);
        panel11.add(textthuong);
        panel11.add(textluongcb);
        panel11.setBounds(650, 10, 300, 300);
        panel11.setBackground(Color.PINK);
        panel1.add(panel11);

        panel1.setBackground(Color.decode("#99CCCC"));
        panel1.add(tendangnhap);
        panel1.add(chuthichJLabel);
        panel1.add(texttendangnhap);
        panel1.add(manv);
        panel1.add(textmanv);
        panel1.add(hoten);
        panel1.add(texthoten);
        panel1.add(ngaysinh);
        panel1.add(datengay);
        panel1.add(ngayvaolam);
        panel1.add(datengayvaolam);
        panel1.add(chucvu);
        panel1.add(textchucvu);
        panel1.add(ghichu);

        panel2 = new JPanel();
        panel2.setLayout(null);

        JLabel manvs = new JLabel("*Mã Nhân viên:");
        manvs.setBounds(10, 10, 90, 30);
        JTextField textmanvs = new JTextField();
        textmanvs.setBounds(100, 10, 110, 25);
        JLabel hotens = new JLabel("Họ và tên");
        hotens.setBounds(220, 10, 110, 30);
        JTextField texthotens = new JTextField();
        texthotens.setBounds(280, 10, 160, 25);

        JLabel ngaysinhs = new JLabel("Ngày Sinh");
        ngaysinhs.setBounds(10, 50, 100, 25);
        JDateChooser datengays = new JDateChooser();
        datengays.setBounds(100, 50, 150, 25);

        JLabel ngayvaolams = new JLabel("Ngày vào làm");
        ngayvaolams.setBounds(10, 100, 100, 25);
        JDateChooser datengayvaolams = new JDateChooser();
        datengayvaolams.setBounds(100, 100, 150, 25);

        JLabel chucvus = new JLabel("*Chức vụ");
        chucvus.setBounds(260, 100, 110, 30);
        JTextField textchucvus = new JTextField();
        textchucvus.setBounds(310, 100, 130, 25);

        JLabel Sodt = new JLabel("Số điện thoại");
        Sodt.setBounds(10, 160, 110, 30);
        JTextField textSDT = new JTextField();
        textSDT.setBounds(100, 160, 130, 25);

        JLabel chuthichJLabels = new JLabel("Chú thích");
        chuthichJLabels.setBounds(10, 220, 110, 30);

        JButton reset = new JButton("Reset");
        reset.setBounds(100, 500, 100, 30);

        JButton update = new JButton("Update");
        update.setBounds(250, 500, 100, 30);

        JTextArea ghichus = new JTextArea();
        ghichus.setBounds(10, 250, 500, 220);

        panel12 = new JPanel();
        panel12.setLayout(null);

        JLabel thongtinthangs = new JLabel("Thay đổi mật khẩu:");
        thongtinthangs.setBounds(100, 5, 150, 30);
        thongtinthangs.setFont(new Font("TimesRoman", Font.BOLD, 15));
        thongtinthangs.setForeground(Color.red);

        JLabel tenuser = new JLabel("*Tên đăng nhập:");
        tenuser.setBounds(5, 50, 100, 30);
        JTextField texttenuser = new JTextField();
        texttenuser.setBounds(100, 50, 100, 25);

        JLabel matkhaucu = new JLabel("Mật khẩu cũ");
        matkhaucu.setBounds(5, 100, 100, 30);
        JTextField textluongcbs = new JTextField();
        textluongcbs.setBounds(100, 100, 120, 25);

        JLabel mkmoi = new JLabel("Mật khẩu mới");
        mkmoi.setBounds(5, 150, 100, 30);
        JTextField textmkmoi = new JTextField();
        textmkmoi.setBounds(100, 150, 120, 25);

        JLabel nhaplai = new JLabel("Nhập lại");
        nhaplai.setBounds(5, 200, 100, 30);
        JTextField textnhaplai = new JTextField();
        textnhaplai.setBounds(100, 200, 120, 25);
        
        JButton updatemk = new JButton("Update");
        updatemk.setBounds(100, 250, 100, 30);
        JLabel dausao = new JLabel("(*)Không thể thay đổi");
        dausao.setBounds(650, 320, 110, 30);
       
        panel12.add(nhaplai);
        panel12.add(textnhaplai);
        panel12.add(thongtinthangs);
        panel12.add(tenuser);
        panel12.add(texttenuser);
        panel12.add(matkhaucu);
        panel12.add(mkmoi);
        panel12.add(textmkmoi);
        panel12.add(textluongcbs);
        panel12.add(updatemk);
        panel12.setBounds(650, 10, 300, 300);
        panel12.setBackground(Color.PINK);
        panel2.add(panel12);

        panel2.setBackground(Color.decode("#99CCCC"));
        panel2.add(Sodt);
        panel2.add(chuthichJLabels);
        panel2.add(textSDT);
        panel2.add(manvs);
        panel2.add(textmanvs);
        panel2.add(hotens);
        panel2.add(texthotens);
        panel2.add(ngaysinhs);
        panel2.add(datengays);
        panel2.add(ngayvaolams);
        panel2.add(datengayvaolams);
        panel2.add(chucvus);
        panel2.add(textchucvus);
        panel2.add(ghichus);
        panel2.add(reset);
        panel2.add(update);
        panel2.add(dausao);
        /* add three tab with three JPanel */
        tabbedPane.addTab("Thông tin cá nhân", null, panel1, "click to show panel 1");
        tabbedPane.addTab("Thay đổi thông tin", null, this.panel2, "click to show panel 2");
        JPanel x = new JPanel();
        x.setLayout(new BorderLayout());
        x.add(tabbedPane, BorderLayout.CENTER);
        x.setBounds(2, 50, 990, 600);
     
        JButton quaylaiButton=new JButton("Quay lại");
        quaylaiButton.setBounds(10, 20, 80, 30);
        quaylaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jf.dispose();
                    new ManHinhChinh("",1);
                } catch (IOException ex) {
                    Logger.getLogger(Quanlytinthongcanhan.class.getName()).log(Level.SEVERE, null, ex);
                }
                  }
        });
        jf.add(quaylaiButton);
        jf.add(x);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }

}

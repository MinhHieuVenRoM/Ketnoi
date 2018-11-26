/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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

/**
 *
 * @author Minh Hieu
 */
public class Quanlynhanvien extends JFrame {

    JFrame f;
    JPanel panelNullLayOut;
    JPanel leftP;
    JLabel inflb;
    JLabel findlb;
    JTextField findtf;
    JPanel rightP;
    JLabel changelb;
    //
    JLabel id_stafflb;
    JTextField id_stafftf;
    //
    JLabel name_stafflb;
    JTextField name_stafftf;
    //
    JLabel birthdaylb;
    JDateChooser birthdaytf;
    //
    JLabel daytoworklb;
    JDateChooser daytoworktf;
    //
    JLabel positionlb;
    JTextField positiontf;
    //
    JLabel bonuslb;
    JLabel bonusf;
    //
    JLabel IDlb;
    JTextField IDtf;
    //
    JLabel passlb;
    JTextField passtf;
    //
    JLabel rulelb;
    //
    JTextField sefttf;
    //
    JTable table;
    JLabel headerlb;

    public Quanlynhanvien() {
        f = new JFrame();
        f.setTitle("Quản lý Cửa hàng tiện lợi");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);//Khong su dung Layout Manager  
        f.setSize(1015, 660);//Do rong la 1015 va chieu cao la 695
        panelNullLayOut = new JPanel();
        panelNullLayOut.setLayout(null);
        headerlb = new JLabel("Quản lý Nhân viên");
        headerlb.setFont(new Font("TimesRoman", Font.BOLD, 24));
        headerlb.setForeground(Color.gray);
        ////

        leftP = new JPanel();
        leftP.setLayout(null);
        leftP.setBounds(20, 50, 400, 600);
        inflb = new JLabel("Thông tin nhân viên: ");
        inflb.setFont(new Font("TimesRoman", Font.BOLD, 16));
        inflb.setBounds(0, 0, 170, 20);
        inflb.setForeground(Color.red);
        //
        findlb = new JLabel("Tìm kiếm: ");
        findlb.setFont(new Font("TimesRoman", Font.ITALIC, 15));
        findlb.setBounds(0, 30, 80, 20);
        findlb.setForeground(Color.black);

        findtf = new JTextField("Họ và tên");
        findtf.setBounds(70, 30, 180, 25);
        //
        String column[] = new String[]{"Mã NV", "Họ và tên", "Loại nhân viên"};
        Object data[][] = new Object[][]{
            {"001", "Nguyễn Văn A", "Hỗ trợ"},
            {"002", "Nguyễn Văn B", "Tại quầy"}};
        table = new JTable(data, column);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(5, 60, 350, 450);

        leftP.add(inflb);
        leftP.add(findlb);
        leftP.add(findtf);
        leftP.add(sp);
        //findtf.setBorder(BorderFactory.createCompoundBorder());
        rightP = new JPanel();
        rightP.setLayout(null);
        rightP.setBounds(425, 50, 580, 600);
        changelb = new JLabel("Thay đổi thông tin:");
        changelb.setFont(new Font("TimesRoman", Font.BOLD, 16));
        changelb.setForeground(Color.red);
        changelb.setBounds(20, 0, 170, 20);
        //
        id_stafflb = new JLabel("*Mã nhân viên: ");
        id_stafflb.setFont(new Font("TimesRoman", Font.BOLD, 15));
        id_stafflb.setForeground(Color.black);
        id_stafflb.setBounds(5, 35, 110, 20);
        //
        id_stafftf = new JTextField();
        id_stafftf.setFont(new Font("TimesRoman", Font.BOLD, 10));
        id_stafftf.setForeground(Color.red);
        id_stafftf.setBounds(120, 30, 90, 27);
        //
        name_stafflb = new JLabel("*Họ và tên: ");
        name_stafflb.setFont(new Font("TimesRoman", Font.BOLD, 15));
        name_stafflb.setForeground(Color.black);
        name_stafflb.setBounds(220, 35, 110, 20);
        //
        name_stafftf = new JTextField();
        name_stafftf.setFont(new Font("TimesRoman", Font.BOLD, 10));
        name_stafftf.setForeground(Color.red);
        name_stafftf.setBounds(310, 30, 180, 27);
        //
        birthdaylb = new JLabel("Ngày sinh:");
        birthdaylb.setFont(new Font("TimesRoman", Font.ITALIC, 15));
        birthdaylb.setForeground(Color.black);
        birthdaylb.setBounds(5, 65, 110, 20);

        birthdaytf = new JDateChooser();
        birthdaytf.setFont(new Font("TimesRoman", Font.ITALIC, 15));
        birthdaytf.setForeground(Color.black);
        birthdaytf.setBounds(120, 65, 180, 27);
        //
        daytoworklb = new JLabel("Ngày vào làm:");
        daytoworklb.setFont(new Font("TimesRoman", Font.ITALIC, 15));
        daytoworklb.setForeground(Color.black);
        daytoworklb.setBounds(5, 95, 150, 20);

        daytoworktf = new JDateChooser();
        daytoworktf.setFont(new Font("TimesRoman", Font.ITALIC, 15));
        daytoworktf.setForeground(Color.black);
        daytoworktf.setBounds(120, 95, 150, 27);
        //
        positionlb = new JLabel("Chức vụ: ");
        positionlb.setFont(new Font("TimesRoman", Font.BOLD, 15));
        positionlb.setForeground(Color.black);
        positionlb.setBounds(300, 95, 110, 20);

        positiontf = new JTextField("Chức vụ nhân viên");
        positiontf.setFont(new Font("TimesRoman", Font.ITALIC, 10));
        positiontf.setForeground(Color.black);
        positiontf.setBounds(380, 90, 180, 27);
        //
        bonuslb = new JLabel("Hệ số lương: ");
        bonuslb.setFont(new Font("TimesRoman", Font.BOLD, 15));
        bonuslb.setForeground(Color.black);
        bonuslb.setBounds(5, 125, 150, 20);

        bonusf = new JLabel("Hệ số...");
        bonusf.setFont(new Font("TimesRoman", Font.ITALIC, 13));
        bonusf.setForeground(Color.black);
        bonusf.setBounds(120, 127, 70, 20);
        //
        IDlb = new JLabel("Tên đăng nhập: ");
        IDlb.setFont(new Font("TimesRoman", Font.BOLD, 15));
        IDlb.setForeground(Color.black);
        IDlb.setBounds(160, 160, 150, 20);

        IDtf = new JTextField("   id...");
        IDtf.setFont(new Font("TimesRoman", Font.ITALIC, 13));
        IDtf.setForeground(Color.black);
        IDtf.setBounds(290, 155, 180, 27);
        //
        passlb = new JLabel("Mật khẩu: ");
        passlb.setFont(new Font("TimesRoman", Font.BOLD, 15));
        passlb.setForeground(Color.black);
        passlb.setBounds(160, 185, 150, 20);

        passtf = new JTextField("   password...");
        passtf.setFont(new Font("TimesRoman", Font.ITALIC, 13));
        passtf.setForeground(Color.black);
        passtf.setBounds(290, 185, 180, 27);
        //
        rulelb = new JLabel("(*) Không thể thay đổi thông tin");
        rulelb.setFont(new Font("TimesRoman", Font.ITALIC, 13));
        rulelb.setForeground(Color.red);
        rulelb.setBounds(5, 250, 200, 20);
        //
        sefttf = new JTextField("Sở trường, năng lực .....");
        sefttf.setFont(new Font("TimesRoman", Font.ITALIC, 15));
        sefttf.setForeground(Color.black);
        sefttf.setBounds(5, 270, 500, 200);
        //

        rightP.add(changelb);
        rightP.add(id_stafflb);
        rightP.add(id_stafftf);
        rightP.add(name_stafflb);
        rightP.add(name_stafftf);
        rightP.add(birthdaylb);
        rightP.add(birthdaytf);
        rightP.add(daytoworklb);
        rightP.add(daytoworktf);
        rightP.add(positionlb);
        rightP.add(positiontf);
        rightP.add(bonuslb);
        rightP.add(bonusf);
        rightP.add(IDlb);
        rightP.add(IDtf);
        rightP.add(passlb);
        rightP.add(passtf);
        rightP.add(rulelb);
        rightP.add(sefttf);
        ////

        JButton quaylaiButton = new JButton("Quay lại");
        quaylaiButton.setBounds(10, 20, 80, 30);
        quaylaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    f.dispose();
                    new ManHinhChinh("");
                } catch (IOException ex) {
                    Logger.getLogger(Quanlytinthongcanhan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        

        headerlb.setBounds(400, 0, 300, 40);
        headerlb.setBackground(Color.GREEN);
        panelNullLayOut.add(headerlb);
        panelNullLayOut.add(leftP);
        panelNullLayOut.add(rightP);
        panelNullLayOut.setBounds(0, 0, 1015, 660); 
        panelNullLayOut.add(quaylaiButton);
        f.add(panelNullLayOut);
        f.setVisible(true);//Tao Frame la co the nhin thay (visible)  
        f.setLocationRelativeTo(null);
    }
}

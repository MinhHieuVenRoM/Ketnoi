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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Minh Hieu
 */
public class GiaoDienKho extends JScrollPane{
    JFrame f = new JFrame();//Tao instance cua JFrame 
    
    

    
    static JPanel QLSP_timKiem()
    {
        JPanel TimKiem = new JPanel();  // Khung tim kiem
        TimKiem.setBackground(Color.WHITE);  // Mau nen cho khung tim kiem
        
        
        //-------------------------------------------------
        // Label tim kiem
        
        JLabel timkiem = new JLabel("Tìm kiếm: "); // Chu Tim kiem: 
        Font fontTimKiem = new Font("System", Font.BOLD, 12);  //set font
        timkiem.setFont(fontTimKiem);  
        timkiem.setBounds(14, 16, 58, 17);  // Dat vi tri cua label Tim kiem trong khung tim kiem
        
        TimKiem.add(timkiem);  //Them label Tim kiem vao Panel Tim kiem
        
        //-------------------------------------------------
        // textField tim kiem
        
        JTextField tenSP = new JTextField();
        tenSP.setText("Tên sản phẩm");
        tenSP.setBounds(80,12,259,25);
        tenSP.setPreferredSize(new Dimension(259,25));
        TimKiem.add(tenSP);
        
        //-------------------------------------------------
        // tao nut Tim
        
        JButton tim = new JButton("Tìm");
        tim.setBounds(351,12,76,26);
        tim.setPreferredSize(new Dimension(76,26));  //kich thuoc nut Tim
        TimKiem.add(tim);
        
        //-------------------------------------------------
        // tuy chinh khung tim kiem
        
        TimKiem.setLayout(null);  // set layout tuy chinh
        
        TimKiem.setPreferredSize(new Dimension(441,48));
        Border TimKiemBorder = BorderFactory.createLineBorder(Color.darkGray); //Tao border cho khung tim kiem
        TimKiem.setBorder(TimKiemBorder); //set Border
        
        return TimKiem;
    }
    
    static void QLSP_TopLeft(JPanel QLSP)
    {
        JPanel TimKiem = QLSP_timKiem(); //Panel Tim kiem
        TimKiem.setBounds(0,0,441,48);   //Set vi tri cua Panel tim kiem
        
        JPanel topLeft = new JPanel();
        topLeft.add(TimKiem);
        topLeft.setBounds(16,19,586,54);
        
        JButton ThemSP = new JButton("Thêm sản phẩm");
        ThemSP.setBounds(455,1,129,46);
        
        topLeft.add(ThemSP);
        topLeft.setPreferredSize(new Dimension(586,54));
        topLeft.setLayout(null);
        QLSP.add(topLeft);  // Them Panel tim kiem vao khung QLSanPham
    }
    
    static void QLSP_BangSP(JPanel QLSP)
    {
        DefaultTableModel bangSP = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int rows, int cols) {
                if(cols<2)
                    return false; //To change body of generated methods, choose Tools | Templates.
                else 
                    return true; 
            }
        };
        bangSP.addColumn("STT");
        bangSP.addColumn("Mã SP");
        bangSP.addColumn("Tên SP");
        bangSP.addColumn("Loại");
        bangSP.addColumn("Đơn giá nhập");
        bangSP.addColumn("Đơn giá bán");
        bangSP.addColumn("SL tồn");
        bangSP.addColumn("Ghi chú");
        
        Vector data = new Vector();
        data.add("1");
        data.add("SP001");
        data.add("7up");
        data.add("Nước GK");
        data.add("7000");
        data.add("10000");
        data.add("10");
        data.add("");
        
        JTable SP = new JTable();  //Tao bang (chi co noi dung bang)
        SP.setModel(bangSP);
        bangSP.addRow(data);
        
        
        JScrollPane sp = new JScrollPane(SP);  //Them tieu de moi cot
        sp.setBounds(16,73,586,457);
        
        QLSP.add(sp);
    }
    
    static void QLSP_ChinhSuaTT(JPanel QLSP)
    {
        JPanel ChinhSuaTT = new JPanel();
        ChinhSuaTT.setBounds(610,0,348,544);
        ChinhSuaTT.setLayout(null);
        
        //---------------------------------------------------
        //Tieu de 
        JLabel Title = new JLabel("Chỉnh sửa thông tin sản phẩm");
        Title.setFont(new Font("System", Font.BOLD + Font.ITALIC, 15));
        Title.setBounds(14,46,214,21);
        ChinhSuaTT.add(Title);
        
        //---------------------------------------------------
        //Bang chinh sua
        
        JPanel chinhsua = new JPanel();
        chinhsua.setBounds(14,73,320,457);
        chinhsua.setBackground(Color.white);
        chinhsua.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        chinhsua.setLayout(null);
        
            //Label maSP
            JLabel MaSP = new JLabel("Mã SP:");
            MaSP.setFont(new Font("System", Font.BOLD, 12));
            MaSP.setBounds(19,19,40,17);
            chinhsua.add(MaSP);
            //TextField maSP
            JTextField maSP = new JTextField("SP001");
            maSP.setBounds(62,15,87,25);
            chinhsua.add(maSP);
            
            //Label so luong ton
            JLabel SLT = new JLabel("Số lượng tồn:");
            SLT.setFont(new Font("System", Font.BOLD, 12));
            SLT.setBounds(169,19,78,17);
            chinhsua.add(SLT);
            //TextField so luong ton
            JTextField slt = new JTextField("0");
            slt.setBounds(250,15,51,25);
            chinhsua.add(slt);
            
            //Label ten san pham
            JLabel TenSP = new JLabel("Tên SP:");
            TenSP.setFont(new Font("System", Font.BOLD, 12));
            TenSP.setBounds(18,53,43,17);
            chinhsua.add(TenSP);
            //TextField ten san pham
            JTextField tenSP = new JTextField("Tên sản phẩm");
            tenSP.setBounds(62,49,240,25);
            chinhsua.add(tenSP);
        
            //Label don gia nhap
            JLabel DGNhap = new JLabel("Đơn giá nhập:");
            DGNhap.setFont(new Font("System", Font.BOLD, 12));
            DGNhap.setBounds(18,88,81,17);
            chinhsua.add(DGNhap);
            //TextField don gia nhap
            JTextField dgNhap = new JTextField("Giá nhập về");
            dgNhap.setBounds(104,84,198,25);
            chinhsua.add(dgNhap);
            
            //Label don gia ban
            JLabel DGBan = new JLabel("Đơn giá bán:");
            DGBan.setFont(new Font("System", Font.BOLD, 12));
            DGBan.setBounds(18,123,73,17);
            chinhsua.add(DGBan);
            //TextField don gia ban
            JTextField dgBan = new JTextField("Giá bán ra");
            dgBan.setBounds(105,120,198,25);
            chinhsua.add(dgBan);
            
            //Label Loai
            JLabel Loai = new JLabel("Loại:");
            Loai.setFont(new Font("System", Font.BOLD, 12));
            Loai.setBounds(18,156,28,17);
            chinhsua.add(Loai);
            //ComboBox Loai
            String[] type = new String[]{"Nước GK", "Snack"};
            JComboBox loai = new JComboBox(type);
            loai.setBounds(54,152,150,25);
            chinhsua.add(loai);
            
            //Label ghi chu
            JLabel GhiChu = new JLabel("Ghi chú:");
            GhiChu.setFont(new Font("System", Font.BOLD, 12));
            GhiChu.setBounds(18,186,48,17);
            chinhsua.add(GhiChu);
            //TextArea ghi chu
            JTextArea ghichu = new JTextArea("Hàng dễ vỡ, hàng khuyến mãi,...");
            ghichu.setBounds(18,211,285,176);
            ghichu.setBorder(BorderFactory.createLineBorder(Color.darkGray));
            chinhsua.add(ghichu);
            
            //Button Xoa
            JButton xoa = new JButton("Xoá");
            xoa.setBounds(18,397,58,46);
            chinhsua.add(xoa);
            
            //Button Sua
            JButton sua = new JButton("Sửa");
            sua.setBounds(246,397,58,46);
            chinhsua.add(sua);
        //---------------------------------------------------
        
        ChinhSuaTT.add(chinhsua);
        QLSP.add(ChinhSuaTT);
    }
    
    static JPanel QLSanPham()
    {
        JPanel QLSP = new JPanel(); //Cả khung Quản lý sản phẩm
        QLSP.setBounds(0,0,965,544);
        QLSP.setLayout(null);
        
        QLSP_TopLeft(QLSP);  //Khung tim kiem + nut Them SP
        
        QLSP_BangSP(QLSP);  // Bang SP
        
        QLSP_ChinhSuaTT(QLSP);
        
        return QLSP;
    }
    
    //---------------------------------------------------------------------------------
    static JPanel QLD_timKiem()
    {
        JPanel TimKiem = new JPanel();  // Khung tim kiem
        TimKiem.setBackground(Color.WHITE);  // Mau nen cho khung tim kiem
        
        
        //-------------------------------------------------
        // Label tim kiem
        
        JLabel timkiem = new JLabel("Tìm kiếm: "); // Chu Tim kiem: 
        Font fontTimKiem = new Font("System", Font.BOLD, 12);  //set font
        timkiem.setFont(fontTimKiem);  
        timkiem.setBounds(13, 16, 58, 17);  // Dat vi tri cua label Tim kiem trong khung tim kiem
        
        TimKiem.add(timkiem);  //Them label Tim kiem vao Panel Tim kiem
        
        //-------------------------------------------------
        // date choose tim kiem
        
        JDateChooser date = new JDateChooser(); 
        date.setFont(new Font("System",Font.PLAIN,12));
        date.setBounds(79,12,137,26);
        TimKiem.add(date); 
        date.setDateFormatString("dd/MM/yyyy");
        
        
        //-------------------------------------------------
        // tao nut Tim
        
        JButton tim = new JButton("Tìm");
        tim.setBounds(231,12,76,26);
        tim.setPreferredSize(new Dimension(76,26));  //kich thuoc nut Tim
        TimKiem.add(tim);
        
        
        //-------------------------------------------------
        // tuy chinh khung tim kiem
        
        TimKiem.setLayout(null);  // set layout tuy chinh
        
        TimKiem.setPreferredSize(new Dimension(320,48));
        Border TimKiemBorder = BorderFactory.createLineBorder(Color.darkGray); //Tao border cho khung tim kiem
        TimKiem.setBorder(TimKiemBorder); //set Border
        TimKiem.setBounds(0,3,320,48);
        
        return TimKiem;
    }
    
    static void QLD_TopLeft(JPanel QLD)
    {
        JPanel TimKiem = QLD_timKiem(); //Panel Tim kiem
        
        JPanel topLeft = new JPanel();
        topLeft.add(TimKiem);
        topLeft.setBounds(14,14,454,53);
        
        JButton NhapHang = new JButton("Nhập hàng");
        NhapHang.setBounds(333,4,102,46);
        
        topLeft.add(NhapHang);
        topLeft.setLayout(null);
        QLD.add(topLeft);  // Them Panel tim kiem vao khung QLSanPham
    }
    
    static void QLD_BangDon(JPanel QLD)
    {
        String column[] = new String[]{"STT","Mã đơn hàng","Ngày nhập hàng","Tổng giá trị","Ghi chú"};
        Object data[][] = new Object[][]{ 
            {"1", "DH001","22/02/2014", "1000000",""}, 
            {"2", "DH002","21/04/2015", "4000000",""}};
        
        JTable DH = new JTable(data, column);  //Tao bang (chi co noi dung bang)
        
        JScrollPane dh = new JScrollPane(DH);  //Them tieu de moi cot
        dh.setBounds(14,72,436,458);
        
        QLD.add(dh);
    }
    
    static void QLD_TTDon(JPanel QLD)
    {
        JPanel TT = new JPanel();
        TT.setBounds(472,34,490,509);
        TT.setLayout(null);
        
        
        JLabel title = new JLabel("Thông tin đơn hàng");
        title.setFont(new Font("System", Font.BOLD + Font.ITALIC, 15));
        title.setBounds(8,40,140,21);
        TT.add(title);
        
        
        JPanel tt = new JPanel();
        tt.setLayout(null);
        tt.setBounds(4,62,473,433);
        tt.setBackground(Color.white);
        tt.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        
            
            //Label ma don hang
            JLabel MaDH = new JLabel("Mã đơn hàng:");
            MaDH.setFont(new Font("System", Font.BOLD, 12));
            MaDH.setBounds(14,16,80,17);
            tt.add(MaDH);
            //TextField ma don hang
            JTextField maDH = new JTextField("DH001");
            maDH.setBounds(100,12,107,25);
            tt.add(maDH);
            
            //Label Ngay nhap
            JLabel NgayNhap = new JLabel("Ngày nhập:");
            NgayNhap.setFont(new Font("System", Font.BOLD, 12));
            NgayNhap.setBounds(232,16,70,17);     
            tt.add(NgayNhap);
            //date choose Ngay nhap
            JDateChooser ngayNhap = new JDateChooser(); 
            ngayNhap.setFont(new Font("System",Font.PLAIN,12));
            ngayNhap.setBounds(308,12,160,26);
            ngayNhap.setDateFormatString("dd/MM/yyyy");
            tt.add(ngayNhap); 
            
            //Label tong gia tri
            JLabel TongGT = new JLabel("Tổng giá trị:");
            TongGT.setFont(new Font("System", Font.BOLD, 12));
            TongGT.setBounds(14,48,70,17);
            tt.add(TongGT);
            //TextField Tong gia tri
            JTextField tongGT = new JTextField("Giá trị đơn hàng");
            tongGT.setBounds(100,44,107,25);
            tt.add(tongGT);
            
            //Label ghi chu
            JLabel GhiChu = new JLabel("Ghi chú:");
            GhiChu.setFont(new Font("System", Font.BOLD, 12));
            GhiChu.setBounds(14,76,48,17);
            tt.add(GhiChu);
            //TextArea ghi chu
            JTextArea ghichu = new JTextArea("Hàng dễ vỡ, hàng khuyến mãi,...");
            ghichu.setBounds(14,97,451,76);
            ghichu.setBorder(BorderFactory.createLineBorder(Color.darkGray));
            tt.add(ghichu);
            
            //Label DS san pham
            JLabel DSSP = new JLabel("Danh sách sản phẩm:");
            DSSP.setFont(new Font("System", Font.BOLD, 12));
            DSSP.setBounds(14,178,125,17);
            tt.add(DSSP);
            //table dssp
            String column[] = new String[]{"STT","Mã SP","Tên SP","Loại","Đơn giá","SL","Thành tiền"};
            Object data[][] = new Object[][]{ 
                {"1", "SP001","7up","Nước GK","7000","20","140000"}};

            JTable dssp = new JTable(data, column);  //Tao bang (chi co noi dung bang)

            JScrollPane DSsp = new JScrollPane(dssp);  //Them tieu de moi cot
            DSsp.setBounds(14,203,451,218);
            tt.add(DSsp);
        
        
        TT.add(tt);
        QLD.add(TT);
    }
    static JPanel QLDon()
    {
        JPanel qlDon = new JPanel();
        qlDon.setLayout(null);
        
        QLD_TopLeft(qlDon);
        QLD_BangDon(qlDon);
        QLD_TTDon(qlDon);
        
        return qlDon;
    }

    public GiaoDienKho() {

        f.getContentPane().setBackground(Color.WHITE); //Set mau nen cho ca frame
        f.setTitle("Quản lý kho");
        
        
        JLabel QLK = new JLabel("QUẢN LÝ KHO");
        QLK.setBounds(397,14,210,30);//Toa do X, Y, rong toi da, cao toi da cua Label
        Font fontQLK = new Font("System", Font.BOLD, 30); //Font System, Bold, 30
        QLK.setFont(fontQLK);
        
        JPanel tab1 = QLSanPham();
        
        JPanel tab2 = QLDon();
        
        JTabbedPane tabpane = new JTabbedPane();
        tabpane.add("Quản lý sản phẩm", tab1);
        tabpane.add("Quản lý đơn nhập hàng", tab2);
        tabpane.setBounds(17,63,965,573);
         JButton quaylaiButton=new JButton("Quay lại");
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
        f.add(quaylaiButton);

        f.add(QLK); //Them Label Quan Ly Kho vao trong JFrame  
        f.add(tabpane);
        
        f.setSize(1015,689);//Do rong la 1015 va chieu cao la 695
        f.setLayout(null);//Khong su dung Layout Manager  
        f.setVisible(true);//Tao Frame la co the nhin thay (visible)  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setLocationRelativeTo(null);
    }

            
    
}

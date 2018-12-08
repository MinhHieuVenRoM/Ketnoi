/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Minh Hieu
 */
public class NHANVIENModel {

    private String MaNV;
    private String TenNV;
    private Date NgaySinh;
    private String GioiTinh;
    private String DiaChi;
    private String MaChucVu;
    private Date NgayVaoLam;
    private String SDT;
    private String MatKhau;

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

    public void setNgayVaoLam(Date NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public Date getNgayVaoLam() {
        return NgayVaoLam;
    }

    public String getSDT() {
        return SDT;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public NHANVIENModel(String ten,String pass) {
        this.TenNV=ten;
        this.MatKhau=pass;
    }
    
}

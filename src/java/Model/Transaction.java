/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author buiqu
 */
public class Transaction {
    private String maGD;
    private String moTa;
    private double giaTri;
    private String ngayDienRa;
    private String soTaiKhoan;

    public Transaction(String maGD, String moTa, double giaTri, String ngayDienRa, String soTaiKhoan) {
        this.maGD = maGD;
        this.moTa = moTa;
        this.giaTri = giaTri;
        this.ngayDienRa = ngayDienRa;
        this.soTaiKhoan = soTaiKhoan;
    }

    // Getters and Setters

    public String getMaGD() {
        return maGD;
    }

    public void setMaGD(String maGD) {
        this.maGD = maGD;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(double giaTri) {
        this.giaTri = giaTri;
    }

    public String getNgayDienRa() {
        return ngayDienRa;
    }

    public void setNgayDienRa(String ngayDienRa) {
        this.ngayDienRa = ngayDienRa;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    @Override
    public String toString() {
        return "Transaction{" + "maGD=" + maGD + ", moTa=" + moTa + ", giaTri=" + giaTri + ", ngayDienRa=" + ngayDienRa + ", soTaiKhoan=" + soTaiKhoan + '}';
    }
    
}

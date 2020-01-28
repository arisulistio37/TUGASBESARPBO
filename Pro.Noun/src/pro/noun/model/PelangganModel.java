/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.noun.model;

import javax.swing.JOptionPane;
import pro.noun.event.PelangganListener;

/**
 *
 * @author asus
 */
public class PelangganModel {
    
    
    private String nama;
    private String email;
    private String noTelp;
    private String harga;
    private String jumlah;
    
    private PelangganListener pelangganListener;

    public PelangganListener getPelangganListener() {
        return pelangganListener;
    }

    public void setPelangganListener(PelangganListener pelangganListener) {
        this.pelangganListener = pelangganListener;
    }
    
    
    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
        fireOnChange();
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
        fireOnChange();
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
        fireOnChange();
    }
    
    
    private void fireOnChange(){
        if (pelangganListener!=null){
            pelangganListener.onChange(this);
        }
        
    }
    
    public void resetForm(){
        setNama("");
        setEmail("");
        setNoTelp("");
        setHarga("");
        setJumlah("");
    }
    
    public void simpanForm(){
        JOptionPane.showMessageDialog(null,"Berhasil Disimpan");
        
    }
    
        
}

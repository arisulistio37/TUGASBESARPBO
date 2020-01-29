/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.noun.model;


import java.sql.SQLException;
import pro.noun.database.PronounDatabase;
import pro.noun.entity.Pelanggan;
import pro.noun.error.PelangganException;
import pro.noun.event.PelangganListener;
import pro.noun.service.PelangganDao;

/**
 *
 * @author Acer
 */
public class PelangganModel {
    
    private Integer id;
    private String nama;
    private String alamat;
    private String telepon;
    private String email;
    private Integer harga;
    private Integer jumlah;
    private Integer total;
    
    private PelangganListener listener;

    public PelangganListener getListener() {
        return listener;
    }

    public void setListener(PelangganListener listener) {
        this.listener = listener;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
    
    
    
    protected void fireOnChange(){
         if (listener != null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Pelanggan pelanggan){
         if (listener != null) {
            listener.onInsert(pelanggan);
        }
    }
    
    protected void fireOnUpdate(Pelanggan pelanggan){
        if (listener != null) {
            listener.onUpdate(pelanggan);
        }
    }
    
    protected void fireOnDelete(){
        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void insertPelanggan() throws SQLException, PelangganException {
        PelangganDao dao = PronounDatabase.getPelangganDao();

        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setEmail(email);
        pelanggan.setHarga(harga);
        pelanggan.setJumlah(jumlah);
         pelanggan.setTotal(total);

        dao.insertPelanggan(pelanggan);
        fireOnInsert(pelanggan);
    }
    
    public void updatePelanggan() throws SQLException, PelangganException {
        PelangganDao dao = PronounDatabase.getPelangganDao();

        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setId(id);
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setEmail(email);
        pelanggan.setHarga(harga);
        pelanggan.setJumlah(jumlah);
        pelanggan.setTotal(total);

        dao.updatePelanggan(pelanggan);
        fireOnUpdate(pelanggan);
    }
    
    public void deletePelanggan() throws SQLException, PelangganException {
        
        PelangganDao dao = PronounDatabase.getPelangganDao();
        dao.deletePelanggan(id);
        fireOnDelete();
    }
    
    public void resetPelanggan(){
        
    setId(0);
        setNama("");
        setAlamat("");
        setEmail("");
        setHarga(0);
        setJumlah(0);
        setTotal(0);
    }

}
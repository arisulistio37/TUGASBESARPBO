/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.noun.entity;

import java.util.Objects;

/**
 *
 * @author asus
 */
public class Pelanggan {
    
    private Integer id;
    private String nama;
    private String alamat;
    private String email;
    private Integer harga;
    private Integer jumlah;
     private Integer total;
    
    
    public Pelanggan(){
        
    }

    public Pelanggan(String nama, String alamat, String email, Integer harga, Integer jumlah) {
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.harga = harga;
        this.jumlah = jumlah;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nama);
        hash = 83 * hash + Objects.hashCode(this.alamat);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.harga);
        hash = 83 * hash + Objects.hashCode(this.jumlah);
        hash = 83 * hash + Objects.hashCode(this.total);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelanggan other = (Pelanggan) obj;
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.alamat, other.alamat)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.harga, other.harga)) {
            return false;
        }
        if (!Objects.equals(this.jumlah, other.jumlah)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }

   
    

   
    
    
}

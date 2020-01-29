/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.noun.controller;


import javax.swing.JOptionPane;
import pro.noun.model.PelangganModel;
import pro.noun.view.NewMainView;

/**
 *
 * @author Acer
 */
public class PelangganController {
    
    PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void resetPelanggan(NewMainView u){
        model.resetPelanggan();
    }
    
   
    public void insertPelanggan(NewMainView u){
        String nama = u.getTxtNama().getText();
        String alamat = u.getTxtAlamat().getText();
        String email = u.getTxtEmail().getText();
        Integer harga = Integer.parseInt(u.getTxtHarga().getText());
        Integer jumlah = Integer.parseInt(u.getTxtJumlah().getText());
        Integer total = Integer.parseInt(u.getTxtTotal().getText());

        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(u, "Nama Masih Kosong");
        } else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setEmail(email);
            model.setHarga(harga);
            model.setJumlah(jumlah);
            model.setTotal(total);
     
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(u, "Pelanggan Berhasil Ditambahkan");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(u, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }
    public void updatePelanggan(NewMainView u){
         if (u.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(u, "Silahkan Seleksi baris data yang akan diubah");
            return;
        }
         
        Integer id = Integer.parseInt(u.getTxtId().getText());
        String nama = u.getTxtNama().getText();
        String alamat = u.getTxtAlamat().getText();
        
        String email = u.getTxtEmail().getText();
        Integer harga = Integer.parseInt(u.getTxtHarga().getText());
        Integer jumlah = Integer.parseInt(u.getTxtJumlah().getText());
        Integer total = Integer.parseInt(u.getTxtTotal().getText());
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(u, "Nama Masih Kosong");
        } else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setEmail(email);
            model.setHarga(harga);
            model.setJumlah(jumlah);
            model.setTotal(total);
            
           
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(u, "Pelanggan Berhasil Diubah");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(u, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }
    
    public void deletePelanggan(NewMainView u){
    //jika tidak ada yang diseleksi kasih peringatan
        if (u.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(u, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(u, "Anda yakin akan menghapus?")
                == JOptionPane.OK_OPTION) {

            Integer no = Integer.parseInt(u.getTxtId().getText());
            model.setId(no);

            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(u, "Data Pelanggan Berhasil Di Hapus");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(u, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

}

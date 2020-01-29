/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.noun.service;

import java.util.List;
import pro.noun.entity.Pelanggan;
import pro.noun.error.PelangganException;

/**
 *
 * @author asus
 */
public interface PelangganDao {
    
    public void insertPelanggan(Pelanggan pelanggan ) throws PelangganException;
    
    public void updatePelanggan(Pelanggan pelanggan ) throws PelangganException;
    
    public void deletePelanggan(Integer id ) throws PelangganException;
    
    public List<Pelanggan> selectAllPelanggan() throws PelangganException;

    


}

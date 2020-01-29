/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.noun.impl;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import pro.noun.entity.Pelanggan;
import pro.noun.error.PelangganException;
import pro.noun.service.PelangganDao;

/**
 *
 * @author asus
 */
public class PelangganDaoImpl implements PelangganDao{
    
    private Connection connection;
    
    private final String insertPelanggan = "INSERT INTO PELANGGAN(NAMA,ALAMAT,EMAIL,HARGA,JUMLAH,TOTAL) VALUES (?,?,?,?,?,?)";

    private final String updatePelanggan = "UPDATE PELANGGAN SET NAMA=?,ALAMAT=?,EMAIL=?,HARGA=?,JUMLAH=?,TOTAL=? WHERE ID=?";
    
    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID=?";
    
    private final String selectAll = "SELECT * FROM PELANGGAN";
    public PelangganDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    

    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException {
        
         PreparedStatement statement = null;
         try {
             connection.setAutoCommit(false);
            statement = (PreparedStatement) connection.prepareStatement(insertPelanggan);
            statement.setString(1,pelanggan.getNama());
            statement.setString(2,pelanggan.getAlamat());
            statement.setString(3,pelanggan.getEmail());
            statement.setInt(4,pelanggan.getHarga());
            statement.setInt(5,pelanggan.getJumlah());
            statement.setInt(6,pelanggan.getTotal());
            statement.executeUpdate();
            
           
            
            connection.commit();
            
        } catch (SQLException e) {
                try {
                    connection.rollback();
             } catch (SQLException ex) {
             }
            throw new PelangganException(e.getMessage()); 
        } finally {
             try {
                 connection.setAutoCommit(true); 
             } catch (SQLException ex) {
             }
                if (statement!=null) {
                    try {
                    statement.close(); 
                } catch (SQLException e) {
                }
             }
             
             
             
         }
        
        
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement statement = null;
         try {
             connection.setAutoCommit(false);
            statement =  (PreparedStatement) connection.prepareStatement(updatePelanggan);
            statement.setString(1,pelanggan.getNama());
            statement.setString(2,pelanggan.getAlamat());
            statement.setString(4,pelanggan.getEmail());
            statement.setInt(5,pelanggan.getHarga());
            statement.setInt(6,pelanggan.getJumlah());
            statement.setInt(7,pelanggan.getTotal());
            statement.executeUpdate();
           connection.commit();
           
        } catch (SQLException e) {
                try {
                    connection.rollback();
             } catch (SQLException ex) {
             }
            throw new PelangganException(e.getMessage()); 
        } finally {
             try {
                 connection.setAutoCommit(true); 
             } catch (SQLException ex) {
             }
                if (statement!=null) {
                    try {
                    statement.close(); 
                } catch (SQLException e) {
                }
             }
             
             
             
         }
    }

    @Override
    public void deletePelanggan(Integer id) throws PelangganException {
        PreparedStatement statement = null;
         try {
             connection.setAutoCommit(false);
            statement = (PreparedStatement) connection.prepareStatement(deletePelanggan);
            statement.setInt(1,id);
            statement.executeUpdate();
            connection.commit();
            
        } catch (SQLException e) {
                try {
                    connection.rollback();
             } catch (SQLException ex) {
             }
            throw new PelangganException(e.getMessage()); 
        } finally {
             try {
                 connection.setAutoCommit(true); 
             } catch (SQLException ex) {
             }
                if (statement!=null) {
                    try {
                    statement.close(); 
                } catch (SQLException e) {
                }
             }
             
             
             
         }
    }

   

    @Override
    public List<Pelanggan> selectAllPelanggan() throws PelangganException {
        Statement statement = null;
        List<Pelanggan> list = new ArrayList<Pelanggan>();
        
        try {
            connection.setAutoCommit(false);
            statement =  connection.createStatement();
            
             ResultSet result = statement.executeQuery(selectAll);
             
             
             while (result.next()) {
                 Pelanggan pelanggan = new Pelanggan();
                 pelanggan.setNama(result.getString("NAMA"));
                 pelanggan.setAlamat(result.getString("ALAMAT"));
                 pelanggan.setEmail(result.getString("EMAIL"));
                 pelanggan.setHarga(result.getInt("HARGA"));
                 pelanggan.setJumlah(result.getInt("JUMLAH"));
                 pelanggan.setTotal(result.getInt("TOTAL"));
                 list.add(pelanggan);
             }
             connection.commit();
            return list;
        } catch (SQLException e) {
                try {
                    connection.rollback();
             } catch (SQLException ex) {
             }
            throw new PelangganException(e.getMessage()); 
        } finally {
             try {
                 connection.setAutoCommit(true); 
             } catch (SQLException ex) {
             }
                if (statement!=null) {
                    try {
                    statement.close(); 
                } catch (SQLException e) {
                }
             }
             
             
             
         }
    }

       
}

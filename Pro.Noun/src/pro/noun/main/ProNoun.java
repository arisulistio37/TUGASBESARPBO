/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.noun.main;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import pro.noun.error.PelangganException;
import pro.noun.view.HalamanMainView;


/**
 *
 * @author Acer
 */
public class ProNoun {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws pro.noun.error.PelangganException
     */
    public static void main(String[] args) throws SQLException, PelangganException{
        // TODO code application logic hereLoginDao dao = LaundryskuyDatabase.getLoginDao();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    HalamanMainView pelanggan = new HalamanMainView();
                    pelanggan.loadDatabase();
                    pelanggan.setVisible(true);
                } catch (SQLException ex) {
                } catch (PelangganException ex) {
                    Logger.getLogger(ProNoun.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
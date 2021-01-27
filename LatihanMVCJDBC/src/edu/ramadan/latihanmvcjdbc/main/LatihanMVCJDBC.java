/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ramadan.latihanmvcjdbc.main;

import edu.ramadan.latihanmvcjdbc.database.BarbershopDatabase;
import edu.ramadan.latihanmvcjdbc.entity.Pelanggan;
import edu.ramadan.latihanmvcjdbc.error.pelangganException;
import edu.ramadan.latihanmvcjdbc.service.PelangganDao;
import java.sql.SQLException;

/**
 *
 * @author ENDOG
 * Nama     : Muhamad Ramadan
 * Nim      : 10119004
 * Kelas    : IF1
 */
public class LatihanMVCJDBC {
    public static void main(String[] args) throws SQLException, pelangganException{
        
        PelangganDao dao = BarbershopDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama("Muhamad Ramadan");
        pelanggan.setAlamat("Rancaekek");
        pelanggan.setTelepon("081398651635");
        pelanggan.setEmail("muhamadramadan202@gmail.com");
        
        dao.insertPelanggan(pelanggan);
    }
    
}

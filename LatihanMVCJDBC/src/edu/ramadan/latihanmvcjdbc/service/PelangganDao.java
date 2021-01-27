/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ramadan.latihanmvcjdbc.service;
import edu.ramadan.latihanmvcjdbc.entity.Pelanggan;
import edu.ramadan.latihanmvcjdbc.error.pelangganException;
import java.util.List;

/**
 *
 * @author ENDOG
 * Nama     : Muhamad Ramadan
 * Nim      : 10119004
 * Kelas    : IF1
 */
public interface PelangganDao {
    
    //untuk melakukan aktifitas CRUD
    //get by ID dan get by Email
    public void insertPelanggan(Pelanggan pelanggan) throws pelangganException;
    
    public void updatePelanggan(Pelanggan pelanggan) throws pelangganException;
    
    public void deletePelanggan(Integer id) throws pelangganException;
    
    public Pelanggan getPelanggan(Integer id) throws pelangganException;
    
    //unique
    public Pelanggan getPelanggan(String email) throws pelangganException;
    
    //jika ingin meload semua data pelanggan
    public List<Pelanggan> selectAllPelanggan() throws pelangganException;
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ramadan.latihanmvcjdbc.impl;

import edu.ramadan.latihanmvcjdbc.entity.Pelanggan;
import edu.ramadan.latihanmvcjdbc.error.pelangganException;
import edu.ramadan.latihanmvcjdbc.service.PelangganDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ENDOG
 * Nama     : Muhamad Ramadan
 * Nim      : 10119004
 * Kelas    : IF1
 */
public class PelangganDaoImpl implements PelangganDao{
    
    private Connection connection;
    
    public PelangganDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    private final String insertPelanggan = "INSERT INTO PELANGGAN"
            + "(NAMA, ALAMAT, TELEPON, EMAIL) VALUES"
            + "(?,?,?,?)";

    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws pelangganException {
        
        //Gimana jika suatu saat ketika diproses didalam try terjadi error
        //Otomatis kan akan menempatkan statement ke dalam catch tanpa di close.
        //Jadi kita pasang finally dan
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPelanggan);
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getAlamat());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getEmail());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new pelangganException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
            }
        }
        }
        
    }
    
    private final String updatePelanggan = "UPDATE PELANGGAN SET NAMA=?,ALAMAT=?,TELEPON=?,EMAIL=? WHERE ID=?";

    @Override
    public void updatePelanggan(Pelanggan pelanggan) throws pelangganException {
        
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePelanggan);
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getAlamat());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getEmail());
            statement.setInt(5, pelanggan.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new pelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
            }
        }
    }
            
       
    }
    
    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID=?";

    @Override
    public void deletePelanggan(Integer id) throws pelangganException {
        
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement =connection.prepareStatement(deletePelanggan);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new pelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
                }
        }
        
    }
    
    private final String getById = "SELECT * FROM PELANGGAN WHERE ID=?";

    @Override
    public Pelanggan getPelanggan(Integer id) throws pelangganException {
        
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            //indeks ke 1, isinya ID dari parameter
            statement.setInt(1, id);
            
            ResultSet result = statement.executeQuery();
            Pelanggan pelanggan = null;
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
            } else {
                throw new pelangganException("Pelanggan dengan id " + id + " tidak ditemukan");
            }
            connection.commit();
            return pelanggan;
            
            } catch (SQLException e) {
                try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new pelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
        
    }
    
     private final String getByEmail = "SELECT * FROM PELANGGAN WHERE EMAIL=?";

    @Override
    public Pelanggan getPelanggan(String email) throws pelangganException {
        
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByEmail);
            //indeks ke 1, isinya ID dari parameter
            statement.setString(1, email);
            
            ResultSet result = statement.executeQuery();
            Pelanggan pelanggan = null;
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
            } else {
                throw new pelangganException("Pelanggan dengan email " + email + " tidak ditemukan");
            }
            connection.commit();
            return pelanggan;
            
            } catch (SQLException e) {
                try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new pelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
  
    }
    
    private final String selectAll = "SELECT * FROM PELANGGAN";

    @Override
    public List<Pelanggan> selectAllPelanggan() throws pelangganException {
        Statement statement = null;
        List<Pelanggan> list = new ArrayList<Pelanggan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()) {
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                
                list.add(pelanggan);
            }
            connection.commit();
            return list;
            
            } catch (SQLException e) {
                try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new pelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    
}

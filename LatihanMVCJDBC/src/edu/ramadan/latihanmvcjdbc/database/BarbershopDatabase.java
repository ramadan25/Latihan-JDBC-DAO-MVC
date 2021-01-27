/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ramadan.latihanmvcjdbc.database;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.ramadan.latihanmvcjdbc.impl.PelangganDaoImpl;
import edu.ramadan.latihanmvcjdbc.service.PelangganDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ENDOG
 * Nama     : Muhamad Ramadan
 * Nim      : 10119004
 * Kelas    : IF1
 */
public class BarbershopDatabase {
    private static PelangganDao pelangganDao;
    
    public static PelangganDao getPelangganDao() throws SQLException {
        if (pelangganDao == null) {
            pelangganDao = new PelangganDaoImpl(getConnection());
        }
        return pelangganDao;
    }
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/barbershg");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        return connection;
    }
    
}

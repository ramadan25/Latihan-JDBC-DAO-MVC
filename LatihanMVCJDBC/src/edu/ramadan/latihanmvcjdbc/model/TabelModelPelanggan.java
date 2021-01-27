/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ramadan.latihanmvcjdbc.model;

import edu.ramadan.latihanmvcjdbc.entity.Pelanggan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ENDOG
 * Nama     : Muhamad Ramadan
 * Nim      : 10119004
 * Kelas    : IF1
 */
public class TabelModelPelanggan extends AbstractTableModel{

    private List<Pelanggan> list = new ArrayList<Pelanggan>();
    
    public void setList(List<Pelanggan> list) {
        this.list = list;
}

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "NAMA";
            case 3:
                return "ALAMAT";
            case 4:
                return "TELEPON";
            case 5:
                return "EMAIL";
            default:
                return null;
    }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    public boolean add(Pelanggan e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Pelanggan set(int index, Pelanggan element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Pelanggan remove(int index) {
        try {
            return list.remove(index);
        } finally {
                fireTableRowsUpdated(index, index);
        }
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 3:
                return list.get(rowIndex).getAlamat();
            case 4:
                return list.get(rowIndex).getTelepon();
            case 5:
                return list.get(rowIndex).getEmail();
            default:
                return null;
        }
    
    }
}
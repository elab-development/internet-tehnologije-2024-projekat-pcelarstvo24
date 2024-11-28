/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ClanBiblioteke;

/**
 *
 * @author Aleksandra
 */
public class ModelTabeleClanBiblioteke extends AbstractTableModel {

    private String[] kolone = {"ID", "IME", "PREZIME", "CENA PENALA", "UKUPNO ZADUZENJE"};
    private List<ClanBiblioteke> listaClanova = new ArrayList<>();

    public ModelTabeleClanBiblioteke(List<ClanBiblioteke> listaClanova) {
        this.listaClanova = listaClanova;
    }

    @Override
    public int getRowCount() {
        return listaClanova.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClanBiblioteke c = listaClanova.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getIme();
            case 2:
                return c.getPrezime();
            case 3:
                return c.getCenaPenala();
            case 4:
                return c.getUkupnoZaduzenje();
            default:
                System.out.println("GRESKA MODEL TABELE CLAN BIBLIOTEKE");
                return null;
        }
    }

    public String[] getKolone() {
        return kolone;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }

    public List<ClanBiblioteke> getListaClanova() {
        return listaClanova;
    }

    public void setListaClanova(List<ClanBiblioteke> listaClanova) {
        this.listaClanova = listaClanova;
    }

    public String getColumnName(int column) {
        return kolone[column];
    }

    void osveziTabelu() {
        fireTableDataChanged();
    }
}

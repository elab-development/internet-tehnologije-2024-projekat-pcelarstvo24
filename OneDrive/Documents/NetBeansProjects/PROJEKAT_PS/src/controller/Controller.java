/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.Bibliotekar;
import model.ClanBiblioteke;

/**
 *
 * @author Aleksandra
 */
public class Controller {

    private static Controller instance;

    private List<ClanBiblioteke> listaClanova = new ArrayList<>();
    private DBBroker dbb;

    public Controller() {
        dbb = new DBBroker();
    }

    public static Controller getinstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public List<ClanBiblioteke> getListaClanova() {
        return listaClanova;
    }

    public void setListaClanova(List<ClanBiblioteke> listaClanova) {
        this.listaClanova = listaClanova;
    }

    public List<ClanBiblioteke> ucitajClanoveIzBaze() {
        return dbb.ucitajClanoveIzBaze();
    }

    public void obrisiClanaIzBaze(int selektovaniRed) {
        dbb.obrisiClanaIzBaze(selektovaniRed);
    }

    public void ubaciClanaUBazu(ClanBiblioteke c) {
        dbb.ubaciClanaUBazu(c);
    }

    public void izmeniClanaBiblioteke(int id, String ime, String prezime, int cenaP, int uk) {
        dbb.izmeniClanaBiblioteke(id, ime, prezime, cenaP, uk);
    }

    public List<ClanBiblioteke> pretraziClana(String ime, String prezime) {
        return dbb.pretraziClana(ime, prezime);
    }

    public List<Bibliotekar> vratiSveBibliotekare() {
        return dbb.vratiSveBibliotekare();
    }

}

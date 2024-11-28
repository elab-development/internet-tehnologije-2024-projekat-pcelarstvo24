/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ClanBiblioteke;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.Bibliotekar;

/**
 *
 * @author Aleksandra
 */
public class DBBroker {

    public List<ClanBiblioteke> ucitajClanoveIzBaze() {
        List<ClanBiblioteke> listaClanova = new ArrayList<>();
        String upit = "SELECT * FROM clan";
        try {
            Statement s = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("id");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                int cenaPenala = rs.getInt("cenapenala");
                int ukupnoZad = rs.getInt("ukupnozaduzenje");

                ClanBiblioteke c = new ClanBiblioteke(id, ime, prezime, cenaPenala, ukupnoZad);
                listaClanova.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaClanova;
    }

    public void obrisiClanaIzBaze(int selektovaniRed) {
        int id = ucitajClanoveIzBaze().get(selektovaniRed).getId(); //vraca mi id osobe koja se trenutno nalazi u selektovanom redu
        String upit = "DELETE FROM clan WHERE id=?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, id);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ubaciClanaUBazu(ClanBiblioteke c) {
        String ime = c.getIme();
        String prezime = c.getPrezime();
        int cenap = c.getCenaPenala();
        int uk = c.getUkupnoZaduzenje();

        String upit = "INSERT INTO clan(ime, prezime, cenapenala,ukupnozaduzenje) VALUES (?, ?, ?,?)";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setInt(3, cenap);
            ps.setInt(4, uk);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Član je uspešno dodat.");
            } else {
                System.out.println("Greška prilikom dodavanja člana.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void izmeniClanaBiblioteke(int id, String ime, String prezime, int cenaP, int uk) {
        String upit = "UPDATE clan SET ime = ?, prezime = ?, cenapenala = ?, ukupnozaduzenje = ? WHERE id = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setInt(3, cenaP);
            ps.setInt(4, uk);
            ps.setInt(5, id);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Član je uspešno izmenjen.");

            } else {
                System.out.println("Greška prilikom izmene člana.");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<ClanBiblioteke> pretraziClana(String ime, String prezime) {
        ClanBiblioteke clan = null;
        List<ClanBiblioteke> lista = new ArrayList<>();
        String upit = "SELECT * FROM clan WHERE ime = ? AND prezime = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, ime);
            ps.setString(2, prezime);
            Konekcija.getInstance().getConnection().commit();
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                clan = new ClanBiblioteke();
                clan.setId(rs.getInt("id"));
                clan.setIme(rs.getString("ime"));
                clan.setPrezime(rs.getString("prezime"));
                clan.setCenaPenala(rs.getInt("cenapenala"));
                clan.setUkupnoZaduzenje(rs.getInt("ukupnozaduzenje"));
                System.out.println("ID: " + clan.getId() + ", Ime: " + clan.getIme() + ", Prezime: " + clan.getPrezime());
                lista.add(clan);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Bibliotekar> vratiSveBibliotekare() {
        List<Bibliotekar> listaBibliotekara = new ArrayList<>();
        String upit = "SELECT * FROM bibliotekar";
        try {
            Statement s = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(upit);

            while (rs.next()) {
                int id = rs.getInt("id");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                int godinaRodjenja = rs.getInt("godinarodjenja");
                String korisnickoIme = rs.getString("korisnickoime");
                String lozinka = rs.getString("lozinka");
                Bibliotekar b = new Bibliotekar(id, ime, prezime, godinaRodjenja, korisnickoIme, lozinka);
                listaBibliotekara.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaBibliotekara;

    }

}

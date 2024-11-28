/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author Aleksandra
 */
public class ClanBiblioteke {

    private int id;
    private String ime;
    private String prezime;
    private int cenaPenala;
    private int ukupnoZaduzenje;
    private int idKategorijaOsobe;

    public ClanBiblioteke() {
    }
   public ClanBiblioteke(String ime, String prezime, int cenaPenala, int ukupnoZaduzenje) {
        this.ime = ime;
        this.prezime = prezime;
        this.cenaPenala = cenaPenala;
        this.ukupnoZaduzenje = ukupnoZaduzenje;
    }
  
    public ClanBiblioteke(int id, String ime, String prezime, int cenaPenala, int ukupnoZaduzenje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.cenaPenala = cenaPenala;
        this.ukupnoZaduzenje = ukupnoZaduzenje;
    }

    @Override
    public String toString() {
        return "ClanBiblioteke{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", cenaPenala=" + cenaPenala + ", ukupnoZaduzenje=" + ukupnoZaduzenje + ", idKategorijaOsobe=" + idKategorijaOsobe + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClanBiblioteke other = (ClanBiblioteke) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cenaPenala != other.cenaPenala) {
            return false;
        }
        if (this.ukupnoZaduzenje != other.ukupnoZaduzenje) {
            return false;
        }
        if (this.idKategorijaOsobe != other.idKategorijaOsobe) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        return Objects.equals(this.prezime, other.prezime);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getCenaPenala() {
        return cenaPenala;
    }

    public void setCenaPenala(int cenaPenala) {
        this.cenaPenala = cenaPenala;
    }

    public int getUkupnoZaduzenje() {
        return ukupnoZaduzenje;
    }

    public void setUkupnoZaduzenje(int ukupnoZaduzenje) {
        this.ukupnoZaduzenje = ukupnoZaduzenje;
    }

//    public int getIdKategorijaOsobe() {
//        return idKategorijaOsobe;
//    }
//
//    public void setIdKategorijaOsobe(int idKategorijaOsobe) {
//        this.idKategorijaOsobe = idKategorijaOsobe;
//    }
}

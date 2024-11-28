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
public class KategorijaOsobe {
    private int id;
    private String naziv;
    private boolean povlastica;

    public KategorijaOsobe() {
    }

    public KategorijaOsobe(int id, String naziv, boolean povlastica) {
        this.id = id;
        this.naziv = naziv;
        this.povlastica = povlastica;
    }

    @Override
    public String toString() {
        return "KategorijaOsobe{" + "id=" + id + ", naziv=" + naziv + ", povlastica=" + povlastica + '}';
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
        final KategorijaOsobe other = (KategorijaOsobe) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.povlastica != other.povlastica) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isPovlastica() {
        return povlastica;
    }

    public void setPovlastica(boolean povlastica) {
        this.povlastica = povlastica;
    }
    
}

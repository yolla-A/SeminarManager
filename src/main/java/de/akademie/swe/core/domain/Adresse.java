package de.akademie.swe.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "adresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "strasse", length = 100, nullable = false)
    private String strasse;
    @Column(name = "plz", length = 5, nullable = false)
    private String plz;
    @Column(name = "ort", length = 100, nullable = false)
    private String ort;

    private Adresse() {     // Default Konstruktor
    }

    public Adresse(String strasse, String plz, String ort) {
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }

    @Override
    public boolean equals(Object o) {       //without id
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return Objects.equals(strasse, adresse.strasse) && Objects.equals(plz, adresse.plz) && Objects.equals(ort, adresse.ort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strasse, plz, ort);
    }


    public long getId() { //only getter for Id no setter
        return id;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
                                                   //toString
    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", strasse='" + strasse + '\'' +
                ", plz='" + plz + '\'' +
                ", ort='" + ort + '\'' +
                '}';
    }
}

package de.akademie.swe.application.rest.dto;

import de.akademie.swe.core.domain.Anrede;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonDto {
    //@Notnull
// @Pattern for password for example

    private Anrede anrede;
    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    @Size(min = 2)
    private String vorname;

    @Past
    @DateTimeFormat
    private Date geburtsdatum;

   /* //private String geburtsdatum;*/
    private Date convertedGeburtsdatum;

    @NotBlank
    @Size(min = 10)
    private String strasse;
    @NotBlank
    @Size(min = 5, max = 5)
    private String plz;
    @NotBlank
    @Size(min = 2)
    private String ort;


    public Date geGeburtsdatum() {
        return this.convertedGeburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            this.convertedGeburtsdatum = simpleDateFormat.parse(geburtsdatum);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        if (strasse == null || strasse.length() < 3) {
            throw new IllegalArgumentException("Der Wert" + strasse + " ist nicht zugelassen! ");
        }

        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        if (plz == null || plz.length() < 3) {
            throw new IllegalArgumentException("Der Wert" + plz + " ist nicht zugelassen! ");
        }
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        if (ort == null || ort.length() < 2) {
            throw new IllegalArgumentException("Der Wert" + ort + " ist nicht zugelassen! ");
        }

        this.ort = ort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException("Der Wert" + name + " ist nicht zugelassen! ");
        }
        this.name = name;
    }

    public String getVorname() {

        return vorname;
    }

    public void setVorname(String vorname) {
        if (vorname == null || vorname.length() < 2) {
            throw new IllegalArgumentException("Der Wert" + vorname + " ist nicht zugelassen! ");
        }
        this.vorname = vorname;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }
}

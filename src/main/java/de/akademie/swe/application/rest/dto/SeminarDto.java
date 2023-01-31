package de.akademie.swe.application.rest.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SeminarDto {
    @Length(min = 4)
    private String nummer;
    @Length(min = 5)
    private String name;
    //private String startdatum;
    //private String endedatum;

    @DateTimeFormat
    private Date convertedStartDate;
    @DateTimeFormat
    private Date convertedEndeDate;
    //private Module modul;
    @Min(1)
    private long modulId;

    public String getNummer() {

        return nummer;
    }

    public void setNummer(String nummer) {

        this.nummer = nummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Date getStartdatum() {
        return convertedStartDate;
    }

    public void setStartdatum(String startdatum) {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            this.convertedStartDate = simpleDateFormat.parse(startdatum);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public Date getEndedatum() {
        return convertedEndeDate;
    }

    public void setEndedatum(String endedatum) {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            this.convertedEndeDate = simpleDateFormat.parse(endedatum);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
    public long getModulId() {
        return modulId;
    }

    public void setModulId(long modulId) {
        this.modulId = modulId;
    }


   /* public Module getModul() {
        return modul;
    }

    public void setModul(Module modul) {
        this.modul = modul;
    }*/

   /* public Date getConvertedStartDate() {
        return convertedStartDate;


    public void setConvertedStartDate(Date convertedStartDate) {
        this.convertedStartDate = convertedStartDate;


    public Date getConvertedEndeDate() {
        return convertedEndeDate;
    }

    public void setConvertedEndeDate(Date convertedEndeDate) {
        this.convertedEndeDate = convertedEndeDate;
    }
}*/

}

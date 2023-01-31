package de.akademie.swe.application.rest.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
public class ModulDto {

    @NotBlank
    private String name;
    @NotBlank
    private String nummer;
    @Min(1)
    private int creditPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {                   // modul name: "C" ,so(|| name.length() < 3) is not fulfilled
            throw new IllegalArgumentException("Der Wert " + name + " ist nicht zugelassen! ");
        }
        this.name = name;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        if (nummer == null) {                   // modul name: "C" ,so(|| name.length() < 3) is not fulfilled
            throw new IllegalArgumentException("Der Wert " + nummer + " ist nicht zugelassen! ");
        }
        this.nummer = nummer;
    }

    public int getCp() {
        return creditPoints;
    }

    public void setCreditPoints(String creditPoints) {

        this.creditPoints = Integer.parseInt(creditPoints);
    }
}

package de.akademie.swe.application.rest.dto;

import javax.validation.constraints.*;

public class NoteDto {

    @DecimalMin(value = "1.0")
    @DecimalMax(value = "5.0")
    @Digits(integer = 2, fraction = 1)
    private double note;

    @Max(1)
    private long modulId;

    @Max(1)
    private long seminarId;

    @Max(1)
    private long personId;

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public long getModulId() {
        return modulId;
    }

    public void setModulId(long modulId) {
        this.modulId = modulId;
    }

    public long getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(long seminarId) {
        this.seminarId = seminarId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}

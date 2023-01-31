package de.akademie.swe.application.rest.dto;

public class ZertifikatDto {

    private long seminarId;

    private long personId;

    public long getSeminarId () {
        return seminarId;
    }

    public void setSeminarId (long seminarId) {
        this.seminarId = seminarId;
    }

    public long getPersonId () {
        return personId;
    }

    public void setPersonId (long personId) {
        this.personId = personId;
    }

}

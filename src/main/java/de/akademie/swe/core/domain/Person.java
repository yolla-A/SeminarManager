package de.akademie.swe.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "anrede")
    private Anrede anrede;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "vorname", length = 100, nullable = false)
    private String vorname;

    @Temporal(TemporalType.DATE)
    //@Column(name = "geburtsdatum", length = 100, nullable = false)
    private Date geburtsdatum;

    @OneToMany(cascade = CascadeType.ALL) //every person has at least one address
    // private Adresse adresse;
    private List<Adresse> adressen = new ArrayList<>();

    public Person(String name, String vorname, Date geburtsdatum, Adresse adresse) {
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
        this.adressen.add(adresse);
    }

    public Person(Anrede anrede, String name, String vorname, Date geburtsdatum, Adresse adresse) {
        this.anrede = anrede;
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
        this.adressen.add(adresse); //every person has at least one address
    }

    public Anrede getAnrede() {
        return anrede;
    }

    public void setAnrede(Anrede anrede) {
        this.anrede = anrede;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public List<Adresse> getAdressen() {
        return  new ArrayList<Adresse>(this.adressen); //gives a Copy of the list so any
                                                     // change in the list of addresses
                                                     // would affect the copy and has no effect on the original one.
                 //return adressen //the original
                //references are  complex not for automaten daten typen
    }

    public void setAdressen(List<Adresse> adressen) {
        this.adressen = adressen;
    }

    public void addAdresse(Adresse adresse) {
        if(this.adressen.contains(adresse)){
            throw new IllegalArgumentException("this address already exists" );
        }
        this.adressen.add(adresse);

    }
    public void removeAdresse(Adresse adresse) {
        if(adressen.size()==1 || !adressen.contains(adresse)){
           throw new IllegalArgumentException("adresse kann nicht gelöst werden weil +" +
                   " entweder die List von Adresse hat nur ein Element oder die+" +
                   " Adresse nicht contained in List");
        }
        adressen.remove(adresse);
    }

    public Person() { //?
    }
}

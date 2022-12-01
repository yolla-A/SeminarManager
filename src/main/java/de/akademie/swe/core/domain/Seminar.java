package de.akademie.swe.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "seminar")
public class Seminar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nummer", nullable = false, unique = true) // unique
    private String nummer;

    @Column(name = "name", nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date start;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date ende;

    @ManyToMany
    private List<Modul> module = new ArrayList<>(); //static Zugriff

    @ManyToMany
    private List<Person> teilnehmende = new ArrayList<>();


    public Seminar() {
    }

    public Seminar(String nummer, String name, Date start, Date ende, Modul modul) {
        this.nummer = nummer;
        this.name = name;
        this.start = start;
        this.ende = ende;
        this.module.add(modul);
    }

    public Seminar(String nummer, String name, Date start, Date ende, List<Modul> module) {
        if (module.size() == 0) {
            throw new IllegalArgumentException("Ein Seminar miss mindesten ein Modul enthalten");
        }

        this.nummer = nummer;
        this.name = name;
        this.start = start;
        this.ende = ende;
        this.module = module;
    }

    public long getId() {

        return id;
    }

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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnde() {
        return ende;
    }

    public void setEnde(Date ende) {
        this.ende = ende;
    }

    public List<Modul> getModule() {
        return module;
    }

    public void setModule(List<Modul> module) {
        this.module = module;
    }

    public List<Person> getTeilnehmende() {
        return teilnehmende;
    }

    public void setTeilnehmende(List<Person> teilnehmende) {
        this.teilnehmende = teilnehmende;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seminar seminar = (Seminar) o;
        return Objects.equals(nummer, seminar.nummer) && Objects.equals(name, seminar.name) && Objects.equals(start, seminar.start) && Objects.equals(ende, seminar.ende) && Objects.equals(module, seminar.module) && Objects.equals(teilnehmende, seminar.teilnehmende);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nummer, name, start, ende, module, teilnehmende);
    }

    @Override
    public String toString() {
        return "Seminar{" +
                "id=" + id +
                ", nummer='" + nummer + '\'' +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", ende=" + ende +
                ", module=" + module +
                ", teilnehmende=" + teilnehmende +
                '}';
    }
}

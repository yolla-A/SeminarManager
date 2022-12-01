package de.akademie.swe.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "zertifikat")
public class Zertifikat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //private Anrede anrede; // kein pflicht feld
    @Column(name = "vorname", nullable = false)
    private String vorname;

    @Column(name = "name", nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @ManyToOne
    private Seminar seminar;

    @OneToMany
    private List<Note> note;

    @Transient
    private List<Modul> module;

    public Zertifikat() {

    }
   /* public Zertifikat(Zertifikat z, Date date, String seminar, List<Note> note, List<Modul> module) {
       // this(z.getVorname(),z.getName(),new Date(),Seminar.getName(),note,module);

    }*/

    public Zertifikat(Person person, Date date , List<Modul> module, List<Note> note){

        //this(Person.copy(person).getVorname()) = vorname;
        this.vorname=person.getVorname();
        this.name=person.getName();
        //person.setVorname(person.getVorname());
       // person.setName(person.getName());
        this.date=date;
        this.module=module;
        this.note=note;
    }

    public Zertifikat(String vorname, String name, Date date, Seminar seminar, List<Note> note, List<Modul> module) {

        this.vorname = vorname;
        this.name = name;
        this.date = date;
        this.seminar = seminar;
        this.note = note;
        this.module=module;
    }

    public long getId() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }

    public List<Note> getNote() {
        return new ArrayList<Note>(this.note); //copy
    }

    public void setNote(List<Note> note) {
        this.note = note;
    }

    public List<Modul> getModule() {
        return new ArrayList<Modul>(this.module); //copy
    }

    public void setModule(List<Modul> module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zertifikat that = (Zertifikat) o;
        return Objects.equals(vorname, that.vorname) && Objects.equals(name, that.name) && Objects.equals(date, that.date) && Objects.equals(seminar, that.seminar) && Objects.equals(note, that.note) && Objects.equals(module, that.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vorname, name, date, seminar, note, module);
    }

    @Override
    public String toString() {
        return "Zertifikat{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", seminar=" + seminar +
                ", note=" + note +
                ", module=" + module +
                '}';
    }
}

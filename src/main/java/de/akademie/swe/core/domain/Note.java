package de.akademie.swe.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "note", precision = 2, scale = 1, nullable = false)
    private double note;
    //The precision represents the number of significant digits that are stored for values,
    // and the scale represents the number of digits that can be stored following the decimal point.

    @OneToOne       //here without cascadieren, because when deleting a note there wouldn't be a module
    @JoinColumn(name = "module_id",nullable = false) // more specified with fK , we can use this nullable
    private Modul modul;

    public Note(){
    }

    public Note(double note, Modul modul) {
        this.note = note;
        this.modul = modul;
    }

    public long getId() {
        return id;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public double getNote() {
        return note;
    }


    public void setModul(Modul modul) {
        this.modul = modul;
    }


    public Modul getModul() {
        return modul;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return Double.compare(note1.note, note) == 0 && Objects.equals(modul, note1.modul);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, modul);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note=" + note +
                ", modul=" + modul +
                '}';
    }
}

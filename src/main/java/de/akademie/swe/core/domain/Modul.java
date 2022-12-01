package de.akademie.swe.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "modul")
public class Modul {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "nummer",  nullable = false ,unique = true)
    private String nummer;

    @Column(name = "creditpoints", nullable = false)
    private int creditpoints;

    public Modul(String name, String nummer, int creditPoints) {
        this.name = name;
        this.nummer = nummer;
        this.creditpoints = creditPoints;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) { // we made comparison with one attribute her ist unique
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modul modul = (Modul) o;
        return Objects.equals(nummer, modul.nummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nummer);
    }

    @Override
    public String toString() {
        return "Modul{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nummer='" + nummer + '\'' +
                ", kreditpoints=" + creditpoints +
                '}';
    }
}

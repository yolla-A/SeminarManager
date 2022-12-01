package de.akademie.swe.core.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    @Test
    public void personHasAlwaysOneAddress() {

        Adresse adresse = new Adresse("Strasse 1", "12345", "Musterhausen");
        Person person = new Person("Rosowski", "Ursula", new Date(), adresse);

        List<Adresse> adressen = person.getAdressen();//copy of list
        // private Adresse adresse;                                   //original
        assertEquals(1, adressen.size());

        //   adressen.remove(adresse);
        assertEquals(1, person.getAdressen().size());

        //person.removeAdresse(adresse);// we get an exception

        Adresse adresse1 = adressen.get(0);  //  change is possible in copy but not add or remove ,
                                            // but we can change the /content/ of an element
                                            // because the copied and original list
                                           // have the same reference
        adresse1.setStrasse("Strasse 2");
        System.out.println(person.getAdressen().get(0));
    }

    @Test
    public void checkEquals() {
        Adresse adresse = new Adresse("Stass 1", "12345", "Musterhausen");
        Person person = new Person("Rosowski", "Ursula", new Date(), adresse);
        Person person1 = new Person("Rosowski", "Ursula", new Date(), adresse);

        if (person.equals(person1)) {
            System.out.println("wird sein gleich");

        } else {
            System.out.println(":(");
        }
        if (person == person1) {
            System.out.println("woo wir haben die selbe Identitaet");

        } else {
            System.out.println("wir haben zwar nicht die selbe Identitaet,sind aber trotzdem gleich ;*");
        }
       // Integer x=4;
//MessageDigest digest =
    }

}

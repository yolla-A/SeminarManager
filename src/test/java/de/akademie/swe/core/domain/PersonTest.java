package de.akademie.swe.core.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
   @Test
   public  void personHasAlwaysOneAddress(){

      Adresse adresse=new Adresse("Stass 1","12345","Musterhausen");
      Person person=new Person("Rosowski","Ursula",new Date(),adresse);
      List<Adresse>adressen=person.getAdressen();//copy of list

      assertEquals(1,adressen.size());

      adressen.remove(adresse);
      assertEquals(1,person.getAdressen().size());
     // person.removeAdresse(adresse);
      Adresse adresse1=adressen.get(0);  //  change in copy but not add or remove ,
                                         // but we can change the /content/ of an element
                                        // because the copied and original list
                                        // have the same reference
      adresse1.setStrasse("Strasse 2");
      System.out.println(person.getAdressen().get(0));
   }
}

package de.akademie.swe.core.domain;

import java.util.Date;

public class SeminarTest {


    public void createSeminar(){
        Modul moduleInformatik=new Modul("Grundlage der Informatik","M01",3);
        Modul moduleDataSience=new Modul("Data Sience","M04",3);
        Modul modulOOp=new Modul("Objektorientierte Programierung","M06",6);

        Seminar swe=new Seminar("10034","SWE-2021",new Date(),new Date(),moduleInformatik);
       // swe.addModul(modulOOp);
       // swe.addModul(moduleDataSience);

        Seminar datasience =new Seminar("10035","SWE-2021",new Date(),new Date(),moduleInformatik);
       // datasience.addModul(moduleDataSience);
    }
}

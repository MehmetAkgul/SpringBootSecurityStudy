package com.techpro.SpringBootStudy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // Springboot bu class 'ı (control layer) kontrol katmanı olarak tanımlar


@RestController
public class StudentBean01Controller {


//Controller annotasyonu Dispatcher servisinden mutlak üzere bir View alınması zorunlu ilen RestController buna gereksinim duymaz.
// Herhangi bir Controller annotasyonu ile oluşturulmuş bir Controller'a ise sınıf bazında veya fonksiyon bazında ResponseBody
// annotastonu eklenerek Rest Response sağlanır ve herhangi bir 404 hatası alınmaz.


    //@RequestMapping(method= RequestMethod.GET,path = "/getRequest")
    //@ResponseBody // method içimdeki cevabı görüntüler
    //public String getMethod1() {
    //    return "Get Request method çalıştı";
    //}

    @GetMapping(path = "/getRequest2")
// -->  Get Request'leri getMethod2()  ile mapping yapıp path'daki url çalışır return edilen data gösterilir.
    public String getMethod2() {
        return "Get Request method2 çalıştı";
    }

    //Tight  copule
    @GetMapping(path = "/getObjectTight")
    public StudentBean01 getObjectTight() {
        return new StudentBean01("islam", 33, "ig202233");
    }

    //Loose copule

    @Autowired//    StudentBean01 data type'de IOC conteinere defalut obj create eder
    StudentBean01 s; //  StudentBean01  s = new  StudentBean01()  anlamına gelir. ==> tight coupling
    @GetMapping(path = "/getObjectLoose")
    public StudentBean01 getObjectLoose() {

        s.setAge(33);
        s.setName("gökhan");
        s.setId("gh202233");

        return s;


    }


    //Tight  copuling
    @GetMapping(path = "/getObjectParameter/{school}")
    public StudentBean01 getObjectParameter(@PathVariable String school) {

       // return new StudentBean01(school+"  okulunda okuyan cengiz erdem",33 ,"ce202233");
        return new StudentBean01("cengiz erdem",33 ,String.format("ce202233%s",school));

    }

    //Tight  copuling
    @GetMapping(path = "/getObjectList")
    public List<StudentBean01> getObjectList() {

        return List.of(
                new StudentBean01("Gökhan",33,"G013349"),
                new StudentBean01("İslam",33,"I013349"),
                new StudentBean01("Hatice",33,"H013349"),
                new StudentBean01("Mehmet",33,"M013349")
        );

    }



}


package com.techpro.SpringBootStudy;


import org.springframework.stereotype.Component;

@Component//bileşen tamamlayıcı kullanılan class tan obj IOC create eder
public class StudentBean01 {


    private String name;
    private int age;
    private  String id;

    public StudentBean01() {
        System.out.println("eğer bu yazıyı okuduysan cons run edildi");
    }

    public StudentBean01(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentBean01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

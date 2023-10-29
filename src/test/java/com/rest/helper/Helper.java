package com.rest.helper;

import com.github.javafaker.Faker;

public class Helper {
    public Faker faker;
    public String getFirstName(){
        faker = new Faker();
        String fname = faker.name().firstName();
        return fname;
    }

    public String getFullName(){
        faker = new Faker();
        String fullname = faker.name().fullName();
        return fullname;
    }

    public String getLastName(){
        faker = new Faker();
        String lname = faker.name().lastName();
        return lname;
    }

    public String getEmailID(){
        faker = new Faker();
        String firstname = faker.name().firstName();
        String email = firstname + "@mailinator.com";
        return email;
    }

    public String getJobTitle(){
        faker = new Faker();
        String job = faker.job().title();
        return job;
    }

    public String getAnimalName(){
        faker = new Faker();
        String animalName = faker.animal().name();
        return animalName;
    }

    public String getAnimalColor(){
        faker = new Faker();
        String color = faker.color().name();
        return color;
    }

    public int getAnimalAge(){
        faker = new Faker();
        String age = faker.number().digits(2);
        int animalAge = Integer.parseInt(age);
        return animalAge;
    }

}

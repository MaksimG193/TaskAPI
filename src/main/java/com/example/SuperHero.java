package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class SuperHero {

    private String gender;
    private boolean work;
    private int height;
    private String name;

    public String isGender() {
        return gender;
    }

    public boolean isWork() {
        return work;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public static SuperHero findTallestHero(String gender, boolean hasJob) {
        Response response = RestAssured.get("https://akabab.github.io/superhero-api/api/all.json");
        List<SuperHero> heroes = response.jsonPath().getList("$", SuperHero.class);

        SuperHero tallestHero = null;

        for (SuperHero hero : heroes) {
            if ((gender == null || hero.isGender().equals(gender)) &&
                    (hasJob == hero.isWork())) {
                if (tallestHero == null || hero.getHeight() > tallestHero.getHeight()) {
                    tallestHero = hero;
                }
            }
        }
        return tallestHero;
    }
}


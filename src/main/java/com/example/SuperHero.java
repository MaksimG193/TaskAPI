package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SuperHero {
    private String gender;
    private boolean occupation; // Убедитесь, что это правильно соответствует типу из JSON
    private float height;
    private String name;


    public String getGender() {
        return gender;
    }

    public boolean getOccupation() {
        return occupation;
    }

    public Float getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }


    @JsonProperty("appearance")
    public void setAppearance(Map<String, Object> properties) {
        this.gender = (String) properties.get("gender");
        String[] height = ((List<String>) properties.get("height")).get(1).split(" ");
        float result = Float.parseFloat(height[0]);
        this.height = height[1].contains("cm") ? result : result * 100;
    }
    // 203 cm

    @JsonProperty("work")
    public void setOccupation(Map<String, Object> properties) {
        this.occupation = !((String) properties.get("occupation")).matches("^-$");
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public static SuperHero findTallestHero(String gender, boolean hasJob) {
        Response response = RestAssured.get("https://akabab.github.io/superhero-api/api/all.json");
        List<SuperHero> heroes = response.jsonPath().getList("", SuperHero.class);
        SuperHero tallestHero = new SuperHero();
        for (SuperHero hero : heroes) {
            System.out.println(hero.getHeight());
        }

        for (SuperHero hero : heroes) {
            if ((hero.getGender().equals(gender))) {
                if ((hero.getHeight() >= tallestHero.getHeight())) {
                    tallestHero = hero;
                }
            }
        }
        return tallestHero;
    }
}

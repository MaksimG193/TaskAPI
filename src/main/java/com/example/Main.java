package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        String jsonString = "{\"work\": \"Супер работа\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SuperHero hero = objectMapper.readValue(jsonString, SuperHero.class);
            System.out.println(hero.getOccupation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

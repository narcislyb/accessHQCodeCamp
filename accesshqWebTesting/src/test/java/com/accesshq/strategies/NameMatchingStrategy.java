package com.accesshq.strategies;

import com.accesshq.model.Planet;

import java.text.ParseException;

public class NameMatchingStrategy implements MatchingStrategy{
    private final String name;

    public NameMatchingStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean match(Planet planet) throws ParseException {
        return planet.getName().equalsIgnoreCase(name);
    }
}

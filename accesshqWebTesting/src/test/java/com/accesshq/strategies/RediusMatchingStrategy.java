package com.accesshq.strategies;

import com.accesshq.model.Planet;

import java.text.ParseException;

public class RediusMatchingStrategy implements MatchingStrategy{

    private double number;
    public RediusMatchingStrategy(double number) {
        this.number = number;
    }

    @Override
    public boolean match(Planet planet) throws ParseException {
        return planet.getRadius().equals(number);
    }
}

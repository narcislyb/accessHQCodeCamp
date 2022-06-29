package com.accesshq.strategies;

import com.accesshq.model.Planet;

import java.text.ParseException;

public interface MatchingStrategy {

    public boolean match(Planet planet) throws ParseException;

}

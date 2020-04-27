package domain;

import java.time.LocalDate;

public class Dropping extends ActiviteitMetInschrijving implements HeeftMinimumleeftijd {
    private String startplaats;
    private static final int minimumLeeftijd = 10;

    public Dropping(String naam, LocalDate datum, String startplaats) {
        super(naam, datum);
        this.startplaats = startplaats;
    }

    @Override
    public int getMinimumLeeftijd() {
        return minimumLeeftijd;
    }
}

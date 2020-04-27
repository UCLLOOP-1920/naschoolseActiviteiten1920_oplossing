package domain;

import java.time.LocalDate;

public class Wedstrijd extends ActiviteitMetInschrijving implements HeeftMinimumleeftijd {
    private Sport sport;

    public Wedstrijd(String naam, LocalDate datum, Sport sport) {
        super(naam, datum);
        this.sport = sport;
    }

    @Override
    public int getMinimumLeeftijd() {
        if (sport instanceof HeeftMinimumleeftijd)
            return ((HeeftMinimumleeftijd) sport).getMinimumLeeftijd();
        else return 0;
    }

    @Override
    public String toString() {
        return super.toString()+(getMinimumLeeftijd()>0?"\nMinimumleeftijd: "+getMinimumLeeftijd():"");
    }
}

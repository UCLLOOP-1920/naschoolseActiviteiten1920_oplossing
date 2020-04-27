package domain;

public class Voetbal extends Sport implements HeeftMinimumleeftijd{
    private static final int minimumLeeftijd = 5;
    public Voetbal() {
        super("Voetbal");
    }

    @Override
    public int getMinimumLeeftijd() {
        return minimumLeeftijd;
    }
}

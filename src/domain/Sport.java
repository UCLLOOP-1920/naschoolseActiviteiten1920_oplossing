package domain;

public abstract class Sport {
    String naam;

    public Sport(String naam) {
        if (naam == null || naam.trim().isEmpty())
            throw new DomainException("Geen geldige naam voor sport");
        this.naam = naam;
    }

    @Override
    public String toString() {
        return naam;
    }

}

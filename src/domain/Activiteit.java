package domain;

import java.time.LocalDate;

public abstract class Activiteit {
    private final String naam;
    private LocalDate datum;

    public Activiteit(String naam, LocalDate datum) {
        if (naam == null || naam.trim().isEmpty())
            throw new DomainException("Geen geldige naam");
        this.naam = naam;
        if (datum == null)
            throw new DomainException("Geen geldige datum");
        this.datum = datum;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDate getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return "Activiteit: " + getNaam() + " op " + getDatum();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Activiteit))
            return false;
        Activiteit otherActiviteit = (Activiteit) other;
        return this.getNaam().equals(otherActiviteit.getNaam()) && this.getDatum().equals(((Activiteit) other).getDatum());
    }

    public boolean isBeschikbaarVoorPersoon(Persoon persoon) {
        return true;
    }

}

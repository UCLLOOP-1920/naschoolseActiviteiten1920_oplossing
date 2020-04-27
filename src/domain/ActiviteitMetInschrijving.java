package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ActiviteitMetInschrijving extends Activiteit {
    private List<Persoon> personen;

    public ActiviteitMetInschrijving(String naam, LocalDate datum) {
        super(naam, datum);
        personen = new ArrayList<>();
    }

    public void schrijfIn(Persoon persoon) {
        if (!isBeschikbaarVoorPersoon(persoon))
            throw new DomainException("Gegeven persoon kan niet ingeschreven worden");
        personen.add(persoon);
    }

    public boolean isIngeschreven(Persoon persoon) {
        return personen.contains(persoon);
    }

    @Override
    public boolean isBeschikbaarVoorPersoon(Persoon persoon) {
        if (persoon == null)
            throw new DomainException("Gegeven persoon is niet effectief");
        if (isIngeschreven(persoon))
            return false;
        if (this instanceof HeeftMinimumleeftijd && persoon.geefLeeftijdOpDag(this.getDatum()) < ((HeeftMinimumleeftijd) this).getMinimumLeeftijd())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+"\nAantal deelnemers: "+personen.size();
    }
}

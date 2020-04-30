package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrganisatieNaschoolseActiviteiten {
    private List<Activiteit> activiteiten;

    public OrganisatieNaschoolseActiviteiten() {
        this.activiteiten = new ArrayList<>();
    }

    public void voegActiviteitToe(Activiteit activiteit) {
        if (activiteit == null)
            throw new DomainException("Je probeert een niet-effectieve activiteit te registreren");
        if (activiteiten.contains(activiteit))
            throw new DomainException("Deze activiteit is al geregistreerd");
        activiteiten.add(activiteit);
    }

    private boolean bevatActiviteit(Activiteit activiteit) {
        return activiteiten.contains(activiteit);
    }

    public void schrijfIn(Persoon persoon, Activiteit activiteit) {
        if (!bevatActiviteit(activiteit))
            throw new DomainException("Gevraagde activiteit bestaat niet");
        if (activiteit instanceof ActiviteitMetInschrijving) {
            try {
                ((ActiviteitMetInschrijving) activiteit).schrijfIn(persoon);
            } catch (DomainException e) {
                throw new DomainException(e.getMessage());
            }
        }
    }

    public List<Wedstrijd> geefWedstrijden() {
        List<Wedstrijd> wedstrijden = new ArrayList<>();
        for (Activiteit a : activiteiten
        ) {
            if (a instanceof Wedstrijd)
                wedstrijden.add((Wedstrijd) a);
        }
        return wedstrijden;
    }

    public List<Activiteit> verwijderActiviteitenOpDatum(LocalDate datum) {
        List<Activiteit> verwijderdeActiviteiten = new ArrayList<>();
        Iterator<Activiteit> iterator = activiteiten.iterator();
        while (iterator.hasNext()) {
            Activiteit a = iterator.next();
            if (a.getDatum().equals(datum)) {
                verwijderdeActiviteiten.add(a);
                iterator.remove();
            }
        }
        return verwijderdeActiviteiten;
    }

    public List<Activiteit> geefActiviteitenVoorPersoonOpDag(Persoon persoon, LocalDate dag) {
        if (persoon == null || dag == null)
            throw new DomainException("Geen geldige invoer");
        List<Activiteit> activiteiten = new ArrayList<>();
        for (Activiteit a : this.activiteiten
        ) {
            if (a.getDatum().equals(dag) && a.isBeschikbaarVoorPersoon(persoon))
                activiteiten.add(a);
        }
        return activiteiten;
    }

    public int geefAantalActiviteiten(){
        return activiteiten.size();
    }
}

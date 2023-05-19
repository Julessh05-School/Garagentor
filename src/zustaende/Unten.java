package zustaende;

import fachkonzept.Richtung;
import steuerung.Steuerung;

public final class Unten extends Zustand {

    private final Steuerung dieSteuerung;

    public Unten(Steuerung steuerung) {
        dieSteuerung = steuerung;
    }
    @Override
    public void gedruecktAuf() {
        dieSteuerung.starteMotor(Richtung.auf);
        dieSteuerung.setzeZustand(new Hebend(dieSteuerung));
    }

    @Override
    public void gedruecktAb() {
        // Do nothing
    }

    @Override
    public void gedruecktStopp() {
        dieSteuerung.stoppeMotor();
    }
}

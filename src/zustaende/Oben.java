package zustaende;

import fachkonzept.Richtung;
import steuerung.Steuerung;

public final class Oben extends Zustand {

    private final Steuerung dieSteuerung;

    public Oben(Steuerung steuerung) {
        dieSteuerung = steuerung;
    }
    @Override
    public void gedruecktAuf() {
        // Do nothing
    }

    @Override
    public void gedruecktAb() {
        dieSteuerung.starteMotor(Richtung.ab);
        dieSteuerung.setzeZustand(new Senkend(dieSteuerung));
    }

    @Override
    public void gedruecktStopp() {
        dieSteuerung.stoppeMotor();
    }
}

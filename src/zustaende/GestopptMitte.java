package zustaende;

import fachkonzept.Richtung;
import steuerung.Steuerung;

public class GestopptMitte extends Zustand {

    private final Steuerung dieSteuerung;

    public GestopptMitte(Steuerung steuerung) {
        dieSteuerung = steuerung;
    }
    @Override
    public void gedruecktAuf() {
        dieSteuerung.starteMotor(Richtung.auf);
        dieSteuerung.setzeZustand(new Hebend(dieSteuerung));
    }

    @Override
    public void gedruecktAb() {
        dieSteuerung.starteMotor(Richtung.ab);
        dieSteuerung.setzeZustand(new Senkend(dieSteuerung));
    }

    @Override
    public void gedruecktStopp() {
        // Do nothing.
    }
}

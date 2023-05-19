package zustaende;

import fachkonzept.Richtung;
import steuerung.Steuerung;

public final class Hebend extends Zustand {

    private final Steuerung dieSteuerung;

    public Hebend(Steuerung steuerung) {
        dieSteuerung = steuerung;
    }
    @Override
    public void gedruecktAuf() {
        // Do nothing
    }

    @Override
    public void gedruecktAb() {
        dieSteuerung.stoppeMotor();
        dieSteuerung.starteMotor(Richtung.ab);
        dieSteuerung.setzeZustand(new Senkend(dieSteuerung));
    }

    @Override
    public void gedruecktStopp() {
        dieSteuerung.stoppeMotor();
        // TODO: set
    }
}

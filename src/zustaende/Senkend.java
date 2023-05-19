package zustaende;

import fachkonzept.Richtung;
import steuerung.Steuerung;

public final class Senkend extends Zustand {

    private final Steuerung dieSteuerung;

    public Senkend(Steuerung steuerung) {
        dieSteuerung = steuerung;
    }
    @Override
    public void gedruecktAuf() {
        dieSteuerung.stoppeMotor();
        dieSteuerung.starteMotor(Richtung.auf);
    }

    @Override
    public void gedruecktAb() {
        // Do nothing
    }

    @Override
    public void gedruecktStopp() {
        dieSteuerung.stoppeMotor();
        // TODO: set
    }
}

package steuerung;

import java.util.ArrayList;
import benutzerschnittstelle.Benutzerschnittstelle;
import fachkonzept.Motor;
import fachkonzept.Richtung;
import fachkonzept.Sensor;
import zustaende.Unten;
import zustaende.Zustand;

public final class Steuerung
{
	private final Benutzerschnittstelle dieBenutzerschnittstelle;
	private final Motor derMotor;
	private final int positionOben;
	private final int positionUnten;

	private Zustand derZustand;

	private final ArrayList<Sensor> derSensor;

	public Steuerung(Benutzerschnittstelle pBenutzerschnittstelle)
	{
		dieBenutzerschnittstelle = pBenutzerschnittstelle;

		positionOben = 100;
		positionUnten = 0;
		setzeZustand(new Unten(this));
		int initialePositionTor = 0;
		derMotor = new Motor(initialePositionTor);

		derSensor = new ArrayList<>();
		for (int positionSensor = positionUnten; positionSensor <= positionOben; positionSensor++)
		{
			derSensor.add(new Sensor(this, derMotor, positionSensor));
		}
	}

	public void empfangenSensorsignal(int pPositionSensor)
	{
		// TO DO: Ereignis an aktuellen Zustand weitergeben
		dieBenutzerschnittstelle.zeigePositionTor(pPositionSensor);
	}

	public void gedruecktAb()
	{
		derZustand.gedruecktAb();
	}

	public void gedruecktAuf()
	{
		derZustand.gedruecktAuf();
	}

	public void gedruecktStopp()
	{
		derZustand.gedruecktStopp();
	}
	
	public int liesPositionOben()
	{
		return positionOben;
	}
	
	public int liesPositionUnten()
	{
		return positionUnten;
	}

	public void setzeZustand(Zustand pZustand) {
		derZustand = pZustand;
	}
	
	public void starteMotor(Richtung pRichtung)
	{
		derMotor.starte(pRichtung);
	}
	
	public void stoppeMotor()
	{
		derMotor.stoppe();
	}
}

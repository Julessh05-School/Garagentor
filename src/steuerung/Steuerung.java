package steuerung;

import java.util.ArrayList;
import benutzerschnittstelle.Benutzerschnittstelle;
import fachkonzept.Motor;
import fachkonzept.Richtung;
import fachkonzept.Sensor;

public class Steuerung
{
	private Benutzerschnittstelle dieBenutzerschnittstelle;
	private Motor derMotor;
	private ArrayList<Sensor> derSensor;
	private int positionOben;
	private int positionUnten;

	public Steuerung(Benutzerschnittstelle pBenutzerschnittstelle)
	{
		dieBenutzerschnittstelle = pBenutzerschnittstelle;

		positionOben = 100;
		positionUnten = 0;
		// TO DO: Initialzustand setzen
		int initialePositionTor = 0;
		derMotor = new Motor(initialePositionTor);

		derSensor = new ArrayList<Sensor>();
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
		// TO DO: Ereignis an aktuellen Zustand weitergeben
	}

	public void gedruecktAuf()
	{
		// TO DO: Ereignis an aktuellen Zustand weitergeben
	}

	public void gedruecktStopp()
	{
		// TO DO: Ereignis an aktuellen Zustand weitergeben
	}
	
	public int liesPositionOben()
	{
		return positionOben;
	}
	
	public int liesPositionUnten()
	{
		return positionUnten;
	}
	
	// TO DO: aktuellen Zustand setzen
	
	public void starteMotor(Richtung pRichtung)
	{
		derMotor.starte(pRichtung);
	}
	
	public void stoppeMotor()
	{
		derMotor.stoppe();
	}
}

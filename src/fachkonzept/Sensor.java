package fachkonzept;

import java.util.Timer;
import java.util.TimerTask;

import steuerung.Steuerung;

public class Sensor
{
	private final Steuerung dieSteuerung;
	private final Motor derMotor;
	private final int positionSensor;
	
	private boolean hatTorkontakt()
	{
		return derMotor.liesPositionTor() == positionSensor;
	}
	
	private void sendeSensorsignal()
	{
		dieSteuerung.empfangenSensorsignal(positionSensor);
	}
	
	public Sensor(Steuerung pSteuerung, Motor pMotor, int pPositionSensor)
	{
		dieSteuerung = pSteuerung;
		derMotor = pMotor;
		positionSensor = pPositionSensor;

		Timer derTimer = new Timer();
		final long delay = 0;
		final long frequency = 100;
		derTimer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				if (hatTorkontakt())
				{
					sendeSensorsignal();
				}
			}
		}, delay, frequency);
	}
}

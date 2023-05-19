package fachkonzept;

import java.util.Timer;
import java.util.TimerTask;

import steuerung.Steuerung;

public class Sensor
{
	private Steuerung dieSteuerung;
	private Motor derMotor;
	private Timer derTimer;
	private int positionSensor;
	
	private boolean hatTorkontakt()
	{
		if (derMotor.liesPositionTor() == positionSensor)
		{
			return true;
		}
		return false;
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
		
		derTimer = new Timer();
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

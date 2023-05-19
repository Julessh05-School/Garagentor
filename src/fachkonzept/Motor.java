package fachkonzept;

import java.util.Timer;
import java.util.TimerTask;

public class Motor
{
	private Timer derTimer;
	private int positionTor;
	
	public int liesPositionTor()
	{
		return positionTor;
	}
	
	private void macheSchritt(Richtung pRichtung)
	{
		switch (pRichtung)
		{
			case ab:
				positionTor--;
				break;
			case auf:
				positionTor++;
				break;
		}
	}

	public Motor(int pInitialePositionTor)
	{
		positionTor = pInitialePositionTor;
	}
	
	public void starte(Richtung pRichtung)
	{
		derTimer = new Timer();
		final long delay = 0;
		final long frequency = 100;
		derTimer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				macheSchritt(pRichtung);
			}
		}, delay, frequency);
	}
	
	public void stoppe()
	{
		if (derTimer != null)
		{
			derTimer.cancel();
		}
	}
}

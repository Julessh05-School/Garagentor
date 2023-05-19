package benutzerschnittstelle;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import steuerung.Steuerung;
import javax.swing.ImageIcon;

public class Benutzerschnittstelle extends JFrame
{
	private final JProgressBar prbGaragentor;
	
	private final Steuerung dieSteuerung;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() -> {
			try
			{
				Benutzerschnittstelle frame = new Benutzerschnittstelle();
				frame.setVisible(true);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		});
	}

	public Benutzerschnittstelle()
	{
		setResizable(false);
		setTitle("Garagentor-Steuerung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 392);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAuf = new JButton("");
		btnAuf.setIcon(new ImageIcon(Benutzerschnittstelle.class.getResource("/benutzerschnittstelle/auf.png")));
		btnAuf.addActionListener(e -> gedruecktAuf());
		btnAuf.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnAuf.setBounds(443, 11, 100, 100);
		contentPane.add(btnAuf);

		JButton btnStopp = new JButton("");
		btnStopp.setIcon(new ImageIcon(Benutzerschnittstelle.class.getResource("/benutzerschnittstelle/stopp.png")));
		btnStopp.addActionListener(e -> gedruecktStopp());
		btnStopp.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnStopp.setBounds(443, 122, 100, 100);
		contentPane.add(btnStopp);

		JButton btnAb = new JButton("");
		btnAb.setIcon(new ImageIcon(Benutzerschnittstelle.class.getResource("/benutzerschnittstelle/ab.png")));
		btnAb.addActionListener(e -> gedruecktAb());
		btnAb.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnAb.setBounds(443, 233, 100, 100);
		contentPane.add(btnAb);
		
		prbGaragentor = new JProgressBar();
		prbGaragentor.setOrientation(SwingConstants.VERTICAL);
		prbGaragentor.setBounds(10, 11, 423, 322);
		contentPane.add(prbGaragentor);

		dieSteuerung = new Steuerung(this);
	}

	private void gedruecktAb()
	{
		dieSteuerung.gedruecktAb();
	}

	private void gedruecktAuf()
	{
		dieSteuerung.gedruecktAuf();
	}

	private void gedruecktStopp()
	{
		dieSteuerung.gedruecktStopp();
	}

	public void zeigePositionTor(int pPositionTor)
	{
		prbGaragentor.setValue(pPositionTor);
	}
}

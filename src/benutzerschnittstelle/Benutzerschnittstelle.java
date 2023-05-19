package benutzerschnittstelle;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import steuerung.Steuerung;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Benutzerschnittstelle extends JFrame
{
	private JPanel contentPane;
	private JButton btnAuf;
	private JButton btnStopp;
	private JButton btnAb;
	private JProgressBar prbGaragentor;
	
	private Steuerung dieSteuerung;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Benutzerschnittstelle frame = new Benutzerschnittstelle();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Benutzerschnittstelle()
	{
		setResizable(false);
		setTitle("Garagentor-Steuerung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAuf = new JButton("");
		btnAuf.setIcon(new ImageIcon(Benutzerschnittstelle.class.getResource("/benutzerschnittstelle/auf.png")));
		btnAuf.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				gedruecktAuf();
			}
		});
		btnAuf.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnAuf.setBounds(443, 11, 100, 100);
		contentPane.add(btnAuf);

		btnStopp = new JButton("");
		btnStopp.setIcon(new ImageIcon(Benutzerschnittstelle.class.getResource("/benutzerschnittstelle/stopp.png")));
		btnStopp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				gedruecktStopp();
			}
		});
		btnStopp.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnStopp.setBounds(443, 122, 100, 100);
		contentPane.add(btnStopp);

		btnAb = new JButton("");
		btnAb.setIcon(new ImageIcon(Benutzerschnittstelle.class.getResource("/benutzerschnittstelle/ab.png")));
		btnAb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				gedruecktAb();
			}
		});
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewInscription extends JFrame implements ActionListener {

	public ViewInscription ()
	{
		 JFrame f =new JFrame ();
		 JPanel pan = new JPanel ();
		 JLabel lab1 = new JLabel("Matricule");
	     JTextField t1 = new JTextField();
	     
	     JLabel lab2 = new JLabel("Nom");
	     JTextField t2 = new JTextField();
	     
	     JLabel lab3 = new JLabel("Prénom");
	     JTextField t3 = new JTextField();
	     
		 JLabel lab4 = new JLabel("Email");
	     JTextField t4 = new JTextField();
	     
	     JLabel lab5 = new JLabel("Mot de passe");
	     JPasswordField t5 = new JPasswordField();

		 JLabel lab6 = new JLabel("ID université");
	     JTextField t6 = new JTextField();
	     
	     JButton annuler = new JButton ("Annuler");
	     JButton envoyer = new JButton ("Envoyer");
	     
	     pan.add(lab1);
	     pan.add(t1);
	     
	     pan.add(lab2);
	     pan.add(t2);
	     
	     pan.add(lab3);
	     pan.add(t3);
	     
	     pan.add(lab4);
	     pan.add(t4);
	     
	     pan.add(lab5);
	     pan.add(t5);
	     
	     pan.add(lab6);
	     pan.add(t6);
	     
	     pan.add(annuler);
	     pan.add(envoyer);
	     
	     envoyer.addActionListener(this);
	     annuler.addActionListener(this);


	     f.add(pan);
	     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     f.setSize(250, 250);
	     f.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ControleurInscription c = new ControleurInscription();
		c.InscriptionControle();
	}

	
	

}

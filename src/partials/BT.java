package partials;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class BT extends JButton{

	private String bouton;
	private ImageIcon iconFond1;
	private Image imgFond1;
    
	 public BT(String bouton){
		 super();
		 this.bouton=bouton;

		 iconFond1= new ImageIcon(getClass().getResource("/Images/"+getBouton()+".png"));
		 this.imgFond1=this.iconFond1.getImage();	 
	 }
	
		public void paintComponent(Graphics g){
			super.paintComponents(g);
			Graphics g2 = (Graphics2D)g;               
			g2.drawImage(this.imgFond1,0,0, null );	
		}
		
		public String getBouton() {return bouton;}
        public void setBouton(String bouton) {this.bouton = bouton;}
}

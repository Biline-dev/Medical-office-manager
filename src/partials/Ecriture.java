package partials;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ecriture extends JTextField{

		public Ecriture(String ecriture) {
			this.setText(ecriture);
		    this.getFont().deriveFont(Font.ITALIC);
	        this.setForeground(Color.GRAY);
	        
	        this.addMouseListener(new MouseListener() {           
	        	public void mouseReleased(MouseEvent e) {}         
	            public void mousePressed(MouseEvent e) {}          
	            public void mouseExited(MouseEvent e) {}           
	            public void mouseEntered(MouseEvent e) {}          
	    	    public void mouseClicked(MouseEvent e) {
	    	    	JTextField texteField = ((JTextField)e.getSource());
	        		texteField.setText("");
	                texteField.getFont().deriveFont(Font.PLAIN);
	                texteField.setForeground(Color.black);
	                texteField.removeMouseListener(this);
	    	    }
	    		});
		}     
	
}

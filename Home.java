package VechileParkingManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener{
	private static final long serialVersionUID = 2137713878272429767L;
	JLabel l;
	JButton b;
    Container container;
    
    public Home() {
    	l=new JLabel("Apply for parking solt");
        l.setBounds(MAXIMIZED_BOTH, MAXIMIZED_BOTH, MAXIMIZED_BOTH, MAXIMIZED_BOTH);
        b=new JButton("Register your vechile");
        b.setBounds(MAXIMIZED_BOTH, MAXIMIZED_BOTH, MAXIMIZED_BOTH, MAXIMIZED_BOTH);
        
        container=getContentPane();
        container.add(l);
        container.add(b);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==b) {
			Registration obj=new Registration();
	        obj.setTitle("Vechile Parking Management");
	        obj.setVisible(true);
	        obj.setBounds(500, 100, 500, 700);
	        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        obj.setResizable(true);
		}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Home obj=new Home(); 

	}

}

package VechileParkingManagement;
import javax.swing.*;
import java.awt.*;

public class Home extends JFrame{
	private static final long serialVersionUID = 2137713878272429767L;
	JLabel l;
    Container container;
    
    public Home() {
    	l=new JLabel("redirect to student page...");
        l.setBounds(50, 60, 100, 30);
        container=getContentPane();
        container.add(l);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Home obj=new Home(); 

	}

}

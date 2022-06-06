package VechileParkingManagement;
import javax.swing.*;
import java.awt.*;

public class HomeSecurity extends JFrame{
	private static final long serialVersionUID = 7420946601791311143L;
	JLabel l;
    Container container;
    
    public HomeSecurity() {
    	l=new JLabel("redirect to security page...");
        l.setBounds(50, 60, 100, 30);
        container=getContentPane();
        container.add(l);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomeSecurity obj3=new HomeSecurity(); 

	}

}

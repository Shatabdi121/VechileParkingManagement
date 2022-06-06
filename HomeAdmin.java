package VechileParkingManagement;
import javax.swing.*;
import java.awt.*;

public class HomeAdmin extends JFrame{
	private static final long serialVersionUID = 1299433473218473757L;
	JLabel l;
    Container container;
    
    public HomeAdmin() {
    	l=new JLabel("redirect to admin page...");
        l.setBounds(50, 60, 100, 30);
        container=getContentPane();
        container.add(l);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomeAdmin obj2=new HomeAdmin(); 

	}

}

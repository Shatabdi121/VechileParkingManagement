package VechileParkingManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Parking extends JFrame implements ActionListener {
	private static final long serialVersionUID = -2052041772856221780L;
	static JLabel l,l1; 
	static JButton account,b1;
	static JButton student,admin,security;
	static Container container;
	
	//constructor
	public Parking() {
		setSize(400,200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initialize();
        container = getContentPane();
        container.setBackground(Color.lightGray);
        add();
	}
	
	private void initialize() {
		l =new JLabel("Login as");
	    l.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC,40));
		l.setForeground(Color.ORANGE);
	    l.setBounds(100, 60, 300, 100);
	    account =new JButton("New Account");
	    account.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC,20));
		account.setForeground(Color.RED);
	    account.setBounds(400, 300, 200, 50);
	    student=new JButton("Student");
	    student.setBackground(new Color(204, 255, 204));
		student.setForeground(Color.GREEN);
	    student.setBounds(400, 150, 200, 30);
	    admin=new JButton("Admin");
	    admin.setBackground(new Color(204, 255, 204));
		admin.setForeground(Color.GREEN);
	    admin.setBounds(400,200,200,30);
	    security=new JButton("Security");
	    security.setBackground(new Color(204, 255, 204));
		security.setForeground(Color.GREEN);
	    security.setBounds(400,250,200,30);
	    
	    student.addActionListener(this);
	    admin.addActionListener(this);
	    security.addActionListener(this);
	    account.addActionListener(this);
		
	}
	private void add() {
		container.setLayout(null);
        container.add(l);
        container.add(account);
        container.add(student);
        container.add(admin);
        container.add(security);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==student) {
			LoginPage obj=new LoginPage();
	        obj.setTitle("Vechile Parking Management");
	        obj.setVisible(true);
	        obj.setBounds(500, 100, 500, 700);
	        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        obj.setResizable(true);
		}
		else if(e.getSource()==admin) {
			LoginPageAdmin obj=new LoginPageAdmin();
	        obj.setTitle("Vechile Parking Management");
	        obj.setVisible(true);
	        obj.setBounds(500, 100, 500, 700);
	        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        obj.setResizable(true);
		}
		else if(e.getSource()==security) {
			LoginPageSecurity obj=new LoginPageSecurity();
	        obj.setTitle("Vechile Parking Management");
	        obj.setVisible(true);
	        obj.setBounds(500, 100, 500, 700);
	        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        obj.setResizable(true);
		}
		else if(e.getSource()==account) {
			CreateAccount obj=new CreateAccount();
			obj.setTitle("Vechile Parking Management");
	        obj.setVisible(true);
	        obj.setBounds(500, 100, 500, 700);
	        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        obj.setResizable(true);
			
		}
		else {
			System.out.print("Invalid input");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parking t=new Parking();
        t.setTitle("Vechile Parking Management");
        t.setVisible(true);
        t.setBounds(450, 190, 1014, 597);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setResizable(true);

	}
}

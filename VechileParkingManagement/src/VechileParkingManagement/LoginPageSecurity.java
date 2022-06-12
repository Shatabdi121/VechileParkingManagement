package VechileParkingManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LoginPageSecurity extends JFrame implements ActionListener {
	private static final long serialVersionUID = 8911991139768426680L;
	//se=Security
	static JLabel title,seId;
	static JLabel sePassword;
    static JTextField se;
    static JPasswordField seP;
    static JButton submit3;
    static JButton reset3;
    static Container container;
    
    //constructor
    public LoginPageSecurity() {

        setSize(400,200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        initialize();
        container = getContentPane();
        container.setBackground(Color.YELLOW);
        add();
    }

private void initialize() {
	title=new JLabel("Security Login");
	title.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC,15));
	title.setForeground(Color.BLUE);
    title.setBounds(20, 40, 100, 30);
	seId =new JLabel("Enter your ID:");
    seId.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC,12));
	seId.setForeground(Color.RED);
    seId.setBounds(50, 60, 100, 30);
    sePassword =new JLabel("Enter password:");
    sePassword.setForeground(Color.RED);
	sePassword.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 12));
    sePassword.setBounds(50, 110, 100, 30);
    se =new JTextField(20);
    se.setForeground(Color.GREEN);
    se.setBounds(130, 60, 200, 30);
    seP=new JPasswordField(20);
    seP.setEchoChar('*');
	seP.setForeground(Color.BLACK);
    seP.setBounds(150, 120, 200, 30);
    submit3=new JButton("Login");
    submit3.setBackground(new Color(204, 255, 204));
	submit3.setForeground(Color.GREEN);
    submit3.setBounds(130, 550, 200, 30);
    reset3=new JButton("Reset");
    reset3.setBackground(new Color(255, 153, 102));
	reset3.setForeground(new Color(51, 0, 204));
    reset3.setBounds(130,600,200,30);
    submit3.addActionListener(this);
    reset3.addActionListener(this);		
	}

public static void add() {
        
        container.setLayout(null);
        container.add(title);
        container.add(seId);
        container.add(sePassword);
        container.add(se);
        container.add(seP);
        container.add(submit3);
        container.add(reset3);
       
}
    
    public void actionPerformed(ActionEvent e) {


        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vechile_parking", "root","g12l8");
            System.out.println("Connection Successfull");
            Statement s=con.createStatement();
            String query="select * from security_login where security_id='"+se.getText()+"'";
            ResultSet rs=s.executeQuery(query);
            int seId = 0;
            String password="";
            String pass= String.valueOf(seP.getPassword());
            String seId1=se.getText();
            int seIdFinal=Integer.parseInt(seId1); 
            while(rs.next()) {
                seId=rs.getInt("security_id");
                password=rs.getString("security_password");
            }
            if(e.getSource()==reset3){
                se.setText("");
                seP.setText("");
            }
            if(seId==seIdFinal && password.equals(pass)) {
                JOptionPane.showMessageDialog(submit3, "You have successfully logged in");
                HomeSecurity obj2=new HomeSecurity();
                obj2.setTitle("Vechile Parking Management");
                obj2.setVisible(true);
                obj2.setBounds(500, 100, 500, 700);
                obj2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                obj2.setResizable(true);
            }

            else {
                JOptionPane.showMessageDialog(submit3, "Wrong Username & Password");
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
}
    public static void main(String [] args) {
    	LoginPageSecurity t=new LoginPageSecurity();
        t.setTitle("Vechile Parking Management");
        t.setVisible(true);
        t.setBounds(450, 190, 1014, 597);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setResizable(true);
    }

}
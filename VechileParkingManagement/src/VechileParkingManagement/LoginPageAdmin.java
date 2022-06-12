package VechileParkingManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LoginPageAdmin extends JFrame implements ActionListener {
	private static final long serialVersionUID = -6064070951114299117L;
	//ad=Admin
	static JLabel title,adId;
	static JLabel adPassword;
    static JTextField ad;
    static JPasswordField adP;
    static JButton submit2;
    static JButton reset2;
    static Container container;
    
    //constructor
    public LoginPageAdmin() {

        setSize(400,200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        initialize();
        container = getContentPane();
        container.setBackground(Color.GREEN);
        add();
    }

private void initialize() {
	title=new JLabel("Administration Login");
	title.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC,15));
	title.setForeground(Color.BLUE);
    title.setBounds(20, 40, 100, 30);
	adId =new JLabel("Enter your ID:");
    adId.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC,12));
	adId.setForeground(Color.RED);
    adId.setBounds(50, 60, 100, 30);
    adPassword =new JLabel("Enter password:");
    adPassword.setForeground(Color.RED);
	adPassword.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 12));
    adPassword.setBounds(50, 110, 100, 30);
    ad =new JTextField(20);
    ad.setForeground(Color.GREEN);
    ad.setBounds(130, 60, 200, 30);
    adP=new JPasswordField(20);
    adP.setEchoChar('*');
	adP.setForeground(Color.BLACK);
    adP.setBounds(150, 120, 200, 30);
    submit2=new JButton("Login");
    submit2.setBackground(new Color(204, 255, 204));
	submit2.setForeground(Color.GREEN);
    submit2.setBounds(130, 550, 200, 30);
    reset2=new JButton("Reset");
    reset2.setBackground(new Color(255, 153, 102));
	reset2.setForeground(new Color(51, 0, 204));
    reset2.setBounds(130,600,200,30);
    submit2.addActionListener(this);
    reset2.addActionListener(this);		
	}

public static void add() {
        
        container.setLayout(null);
        container.add(title);
        container.add(adId);
        container.add(adPassword);
        container.add(ad);
        container.add(adP);
        container.add(submit2);
        container.add(reset2);
       
}
    
    public void actionPerformed(ActionEvent e) {


        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vechile_parking", "root","g12l8");
            System.out.println("Connection Successfull");
            Statement s=con.createStatement();
            String query="select * from admin_login where admin_id='"+ad.getText()+"'";
            ResultSet rs=s.executeQuery(query);
            int adId = 0;
            String password="";
            String pass= String.valueOf(adP.getPassword());
            String adId1=ad.getText();
            int adIdFinal=Integer.parseInt(adId1); 
            while(rs.next()) {
                adId=rs.getInt("admin_id");
                password=rs.getString("admin_password");
            }
            if(e.getSource()==reset2){
                ad.setText("");
                adP.setText("");
            }
            if(adId==adIdFinal && password.equals(pass)) {
                JOptionPane.showMessageDialog(submit2, "You have successfully logged in");
                HomeAdmin obj2=new HomeAdmin();
                obj2.setTitle("Vechile Parking Management");
                obj2.setVisible(true);
                obj2.setBounds(500, 100, 500, 700);
                obj2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                obj2.setResizable(true);
            }

            else {
                JOptionPane.showMessageDialog(submit2, "Wrong Username & Password");
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
}
    public static void main(String [] args) {
    	LoginPageAdmin t=new LoginPageAdmin();
        t.setTitle("Vechile Parking Management");
        t.setVisible(true);
        t.setBounds(450, 190, 1014, 597);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setResizable(true);
    }

}
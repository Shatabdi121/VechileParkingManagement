package VechileParkingManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LoginPage extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1275826161942053334L;
	//st=Student,ad=Admin,se=Security
	static JLabel title,stId,adId,seId;
	static JLabel stPassword,adPassword,sePassword;
    static JTextField st,ad,se;
    static JPasswordField stP,adP,seP;
    static JButton submit1,submit2, submit3;
    static JButton reset1, reset2, reset3;
    static Container container;
    
    //constructor
    public LoginPage() {

        setSize(400,200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initialize();
        container = getContentPane();
        add();
    }

private void initialize() {
	title=new JLabel("Student Login");
	title.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC,15));
	title.setForeground(Color.BLUE);
    title.setBounds(20, 40, 100, 30);
	stId =new JLabel("Enter your ID:");
    stId.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC,12));
	stId.setForeground(Color.RED);
    stId.setBounds(50, 60, 100, 30);
    stPassword =new JLabel("Enter password:");
    stPassword.setForeground(Color.RED);
	stPassword.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 12));
    stPassword.setBounds(50, 110, 100, 30);
    st =new JTextField(20);
    st.setForeground(Color.GREEN);
    st.setBounds(130, 60, 200, 30);
    stP=new JPasswordField(20);
    stP.setEchoChar('*');
	stP.setForeground(Color.BLACK);
    stP.setBounds(150, 120, 200, 30);
    submit1=new JButton("Login");
    submit1.setBackground(new Color(204, 255, 204));
	submit1.setForeground(Color.GREEN);
    submit1.setBounds(130, 550, 200, 30);
    reset1=new JButton("Reset");
    reset1.setBackground(new Color(255, 153, 102));
	reset1.setForeground(new Color(51, 0, 204));
    reset1.setBounds(130,600,200,30);
    submit1.addActionListener(this);
    reset1.addActionListener(this);
		
	}

public static void add() {
        
        container.setLayout(null);
        container.add(title);
        container.add(stId);
        container.add(stPassword);
        container.add(st);
        container.add(stP);
        container.add(submit1);
        container.add(reset1);
}
    
    public void actionPerformed(ActionEvent e) {


        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vechile_parking", "root","g12l8");
            System.out.println("Connection Successfull");
            Statement s=con.createStatement();
            String query="select * from student_login where student_id='"+st.getText()+"'";
            ResultSet rs=s.executeQuery(query);
            int stId = 0;
            String password="";
            String pass= String.valueOf(stP.getPassword());
            String stId1=st.getText();
            int stIdFinal=Integer.parseInt(stId1); 
            while(rs.next()) {
                stId=rs.getInt("student_id");
                password=rs.getString("student_password");
            }
            if(e.getSource()==reset1){
                st.setText("");
                stP.setText("");
            }
            if(stId==stIdFinal && password.equals(pass)) {
                JOptionPane.showMessageDialog(submit1, "You have successfully logged in");
                Home obj=new Home();
                obj.setTitle("Vechile Parking Management");
                obj.setVisible(true);
                obj.setBounds(500, 100, 500, 700);
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                obj.setResizable(true);
            }

            else {
                JOptionPane.showMessageDialog(submit1, "Wrong Username & Password");
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
}
    public static void main(String [] args) {
    	LoginPage t=new LoginPage();
        t.setTitle("Vechile Parking Management");
        t.setVisible(true);
        t.setBounds(500, 100, 500, 700);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setResizable(true);
    }

}
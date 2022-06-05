package VechileParkingManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LoginPage extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1275826161942053334L;
	//st=Student,ad=Admin,se=Security
	static JLabel stId,adId,seId;
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
        
        //For student Login
        stId =new JLabel("Enter your ID:");
        stId.setBounds(50, 60, 100, 30);
        stPassword =new JLabel("Enter password:");
        stPassword.setBounds(50, 110, 100, 30);
        st =new JTextField(20);
        st.setBounds(130, 60, 200, 30);
        stP=new JPasswordField(20);
        stP.setBounds(150, 120, 200, 30);
        submit1=new JButton("Login");
        submit1.setBounds(130, 550, 200, 30);
        reset1=new JButton("Reset");
        reset1.setBounds(130,600,200,30);
        
        //For Administration Login
        adId =new JLabel("Enter your ID:");
        adId.setBounds(50, 80, 150, 30);
        adPassword =new JLabel("Enter password:");
        adPassword.setBounds(50, 150, 150, 30);
        ad =new JTextField(20);
        ad.setBounds(130, 80, 250, 30);
        adP=new JPasswordField(20);
        adP.setBounds(150, 160, 250, 30);
        submit2=new JButton("Login");
        submit2.setBounds(130, 550, 250, 30);
        reset2=new JButton("Reset");
        reset2.setBounds(130,600,250,30);

        submit2.addActionListener(this);
        reset2.addActionListener(this);
        container = getContentPane();
        add();
    }

public static void add() {
        
        container.setLayout(null);
        container.add(stId);
        container.add(stPassword);
        container.add(st);
        container.add(stP);
        container.add(submit1);
        container.add(reset1);
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
            String query="select * from login_student where student_id='"+st.getText()+"'";
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
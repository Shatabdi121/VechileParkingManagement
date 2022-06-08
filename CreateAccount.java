package VechileParkingManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CreateAccount extends JFrame{
	private static final long serialVersionUID = 8253800824575963382L;
		private JPanel contentPane;
        private JTextField mob;
        private JPasswordField passwordField;
        private JButton btnNewButton;

        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        CreateAccount frame = new CreateAccount();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        public CreateAccount() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(450, 190, 1014, 597);
            setResizable(false);
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblNewUserRegister = new JLabel("Account Create");
            lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
            lblNewUserRegister.setBounds(362, 52, 325, 50);
            contentPane.add(lblNewUserRegister);

            JLabel lblPassword = new JLabel("Password");
            lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            lblPassword.setBounds(542, 329, 139, 26);
            contentPane.add(lblPassword);

            passwordField = new JPasswordField();
            passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 32));
            passwordField.setBounds(707, 320, 228, 50);
            contentPane.add(passwordField);
            
            JLabel lblMobileNumber = new JLabel("Mobile number");
            lblMobileNumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            lblMobileNumber.setBounds(542, 245, 140, 24);
            contentPane.add(lblMobileNumber);

            mob = new JTextField();
            mob.setFont(new Font("Times New Roman", Font.PLAIN, 32));
            mob.setBounds(707, 235, 228, 50);
            contentPane.add(mob);
            mob.setColumns(10);

            btnNewButton = new JButton("Register");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	String mobileNumber = mob.getText();
                    int len = mobileNumber.length();
                    if (len != 10) {
                        JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                    }
                    else {
                    String password = String.valueOf(passwordField.getPassword());
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vechile_parking", "root", "g12l8");

                        String query = "INSERT INTO student_login (student_mob,student_password)values(" + mobileNumber + ",'" +password + "' );";

                        Statement sta = connection.createStatement();
                        int x = sta.executeUpdate(query);
                        if (x == 0) {
                            JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                        } else {
                            JOptionPane.showMessageDialog(btnNewButton,
                                    "Welcome,  Your account is sucessfully created");
                        }
                        connection.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    }
                }
            });
            btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
            btnNewButton.setBounds(399, 447, 259, 74);
            contentPane.add(btnNewButton);
        }
}

package VechileParkingManagement;

import javax.swing.*;

//import java.awt.event.*;

import java.awt.*;

import java.sql.*;

 

public class HomeSecurity extends JFrame {

 

//Initializing Components
	private static final long serialVersionUID = 1839052819046543219L;

	JLabel lb, lb1, lb2, lb3, lb4,name;

    JTextField tf1, tf2, tf3, tf4,sName;

 

    //Creating Constructor for initializing JFrame components

    HomeSecurity() {

        //Providing Title

        super("Show Student Information");

 

        lb = new JLabel("Student Information From Database");

        lb.setBounds(20, 50, 450, 20);

        lb.setForeground(Color.red);

        lb.setFont(new Font("Serif", Font.BOLD, 20));

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);

        lb1 = new JLabel("Student Name:");

        lb1.setBounds(50, 105, 100, 20);

        tf1 = new JTextField(50);

        tf1.setBounds(160, 105, 100, 20);

        lb2 = new JLabel("Vechile ID:");

        lb2.setBounds(50, 135, 100, 20);

        tf2 = new JTextField(100);

        tf2.setBounds(160, 135, 200, 20);

        lb3 = new JLabel("Vechile Number:");

        lb3.setBounds(50, 165, 100, 20);

        tf3 = new JTextField(50);

        tf3.setBounds(160, 165, 100, 20);

        lb4 = new JLabel("Approved :");

        lb4.setBounds(50, 200, 100, 20);

        tf4 = new JTextField(50);

        tf4.setBounds(160, 200, 100, 20);

        setLayout(null);

 

        //Add components to the JFrame

        add(lb);

        add(lb1);

        add(tf1);

        add(lb2);

        add(tf2);

        add(lb3);

        add(tf3);

        add(lb4);

        add(tf4);

 

        //Set TextField Editable False

        tf1.setEditable(false);

        tf2.setEditable(false);

        tf3.setEditable(false);

        tf4.setEditable(false);

 

        //Create DataBase Connection and Fetching Records for student name

        try {

            String str = "Shatabdi";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vechile_parking", "root","g12l8");
            System.out.println("Connection Successfull");
            PreparedStatement st = con.prepareStatement("select * from register_vechile where s_name=?");

            st.setString(1, str);

 

            //Executing Query

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int s = rs.getInt(1);

                String s1 = rs.getString(2);

                String s2 = rs.getString(3);

                String s3 = rs.getString(4);

 

                //Sets Records in TextFields.

                tf1.setText(Integer.toString(s));

                tf2.setText(s1);

                tf3.setText(s2);

                tf4.setText(s3);

            }

        } //Create Exception Handler

        catch (Exception ex) {

            System.out.println(ex);

        }

    }

//Running Constructor

 

    public static void main(String args[]) {

        new HomeSecurity();

    }

}
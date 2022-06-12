package VechileParkingManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame{
	private static final long serialVersionUID = 8253800824575963372L;
		private JPanel contentPane;
        private JButton apply;

        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Registration frame = new Registration();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        public Registration() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(450, 190, 1014, 597);
            setResizable(false);
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel title = new JLabel("Register for Parking");
            title.setFont(new Font("Times New Roman", Font.PLAIN, 42));
            title.setBounds(100, 30, 400, 30);
            contentPane.add(title);

            JLabel name= new JLabel("Name");
            name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            name.setForeground(Color.BLUE);
            name.setBounds(80, 70, 200, 30);
            contentPane.add(name);
            
            JLabel vNum= new JLabel("Vechile Number");
            vNum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            vNum.setForeground(Color.BLUE);
            vNum.setBounds(80, 110, 200, 30);
            contentPane.add(vNum);
            
            JLabel vInsu= new JLabel("Insurance Number");
            vInsu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            vInsu.setForeground(Color.BLUE);
            vInsu.setBounds(80, 150, 200, 30);
            contentPane.add(vInsu);
            
            JLabel sDl= new JLabel("DL Number");
            sDl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            sDl.setForeground(Color.BLUE);
            sDl.setBounds(80, 190, 200, 30);
            contentPane.add(sDl);
            
            JLabel vType= new JLabel("Choose your Vechile Type");
            vType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            vType.setForeground(Color.BLUE);
            vType.setBounds(80, 230, 240, 30);
            contentPane.add(vType);
            
            JTextField nameTxt=new JTextField();
            nameTxt.setBounds(300, 70, 200, 30);
            nameTxt.setForeground(Color.GREEN);
            contentPane.add(nameTxt);
            
            JTextField vNumTxt=new JTextField();
            vNumTxt.setBounds(300, 110, 200, 30);
            vNumTxt.setForeground(Color.GREEN);
            contentPane.add(vNumTxt);
            
            JTextField vInsTxt=new JTextField();
            vInsTxt.setBounds(300, 150, 200, 30);
            vInsTxt.setForeground(Color.GREEN);
            contentPane.add(vInsTxt);
            
            JTextField vDlTxt=new JTextField();
            vDlTxt.setBounds(300, 190, 200, 30);
            vDlTxt.setForeground(Color.GREEN);
            contentPane.add(vDlTxt);
            
            JTextField vTypeTxt=new JTextField();
            vTypeTxt.setBounds(300, 230, 200, 30);
            vTypeTxt.setForeground(Color.GREEN);
            contentPane.add(vTypeTxt);
            
            
            
            apply = new JButton("Apply");
            apply.setBackground(new Color(204, 255, 204));
        	apply.setForeground(Color.GREEN);
            apply.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	
                    String name = nameTxt.getText();
                    String vNumber = vNumTxt.getText();
                    String insurance= vInsTxt.getText();
                    String dlNo = vDlTxt.getText();
                    int veType=Integer.parseInt(vTypeTxt.getText());
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vechile_parking", "root", "g12l8");

                        String query = "INSERT INTO register_vechile (s_name,vechile_number,insu_number,dl_number,v_type)values('" + name + "','" +vNumber + "','" +insurance + "','" +dlNo + "',"+veType+" );";

                        Statement sta = connection.createStatement();
                        int x = sta.executeUpdate(query);
                        if (x > 0) {
                            JOptionPane.showMessageDialog(apply, "Welcome,  You have sucessfully applied for parking solt");
                        } else {
                            JOptionPane.showMessageDialog(apply,
                                    "Please fill all fields");
                        }
                        connection.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    
                }
            });
            apply.setFont(new Font("Tahoma", Font.PLAIN, 22));
            apply.setBounds(399, 447, 259, 74);
            contentPane.add(apply);
        }
}

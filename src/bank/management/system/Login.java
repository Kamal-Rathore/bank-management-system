
package bank.management.system;
import javax.swing.*; // Jframe resides under the swing which resides under javax
import java.awt.*; //
import java.awt.event.*;// this can be added for ActionListener and actionPerformed to be worked
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    // here extends can be used to implement the inheritance 
    // here implements ActionListener is used to perform the command to the button to hear that
    JButton login,signup,clear; // global declaration of all the JButton
    JTextField cardTextField;// global declaration
    JPasswordField pinTextField;// global declaration
    Login(){ // constructor
        
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);// this is used to stop the bydefault layout and set is to be null
        // and uses the customize layout
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        // to take the icon from the folder under the source package
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //this is used to set the icon size
        ImageIcon i3 = new ImageIcon(i2);
        // JLabel doesnot accepts the Image it only accepts the ImageIcon
        // that's why it needs to convert the Image into ImageIcon
         JLabel label = new JLabel(i3);
         
         label.setBounds(70, 10, 100, 100);// set the label
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38)); // text font to be set
        text.setBounds(200, 40, 400, 40);
        add(text);
        
         JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
         JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
         pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
         login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);// to  perform the ActionListener in the login button
        add(login);
        
         clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
         clear.addActionListener(this);// to  perform the ActionListener in the clear button
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
         signup.addActionListener(this);// to  perform the ActionListener in the signup button
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);// to change the background of the frame
      setSize(800,480);//set the size of frame 
      setVisible(true);// frame to be visible
      setLocation(350,200);// set the location of the frame because the frame starts form topleft corner
      // of the window screen
    }
    
    public void actionPerformed(ActionEvent ae){// making the actionPerformed to be working
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()== login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            
            try{
           ResultSet rs =  conn.s.executeQuery(query);
           if(rs.next()){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
           }
           else{
           JOptionPane.showMessageDialog(null, "Incorrect Cardnumber or PIN");
           }
            }
            catch(Exception e){
            System.out.println(e);
            }
        }
        else if(ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();
    }
}

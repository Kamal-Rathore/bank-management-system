
package bank.management.system;
import java.sql.*; // sql library

public class Conn {
    
    Connection c;   // global object of class connection to establish the connection
    Statement s;
    
   public Conn(){
       
   try {
       
      
       c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","amansinghrathore");
       s = c.createStatement();
   }
   
   catch(Exception e){
       
   System.out.println(e);
   
   }
   }
}


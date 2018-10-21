/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp_project.LoginDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vel
 */
public class CreateAccountDB {
    public static void main(String[] args) {
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        
        String query = "SELECT * FROM VEL.LOGINDB";
        
        try
        {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Login","vel","1458");
            st = con.createStatement();
            rs = st.executeQuery(query);
            rsmd = rs.getMetaData();
            
            int coloumnNo = rsmd.getColumnCount();
            //System.out.println(coloumnNo);
            
            for(int j = 1 ; j<=coloumnNo ; j++)
            {
                System.out.print(rsmd.getColumnName(j)+"\t");
                
            }
            System.out.println();
            
            while(rs.next())
            {
                for(int j = 1 ; j<=coloumnNo ; j++)
            {
                System.out.print(rs.getObject(j)+"\t     ");
                
            }
                System.out.println();
            
                
                /*String username = rs.getString("UserName");
                String pass = rs.getString("Password");
                String usercode = rs.getString("UserCode");
                String userrole = rs.getString("UserRole");
                
                System.out.println(username+"\t   "+ pass+"\t   "+ usercode+"\t   "+ userrole+"\t   ");
                */
            }
            
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        
    }
    
}

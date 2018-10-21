/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp_project.LoginDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vel
 */
public class FYPExport {
    public static void main(String[] args) {
        // allow to connect db
        Connection con = null;
        //execute query db
        Statement sm = null;
        //represent  data
        ResultSet rs = null;
        //allow to process query resource and can get all coloum
        ResultSetMetaData rsmd = null;
        
         String query = "SELECT * FROM VEL.EXPORTDB ";
         
           try
        {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FYPDB","vel", "145810");
            sm = con.createStatement();
            rs = sm.executeQuery(query);
            rsmd = rs.getMetaData();    // explain the data
            int coloumnNo = rsmd.getColumnCount();
            //System.out.println(coloumnNo);
            
            for(int y = 1; y<=coloumnNo; y++)
            {
                System.out.print(rsmd.getColumnName(y)+ "\t    ");
            }
            
            System.out.println();
            
            while(rs.next())
            {
                for(int y=1; y<=coloumnNo; y++)
                {
                    System.out.print(rs.getObject(y)+ "\t    ");
                }
                
                System.out.println();
                
            }
            
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
    
}

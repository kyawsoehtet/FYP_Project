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
public class FYPImport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // allow to connect db
        Connection con = null;
        //execute query db
        Statement sm = null;
        //represent  data
        ResultSet rs = null;
        //allow to process query resource and can get all coloum
        ResultSetMetaData rsmd = null;
        
        String query = "SELECT * FROM VEL.DBTABLE ";
        
        try
        {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FYPDB","vel", "145810");
            sm = con.createStatement();
            rs = sm.executeQuery(query);
            rsmd = rs.getMetaData();    // explain the data
            int coloumnNo = rsmd.getColumnCount();
            //System.out.println(coloumnNo);
            
            for(int x = 1; x<=coloumnNo; x++)
            {
                System.out.print(rsmd.getColumnName(x)+ "\t    ");
            }
            
            System.out.println();
            
            while(rs.next())
            {
                for(int x=1; x<=coloumnNo; x++)
                {
                    System.out.print(rs.getObject(x)+ "\t    ");
                }
                
                System.out.println();
                /*int id = rs.getInt("ID");
                String cust = rs.getString("Customer");
                String conno = rs.getString("ContainerNo");
                String jno = rs.getString("JobNo");
                String lno = rs.getString("LotNo");
                Date date = rs.getDate("Date");
                String address = rs.getString("Address");
                String proty = rs.getString("ProductType");
                String pname = rs.getString("ProductName");
                String mno = rs.getString("ModelNo");
                String pacty = rs.getString("PackType");
                String qty = rs.getString("TotalQty");
                String dqty = rs.getString("DamageQty");
                
                System.out.println(id+"\t  "+ cust+"\t  "+ conno+"\t  "+ jno+"\t  "+ lno+"\t  "+ date+"\t  "+ 
                        address+"\t      "+ proty+"\t    "+ pname+"\t    "+ mno+"\t    "+ pacty+"\t    "+ qty+"\t    "+ dqty+"\t  ");*/
                
            }
            
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}

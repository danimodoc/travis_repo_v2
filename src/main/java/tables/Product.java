package tables;
import java.sql.Connection;

/**
 *  Class contains the methods that operate on the table from the database
 *
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

//import com.mysql.jdbc.ResultSetMetaData;//import com.mysql.cj.jdbc.result.ResultSetMetaData;


import connection.ConnectionFactory;

public class Product {

    private String product_name;
    private int product_id;

    private static final String insertStatementString = "INSERT INTO product(product_name)" + "VALUES(?)";
    private static final String findStatementString = "SELECT * FROM product where product_id=?";
    private static final String deleteStatementString = "delete FROM product where product_id=?";
    private static final String editStatementString = "update product set product_name=? where product_id=?";


    public Product(int product_id,String name) {
        this.product_id=product_id;
        this.product_name = name;
    }

    public Product() {
    }

    public Product(String name) {
        this.product_name=name;
    }

    public String getName() {
        return product_name;
    }

    public void setName(String name) {
        this.product_name = name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public static Product findById(int productId){
        Product toReturn = null;
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;

        try
        {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setInt(1, productId);
            rs=findStatement.executeQuery();
            rs.next();

            String name = rs.getString("product_name");
            toReturn = new Product(productId,name);
        }
        catch(SQLException e)
        {
            System.out.println( "Product:findById "+e.getMessage());
        }
        finally
        {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;

    }

    public int insert()//Product product , can be static and with a Product object as parameter
    {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedId= -1;
        try
        {
            insertStatement = dbConnection.prepareStatement(insertStatementString,Statement.RETURN_GENERATED_KEYS);
            //insertStatement.setString(1, product.getName());
            insertStatement.setString(1, this.getName());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();

            if(rs.next())
            {
                insertedId=rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            System.out.println( "Product:insert "+e.getMessage());
        }
        finally
        {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }

        return insertedId;
    }

    public static Product update(int productId,Product product)
    {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement editStatement = null;
        Product toReturn = null;

        try
        {
            editStatement = dbConnection.prepareStatement(editStatementString);
            editStatement.setLong(2, productId);//this.product_id
            editStatement.setString(1, product.getName());
            editStatement.executeUpdate();

            toReturn = new Product(productId,product.getName());

        }
        catch(SQLException e)
        {
            System.out.println("Product:updated "+e.getMessage());
        }
        finally
        {
            ConnectionFactory.close(editStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;
    }

    public static void deleteById(int productId) {

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;

        ResultSet rs = null;

        try
        {
            findStatement = dbConnection.prepareStatement(deleteStatementString);
            findStatement.setLong(1, productId);
            findStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println("Product:deleteById "+e.getMessage());
        }
        finally
        {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
    }
}

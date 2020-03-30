package tables;
import connection.ConnectionFactory;

import java.sql.Connection;

/**
 *  Class contains the methods that operate on the table from the database
 *
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bug_crud {

    private static final String insertStatementString = "INSERT INTO bug(bug_name,emp_id,status_bug,priority)" + "VALUES(?,?,?,?)";
    private static final String findStatementString = "SELECT * FROM product where product_id=?";

    public static int insert(Bug bug){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedId= -1;
        try
        {
            insertStatement = dbConnection.prepareStatement(insertStatementString,Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, bug.getBug_name());
            insertStatement.setInt(2, bug.getEmp_id());
            insertStatement.setBoolean(3, bug.isStatus_bug());
            insertStatement.setInt(4, bug.getPriority());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();

            if(rs.next())
            {
                insertedId=rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            System.out.println( "Bug:insert "+e.getMessage());
        }
        finally
        {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }

        return insertedId;
    }

    public static Bug read(int bugId){
        Bug toReturn = null;
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;

        try
        {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setInt(1, bugId);
            rs=findStatement.executeQuery();
            rs.next();

            String bug_name = rs.getString("bug_name");
            int emp_id = rs.getInt("emp_id");
            boolean status_bug = rs.getBoolean("status_bug");
            int priority = rs.getInt("priority");
            toReturn = new Bug(bug_name,emp_id,status_bug,priority);
        }
        catch(SQLException e)
        {
            System.out.println( "BUg :findById "+e.getMessage());
        }
        finally
        {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;

    }
}

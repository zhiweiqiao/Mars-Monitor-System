package com.DAL;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Zhiwei Qiao
 * This class is used to operate database.
 */

public class SqlExecute 
{
	private Connection conn;  	//data connection
	private Statement stmt;   	//sql
	private ResultSet rset;		//result
	
	private void getStatement() throws Exception 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Mars?"
			                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8");
			stmt = conn.createStatement();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	//Close the database connection
	public void closeAll() throws SQLException 
	{
		try {
			if( stmt != null) 
			{
				stmt.close();
				stmt = null;
			}
			if( !conn.isClosed()) 
				conn.close();
		}
		catch(SQLException se) 
		{
			throw se;
		}
	}
	
	/**
	 * sql
	 */
	public int executeSql(String sql) throws Exception
	{
		int recoders = 0;
		
		getStatement();

		recoders = stmt.executeUpdate(sql);

		closeAll();
		
		return recoders;
	}
	
	/**
	 * query to get ResultSet to fill in JTable and return Table
	 */
	public JTable getTable(String sql) throws Exception
	{
		getStatement();

		rset = stmt.executeQuery(sql);
		
		ResultSetMetaData rsmd=rset.getMetaData();         //return dataset
        
		//column
		int columns = rsmd.getColumnCount();   
		
        String columntitle[] = new String[columns];        //create columns
        for (int j=1; j<=columns; j++)
            columntitle[j-1] = rsmd.getColumnLabel(j);     //get columnlabel 
        
        DefaultTableModel tm = new DefaultTableModel(columntitle, 0); 

        String results[]= new String[columns]; 
        
        while (rset.next()) 
        {                               
            for(int i=0; i<columns; i++)
            	results[i] = rset.getString(i+1);	
            tm.addRow(results);
        }
        
        JTable tb = new JTable();
        tb.setModel(tm);

        rset.close();

		closeAll();
		
		return tb;
	}
	
	public ResultSet getResultSet(String sql) throws Exception
	{
		getStatement();

		ResultSet rs =  stmt.executeQuery(sql);

		return rs;
	}
}

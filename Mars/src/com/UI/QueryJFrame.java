package com.UI;

import javax.swing.*;
import java.sql.*;

/**
 * @author Zhiwei Qiao
 * query class
 */

public class QueryJFrame extends JFrame {
	private Connection conn; // connection

	public QueryJFrame(String driver, String url, String table)
			throws ClassNotFoundException, SQLException // table
	{
		super(table);
		this.setBounds(300, 240, 700, 320);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Class.forName(driver); // JDBC driver
		this.conn = DriverManager.getConnection(url); // return database
		JTable jtable = query(table);
		this.getContentPane().add(new JScrollPane(jtable));
		this.setVisible(true);
	}

	public JTable query(String table) throws SQLException {
		String sql = "SELECT * FROM " + table;
		Statement stmt = this.conn.createStatement(1003, 1007);
		ResultSet rset = stmt.executeQuery(sql);
		System.out.println("rset.getType()=" + rset.getType());
		System.out.println("rset.getConcurrency()=" + rset.getConcurrency());
		System.out.println("rset.isBeforeFirst()=" + rset.isBeforeFirst());
		ResultSetMetaData rsmd = rset.getMetaData(); // return dataset
		int columns = rsmd.getColumnCount(); // 
		String columntitle[] = new String[columns]; // 
		for (int j = 1; j <= columns; j++)
			columntitle[j - 1] = rsmd.getColumnLabel(j); // 

		int rows = 0;
		while (rset.next())
			// 
			rows++;
		System.out.println("rset.isAfterLast()=" + rset.isAfterLast());

		String results[][] = new String[rows][columns]; // 

		for (int i = rows - 1; rset.previous(); i--)
			// columns
			for (int j = 1; j <= columns; j++)
				results[i][j - 1] = rset.getString(j); // columns
		rset.close();
		stmt.close();
		return new JTable(results, columntitle);
	}

	public void finalize() throws SQLException // close
	{
		this.conn.close();
	}

	public static void main(String args[]) throws Exception {
		String driver = "com.mysql.jdbc.Driver"; // MySQL
																		// JDBC
		String url = "jdbc:mysql://localhost:3306/Mars?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		new QueryJFrame(driver, url, "Account");
	}
}
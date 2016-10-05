package com.UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.DAL.SqlExecute;
import com.DAO.User;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;

/**
 * @author Zhiwei Qiao
 * sign up
 */

public class Register extends JInternalFrame implements ActionListener {
	private JLabel welcome = new JLabel("Sign up");
	private JLabel tit1 = new JLabel("Username:");
	private JLabel tit2 = new JLabel("Password:");
	private JLabel tit3 = new JLabel("Usertype:");
	TextField name = new TextField(200);
	TextField password = new TextField(200);
	TextField type = new TextField(200);
	JButton submit = new JButton("Confirm");
	JButton quit = new JButton("Quit");
	JButton reset = new JButton("Reset");

	public Register() {
		setTitle("Sign up");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		this.getContentPane().setLayout(null);

		welcome.setBounds(270, 10, 300, 50);
		welcome.setFont(new Font("Times New Roman", 1, 20));
		this.add(welcome);

		tit1.setBounds(20, 80, 100, 30);
		this.add(tit1);
		name.setBounds(120, 80, 180, 25);
		this.add(name);

		tit2.setBounds(20, 120, 100, 30);
		this.add(tit2);
		password.setBounds(120, 120, 180, 25);
		this.add(password);

		tit3.setBounds(20, 160, 100, 30);
		this.add(tit3);
		type.setBounds(120, 160, 180, 25);
		this.add(type);

		submit.setBounds(120, 300, 100, 30);
		submit.addActionListener(this);
		this.add(submit);
		reset.setBounds(120, 360, 100, 30);
		reset.addActionListener(this);
		this.add(reset);
		quit.setBounds(260, 300, 100, 30);
		quit.addActionListener(this);
		this.add(quit);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Confirm") {
			String z_name = name.getText();
			String z_password = password.getText();
			String z_type = type.getText();

				name.setText("");
				password.setText("");
				type.setText("");
				String URL = "jdbc:mysql://localhost:3306/Mars?";
				String name = "root";
				String password = "root";

				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					try {
						conn = DriverManager.getConnection(URL, name, password);
						String check = "select username from Account where username = ?";
						pstmt = conn.prepareStatement(check);
						pstmt.setString(1, z_name);
						rs = pstmt.executeQuery();
						if (rs.next()) {
							JOptionPane.showMessageDialog(this,
									"Sorry, this username exsits, pleas change new username!");
						} else {
							String insert = "insert into Account values(?,?,?)";
							pstmt = conn.prepareStatement(insert);
							pstmt.setString(1, z_name);
							pstmt.setString(2, z_password);
							pstmt.setString(3, z_type);
							pstmt.execute();
							JOptionPane.showMessageDialog(this, "Congratulation!");
							this.dispose();
						}
					} catch (SQLException e1) {
						System.out.print("Error!");
					}
				} catch (ClassNotFoundException e2) {
					System.out.print("Can't find data!");
				}
			}

		if (e.getActionCommand() == "Reset") {
			name.setText(" ");
			password.setText(" ");
			type.setText(" ");
		}

		if (e.getActionCommand() == "Quit") {
			this.dispose();
		}
	}
}

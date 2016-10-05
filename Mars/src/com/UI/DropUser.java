package com.UI;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Zhiwei Qiao
 *  This class is used to delete user.
 */

public class DropUser extends JInternalFrame implements ActionListener {
	private JLabel tit1 = new JLabel("Username:");
	private JLabel tit2 = new JLabel("Password:");
	private TextField num = new TextField(200);
	private TextField password = new TextField(200);
	JButton submit = new JButton("Confirm");
	JButton quit = new JButton("Quit");
	JButton reset = new JButton("Reset");

	public DropUser() {
		setTitle("Delete user");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		this.getContentPane().setLayout(null);

		tit1.setBounds(20, 80, 100, 30);
		this.add(tit1);
		num.setBounds(120, 80, 180, 25);
		this.add(num);

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
			String z_num = num.getText().trim();
			num.setText("");
			String z_pass = password.getText().trim();
			password.setText("");

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
					String search = "select username from Account where username=?";//judge username
					pstmt = conn.prepareStatement(search);
					pstmt.setString(1, z_num);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						
							String delete = "delete from Account where username=?";
							pstmt = conn.prepareStatement(delete);
							pstmt.setString(1, z_num);
							pstmt.execute();
							JOptionPane.showMessageDialog(this, "Congratulation!");
							this.dispose();
					} else {
						JOptionPane.showMessageDialog(this, "Username or password is incorrect!", "Warning", getDefaultCloseOperation());
					}
				} catch (SQLException e1) {
					System.out.println("error1");
				}
			} catch (ClassNotFoundException e1) {
				System.out.println("error2");
			}
		}

		if (e.getActionCommand() == "Reset") {
			num.setText(" ");
			password.setText(" ");
		}

		if (e.getActionCommand() == "Quit") {
			this.dispose();
		}
	}
}

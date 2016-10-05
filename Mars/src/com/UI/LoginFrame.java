package com.UI;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

import com.DAL.*;

import com.DAO.User;

/**
 * @author Zhiwei Qiao
 *  Login
 */

public class LoginFrame extends JDialog implements ActionListener {
	private JTextField Name = new JTextField(10);
	private JTextField PW = new JTextField(10);
	private JLabel name = new JLabel("UserName:");
	private JLabel pw = new JLabel("Password:");
	private JButton btnOK = new JButton("Confirm");
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnReset = new JButton("Reset");

	public LoginFrame(JFrame jf, boolean model) {
		super(jf, model);
		this.setTitle("Login");

		this.setBounds(500, 200, 300, 200);

		getContentPane().setLayout(new FlowLayout(1, 25, 10));

		getContentPane().add(name);
		getContentPane().add(Name);
		getContentPane().add(pw);
		getContentPane().add(PW);

		getContentPane().add(btnOK);
		btnOK.addActionListener(this);

		getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);

		getContentPane().add(btnReset);
		btnReset.addActionListener(this);

		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Confirm") {
			String name_t = Name.getText();
			String password_t = PW.getText();

			ResultSet rs;

			SqlExecute se = new SqlExecute();
			try {
				String sql = "select * from Account where username ='" + name_t + "'";
				rs = se.getResultSet(sql);
				User u = new User();
				while (rs.next()) {
					u.setUserName(rs.getString("username"));
					u.setPassword(rs.getString(2));
					u.setUserType(rs.getString(3));
				}
				rs.close();
				se.closeAll();
				boolean isPass = PW.getText().trim()
						.equals(u.getPassword().trim());
				if (isPass) {
					MdiFrame.user.setUserType(u.getUserType().trim());
					MdiFrame.user.setUserName(u.getUserName().trim());
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "Username or password is incorrect!\r\nPlease enter again!", "Warning", getDefaultCloseOperation());
				}

			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Connection failed£¡");
			}
		} else if (e.getActionCommand() == "Cancel") {
			System.exit(0);
		} else if (e.getActionCommand() == "Reset") {
			Name.setText("");
			PW.setText("");
		}
	}
}

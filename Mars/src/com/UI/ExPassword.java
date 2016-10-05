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
 * change password
 */

public class ExPassword extends JInternalFrame implements ActionListener {
	private JLabel waring = new JLabel("Please remember your password£¡");
	private JLabel tit = new JLabel("Username");
	private JLabel tit1 = new JLabel("Old password:");
	private JLabel tit2 = new JLabel("New password:");
	private JLabel tit3 = new JLabel("New passoword again:");
	TextField name = new TextField(200);
	TextField oldpass = new TextField(200);
	TextField newpass = new TextField(200);
	TextField renewpass = new TextField(200);
	JButton submit = new JButton("Confirm");
	JButton quit = new JButton("Quit");
	JButton reset = new JButton("Reset");

	public ExPassword() {
		setTitle("Change password");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		this.getContentPane().setLayout(null);

		waring.setBounds(270, 10, 300, 50);
		waring.setFont(new Font("Times New Roman", 1, 20));
		this.add(waring);

		tit.setBounds(20, 80, 100, 30);
		this.add(tit);
		name.setBounds(120, 80, 180, 25);
		this.add(name);

		tit1.setBounds(20, 120, 100, 30);
		this.add(tit1);
		oldpass.setBounds(120, 120, 180, 25);
		this.add(oldpass);

		tit2.setBounds(20, 160, 100, 30);
		this.add(tit2);
		newpass.setBounds(120, 160, 180, 25);
		this.add(newpass);

		tit3.setBounds(20, 200, 100, 30);
		this.add(tit3);
		renewpass.setBounds(120, 200, 180, 25);
		this.add(renewpass);

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
			String z_old = oldpass.getText();
			String z_new = newpass.getText();
			String z_renew = renewpass.getText();
			String z_num = name.getText();

			boolean isequal = z_renew.trim().equals(z_new.trim());

			if (!isequal) {
				JOptionPane.showMessageDialog(this, "The passoword is different!");//judge
				renewpass.setText(" ");
			}

			if (z_new.equals(z_renew)) {
				String URL = "jdbc:mysql://localhost:3306/Mars?";
				String name = "root";
				String password = "root";

				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				PreparedStatement pstmt2 = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					try {
						conn = DriverManager.getConnection(URL, name, password);
						String serch = "select password from Account where username=? and password=?";//old
						pstmt = conn.prepareStatement(serch);
						pstmt.setString(1, z_num);
						pstmt.setString(2, z_old);
						rs = pstmt.executeQuery();
						if (rs.next()) {
							String update = "update Account set password=? where username=?";
							pstmt2 = conn.prepareStatement(update);
							pstmt2.setInt(1, Integer.parseInt(z_new));
							pstmt2.setString(2, z_num);
							pstmt2.execute();
							JOptionPane.showMessageDialog(this,
									"Congratulation, please use new password to login in!");

							this.dispose();
							MdiFrame mdiMain = new MdiFrame();
							new LoginFrame(mdiMain, true);
						} else {
							JOptionPane.showMessageDialog(this,
									"The password is incorrect, please enter again!");
							oldpass.setText(" ");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "The password is different");
			newpass.setText(" ");
			renewpass.setText(" ");
		}

		if (e.getActionCommand() == "Reset") {
			name.setText(" ");
			oldpass.setText(" ");
			newpass.setText(" ");
			renewpass.setText(" ");
		}

		if (e.getActionCommand() == "Quit") {
			this.dispose();
		}
	}
}

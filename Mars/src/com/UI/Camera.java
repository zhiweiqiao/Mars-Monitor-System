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
 * camere class
 */

public class Camera extends JInternalFrame implements ActionListener {
	private JLabel Instruction = new JLabel("Choose one camera to show video");
	private JLabel Url = new JLabel("Camera URL:");
	private JLabel Location = new JLabel("Screen Name:");
	private JLabel Name = new JLabel("Display Name:");
	TextField url = new TextField(200);
	TextField location = new TextField(200);
	TextField name = new TextField(200);
	JButton submit = new JButton("Add Camera");
	JButton quit = new JButton("Quit");
	JButton reset = new JButton("Reset");
	JButton delete  = new JButton("Delete");
	
	JLabel sc1 = new JLabel("1");
	JLabel sc2 = new JLabel("2");
	JLabel sc3 = new JLabel("3");
	JLabel sc4 = new JLabel("4");
	
	CameraPanel pnl1 = new CameraPanel();
	CameraPanel pnl2 = new CameraPanel();
	CameraPanel pnl3 = new CameraPanel();
	CameraPanel pnl4 = new CameraPanel();
	
	JComboBox urlcomboBox1 = new JComboBox();
	JComboBox urlcomboBox2 = new JComboBox();
	JComboBox urlcomboBox3 = new JComboBox();
	JComboBox urlcomboBox4 = new JComboBox();
	
	JButton zoom1 = new JButton("Zoom +");
	JButton zoom2 = new JButton("Zoom -");
	JButton zoom3 = new JButton("Zoom +");
	JButton zoom4 = new JButton("Zoom -");
	JButton zoom5 = new JButton("Zoom +");
	JButton zoom6 = new JButton("Zoom -");
	JButton zoom7 = new JButton("Zoom +");
	JButton zoom8 = new JButton("Zoom -");

	public Camera() {
		setTitle("Camera");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		this.getContentPane().setLayout(null);

		Instruction.setBounds(500, 450, 400, 50);
		Instruction.setFont(new Font("Times New Roman", 1, 20));
		this.add(Instruction);

		Url.setBounds(200, 660, 100, 30);
		this.add(Url);
		url.setBounds(300, 660, 500, 25);
		url.setText("img/.jpg");
		this.add(url);

		Name.setBounds(200, 600, 100, 30);
		this.add(Name);
		name.setBounds(300, 600, 500, 25);
		this.add(name);
		
		Location.setBounds(200, 540, 100, 30);
		this.add(Location);
		location.setBounds(300, 540, 500, 25);
		this.add(location);

		submit.setBounds(900, 600, 100, 30);
		submit.addActionListener(this);
		this.add(submit);
		reset.setBounds(900, 660, 100, 30);
		reset.addActionListener(this);
		this.add(reset);
		quit.setBounds(1040, 600, 100, 30);
		quit.addActionListener(this);
		this.add(quit);
		delete.setBounds(1040, 660, 100, 30);
		delete.addActionListener(this);
		this.add(delete);
		
		zoom1.setBounds(50, 400, 100, 30);
		zoom1.addActionListener(this);
		this.add(zoom1);
		zoom2.setBounds(200, 400, 100, 30);
		zoom2.addActionListener(this);
		this.add(zoom2);
		zoom3.setBounds(350, 400, 100, 30);
		zoom3.addActionListener(this);
		this.add(zoom3);
		zoom4.setBounds(500, 400, 100, 30);
		zoom4.addActionListener(this);
		this.add(zoom4);
		zoom5.setBounds(650, 400, 100, 30);
		zoom5.addActionListener(this);
		this.add(zoom5);
		zoom6.setBounds(800, 400, 100, 30);
		zoom6.addActionListener(this);
		this.add(zoom6);
		zoom7.setBounds(950, 400, 100, 30);
		zoom7.addActionListener(this);
		this.add(zoom7);
		zoom8.setBounds(1100, 400, 100, 30);
		zoom8.addActionListener(this);
		this.add(zoom8);
				
		
		pnl1.setBounds(50, 50, 250, 250);
		this.add(pnl1);
		pnl2.setBounds(350, 50, 250, 250);
		this.add(pnl2);
		pnl3.setBounds(650, 50, 250, 250);
		this.add(pnl3);
		pnl4.setBounds(950, 50, 250, 250);
		this.add(pnl4);
		
		sc1.setBounds(170, 20, 10, 25);
		sc1.setFont(new Font("Times New Roman", 1, 20));
		this.add(sc1);
		sc2.setBounds(470, 20, 10, 25);
		sc2.setFont(new Font("Times New Roman", 1, 20));
		this.add(sc2);
		sc3.setBounds(770, 20, 10, 25);
		sc3.setFont(new Font("Times New Roman", 1, 20));
		this.add(sc3);
		sc4.setBounds(1070, 20, 10, 25);
		sc4.setFont(new Font("Times New Roman", 1, 20));
		this.add(sc4);
		
		urlcomboBox1.setBounds(70,320,220,50);
		this.add(urlcomboBox1);
		urlcomboBox2.setBounds(370,320,220,50);
		this.add(urlcomboBox2);
		urlcomboBox3.setBounds(670,320,220,50);
		this.add(urlcomboBox3);
		urlcomboBox4.setBounds(970,320,220,50);
		this.add(urlcomboBox4);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		String z_url = url.getText().trim();
		String z_name = name.getText().trim();
		String z_location = location.getText().trim();
		
		if (e.getActionCommand() == "Add Camera") {
			
			switch (z_location) {
			case "1" :
			pnl1.getImageName(z_url);
			pnl1.repaint();
			urlcomboBox1.addItem(z_name);
			break;
			
			case "2" : 
			pnl2.getImageName(z_url);
			pnl2.repaint();
			urlcomboBox2.addItem(z_name);
			break;
			
			case "3" :
			pnl3.getImageName(z_url);
			pnl3.repaint();
			urlcomboBox3.addItem(z_name);
			break;
			
			case "4" :
			pnl4.getImageName(z_url);
			pnl4.repaint();
			urlcomboBox4.addItem(z_name);
			break;
			}
		}

		if (e.getActionCommand() == "Reset") {
			url.setText(" ");
			location.setText(" ");
			name.setText(" ");
		}

		if (e.getActionCommand() == "Quit") {
			this.dispose();
		}
		
		if (e.getActionCommand() == "Delete") {
			switch (z_location) {
			
			case "1" :
				pnl1.getImageName("img/black.jpg");
				pnl1.repaint();
				urlcomboBox1.removeItem(z_name);
				break;
			case "2" :
				pnl2.getImageName("img/black.jpg");
				pnl2.repaint();
				urlcomboBox2.removeItem(z_name);
				break;
			case "3" :
				pnl3.getImageName("img/black.jpg");
				pnl3.repaint();
				urlcomboBox3.removeItem(z_name);
				break;
			case "4" :
				pnl4.getImageName("img/black.jpg");
				pnl4.repaint();
				urlcomboBox4.removeItem(z_name);
				break;
				
			}
		}
		
		if (e.getSource() == zoom1) {
			pnl1.zoom();
			
		}
		if (e.getSource() == zoom2) {
			pnl1.reduce();
		}
		
		if (e.getSource() == zoom3) {
			pnl2.zoom();
			
		}
		if (e.getSource() == zoom4) {
			pnl2.reduce();
		}
		
		if (e.getSource() == zoom5) {
			pnl3.zoom();
			
		}
		if (e.getSource() == zoom6) {
			pnl3.reduce();
		}
		
		if (e.getSource() == zoom7) {
			pnl4.zoom();
			
		}
		if (e.getSource() == zoom8) {
			pnl4.reduce();
		}
	}
}

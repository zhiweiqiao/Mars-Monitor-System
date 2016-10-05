package com.UI;

import java.lang.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.LabelPeer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import com.DAO.MyTime;

/**
 * @author Zhiwei Qiao
 * Sensor
 */

public class Sensor extends JInternalFrame implements ActionListener {
	private JButton btnUpdate = new JButton("Update");
	private JLabel temperature = new JLabel("Temperature");
	private TextField tem = new TextField(50);
	private JLabel humidity = new JLabel("Humidity");
	private TextField hum = new TextField(50);
	private JLabel oxygenlevel  = new JLabel("Oxygen Level");
	private TextField oxy = new TextField(50);
	private JLabel pressure  = new JLabel("Pressure");
	private TextField pre = new TextField(50);
	private JLabel smoke  = new JLabel("Smoke Detection");
	private TextField smo = new TextField(50);
	private MyTime systime = new MyTime();
	private JLabel time = new JLabel("");
	
	
	
	public Sensor() {
		setTitle("Sensor");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		getContentPane().setLayout(new GridLayout(1, 1));
		JPanel p = new JPanel();
		this.getContentPane().add(p);
		p.setLayout(null);
		
		temperature.setBounds(15, 100, 100, 25);
		tem.setBounds(110, 100, 300, 25);
		humidity.setBounds(15, 150, 100, 25);
		hum.setBounds(110, 150, 300, 25);
		oxygenlevel.setBounds(15, 200, 100, 25);
		oxy.setBounds(110, 200, 300, 25);
		pressure.setBounds(15, 250, 100, 25);
		pre.setBounds(110, 250, 300, 25);
		smoke.setBounds(15, 300, 100, 25);
		smo.setBounds(110, 300, 300, 25);
		time.setBounds(150, 50, 200, 25);
		time.setText(systime.getTime());
		
		
		tem.setText(Double.toString(Math.round(Math.random()*40+50)) + " F");
		hum.setText(Double.toString(Math.round(Math.random()*30+30)) + " %");
		oxy.setText(Double.toString(Math.round(Math.random()*20+10)) + " %");
		pre.setText(Double.toString(Math.round(Math.random()*20+5)) + " psi");
		smo.setText(Double.toString(Math.round(Math.random())));
		
		
		btnUpdate.setBounds(800, 175, 100, 30);
		btnUpdate.addActionListener(this);
		p.add(tem);
		p.add(temperature);
		p.add(humidity);
		p.add(hum);
		p.add(oxygenlevel);
		p.add(oxy);
		p.add(pressure);
		p.add(pre);
		p.add(btnUpdate);
		p.add(smoke);
		p.add(smo);
		p.add(time);
			
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Update") {
			
			MyTime systime1 = new MyTime();	
			time.setText(systime1.getTime());
			
			tem.setText(Double.toString(Math.round(Math.random()*40+50)) + " F");
			hum.setText(Double.toString(Math.round(Math.random()*30+30)) + " %");
			oxy.setText(Double.toString(Math.round(Math.random()*20+10)) + " %");
			pre.setText(Double.toString(Math.round(Math.random()*20+5)) + " psi");
			smo.setText(Double.toString(Math.round(Math.random())));
			
			if(Double.parseDouble(tem.getText().trim().replace(" F", "")) > 75 ) {
				JOptionPane.showMessageDialog(this, "High Temperature!", "Warning", getDefaultCloseOperation());
			} else if (Double.parseDouble(tem.getText().trim().replace(" %", "")) < 65 ) {
				JOptionPane.showMessageDialog(this, "Low Temperature!", "Warning", getDefaultCloseOperation());
			}
			
			if(Double.parseDouble(hum.getText().trim().replace(" %", "")) > 50 ) {
				JOptionPane.showMessageDialog(this, "High Humidity!", "Warning", getDefaultCloseOperation());
			} else if (Double.parseDouble(tem.getText().trim().replace(" %", "")) < 40 ) {
				JOptionPane.showMessageDialog(this, "Low Humidity!", "Warning", getDefaultCloseOperation());
			}
			
			if(Double.parseDouble(oxy.getText().trim().replace(" %", "")) > 25 ) {
				JOptionPane.showMessageDialog(this, "High Oxygen Level!", "Warning", getDefaultCloseOperation());
			} else if (Double.parseDouble(oxy.getText().trim().replace(" %", "")) < 15 ) {
				JOptionPane.showMessageDialog(this, "Low Oxygen Level!", "Warning", getDefaultCloseOperation());
			}
			
			if(Double.parseDouble(pre.getText().trim().replace(" psi", "")) > 20 ) {
				JOptionPane.showMessageDialog(this, "High Pressure!", "Warning", getDefaultCloseOperation());
			} else if (Double.parseDouble(pre.getText().trim().replace(" psi", "")) < 10 ) {
				JOptionPane.showMessageDialog(this, "Low Pressure!", "Warning", getDefaultCloseOperation());
			}
			
			if(smo.getText().equals("1.0")) {
				JOptionPane.showMessageDialog(this, "Smoke Detection!", "Warning", getDefaultCloseOperation());
			}
		}
	}
}

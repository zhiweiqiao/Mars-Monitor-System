package com.UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.BLL.HistoryFrameBll;
import com.DAO.User;

/**
 * @author Zhiwei Qiao
 * Simulator
 */

public class Simulator extends JInternalFrame implements ActionListener {

	private JButton btnUpdate = new JButton("Update");
	private JButton btnSearch = new JButton("Query");
	private JLabel tit = new JLabel("Please enter time peried, format as yyyy-MM-dd HH:mm:ss");
	private JLabel tit1 = new JLabel("For example 2016-01-01 01:01:01");
	private JLabel tit2 = new JLabel("Start time: ");
	private JLabel tit3 = new JLabel("End time: ");
	private Object data[] = { "Temperature", "Humidity", "Oxygen level", "Pressure", "Smoke detection", "Combined chlorine/methane gas detection", "External wall of inner structure", "Outside temperature" };
	private JComboBox com = new JComboBox(data);
	private TextField time1 = new TextField("2016-01-01 01:01:01", 100);
	private TextField time2 = new TextField("2016-02-01 01:01:01", 100);
	private JTable jtable;
	String z_time1 = null;
	String z_time2 = null;
	private JScrollPane scrollPane = new JScrollPane();
	HistoryFrameBll hb = new HistoryFrameBll();

	public Simulator() {
		setTitle("Simulator");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		getContentPane().setLayout(new GridLayout(1, 1));
		JPanel p = new JPanel();
		this.getContentPane().add(p);
		this.getContentPane().add(scrollPane);
		p.setLayout(null);
		tit.setBounds(10, 10, 1000, 30);
		tit1.setBounds(10, 40, 1000, 30);
		tit2.setBounds(10, 70, 1000, 30);
		time1.setBounds(10, 100, 300, 25);
		tit3.setBounds(10, 170, 1000, 30);
		time2.setBounds(10, 200, 300, 25);
		com.setBounds(10, 300, 300, 25);
		com.addActionListener(this);
		btnUpdate.setBounds(220, 400, 100, 30);
		btnUpdate.addActionListener(this);
		btnSearch.setBounds(50, 400, 100, 30);
		btnSearch.addActionListener(this);
		p.add(tit);
		p.add(tit1);
		p.add(tit2);
		p.add(tit3);
		p.add(time1);
		p.add(time2);
		p.add(com);
		p.add(btnSearch);
		p.add(btnUpdate);

		try {
			jtable = hb.getAll();
		} catch (Exception e) {
			System.out.println(e.toString()); // 调试程序时，如果有异常，可以用此句看看异常信息

		}
		jtable.disable();
		scrollPane.setViewportView(jtable);
		this.getContentPane().add(scrollPane);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Update") {
			try {
				jtable = hb.getAll();
			} catch (Exception e1) {
				System.out.println(e1.toString()); // 调试程序时，如果有异常，可以用此句看看异常信息
			}
			scrollPane.setViewportView(jtable);
			this.getContentPane().add(scrollPane);
		}

		if (e.getActionCommand() == "Query") {
			z_time1 = time1.getText().trim();
			z_time2 = time2.getText().trim();
			if (com.getSelectedItem() == "Temperature") {
				try {
					jtable = hb.getTemperature(z_time1, z_time2);
				} catch (Exception e1) {
					System.out.println(e1.toString()); // 调试程序时，如果有异常，可以用此句看看异常信息
				}
				scrollPane.setViewportView(jtable);
				this.getContentPane().add(scrollPane);
			} else {
				if (com.getSelectedItem() == "Pressure") {
					try {
						jtable = hb.getPressure(z_time1, z_time2);
					} catch (Exception e1) {
						System.out.println(e1.toString()); // 调试程序时，如果有异常，可以用此句看看异常信息
					}
					scrollPane.setViewportView(jtable);
					this.getContentPane().add(scrollPane);
				} else if (com.getSelectedItem() == "Humidity") {
					try {
						jtable = hb.getHumidity(z_time1, z_time2);
					} catch (Exception e1) {
						System.out.println(e1.toString()); // 调试程序时，如果有异常，可以用此句看看异常信息
					}
					scrollPane.setViewportView(jtable);
					this.getContentPane().add(scrollPane);
				} else if (com.getSelectedItem() == "Oxygen level") {
					try {
						jtable = hb.getOxygen(z_time1, z_time2);
					} catch (Exception e1) {
						System.out.println(e1.toString()); // 调试程序时，如果有异常，可以用此句看看异常信息
					}
					scrollPane.setViewportView(jtable);
					this.getContentPane().add(scrollPane);
				}
			}
		}
	}
}

package com.UI;

import java.awt.*;

import javax.swing.*;

/**
 * @author Zhiwei Qiao
 *  Information
 */

public class Know extends JInternalFrame {
	private JLabel welcome = new JLabel("How to use this system");
	private JLabel tit1 = new JLabel("Camera");
	private JLabel tit2 = new JLabel("Sensor");

	public Know() {
		setTitle("Help");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		this.getContentPane().setLayout(null);

		welcome.setBounds(270, 10, 300, 50);
		welcome.setFont(new Font("Times New Roman", 1, 20));
		this.add(welcome);

		tit1.setBounds(20, 80, 1000, 30);
		this.add(tit1);
		tit2.setBounds(20, 120, 1000, 30);
		this.add(tit2);
		/*tit3.setBounds(20, 160, 1000, 30);
		this.add(tit3);
		tit4.setBounds(20, 200, 1000, 30);
		this.add(tit4);
		tit5.setBounds(20, 240, 1000, 30);
		this.add(tit5);
		tit6.setBounds(20, 280, 1000, 30);
		this.add(tit6);*/

		this.setVisible(true);
	}
}
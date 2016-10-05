package com.UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.UI.QueryJFrame;
import com.Common.*;
import com.DAO.User;

/**
 * @author Zhiwei Qiao
 * Main frame
 */

public class MdiFrame extends JFrame implements ActionListener {
	public static User user = new User();
	private MDIDesktopPane desktop = new MDIDesktopPane();

	private JMenuBar menuBar = new JMenuBar();

	private JMenu mnuMonitor = new JMenu("Monitor");
	private JMenu mnuSensor = new JMenu("Sensor");
	private JMenu mnuHelp = new JMenu("Help");
	private JMenu mnuSys = new JMenu("User");

	private JMenuItem mnuCamera = new JMenuItem("Camera");
	private JMenuItem mnusen = new JMenuItem("Sensor");
	private JMenuItem mnuSimu = new JMenuItem("Simulator");
	private JMenuItem mnuKnow = new JMenuItem("Information");
	private JMenuItem mnuOpen = new JMenuItem("Sign up");
	private JMenuItem mnuClose = new JMenuItem("Delete user");
	private JMenuItem mnuPassword = new JMenuItem("Change password");

	private JScrollPane scrollPane = new JScrollPane();

	public MdiFrame() {
		setMenu();

		setTitle("Mars Monitoring System");
		desktop.setBackground(java.awt.Color.lightGray);
		scrollPane.getViewport().add(desktop);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 10, 1500, 800);
		this.setVisible(true);
	}

	private void setMenu() {
		mnuMonitor.add(mnuCamera);
		mnuCamera.addActionListener(this);
		mnuSensor.add(mnusen);
		mnusen.addActionListener(this);
		mnuSensor.add(mnuSimu);
		mnuSimu.addActionListener(this);
		mnuHelp.add(mnuKnow);
		mnuKnow.addActionListener(this);
		mnuSys.add(mnuOpen);
		mnuOpen.addActionListener(this);
		mnuSys.add(mnuPassword);
		mnuPassword.addActionListener(this);
		mnuSys.add(mnuClose);
		mnuClose.addActionListener(this);
		
		menuBar.add(mnuSys);
		menuBar.add(mnuMonitor);
		menuBar.add(mnuSensor);
		menuBar.add(mnuHelp);

		setJMenuBar(menuBar);
	}

	private void disMenu() {
		/*mnuQueryUser.setEnabled(false);
		mnuSys.setEnabled(false);
		mnuQueryHistory.setEnabled(false);
		mnuQueryAll.setEnabled(false);
		mnuQueryCharge.setEnabled(false);
		*/
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Camera")) {
			desktop.add(new Camera());
		}
		if (ae.getActionCommand().equals("Simulator")) {
			desktop.add(new Simulator());
		}
		if (ae.getActionCommand().equals("Test Camera")) {
			desktop.add(new CameraPanel());
		}
		if (ae.getActionCommand().equals("Information")) {
			desktop.add(new Know());
		}
		if (ae.getActionCommand().equals("Sensor")) {
			desktop.add(new Sensor());
		}
		if (ae.getActionCommand().equals("Sign up")) {
			desktop.add(new Register());
		}
		if (ae.getActionCommand().equals("Delete user")) {
			desktop.add(new DropUser());
		}
		if (ae.getActionCommand() == "Change password") {
			desktop.add(new ExPassword());
		} else {
			System.out.println(user.getUserName());
		}
		JInternalFrame jf = desktop.getSelectedFrame();

		try {
			jf.setMaximum(true);
		} catch (Exception e) {
			;
		}
	}

	public static void main(String args[]) {
		MdiFrame mdiMain = new MdiFrame();

		new LoginFrame(mdiMain, true);

		if (user.getUserType().equals("user")) {
			mdiMain.disMenu();
		}
	}
}

package com.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CameraPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	ImageIcon img = new ImageIcon("img/black.jpg");
	
	
	private int x = 0;//
	private int y = 0;
	
	private int width = 300;
	private int height = 300;
	
	//zoom size
	private int dx = 50;
	private int dy = 50;
	
	public CameraPanel(){
		this.addMouseWheelListener(new MouseWheelListener() {
			
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(e.getWheelRotation() < 0){
					zoom();
				}else{
					reduce();
				}
				
			}
		});
		
		MouseAdapter ma = new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				zoom();
			}


			boolean moveEnable = false;
			Point point1 = null;
			Point point2 = null;
			
			@Override
			public void mousePressed(MouseEvent e) {
				moveEnable = true;
				point1 = e.getPoint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				moveEnable = false; 
				point1 = null;
				point2 = null;
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				//System.out.println("move");
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("dragged");
				point2 = e.getPoint();
				if(moveEnable){
					if(point1 != null && point2 != null){
						int dx = point2.x - point1.x;
						int dy = point2.y - point1.y;
						x = x + dx;
						y = y + dy;
						//Layer.this.setLocation(_x, _y);
						point1 = point2;
						repaint();
					}
				}
			}
		};
		
		this.addMouseMotionListener(ma);
		this.addMouseListener(ma);
	}
	
	public void getImageName(String s) {
		img = new ImageIcon(s);
	}
	
	@Override
	public void paint(Graphics g) {
		//change
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0, 0, getBounds().width, getBounds().height);
		g2.drawImage(img.getImage(), x, y, width, height, null);
		
	}
	
	/**
	 * zoom-
	 */
	public void reduce(){
		if(width > 2*dx && height > 2*dy){
			x +=  dx;
			y +=  dy;
			width -= 2 * dx;
			height -= 2 * dy;
			super.repaint();
		}
		
	}
	
	/**
	 * zoom+
	 */
	public void zoom(){
		x -=  dx;
		y -=  dy;
		width += 2 * dx;
		height += 2 * dy;
		super.repaint();
	}
}

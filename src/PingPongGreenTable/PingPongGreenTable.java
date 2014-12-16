package PingPongGreenTable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;



public class PingPongGreenTable extends JPanel{
	protected int ballx;
	protected int bally;
	protected int com;
	protected int kid;
	protected String coxy="";
	protected String message="";
	
	private MouseMotionListener mslistener;
	
	public PingPongGreenTable(){
		//this.setBackground(Color.green);
		this.ballx = 80;
		this.bally = 250;
		this.com = 240;
		this.kid = 240;
		
		this.mslistener = new mouseHandler();
		this.addMouseMotionListener(mslistener);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//set table
		g.setColor(Color.green);
		g.fillRect(10, 10, 760, 520);
		g.setColor(Color.white);
		g.drawRect(40, 40, 700, 460);
		g.drawLine(390, 40, 390, 500);
		
		//set ball
		g.setColor(Color.red);
		//g.drawOval(80, 250, 20, 20);
		g.fillOval(ballx, bally, 20, 20);
		
		//set computer board
		
		g.setColor(Color.blue);
		//g.drawRect(60, this.com, 10, 50);
		g.fillRect(60, this.com, 10, 50);
		//set kid board
		
		g.setColor(Color.yellow);
		//g.drawRect(700, this.kid, 10, 50);
		g.fillRect(700, this.kid, 10, 50);
		
		//set coxy
		g.setColor(Color.black);
		g.drawString(this.coxy, 30, 550);
		
		//set message
		g.drawString(this.message, 400, 550);
	}
	
	public void setballpoint(int _ballx,int _bally){
		this.ballx = _ballx;
		this.bally = _bally;
	}
	


	
	private class mouseHandler implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			// String.valueOf(e.getX())+" "+String.valueOf(e.getY());

			
			coxy = ("x : " + String.valueOf(e.getX()) +" y : " + String.valueOf(e.getY()));
			kid = e.getY();
			PingPongGreenTable.this.repaint();
		}
		
	}
}

package PingPongGreenTable;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;


public class Start extends JFrame{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Start frame = new Start();

		PingPongGreenTable ppgt = new PingPongGreenTable();
		
		
		frame.add(ppgt);
		
		frame.setTitle("Ping Pong Green Table");
		frame.setSize(800, 600);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);  
		
		PingPongGameEngine ppge = new PingPongGameEngine(ppgt);
		ppge.run();
	}
	
	
	

}

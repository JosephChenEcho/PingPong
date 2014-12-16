package PingPongGreenTable;

public class PingPongGameEngine {
	
	private PingPongGreenTable table;
	private double bx;
	private double by;
	private double estimatepoint;
	private double xstep;
	private double ystep;
	private int score;
	private int timer;
	private Boolean done;
	
	public PingPongGameEngine(){}
	
	public PingPongGameEngine(PingPongGreenTable _table){
		
		this.bx= _table.ballx;
		this.by = _table.bally;
		
		this.table = _table;
		this.xstep = 5;
		this.ystep = 3;
		this.score = 0;
		this.timer = 50;
		this.done = true;
		this.estimatepoint = _table.com;
	}
	
	public void run(){
		
		while(done){
			
			//Ball move
			bx+=xstep;
			by+=ystep;
			try {
				Thread.sleep(timer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			table.setballpoint((int)bx, (int)by);
			
			if(by>=480||by<=40){
				ystep *= -1;
			}
			
			if(bx>=680){
				if (table.kid<=(by+10)&&(by+10)<=(table.kid+50)){
					xstep *=-1;
					score++;
					
					xstep *= 1.1;
					ystep *= 1.1;
					
					table.message = "Score " + String.valueOf(score);
				}
				else if (bx>=740){
					this.done = false;
					table.message = "Computer Win ! Score " + String.valueOf(score);
				}
			}
			
			if(bx<=70){
				
				if (table.com<=(by+10)&&(by+10)<=(table.com+50)){
					xstep *=-1;
					ystep += Math.random()*2-1;
				}
				else if (bx<=40){
					this.done = false;
					table.message = "You Win ! Score " + String.valueOf(score);
				}
			}
			
			
			//Computer Board Move
			if(xstep<0&&250<=bx&&bx<=390){
				
				//xstep is negative
				estimatepoint = by - (bx-70)*ystep/xstep;
				
				if(estimatepoint<=40){
					//ystep is negative
					estimatepoint -= 2*((bx-70)+((by-40)*(-xstep)/ystep))*ystep/(-xstep);
				}
				
				if(estimatepoint>=480){
					//ystep is positive 
					estimatepoint -= 2*((bx-70)-((480-by)*(-xstep)/ystep))*ystep/(-xstep);			
				}
			}
			
			
			
			if(xstep<0&&(estimatepoint+10)>table.com+30){
				table.com += 10;
			}
			
			if(xstep<0&&(estimatepoint+10)<table.com+20){
				table.com -= 10;
			}

			
			table.repaint();
		}
		
	}
}

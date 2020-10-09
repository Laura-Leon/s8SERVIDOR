package s8servidor;

import com.google.gson.Gson;

import processing.core.PApplet;

public class MainServer extends PApplet {
	private TCPsingleton tcp; 
	
		int x;
		int y;
		String usuario;
		int r,g,b;
		
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("s8servidor.MainServer");
	}
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		tcp = TCPsingleton.getInstace();
		tcp.setMainServer(this);
		//tcp.start();
		x=0;
		y=0;
		
	}
	
	
	
	public void draw() {
		background(255);
		
		
		if (usuario != null) {
			
			fill(r,g,b);
			text(usuario,x-10,y-70);
			ellipse(x,y,50,50);
		}
	
	}
	

	public void onMessage(String obj ) {
		usuario = obj;
		
	}


	public void onMessages(int xs ,int ys) {
		x = xs;
		y = ys;
	}

	public void oncolor(int r2, int g2, int b2) {
		r = r2;
		g = g2 ;
		b= b2;
		
	}



	
	
	

}


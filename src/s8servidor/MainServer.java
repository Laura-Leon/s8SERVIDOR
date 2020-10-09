package s8servidor;

import com.google.gson.Gson;

import processing.core.PApplet;

public class MainServer extends PApplet implements onMessage{
	private TCPsingleton tcp; 
	

		int x;
		int y;
		Coordenada coordenada;
		Usuario usuario;
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
		x=200;
		y=200;
		
	}
	
	
	
	public void draw() {
		background(255);
		if (tcp.obj == null) {
			//System.out.println("nombre"+usuario.getNombre());
			text(usuario.getNombre(),coordenada.getX()-100,coordenada.getY()-100);
		}
		
		if (coordenada != null) {
				fill(0,255,20);
				
				ellipse(coordenada.getX(),coordenada.getY(),50,50);
		}else {
			fill(0,255,20);
			ellipse(0,0,50,50);
		}
		
		
		
	}
	

	public void onMessage(Usuario obj) {
		this.usuario = obj;
		
	}

	@Override
	public void onMessages(Coordenada coordenada) {
		// TODO Auto-generated method stub
		this.coordenada = coordenada;
	}



	
	
	

}


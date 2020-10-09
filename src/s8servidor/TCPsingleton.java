package s8servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;



public class TCPsingleton extends Thread{
	
	private static TCPsingleton unica;
	
	private TCPsingleton() {
		
	}
	
	public static TCPsingleton getInstace() {
		if(unica == null){
			unica = new TCPsingleton();
			unica.start();
			
		}
		return unica;
	}
	
	private BufferedWriter writer;
	private Socket socket;
	private MainServer observer;
	private BufferedReader reader;
	private ServerSocket server;
	//private Coordenada coordenada = new Coordenada(50, 50);
	public Usuario obj;
	
	//sus
	public void setMainServer(MainServer observer) {
		this.observer = observer;
	}
	
	public void run() {
		try {
			//conexion 
			server = new ServerSocket(5000);
			System.out.println("Esperando...");
			Socket socket = server.accept();
			System.out.println("Conectado");
	
			
			//declaraciones
			InputStream is = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			writer = new BufferedWriter (new OutputStreamWriter(out));
			reader = new BufferedReader(new InputStreamReader(is));
			
			//recep
			
			while(true) {
				System.out.println("esperando mensaje...");
				String  lastMessage = reader.readLine();
				System.out.println("mensaje recibido"+ lastMessage);
	
				
				Gson gson = new Gson();
				
				 obj = gson.fromJson(lastMessage,Usuario.class);
				
				Coordenada coordenaRecibida = gson.fromJson(lastMessage, Coordenada.class);
			
				observer.onMessage(obj);
				observer.onMessages(coordenaRecibida);
				
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendMessage(String msg) {
		new Thread(
				()->{
					try {
						writer.write(msg + "\n");
						writer.flush();
						
					}catch(IOException e) {
						e.printStackTrace();
				}
			}
				).start();
	}

}

package chat2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class chatThread extends Thread {
	
	private String name;
	private BufferedReader br;
	private PrintWriter pw;
	private Socket socket;
	List<ChatThread> list;
	
	public chatThread(Socket socket, List<chatThread> list) throws Exception {
		this.socket = socket;
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		this.br = br;
		this.pw = pw;
		this.name = br.readLine();
		this.list = list;
		this.list.add(this);
	}
}

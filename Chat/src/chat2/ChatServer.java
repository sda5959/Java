package chat2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		List<chatThread> list = Collections.synchronizedList(new ArrayList<>());
		
		while (true) {
			Socket socket = serverSocket.accept();
			chatThread chatThread = new chatThread(socket, list);
			chatThread.start();
		}
	}
}

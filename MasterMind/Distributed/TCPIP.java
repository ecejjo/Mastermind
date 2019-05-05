package MasterMind.Distributed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPIP {
	
	private ServerSocket serverSocket;

	private Socket socket;

	private PrintWriter out;

	private BufferedReader in;

	public TCPIP(Socket socket, PrintWriter out, BufferedReader in) {
		this.socket = socket;
		this.out = out;
		this.in = in;
		this.serverSocket = null;
	}

	public TCPIP(ServerSocket serverSocket, Socket socket, PrintWriter out, BufferedReader in) {
		this.socket = socket;
		this.out = out;
		this.in = in;
		this.serverSocket = serverSocket;
	}

	public static TCPIP createClientSocket() {
		try {
			Socket socket = new Socket("localhost", 2020);
			System.out.println("Cliente> Establecida conexion");
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			return new TCPIP(socket, out, in);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
			return null;
		}
	}

	public static TCPIP createServerSocket() {
		try {
			ServerSocket serverSocket = new ServerSocket(2020);
			System.out.println("Server> Waiting for connection ...");
			Socket socket = serverSocket.accept();
			System.out.println("Server> Connection established from: " + socket.getInetAddress().getHostAddress() + ":"
					+ socket.getPort());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			return new TCPIP(serverSocket, socket, out, in);
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void send(String value) {
		this.out.println(value);
		this.out.flush();
		// System.out.println(" - Sent: " + value);
	}

	public String receiveLine() {
		String result = null;
		try {
			result = this.in.readLine();
		} catch (IOException e) {
			System.out.println("Server error!!! Reading line.");
		}
		// System.out.println(" - Received: " + result);
		return result;
	}

	public void close() {
		try {
			this.send(FrameType.CLOSE.name());
			this.in.close();
			this.out.close();
			this.socket.close();
			if (this.serverSocket != null) {
				this.serverSocket.close();				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

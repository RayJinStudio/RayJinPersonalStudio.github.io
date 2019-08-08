

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server{

	public static void main(String[] args) {
		try {
			System.out.println("创建服务端...");
			ServerSocket serverSocket = new ServerSocket(9608);
			System.out.println("等待客户端连接...");
			// 连接成功，返回一个Socket：对客户端的描述
			Socket socket = serverSocket.accept();
			System.out.println("客户端已连接...");

			sendMsg sendMsg = new sendMsg(socket);
			receiverMsg receiverMsg = new receiverMsg(socket);

			Thread t1 = new Thread(sendMsg);
			Thread t2 = new Thread(receiverMsg);

			t1.start();
			t2.start();

			serverSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 服务器发送信息给客户端
	static class sendMsg implements Runnable {
		private Socket socket;
		private PrintWriter pw;

		public sendMsg(Socket socket) {
			super();
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				OutputStream os = socket.getOutputStream();
				pw = new PrintWriter(new OutputStreamWriter(os), true);
				while (true) {
					pw.println(InputUtils.inputStr("服务器请说: "));
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 服务器接收客户端信息
	static class receiverMsg implements Runnable {

		private Socket socket;
		private String name;

		public receiverMsg(Socket socket) {
			super();
			this.socket = socket;
			this.name = socket.getInetAddress().getHostName();
		}

		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));

				while (true) {
					String readLine = br.readLine();
					if (readLine == null) {
						break;
					}
					System.out.println(name + " 说: " + readLine);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


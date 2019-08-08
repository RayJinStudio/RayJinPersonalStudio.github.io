

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class user {
	/**
	 * 使用TCP实现单聊的功能。（客户端和服务端聊天）
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("创建客户端，并连接服务端...");
			InetAddress byName = InetAddress.getByName("139.155.130.246");
			Socket socket2 = new Socket(byName, 80);

			sendMsg sm2 = new sendMsg(socket2);
			receiverMsg rm2 = new receiverMsg(socket2);

			Thread t1 = new Thread(sm2);
			Thread t2 = new Thread(rm2);

			t1.start();
			t2.start();

			// socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 客户端发送信息给服务器
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
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
				while (true) {

					pw.println(InputUtils.inputStr("客户端说: "));
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 客户端接收服务器信息
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
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

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


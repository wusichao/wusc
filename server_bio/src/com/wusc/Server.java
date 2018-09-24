package com.wusc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server{
	
	public static void main(String[] args){
		Server server = new Server();
		server.start();
	}	
	/**
 	*启动服务
 	*/	 
	public void start () {
		try{
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket client = serverSocket.accept();
		InputStream is =client.getInputStream();
		byte[] datas = new byte[1024*1024];
		int len = is.read(datas);
		String requestInfo = new String(datas,0,len);
		System.out.println(requestInfo);
		StringBuilder content =new StringBuilder();
			content.append("<html>");
			content.append("<head>");
			content.append("<title>");
			content.append("服务器响应成功");
			content.append("</title>");
			content.append("</head>");
			content.append("<body>");
			content.append("shsxt server终于回来了。。。。");
			content.append("</body>");
			content.append("</html>");
		int size = content.toString().getBytes().length; //必须获取字节长度
			StringBuilder responseInfo =new StringBuilder();
			String blank =" ";
			String CRLF = "\r\n";
			//返回
			//1、响应行: HTTP/1.1 200 OK
			responseInfo.append("HTTP/1.1").append(blank);
			responseInfo.append(200).append(blank);
			responseInfo.append("OK").append(CRLF);
			responseInfo.append("Date:").append(new Date()).append(CRLF);
			responseInfo.append("Server:").append("shsxt Server/0.0.1;charset=GBK").append(CRLF);
			responseInfo.append("Content-type:text/html").append(CRLF);
			responseInfo.append("Content-length:").append(size).append(CRLF);
			responseInfo.append(CRLF);
			responseInfo.append(content.toString());
			BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(responseInfo.toString());
			bw.flush();
			}catch (IOException e) {
			e.printStackTrace();
		}
	}

}

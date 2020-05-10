//服务器线程处理
//和本线程相关的socket
Socket socket =null;
//
public serverThread(Socket socket){
this.socket = socket;
}

publicvoid run(){
//服务器处理代码
}

//============================================
//服务器代码
ServerSocket serverSocket =newServerSocket(10086);
Socket socket =null;
int count =0;//记录客户端的数量
while(true){
socket = serverScoket.accept();
ServerThread serverThread =newServerThread(socket);
 serverThread.start();
 count++;
System.out.println("客户端连接的数量："+count);
}
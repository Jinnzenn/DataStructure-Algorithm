//服务器端，实现基于UDP的用户登录
//1、创建服务器端DatagramSocket，指定端口
DatagramSocket socket =new datagramSocket(10010);
//2、创建数据报，用于接受客户端发送的数据
byte[] data =newbyte[1024];//
DatagramPacket packet =newDatagramPacket(data,data.length);
//3、接受客户端发送的数据
socket.receive(packet);//此方法在接受数据报之前会一致阻塞
//4、读取数据
String info =newString(data,o,data.length);
System.out.println("我是服务器，客户端告诉我"+info);


//=========================================================
//向客户端响应数据
//1、定义客户端的地址、端口号、数据
InetAddress address = packet.getAddress();
int port = packet.getPort();
byte[] data2 = "欢迎您！".geyBytes();
//2、创建数据报，包含响应的数据信息
DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
//3、响应客户端
socket.send(packet2);
//4、关闭资源
socket.close();
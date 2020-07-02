public class InetAddresscase{
	public static void useless(){
		//获取本机的InetAddress实例
		InetAddress address =InetAddress.getLocalHost();
		address.getHostName();//获取计算机名
		address.getHostAddress();//获取IP地址
		byte[] bytes = address.getAddress();//获取字节数组形式的IP地址,以点分隔的四部分

		//获取其他主机的InetAddress实例
		InetAddress address2 =InetAddress.getByName("其他主机名");
		InetAddress address3 =InetAddress.getByName("IP地址");
	}
	
}
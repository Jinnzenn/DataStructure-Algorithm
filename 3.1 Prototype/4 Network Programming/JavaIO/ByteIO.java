public class ByteIo{
	public static void copyFile(String src, String dist) throws IOException{
		//打开输入字节流和输出字节流
		//src\dist都是文件地址
		FileInputStream in = new FileInputStream(src);
		FileOutputStream out = new FileOutputStream(dist);
		
		byte[] buffer = new byte[20*1024];
		int cnt;
		// read() 最多读取 buffer.length 个字节
		// 返回的是实际读取的个数
		// 返回 -1 的时候表示读到 eof，即文件尾
		
		while((cnt = in.read(buffer, 0, buffer.length)!=-1){
			out.write(buffer, 0 ,cnt);
		}
		//关闭输入流和输出流
		in.close();
		out.close();
	}
}
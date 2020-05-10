public class URLcase{
	public static void main(String[] args) throws IOException {

		URL url = new URL("http://www.baidu.com");

		/* 字节流 */
		InputStream is = url.openStream();

		/* 字符流 */
		InputStreamReader isr = new InputStreamReader(is, "utf-8");

		/* 提供缓存功能 */
		BufferedReader br = new BufferedReader(isr);

		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		br.close();
	}
	public static usecase(){
		//创建一个URL的实例
		URL baidu =new URL("http://www.baidu.com");
		URL url =new URL(baidu,"/index.html?username=tom#test");//？表示参数，#表示锚点
		url.getProtocol();//获取协议
		url.getHost();//获取主机
		url.getPort();//如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
		url.getPath();//获取文件路径
		url.getFile();//文件名，包括文件路径+参数
		url.getRef();//相对路径，就是锚点，即#号后面的内容
		url.getQuery();//查询字符串，即参数
		
		//使用URL读取网页内容
//创建一个URL实例
		URL url =new URL("http://www.baidu.com");
		InputStream is = url.openStream();//通过openStream方法获取资源的字节输入流
		InputStreamReader isr =newInputStreamReader(is,"UTF-8");//将字节输入流转换为字符输入流,如果不指定编码，中文可能会出现乱码
		BufferedReader br =newBufferedReader(isr);//为字符输入流添加缓冲，提高读取效率
		String data = br.readLine();//读取数据
		while(data!=null){
		System.out.println(data);//输出数据
		data = br.readerLine();
		}
		br.close();
		isr.colose();
		is.close();
	}
}
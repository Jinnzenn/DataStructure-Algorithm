public class CharIO{
	//字符流和字节流可以互相编码
	public static void readFileContent(String filePath) throws IOException{
		FileReader fileReader = new FileReader(filePath);
		BufferReader bufferReader = new BufferedReader(fileReader);
		
		String line;
		while((line = bufferReader.readLine())!=null){
			System.out.println(line);
		}
		
		// 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
		// 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
		// 因此只要一个 close() 调用即可
		bufferReader.close();
	}
	
	public void useless(){
		String str1 = "中文";
		byte[] bytes = str1.getBytes("UTF-8");
		String str2 = new String(bytes, "UTF-8");
		System.out.println(str2);
	}
}
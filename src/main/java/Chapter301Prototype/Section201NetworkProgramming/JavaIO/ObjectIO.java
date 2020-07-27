package Chapter301Prototype.Section201NetworkProgramming.JavaIO;

import java.io.*;

public class ObjectIO{
	//
    //序列化：ObjectOutputStream.writeObject()
    //反序列化：ObjectInputStream.readObject()
	private static class Inner implements Serializable {
		private int x;
		private String y;
		Inner(int x, String y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString(){
			return "x=" + x + " " + "y = " + y;
		}
	}
	
	public static void SerialInner(){
		Inner innerObject = new Inner(123,"abc");
		String objectFile = "filePath/innerO";
		try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
            objectOutputStream.writeObject(innerObject);
            objectOutputStream.close();
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
            Inner innerO = (Inner) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(innerO);
        }catch (Exception e){
		    e.printStackTrace();
        }
		
	}
}
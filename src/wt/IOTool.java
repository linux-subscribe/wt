package wt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class IOTool {
	
	public IOTool(){
		
	}

	public Object readFromFile(String filePath) {
		ObjectInputStream ois=null;
		Object object=null;
		try{
			ois=new ObjectInputStream(Files.newInputStream(FileSystems.getDefault().getPath(filePath)));
			object=ois.readObject();
		}catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return object;
	}
	
	public void writeToFile(Object object, String filePath){
		ObjectOutputStream oos=null;
		try{
			oos=new ObjectOutputStream(Files.newOutputStream(FileSystems.getDefault().getPath(filePath)));
			oos.writeObject(object);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

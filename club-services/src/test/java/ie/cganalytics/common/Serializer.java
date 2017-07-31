package ie.cganalytics.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Serializer {

	public void serializeOut(Serializable out) {
		try {
			FileOutputStream bos = new FileOutputStream("file.dat");
			ObjectOutputStream oos = new ObjectOutputStream(bos); 
			oos.writeObject(out);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Serializable serializeIn() {
		Serializable object = null;
		
		try {
			FileInputStream bis = new FileInputStream("file.dat");
			ObjectInputStream ois = new ObjectInputStream(bis);
			object = (Serializable)ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}
}

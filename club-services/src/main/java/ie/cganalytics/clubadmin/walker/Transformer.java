package ie.cganalytics.clubadmin.walker;

import ie.cganalytics.clubadmin.model.Club;
import ie.cganalytics.clubadmin.model.dto.ClubDto;
import ie.cganalytics.clubadmin.model.hibernate.ClubImpl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.PropertyUtils;

public class Transformer<W extends Walkable> {
	
	private Walker<W> walker;
	
	public Transformer(Walker<W> walker) {
		this.walker = walker;
	}
	
	public void transform() throws Exception {
		Class<W> contract = walker.getContract();
		
		PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(contract);
		for (PropertyDescriptor descriptor : descriptors) {
			Class<W> sourceClass = (Class<W>)walker.getSource().getClass();
			Class<W> destClass = (Class<W>)walker.getDestination().getClass();
			Method readMethod = getReadMethod(sourceClass, descriptor.getName());
			Method writeMethod = getWriteMethod(destClass, descriptor.getName());
			
			if (readMethod != null && writeMethod != null) {
				Object value = readMethod.invoke(walker.getSource());
				writeMethod.invoke(walker.getDestination(), value);
			}
		}
	}
	
	private Method getReadMethod(Class<W> clazz, String propertyName) {
		PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(clazz);
		for (PropertyDescriptor descriptor : descriptors) {
			if (propertyName.equalsIgnoreCase(descriptor.getName())) {
				Method readMethod = descriptor.getReadMethod();
				if (readMethod != null) {
					return readMethod;
				}
			}
		}	
		return null;
	}
	
	private Method getWriteMethod(Class<W> clazz, String propertyName) {
		PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(clazz);
		for (PropertyDescriptor descriptor : descriptors) {
			if (propertyName.equalsIgnoreCase(descriptor.getName())) {
				Method writeMethod = descriptor.getWriteMethod();
				if (writeMethod != null) {
					return writeMethod;
				}
			}
		}	
		return null;
	}
	
	public static void main(String[] args) {
		ClubImpl source = new ClubImpl();
		source.setId(1L);
		source.setName("SHAMROCKS");
		
		ClubDto dest = new ClubDto();
		
		Walker walker = new Walker(Club.class, source, dest);
		Transformer transformer = new Transformer(walker);
		
		try {
			transformer.transform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(dest.getId());
		System.out.println(dest.getName());
	}
}

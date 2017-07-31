package ie.cganalytics.common;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

public class DtoProxy implements InvocationHandler, Serializable {
	
	private Map<String, Object> values = new HashMap<String, Object>();
	private List<String> getters = new ArrayList<String>();
	private List<String> setters = new ArrayList<String>();
	private Map<String, String> pairings = new HashMap<String, String>();
	
	public DtoProxy(Class<?> clazz) {
		PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(clazz);
		for (PropertyDescriptor descriptor : descriptors) {
			Method readMethod = descriptor.getReadMethod();
			Method writeMethod = descriptor.getWriteMethod();
			if (readMethod != null && writeMethod != null) {
				getters.add(readMethod.getName());
				setters.add(writeMethod.getName());
				pairings.put(readMethod.getName(), writeMethod.getName());
			} else {
				throw new IllegalArgumentException("Invalid gettter/setter: " + descriptor);
			}
		}	
	}
	
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		if (setters.contains(arg1.getName())) {
			values.put(arg1.getName(), arg2[0]);
			return null;
		} else if (getters.contains(arg1.getName())) {
			return values.get(pairings.get(arg1.getName()));
		}
		return null;
	}
	
	public static <C extends Object> C create(Class<C> clazz) {
		InvocationHandler handler = new DtoProxy(Person.class);
		C object = (C)Proxy.newProxyInstance(clazz.getClassLoader(), 
				new Class[]{clazz}, handler);
		return object;
	}
}

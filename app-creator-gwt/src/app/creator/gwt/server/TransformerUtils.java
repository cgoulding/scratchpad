package app.creator.gwt.server;

import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

public class TransformerUtils {

	public static String toCamelCaseLowerFirst(String name) {
		return StringUtils.uncapitalize(StringUtils.replace(WordUtils.capitalizeFully(name), " ", ""));
	}
	
	public static String toCamelCaseUpperFirst(String name) {
		return StringUtils.capitalize(StringUtils.replace(WordUtils.capitalizeFully(name), " ", ""));
	}

	public static String randomString(int length) {
	    Random r = new Random();
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < length; i++) {
	        char c = (char)(r.nextInt((int)(Character.MAX_VALUE)));
	        sb.append(c);
	    }
	    return sb.toString();
	}
	
	public static String randomString() {
		StringBuffer random = new StringBuffer();
		String uuid = UUID.randomUUID().toString();
		for (char c : uuid.toCharArray()) {
			if ('-' == c) {
				continue;
			}
			
			if (StringUtils.isNumeric(Character.toString(c))) {
				random.append(Character.toChars(c + 49));
			} else {
				random.append(c);
			}
		}
		return random.toString();
//		randomString();
//	    Random r = new Random();
//	    StringBuilder sb = new StringBuilder();
//	    for(int i = 0; i < length; i++) {
//	        char c = (char)(r.nextInt((int)(Character.MAX_VALUE)));
//	        sb.append(c);
//	    }
//	    return sb.toString();
	}
}

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ExpediaJsonFormatter {

	public String expediaJsonString(Object object) throws PrintingException {
		
		try {
			Class<?> objectClass = requireNonNull(object).getClass();
			Map<String, String> jsonElements = new HashMap<>();
			
			for (Field field: objectClass.getDeclaredFields()) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(IncludePrint.class)) {
					jsonElements.put(getJsonKey(field), field.get(object).toString());
				}
			}
			System.out.println(toJsonString(jsonElements));
			return toJsonString(jsonElements);
		}
		catch (IllegalAccessException e) {
			throw new PrintingException(e.getMessage());
		}
	}

	private String toJsonString(Map<String, String> jsonMap) {

		String elementsString = jsonMap.entrySet()
		        .stream()
		        .map(entry -> "\""  + entry.getKey() + "\":\"" + entry.getValue() + "\"")
		        .collect(joining(","));
		return "{" + elementsString + "}";
	}
	
	private static String getJsonKey(Field field) {
		String annotationValue = field.getAnnotation(IncludePrint.class).value();
		
		if (annotationValue.isEmpty()) {
			return field.getName();
		}
		else {
			return annotationValue;
		}
	}
}

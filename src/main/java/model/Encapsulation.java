package main.java.model;

public class Encapsulation {
	
	private String classNamePattern;
	private String fieldNamePattern;
	private final String CLASS = "class";
	private final String FIELD = "field";
	
	public Encapsulation(){};

	public String getClassNamePattern() {
		return this.classNamePattern;
	};
	
	public void setClassNamePattern(String[] className) {
		this.classNamePattern = getNamePattern(CLASS, className);
	};
	
	public String getFieldNamePattern() {
		return this.fieldNamePattern;
	};
	
	public void setFieldNamePattern(String[] fieldName) {		
		this.fieldNamePattern = getNamePattern(FIELD, fieldName);
	};
	
	private String getNamePattern(String type, String[] name) {
		StringBuilder result = new StringBuilder();
		
		if(type.equals(CLASS)) {
			result.append(name[0].substring(0, 1).toUpperCase() + name[0].substring(1, name[0].length()).toLowerCase());
		}else if(type.equals(FIELD)) {
			result.append(name[0].toLowerCase());
		}
		
		if(name.length > 1) {
			for(int i = 1 ; i < name.length ; i++) {
				result.append(name[i].substring(0, 1).toUpperCase() + name[i].substring(1, name[i].length()).toLowerCase()); 
			}	
		}
		
		return result.toString();
	}
}

package patterns.builder.codingexercise;

import java.util.ArrayList;
import java.util.List;

public class CodeBuilder {

	public static final String PUBLIC = "public ";
	public static final String CLASS = "class ";
	public static final String BRACE_OPENING = "{";
	public static final String BRACE_CLOSING = "}";
	public static final String SEMICOLON = ";";
	public static final String SPACE = " ";
	public static final String NEWLINE = System.lineSeparator();

	List<String> fields;
	private final String className;

	public CodeBuilder(String className)
	{
		this.className = PUBLIC + CLASS + className;
		this.fields = new ArrayList<>();
	}

	public CodeBuilder addField(String name, String type)
	{
		String field = PUBLIC + type + SPACE + name + SEMICOLON;
		fields.add(field);

		return this;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(className).append(NEWLINE);
		sb.append(BRACE_OPENING).append(NEWLINE);

		for(String field : fields) {
			sb.append(String.format("  %s", field)).append(NEWLINE);
		}
		sb.append(BRACE_CLOSING).append(NEWLINE);

		return sb.toString();
	}

	public static void main(String[] args) {

		CodeBuilder cb = new CodeBuilder("Person")
				.addField("name", "String")
				.addField("age", "int");

		System.out.println(cb);

		// Expected output of above code is:
			/*
				public class Person
				{
				  public String name;
				  public int age;
				}
			 */
	}
}

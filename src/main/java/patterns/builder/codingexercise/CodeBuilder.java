package patterns.builder.codingexercise;

public class CodeBuilder {

	public CodeBuilder(String className)
	{
		// todo
	}

	public CodeBuilder addField(String name, String type)
	{
		// todo
	}

	@Override
	public String toString()
	{
		// todo
	}

	public static void main(String[] args) {

		// Sample fo the builder you are asked to create:
			/*
				CodeBuilder cb = new CodeBuilder("Person")
					.addField("name", "String")
					.addField("age", "int");
			 */

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

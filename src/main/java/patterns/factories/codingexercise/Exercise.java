package patterns.factories.codingexercise;

/**
 * Implement a non-static PersonFactory that hasa a createPerson() method
 * that takes a person's name and returns a new instance of Person.
 */
public class Exercise {
}

class Person {

	public int id;
	public String name;

	public Person(int id, String name) {

		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {

		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}

class PersonFactory {

	private static int personCount = 0;

	public Person createPerson(String name) {

		return new Person(personCount++, name);
	}
}

class Demo {

	public static void main(String[] args) {

		Person person1 = new PersonFactory().createPerson("Edward");
		System.out.println(person1);
		Person person2 = new PersonFactory().createPerson("Wyatt");
		System.out.println(person2);
	}
}

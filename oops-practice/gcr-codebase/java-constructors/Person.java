
public class Person {

	String name;
	String phoneNumber;
	String email;

	public Person(Person person) {
		this.name = person.name;
		this.email = person.email;
		this.phoneNumber = person.phoneNumber;
	}

}

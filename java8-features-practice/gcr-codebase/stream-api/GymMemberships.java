import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GymMember {
	private String name;
	private LocalDate expiryDate;

	GymMember(String name, LocalDate expiryDate) {
		this.name = name;
		this.expiryDate = expiryDate;
	}

	public String getName() {
		return name;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public String toString() {
		return name + " - " + expiryDate;
	}
}

public class GymMemberships {
	public static void main(String[] args) {

		List<GymMember> members = Arrays.asList(new GymMember("Rahul", LocalDate.now().plusDays(10)),
				new GymMember("Anita", LocalDate.now().plusDays(45)),
				new GymMember("Vikram", LocalDate.now().plusDays(25)),
				new GymMember("Pooja", LocalDate.now().plusDays(5)),
				new GymMember("Arjun", LocalDate.now().plusDays(60)));

		LocalDate today = LocalDate.now();
		LocalDate next30Days = today.plusDays(30);

		List<GymMember> expiringSoon = members.stream().filter(m -> !m.getExpiryDate().isBefore(today))
				.filter(m -> !m.getExpiryDate().isAfter(next30Days)).collect(Collectors.toList());

		expiringSoon.forEach(System.out::println);
	}
}

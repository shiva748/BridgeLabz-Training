import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class InsuranceClaim {
	private String claimType;
	private double amount;

	InsuranceClaim(String claimType, double amount) {
		this.claimType = claimType;
		this.amount = amount;
	}

	public String getClaimType() {
		return claimType;
	}

	public double getAmount() {
		return amount;
	}
}

public class AverageClaim {
	public static void main(String[] args) {

		List<InsuranceClaim> claims = Arrays.asList(new InsuranceClaim("Health", 5000),
				new InsuranceClaim("Vehicle", 12000), new InsuranceClaim("Health", 8000),
				new InsuranceClaim("Property", 20000), new InsuranceClaim("Vehicle", 15000),
				new InsuranceClaim("Health", 7000));

		Map<String, Double> averageClaimAmountByType = claims.stream().collect(Collectors
				.groupingBy(InsuranceClaim::getClaimType, Collectors.averagingDouble(InsuranceClaim::getAmount)));

		averageClaimAmountByType.forEach((type, avg) -> System.out.println(type + " -> " + avg));
	}
}

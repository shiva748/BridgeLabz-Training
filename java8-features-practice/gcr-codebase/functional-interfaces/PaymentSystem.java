public class PaymentSystem {

	public static void main(String[] args) {

		PaymentMethod upi = new UPI("GooglePay");
		PaymentMethod card = new CreditCard("HDFC Credit Card");
		PaymentMethod wallet = new Wallet("Paytm Wallet");

		upi.pay(500);
		card.pay(1200);
		wallet.pay(300);
		upi.pay(1500);
		card.pay(200);
	}

}

interface PaymentMethod {

	public void pay(double amount);
}

class UPI implements PaymentMethod {

	private String name;

	public UPI(String name) {
		this.name = name;
	}

	@Override
	public void pay(double amount) {
		System.out.println(name + " payment of " + amount + " amount successful.");
	}
}

class CreditCard implements PaymentMethod {

	private String name;

	public CreditCard(String name) {
		this.name = name;
	}

	@Override
	public void pay(double amount) {
		System.out.println(name + " payment of " + amount + " amount successful.");
	}
}

class Wallet implements PaymentMethod {

	private String name;

	public Wallet(String name) {
		this.name = name;
	}

	@Override
	public void pay(double amount) {
		System.out.println(name + " payment of " + amount + " amount successful.");
	}
}

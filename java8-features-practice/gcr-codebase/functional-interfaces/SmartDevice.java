public class SmartDevice {

	public static void main(String[] args) {
		RemoteDevice tv = new TV("Samsung");
		RemoteDevice light = new Light("Hall");
		RemoteDevice ac = new AC("Hitachi");
		tv.turnOn();
		tv.turnOn();
		ac.turnOff();
		light.turnOn();
		tv.turnOff();
		ac.turnOff();
	}

}

interface RemoteDevice {

	public void turnOn();

	public void turnOff();
}

class TV implements RemoteDevice {
	private boolean on;
	private String name;

	public TV(String name) {
		this.on = false;
		this.name = name;
	}

	@Override
	public void turnOn() {
		if (on) {
			System.out.println(name + " TV already on.");
			return;
		}
		System.out.println(name + " tv turned on.");
	}

	@Override
	public void turnOff() {
		if (!on) {
			System.out.println(name + " TV already off.");
			return;
		}
		System.out.println(name + " tv turned off.");
	}
}

class Light implements RemoteDevice {
	private boolean on;
	private String name;

	public Light(String name) {
		this.on = false;
		this.name = name;
	}

	@Override
	public void turnOn() {
		if (on) {
			System.out.println(name + " Light already on.");
			return;
		}
		System.out.println(name + " Light turned on.");
	}

	@Override
	public void turnOff() {
		if (!on) {
			System.out.println(name + " Light already off.");
			return;
		}
		System.out.println(name + " Light turned off.");
	}
}

class AC implements RemoteDevice {
	private boolean on;
	private String name;

	public AC(String name) {
		this.on = false;
		this.name = name;
	}

	@Override
	public void turnOn() {
		if (on) {
			System.out.println(name + " AC already on.");
			return;
		}
		System.out.println(name + " AC turned on.");
	}

	@Override
	public void turnOff() {
		if (!on) {
			System.out.println(name + " AC already off.");
			return;
		}
		System.out.println(name + " AC turned off.");
	}
}
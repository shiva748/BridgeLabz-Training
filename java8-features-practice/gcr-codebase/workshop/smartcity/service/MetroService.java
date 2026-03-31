package smartcity.service;

import static smartcity.utils.Utils.sc;

import java.util.List;
import java.util.stream.Collectors;

import smartcity.transport.Metro;
import smartcity.transport.TransportType;
import smartcity.transport.Vehicle;

public class MetroService implements TransportService {
	private List<Metro> metros;

	@Override
	public boolean addVehicle() {
		System.out.print("Please enter number of seat in metro: ");
		int seat = sc.nextInt();
		System.out.print("Please enter charge per km of metro: ");
		int charge = sc.nextInt();
		System.out.print(false);
		Metro metro = new Metro(TransportType.METRO, seat, charge);
		metros.add(metro);
		return true;
	}

	public MetroService() {
		this.metros = metros;
	}

	@Override
	public List<Vehicle> getAvilableVehicle() {
		return metros.stream().filter(Metro::isAvilable).collect(Collectors.toList());
	}

}

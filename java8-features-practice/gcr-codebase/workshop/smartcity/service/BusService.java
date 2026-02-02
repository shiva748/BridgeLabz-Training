package smartcity.service;

import static smartcity.utils.Utils.sc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import smartcity.transport.Bus;
import smartcity.transport.TransportType;
import smartcity.transport.Vehicle;

public class BusService implements TransportService {
	private List<Bus> buses;

	@Override
	public boolean addVehicle() {
		System.out.print("Please enter number of seat in bus: ");
		int seat = sc.nextInt();
		System.out.print("Please enter charge per km of bus: ");
		int charge = sc.nextInt();
		System.out.print(false);
		Bus bus = new Bus(TransportType.HMV, seat, charge);
		buses.add(bus);
		return true;
	}

	public BusService() {
		this.buses = new ArrayList();
	}

	@Override
	public List<Vehicle> getAvilableVehicle() {
		return buses.stream().filter(Bus::isAvilable).collect(Collectors.toList());
	}

}

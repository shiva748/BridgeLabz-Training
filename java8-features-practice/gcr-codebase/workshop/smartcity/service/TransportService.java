package smartcity.service;

import java.util.List;

import smartcity.transport.Vehicle;

public interface TransportService {

	public boolean addVehicle();

	public List<Vehicle> getAvilableVehicle();

}

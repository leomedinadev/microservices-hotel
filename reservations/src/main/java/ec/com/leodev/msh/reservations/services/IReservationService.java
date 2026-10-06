package ec.com.leodev.msh.reservations.services;

import java.util.List;

import ec.com.leodev.msh.reservations.model.Reservation;


public interface IReservationService {
	
	List<Reservation> search();

}

package ec.com.leodev.msh.reservations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.leodev.msh.reservations.dao.IReservationDao;
import ec.com.leodev.msh.reservations.model.Reservation;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDao reservationDao;
	
	@Override
	public List<Reservation> search() {
		return (List<Reservation>) reservationDao.findAll();
	}

}

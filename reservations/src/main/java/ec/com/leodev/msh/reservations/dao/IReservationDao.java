package ec.com.leodev.msh.reservations.dao;

import org.springframework.data.repository.CrudRepository;

import ec.com.leodev.msh.reservations.model.Reservation;

public interface IReservationDao extends CrudRepository<Reservation, Long>{

}

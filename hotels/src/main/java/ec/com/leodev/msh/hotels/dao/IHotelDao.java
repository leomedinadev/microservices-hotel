package ec.com.leodev.msh.hotels.dao;

import org.springframework.data.repository.CrudRepository;

import ec.com.leodev.msh.hotels.model.Hotel;

public interface IHotelDao extends CrudRepository<Hotel, Long> {

}

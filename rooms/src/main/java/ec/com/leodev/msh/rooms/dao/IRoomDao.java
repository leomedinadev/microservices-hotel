package ec.com.leodev.msh.rooms.dao;

import org.springframework.data.repository.CrudRepository;

import ec.com.leodev.msh.rooms.model.Room;

import java.util.List;

public interface IRoomDao extends CrudRepository<Room, Long>{

    List<Room> findByHotelId(long hotelId);
}

package ec.com.leodev.msh.rooms.services;

import java.util.List;

import ec.com.leodev.msh.rooms.model.Room;

public interface IRoomService {
	
	List<Room> search();

	List<Room> searchRoomByHotelId(long hotelId);

}

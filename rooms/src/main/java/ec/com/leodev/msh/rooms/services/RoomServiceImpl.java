package ec.com.leodev.msh.rooms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.leodev.msh.rooms.dao.IRoomDao;
import ec.com.leodev.msh.rooms.model.Room;

@Service
public class RoomServiceImpl implements IRoomService {
	
	@Autowired
	private IRoomDao roomDao;

	@Override
	public List<Room> search() {
		return (List<Room>) roomDao.findAll();
	}

	@Override
	public List<Room> searchRoomByHotelId(long hotelId) {
		return roomDao.findByHotelId(hotelId);
	}

}

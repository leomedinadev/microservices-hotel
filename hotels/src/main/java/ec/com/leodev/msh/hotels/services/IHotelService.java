package ec.com.leodev.msh.hotels.services;

import java.util.List;

import ec.com.leodev.msh.hotels.model.Hotel;
import ec.com.leodev.msh.hotels.model.HotelRooms;

public interface IHotelService {
	
	List<Hotel> search();

	HotelRooms searchHotelById(long hotelId);

	HotelRooms searchHotelByIdWithFeign(long hotelId);

	HotelRooms searchHotelByIdWithoutRooms(long id);
	

}

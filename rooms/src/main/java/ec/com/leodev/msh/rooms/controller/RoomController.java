package ec.com.leodev.msh.rooms.controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ec.com.leodev.msh.rooms.config.RoomsConfiguration;
import ec.com.leodev.msh.rooms.model.RoomsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ec.com.leodev.msh.rooms.model.Room;
import ec.com.leodev.msh.rooms.services.IRoomService;

@RestController
public class RoomController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomController.class);

	@Autowired
	private IRoomService service;

	@Autowired
	private RoomsConfiguration roomsConfiguration;
	
	@GetMapping("rooms")
	public List<Room> search(){
		LOGGER.info("inicio metodo search");
		return this.service.search();
	}

	@GetMapping("rooms/{hotelId}")
	public List<Room> searchByHotelId(@PathVariable long hotelId){
		LOGGER.info("inicio metodo searchByHotelId");
		return this.service.searchRoomByHotelId(hotelId);
	}

	@GetMapping("/rooms/read/properties")
	public String getProperties() throws JsonProcessingException {
		LOGGER.info("inicio metodo getProperties");
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		RoomsProperties roomsProperties = new RoomsProperties();
		roomsProperties.setMsg(roomsConfiguration.getMsg());
		roomsProperties.setBuildVersion(roomsConfiguration.getBuildVersion());
		roomsProperties.setMailDetails(roomsConfiguration.getMailDetails());
		return owj.writeValueAsString(roomsProperties);
	}
}

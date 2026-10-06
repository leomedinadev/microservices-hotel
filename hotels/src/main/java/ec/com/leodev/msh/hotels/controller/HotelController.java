package ec.com.leodev.msh.hotels.controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ec.com.leodev.msh.hotels.config.HotelsPropertiesConfiguration;
import ec.com.leodev.msh.hotels.model.HotelProperties;
import ec.com.leodev.msh.hotels.model.HotelRooms;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ec.com.leodev.msh.hotels.model.Hotel;
import ec.com.leodev.msh.hotels.services.IHotelService;

@RestController
public class HotelController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private IHotelService service;

	@Autowired
	private HotelsPropertiesConfiguration hotelsConfiguration;

	@GetMapping("hotels")
	public List<Hotel> search(){
		LOGGER.info("inicio metodo search");
		return this.service.search();
	}

	@GetMapping("hotels/{id}")
	public HotelRooms searchHotelById(@PathVariable long id){
		LOGGER.info("inicio metodo searchHotelById");
		return this.service.searchHotelById(id);
	}

	@GetMapping("v2/hotels/{id}")
	@CircuitBreaker(name = "searchHotelByIdWithFeignSupportCB", fallbackMethod = "searchHotelByIdWithOutRooms")
	//@Retry(name = "searchHotelByIdWithFeignSupportRetry", fallbackMethod = "searchHotelByIdWithOutRooms")
	public HotelRooms searchHotelByIdWithFeign(@PathVariable long id){
		LOGGER.info("inicio metodo searchHotelByIdWithFeign");
		return this.service.searchHotelByIdWithFeign(id);
	}

	public HotelRooms searchHotelByIdWithOutRooms(@PathVariable long id, Throwable thr){
		LOGGER.info("inicio metodo searchHotelByIdWithOutRooms");
		return this.service.searchHotelByIdWithoutRooms(id);
	}

	@GetMapping("/hotels/read/properties")
	public String getProperties() throws JsonProcessingException {
		LOGGER.info("inicio metodo getProperties");
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		HotelProperties hotelProperties = new HotelProperties();
		hotelProperties.setMsg(hotelsConfiguration.getMsg());
		hotelProperties.setBuildVersion(hotelsConfiguration.getBuildVersion());
		hotelProperties.setMailDetails(hotelsConfiguration.getMailDetails());
		return owj.writeValueAsString(hotelProperties);
	}

}

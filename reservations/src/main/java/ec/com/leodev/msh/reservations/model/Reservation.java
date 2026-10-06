package ec.com.leodev.msh.reservations.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="reservation_id")
	private long reservationId;
	
	@Column(name="room_id")
	private long roomId;
	
	@Column(name="start_dt")
	private Date startDt;
	
	@Column(name="finish_dt")
	private Date finishDt;

}

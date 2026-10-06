package ec.com.leodev.msh.hotels.model;

import lombok.Data;

@Data
public class Room {
    private long roomId;
    private long hotelId;
    private String roomName;
    private String roomAvailable;
}

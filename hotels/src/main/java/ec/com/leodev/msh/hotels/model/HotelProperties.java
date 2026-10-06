package ec.com.leodev.msh.hotels.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class HotelProperties {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
}

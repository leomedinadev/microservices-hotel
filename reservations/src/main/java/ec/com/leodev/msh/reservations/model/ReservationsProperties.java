package ec.com.leodev.msh.reservations.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ReservationsProperties {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
}

package ec.com.leodev.msh.rooms.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class RoomsProperties {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
}

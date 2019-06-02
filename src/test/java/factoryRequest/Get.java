package factoryRequest;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static helpers.MyValues.*;

public class Get implements IRequest {
    @Override
    public CustomReponse send(String path, String body) {
        WebTarget target = client.target(SERVER_MAIN_URL + path);
        Response response_actual = target.request(MediaType.APPLICATION_JSON_TYPE).header(Authentication, Authentication_value).header(ACCEPT,ACCEPT_JSON_TEXT_ALL).get();
        CustomReponse response = new CustomReponse(response_actual.readEntity(String.class).toString(),
                response_actual.getStatus(),
                response_actual.getStatusInfo().toString());
        response_actual.close();
        return response;
    }
}

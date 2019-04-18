package soap;


import org.springframework.stereotype.Service;

import javax.websocket.server.PathParam;
import javax.xml.ws.WebServiceClient;

@WebServiceClient
public class BanqueService {

    public double conversion(@PathParam(value="montant") double mt) {
        return mt * 3.5;
    }

}

package gallery.soap.consuming.client;

import gallery.soap.consuming.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class WorkClient extends WebServiceGatewaySupport {

    public GetWorkResponse getWork(String title) {
        GetWorkRequest request = new ObjectFactory().createGetWorkRequest();

        request.setTitle(title);

        GetWorkResponse response = (GetWorkResponse) getWebServiceTemplate()
                                                 .marshalSendAndReceive("http://localhost:9090/ws/", request);
        return response;
    }

    public AddWorkResponse addWork(Work work) {
        AddWorkRequest request = new ObjectFactory().createAddWorkRequest();

        request.setWork(work);

        AddWorkResponse response = (AddWorkResponse) getWebServiceTemplate()
                                                 .marshalSendAndReceive("http://localhost:9090/ws/", request);
        return response;
    }
}

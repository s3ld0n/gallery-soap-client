package gallery.soap.consuming.client;

import gallery.soap.consuming.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class WorkClient extends WebServiceGatewaySupport {

    @Autowired
    private ObjectFactory objectFactory;

    public GetWorkResponse getWork(String title) {
        GetWorkRequest request = objectFactory.createGetWorkRequest();

        request.setTitle(title);

        GetWorkResponse response = (GetWorkResponse) getWebServiceTemplate()
                                                 .marshalSendAndReceive("http://localhost:9090/ws/", request);
        return response;
    }

    public AddWorkResponse addWork(Work work) {
        AddWorkRequest request = objectFactory.createAddWorkRequest();

        request.setWork(work);

        AddWorkResponse response = (AddWorkResponse) getWebServiceTemplate()
                                                 .marshalSendAndReceive("http://localhost:9090/ws/", request);
        return response;
    }

    public UpdateWorkResponse updateWork(Work work) {
        UpdateWorkRequest request = objectFactory.createUpdateWorkRequest();

        request.setWork(work);

        UpdateWorkResponse response = (UpdateWorkResponse) getWebServiceTemplate()
                                                 .marshalSendAndReceive("http://localhost:9090/ws/", request);
        return response;
    }
}

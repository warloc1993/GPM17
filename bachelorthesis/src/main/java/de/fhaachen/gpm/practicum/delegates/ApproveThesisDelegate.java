package de.fhaachen.gpm.practicum.delegates;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import de.fhaachen.gpm.practicum.dto.appThesisDTO;
import de.fhaachen.gpm.practicum.dto.returnDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.core.MediaType;


public class ApproveThesisDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int thesisId = (Integer) delegateExecution.getVariable("thesisId");
        boolean thesisapp = (Boolean) delegateExecution.getVariable("accept");
        int approve = 0;

        if (thesisapp =true){
            approve =1;
        }
        String DBurl = "http://localhost:8081/REST/thesisApprove/appThesis";

        appThesisDTO thesis = new appThesisDTO();
        thesis.setId(thesisId);
        thesis.setApproved(approve);


        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);

        Client client = Client.create(cc);

        WebResource webResource= client.resource(DBurl);
        ClientResponse response=webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, thesis);

        if(response.getStatus() != 200) {
            throw new Exception("Der Server meldet Fehlercode: " + response.getStatus());
        }
        else {
            returnDTO ret = response.getEntity(returnDTO.class);

            if(!ret.isSuccess()) {
                throw new Exception("Fehler! Einfügen der Daten in die Datenbank war nicht erfolgreich!");
            }
            else {
                delegateExecution.setVariable("studentId", ret.getStudent_id());
                delegateExecution.setVariable("thesisId", ret.getThesis_id());
                delegateExecution.setVariable("success", ret.isSuccess());
            }
        }

    }
}

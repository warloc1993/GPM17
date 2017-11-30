package de.fhaachen.gpm.practicum.delegates;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import de.fhaachen.gpm.practicum.dto.addThesisDTO;
import de.fhaachen.gpm.practicum.dto.returnDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.core.MediaType;


public class addThesisDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String name = (String) delegateExecution.getVariable("name");
        String prename = (String) delegateExecution.getVariable("prename");
        String title = (String) delegateExecution.getVariable("title");
        String supervisor = (String) delegateExecution.getVariable("supervisor");

        String DBurl = "http://localhost:8081/REST/thesis/addThesis";

        addThesisDTO thesis = new addThesisDTO();
        thesis.setName(name);
        thesis.setPrename(prename);
        thesis.setThesis_title(title);
        thesis.setSupervisor(supervisor);

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

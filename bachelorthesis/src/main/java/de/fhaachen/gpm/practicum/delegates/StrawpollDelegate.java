package de.fhaachen.gpm.practicum.delegates;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import de.fhaachen.gpm.practicum.dto.ReturnStrawpollDTO;
import de.fhaachen.gpm.practicum.dto.StrawpollDTO;

import de.fhaachen.gpm.practicum.dto.returnDTO;
import jdk.nashorn.internal.ir.ReturnNode;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.core.MediaType;
import java.util.Date;


public class StrawpollDelegate implements JavaDelegate {
    private int pollId;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Date termin = (Date) delegateExecution.getVariable("termin");
        String[] options = new String[2];
        options[1] = "Akzeptieren";
        options[0] = "Ablehnen";
        String DBurl = "http://localhost:4500/api/v2/polls";

        StrawpollDTO thesis = new StrawpollDTO();
        thesis.setTitle("Termin des Kolloquiums: " + termin);
        thesis.setOptions(options);

        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);

        Client client = Client.create(cc);

        WebResource webResource= client.resource(DBurl);
        ClientResponse response=webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, thesis);

        if(response.getStatus() != 201) {
            throw new Exception("Der Server meldet Fehlercode: " + response.getStatus());
        }
        else {
            ReturnStrawpollDTO ret = response.getEntity(ReturnStrawpollDTO.class);


            delegateExecution.setVariable("pollid", ret.getId());


        }

    }

}

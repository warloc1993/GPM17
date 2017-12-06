package de.fhaachen.gpm.practicum.delegates;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import de.fhaachen.gpm.practicum.dto.ReturnStrawpollDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.core.MediaType;

public class PollAnswerDelegate implements JavaDelegate{

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Integer pollId = (Integer) delegateExecution.getVariable("pollid");
        String DBurl = "http://localhost:4500/api/v2/polls/" + pollId;



        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);

        Client client = Client.create(cc);

        WebResource webResource= client.resource(DBurl);
        ClientResponse response=webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if(response.getStatus() != 201) {
            throw new Exception("Der Server meldet Fehlercode: " + response.getStatus());
        }
        else {
            ReturnStrawpollDTO ret = response.getEntity(ReturnStrawpollDTO.class);
            Integer[] votes = new Integer[2];
            votes = ret.getVotes();
            //loop success
            if (votes[0] > 0 || votes[1] > 0) {
                if(votes[0]>0) {
                    delegateExecution.setVariable("answer", true);
                    delegateExecution.setVariable("acceptdate", false);

                }
                else {
                    delegateExecution.setVariable("answer", true);
                    delegateExecution.setVariable("acceptdate", true);
                }

            }else
            {
                delegateExecution.setVariable("answer", false);

            }
        }
    }
}

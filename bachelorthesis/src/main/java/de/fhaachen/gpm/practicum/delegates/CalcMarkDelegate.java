package de.fhaachen.gpm.practicum.delegates;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import de.fhaachen.gpm.practicum.dto.CalculateTotalGradeReturnDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.core.MediaType;

public class CalcMarkDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("methode aufgerufen");
        float bachnote = Float.parseFloat((String) delegateExecution.getVariable("bachnote"));
        float collnote = Float.parseFloat((String) delegateExecution.getVariable("collnote"));
        Integer studentId = (Integer) delegateExecution.getVariable("studentId");
        String DBurl = "http://localhost:8081/REST/calc/getExams/" + studentId;


        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);

        Client client = Client.create(cc);

        WebResource webResource= client.resource(DBurl);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        System.out.println("get aufgerufen");
        if(response.getStatus() != 200) {
            throw new Exception("Der Server meldet Fehlercode: " + response.getStatus());
        }
        else {
            CalculateTotalGradeReturnDTO ret = response.getEntity(CalculateTotalGradeReturnDTO.class);

            if(!ret.isSuccess()) {
                throw new Exception("Fehler! Einfügen der Daten in die Datenbank war nicht erfolgreich!");
            }
            else {
                //calc gesnote
                System.out.println("rechnen");
                double totalAverage = ret.getAverage() * 0.7 + bachnote * 0.25 + collnote * 0.05;
                String gesnote;
                gesnote=String.valueOf(totalAverage);
                delegateExecution.setVariable("totalaverage", gesnote);
                System.out.println("fertig");
                if(totalAverage<=1.3)
                {
                    delegateExecution.setVariable("urkunde", true);
                }else
                {
                    delegateExecution.setVariable("urkunde", false);
                }
            }
        }


}
}

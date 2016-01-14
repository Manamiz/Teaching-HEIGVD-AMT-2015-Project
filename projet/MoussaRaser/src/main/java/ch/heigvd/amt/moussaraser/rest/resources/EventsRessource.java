package ch.heigvd.amt.moussaraser.rest.resources;

import ch.heigvd.amt.moussaraser.model.entities.ApiKey;
import ch.heigvd.amt.moussaraser.rest.config.EventsEnumeration;
import ch.heigvd.amt.moussaraser.rest.config.response.SendEvent;
import ch.heigvd.amt.moussaraser.rest.config.response.SendUser;
import ch.heigvd.amt.moussaraser.rest.dto.EventDTO;
import ch.heigvd.amt.moussaraser.services.dao.ApiKeyDAOLocal;
import ch.heigvd.amt.moussaraser.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.moussaraser.services.dao.EndUserDAOLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/events")
public class EventsRessource {
   
   @EJB
   EndUserDAOLocal endUsersDAO;

   @EJB
   ApplicationDAOLocal applicationDAO;

   @EJB
   ApiKeyDAOLocal apiKeyDAO;
   
   /*@GET
   public Response getAllEvents() {
      
   }*/
   
   /*@POST
   @Produces(MediaType.APPLICATION_JSON)
   public Response notifyEvent(@QueryParam("apiKey") String apiKey, EventDTO eventDTO) {
      ApiKey key = apiKeyDAO.findByApiKeyString(apiKey);

      if (eventDTO == null || eventDTO.getUserId() == null || eventDTO.getType() == null) {
         return SendEvent.errorEventInvalid();
      }
      
      if(!EventsEnumeration.contains(eventDTO.getType())) {
         return SendEvent.errorEventTypeInvalid();
      }
      
      
      
   }*/
   
}
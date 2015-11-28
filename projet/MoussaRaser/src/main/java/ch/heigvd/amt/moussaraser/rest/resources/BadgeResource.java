package ch.heigvd.amt.moussaraser.rest.resources;

import ch.heigvd.amt.moussaraser.model.entities.ApiKey;
import ch.heigvd.amt.moussaraser.model.entities.Badge;
import ch.heigvd.amt.moussaraser.rest.config.response.SendApiKey;
import ch.heigvd.amt.moussaraser.rest.config.response.SendBadge;
import ch.heigvd.amt.moussaraser.rest.dto.BadgeDTO;
import ch.heigvd.amt.moussaraser.services.dao.ApiKeyDAOLocal;
import ch.heigvd.amt.moussaraser.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.moussaraser.services.dao.BadgeDAOLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import ch.heigvd.amt.moussaraser.web.utils.EncryptionManager;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/badges")
public class BadgeResource {

   @EJB
   BadgeDAOLocal badgeDAO;
   
   @EJB
   ApplicationDAOLocal applicationDAO;
   
   @EJB
   ApiKeyDAOLocal apiKeyDAO;

   @GET
   @Produces("application/json")
   public Response getBadges(@QueryParam("apiKey") String apiKey) {
      
      if(apiKey == null || apiKey.length() != EncryptionManager.getAPIKey().length()) {
         return SendApiKey.errorApiKeyNotProvided();
      }
      
      ApiKey key = apiKeyDAO.findByApiKeyString(apiKey);
      
      if(key == null) {
         return SendApiKey.errorApiKeyInvalid();
      }
      
      List<Badge> badges = badgeDAO.getBadgesByApiKey(key);
      List<BadgeDTO> badgesDTO = new ArrayList<>();
      
      for(Badge badge : badges) {
         badgesDTO.add(new BadgeDTO(badge.getId(), badge.getName(), badge.getCategory(), badge.getDescription(), badge.getImage()));
      }
      
      return SendBadge.send200OK(badgesDTO);
   }
   
   @POST
   @Consumes("application/json")
   @Produces("application/json")
   public Response createBadge(Badge b, @QueryParam("apiKey") String apiKey) {
      
      if(apiKey == null || apiKey.length() != EncryptionManager.getAPIKey().length()) {
         return SendApiKey.errorApiKeyNotProvided();
      }
      
      ApiKey key = apiKeyDAO.findByApiKeyString(apiKey);
      
      if(key == null) {
         return SendApiKey.errorApiKeyInvalid();
      }
      
      b.setApplication(applicationDAO.getApplicationByApiKey(key));
      
      badgeDAO.create(b);
      
      return SendBadge.send200OK(new BadgeDTO(b.getId(), b.getName(), b.getCategory(), b.getDescription(), b.getImage()));
   }
   
   @GET
   @Path("/{id}")
   @Produces("application/json")
   public Response getBadge(@PathParam("id") long id, @QueryParam("apiKey") String apiKey) {
      
      if(apiKey == null || apiKey.length() != EncryptionManager.getAPIKey().length()) {
         return SendApiKey.errorApiKeyNotProvided();
      }
      
      ApiKey key = apiKeyDAO.findByApiKeyString(apiKey);
      
      if(key == null) {
         return SendApiKey.errorApiKeyInvalid();
      }
      
      Badge b = badgeDAO.getBadgeByIdAndByApiKey(id, key);
      
      if(b == null) {
         return SendBadge.errorUserInvalid();
      }
      
      return SendBadge.send200OK(new BadgeDTO(b.getId(), b.getName(), b.getCategory(), b.getDescription(), b.getImage()));
   }
}

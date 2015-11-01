/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.moussaraser.services.dao;

import ch.heigvd.amt.moussaraser.model.entities.Application;
import ch.heigvd.amt.moussaraser.model.entities.User;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author jermoret
 */
@Stateless
public class ApplicationDAO extends GenericDAO<Application, Long> implements ApplicationDAOLocal {

   @Override
   public List<Application> getAllAplicationsForUser(User u) {
      return em.createNamedQuery("Application.findAllByUser").setParameter("user", u).getResultList();
   }

   @Override
   public Application getManagedApplicationByApiKey(String apiKey) {
      return createAndReturnManagedEntity((Application)em.createNamedQuery("Application.findByApiKey").setParameter("apiKey", apiKey).getSingleResult());
   }
}

/**
 * Auteurs : Jérôme Moret & Mathias Dolt & Thibaud Duchoud & Mario Ferreira
 * Date    : 09.10.2015
 * Fichier : EndUser.java
 */

package ch.heigvd.amt.moussaraser.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({ //@NamedQuery(name = "User.findByNameAndPassword", query = "SELECT u FROM User u WHERE u.firstName = :fname AND u.password = :pass"),
})

/**
 * Cette classe est un JPA, elle représente l'entité (table) EndUser.
 */
public class EndUser extends AbstractDomainModelEntity<Long> {

   @ManyToOne
   private Application application;
   private String firstName;
   private String lastName;

   public EndUser() {
   }

   /**
    * @return the firstName
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    * @param firstName the firstName to set
    */
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    * @return the lastName
    */
   public String getLastName() {
      return lastName;
   }

   /**
    * @param lastName the lastName to set
    */
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   /**
    * @return the application
    */
   public Application getApplication() {
      return application;
   }

   /**
    * @param application the application to set
    */
   public void setApplication(Application application) {
      this.application = application;
   }

}

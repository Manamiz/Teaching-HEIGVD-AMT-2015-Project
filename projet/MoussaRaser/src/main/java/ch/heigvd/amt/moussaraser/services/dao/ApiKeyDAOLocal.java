/**
 * Auteurs : Jérôme Moret & Mathias Dolt & Thibaud Duchoud & Mario Ferreira
 * Date : 16.10.2015
 * Fichier : ApplicationDAOLocal.java
 */
package ch.heigvd.amt.moussaraser.services.dao;

import ch.heigvd.amt.moussaraser.model.entities.ApiKey;
import javax.ejb.Local;

/**
 * Interface pour le DAO ApplicationDAO
 */
@Local
public interface ApiKeyDAOLocal extends IGenericDAO<ApiKey, Long> {

    ApiKey findByApiKeyString(String apiKeyStr);
}

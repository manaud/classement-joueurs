package fr.mable.classement.joueurs.services.WS;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe mère pour réponse au rest service
 *
 * @author mable
 */
@XmlRootElement
public class WSResponse implements Serializable {

    private boolean success;

    /**
     * Default constructor
     */
    public WSResponse() {
    }

    /**
     * Constructor
     *
     * @param success
     */
    public WSResponse(boolean success) {
        this.success = success;
    }

    /**
     * Getter
     *
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter
     *
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

}

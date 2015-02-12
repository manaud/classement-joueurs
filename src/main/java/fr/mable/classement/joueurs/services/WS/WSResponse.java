package fr.mable.classement.joueurs.services.WS;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mable
 */
@XmlRootElement
public class WSResponse implements Serializable{
    private boolean success;
    
    /**
     *
     */
    public WSResponse() {
    }

    /**
     *
     * @param success
     */
    public WSResponse(boolean success) {
        this.success = success;
    }

    /**
     *
     * @return
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     *
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }
   
    
}

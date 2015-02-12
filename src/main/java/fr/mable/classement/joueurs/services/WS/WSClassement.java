package fr.mable.classement.joueurs.services.WS;

//import fr.mable.classement.joueurs.services.impl.Player;
import fr.mable.classement.joueurs.data.entities.Player;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mable
 */
@XmlRootElement
public class WSClassement implements Serializable {

    private List<Player> players;
    private int total;

    /**
     *
     */
    public WSClassement() {
    }

    /**
     *
     * @param players
     */
    public WSClassement(List<Player> players) {
        this.players = players;
    }

    /**
     *
     * @return
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     *
     * @param players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     *
     * @return
     */
    public int getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
    }
    
    

}

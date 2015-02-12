package fr.mable.classement.joueurs.services.WS;

import fr.mable.classement.joueurs.data.entities.Player;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mable
 */
@XmlRootElement
public class WSClassementResponse extends WSResponse {

    /**
     * Liste de joueurs triés par points, potentiellement incomplète
     */
    private List<Player> players;

    /**
     * Nombre total de joueurs
     */
    private int total;

    /**
     * Default constructor
     */
    public WSClassementResponse() {
    }

    /**
     * Constructor
     *
     * @param players
     */
    public WSClassementResponse(List<Player> players) {
        super(true);
        this.players = players;
    }

    /**
     * Getter
     *
     * @return players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Setter
     *
     * @param players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * Getter
     *
     * @return total
     */
    public int getTotal() {
        return total;
    }

    /**
     * Setter
     *
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
    }

}

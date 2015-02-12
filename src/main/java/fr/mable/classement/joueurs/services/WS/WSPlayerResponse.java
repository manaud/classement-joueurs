package fr.mable.classement.joueurs.services.WS;

import fr.mable.classement.joueurs.services.impl.PlayerComposite;

/**
 *
 * @author mable
 */
public class WSPlayerResponse extends WSResponse {

    private PlayerComposite player;

    /**
     * Default constructor
     */
    public WSPlayerResponse() {
    }

    /**
     * Constructor
     *
     * @param player
     */
    public WSPlayerResponse(PlayerComposite player) {
        super(player != null);
        this.player = player;
    }

    /**
     * Setter
     *
     * @param player
     */
    public void setPlayer(PlayerComposite player) {
        this.player = player;
    }

    /**
     * Getter
     *
     * @return player
     */
    public PlayerComposite getPlayer() {
        return player;
    }

}

package fr.mable.classement.joueurs.data.factories;

import fr.mable.classement.joueurs.data.entities.Player;
import fr.mable.classement.joueurs.services.impl.PlayerComposite;

/**
 *
 * @author mable
 */
public class PlayerFactory {
    
    private static final PlayerFactory instance = new PlayerFactory();
    
    private PlayerFactory(){
        // Singleton
    }
    
    /**
     *
     * @return
     */
    public static PlayerFactory getInstance(){
        return instance;
    }
    
    /**
     *
     * @param player
     * @return
     */
    public PlayerComposite toPlayerComposite(Player player){
        PlayerComposite pc = null;
        if(player != null){
            pc = new PlayerComposite();
            pc.setPseudo(player.getPseudo());
            pc.setScore(player.getScore());
        }
        
        return pc;
    }
}

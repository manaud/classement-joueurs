package fr.mable.classement.joueurs.data.dao;

import fr.mable.classement.joueurs.data.entities.Player;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mable
 */
@Local
public interface IPlayerDao extends IDao<Player> {

    /**
     *
     * @param pseudo
     * @return
     */
    public Player getPlayerByPseudo(String pseudo);

    /**
     *
     * @param pseudo
     * @param score
     */
    public void updatePlayerByPseudo(String pseudo, int score);

    /**
     *
     * @param pseudo
     * @return
     */
    public boolean playerExiste(String pseudo);

    /**
     *
     * @return
     */
    public List<Player> findAllOrdered();

    /**
     *
     * @param score
     * @return
     */
    public Long getClassement(int score);

    /**
     *
     * @param pseudo
     * @return
     */
    public Long getClassement(String pseudo);
    
    /**
     *
     * @param start
     * @param end
     * @return
     */
    public List<Player> findRangeOrdered(int start, int end);
}

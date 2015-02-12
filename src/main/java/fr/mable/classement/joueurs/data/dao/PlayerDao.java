package fr.mable.classement.joueurs.data.dao;

import fr.mable.classement.joueurs.data.entities.Player;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author mable
 */
@Stateless
public class PlayerDao extends AbstractDao<Player> implements IPlayerDao {

    @PersistenceContext(unitName = "classementPU")
    private EntityManager em;

    /**
     *
     */
    public PlayerDao() {
        super(Player.class);
    }

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     * @param pseudo
     * @return
     */
    @Override
    public Player getPlayerByPseudo(String pseudo) {
        List<Player> liste = getEntityManager().createQuery(
                "SELECT p FROM Player p WHERE p.pseudo = :pseudo")
                .setParameter("pseudo", pseudo)
                .getResultList();

        if (liste.isEmpty()) {
            return null;
        }

        return liste.get(0);

    }

    /**
     *
     */
    @Override
    public void removeAll() {
        getEntityManager().createQuery("Delete from Player").executeUpdate();
    }

    /**
     *
     * @param pseudo
     * @return
     */
    @Override
    public boolean playerExiste(String pseudo) {
        return 0 < (Long) getEntityManager().createQuery("SELECT count(p) FROM Player p WHERE p.pseudo = :pseudo")
                .setParameter("pseudo", pseudo).getSingleResult();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Player> findAllOrdered() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Player> c = cq.from(Player.class);
        cq.select(c);
        cq.orderBy(cb.asc(c.get("score")));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    @Override
    public List<Player> findRangeOrdered(int start, int end) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Player> c = cq.from(Player.class);
        cq.select(c);
        cq.orderBy(cb.asc(c.get("score")));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(end - start);
        q.setFirstResult(start);
        return q.getResultList();
    }

    /**
     *
     * @param pseudo
     * @param score
     */
    @Override
    public void updatePlayerByPseudo(String pseudo, int score) {
        getEntityManager().createQuery(
                "Update Player set score = :score  WHERE pseudo = :pseudo")
                .setParameter("pseudo", pseudo).
                setParameter("score", score).executeUpdate();
    }

    /**
     *
     * @param score
     * @return
     */
    @Override
    public Long getClassement(int score) {
        return 1 + (Long) getEntityManager().createQuery("SELECT count(p) FROM Player p WHERE p.score < :score")
                .setParameter("score", score).getSingleResult();

    }

    /**
     *
     * @param pseudo
     * @return
     */
    @Override
    public Long getClassement(String pseudo) {
        Player player = getPlayerByPseudo(pseudo);
        if (player == null) {
            return 0L;
        } else {
            return 1 + (Long) getEntityManager().createQuery("SELECT count(p) FROM Player p WHERE p.score < :score")
                    .setParameter("score", player.getScore()).getSingleResult();
        }
    }

}

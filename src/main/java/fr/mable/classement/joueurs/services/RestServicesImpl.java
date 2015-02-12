package fr.mable.classement.joueurs.services;

import fr.mable.classement.joueurs.services.impl.PlayerComposite;
import fr.mable.classement.joueurs.data.dao.IPlayerDao;
import fr.mable.classement.joueurs.data.entities.Player;
import fr.mable.classement.joueurs.data.factories.PlayerFactory;
import fr.mable.classement.joueurs.services.WS.WSClassement;
import fr.mable.classement.joueurs.services.WS.WSResponse;
import java.util.logging.Logger;

import java.util.logging.Level;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author mable
 */
@Path("/")
@Stateless
public class RestServicesImpl {

    /**
     * Nombre de joueurs maximum à charger en mémoire. Devrait être
     * paramétrable.
     */
    public final static int MAX_PLAYER = 1000;

    @EJB
    IPlayerDao playerDao;

    private static final Logger LOGGER = Logger
            .getLogger(RestServicesImpl.class.getName());

    /**
     * Creer un joueur avec le pseudo et le score passés en paramètre.
     *
     * @param pseudo
     * @return WSResponse indiquant la reussite ou non
     */
    @POST
    @Path("/createPlayer/{pseudo}")
    public WSResponse createPlayer(@PathParam("pseudo") String pseudo) {
        if (!playerDao.playerExiste(pseudo)) {
            playerDao.create(new Player(pseudo, 0));
            LOGGER.log(Level.INFO, "Player {0} created with score 0", pseudo);
            return new WSResponse(true);
        } else {
            LOGGER.log(Level.INFO, "Player {0} already created", pseudo);
            return new WSResponse(false);
        }

    }

    /**
     * Creer un joueur avec le pseudo passé en paramètre. Score initialisé à 0.
     *
     * @param pseudo
     * @param score
     * @return WSResponse indiquant la reussite ou non
     */
    @POST
    @Path("/createPlayer/{pseudo}/{score:[0-9]+}")
    public WSResponse createPlayer(@PathParam("pseudo") String pseudo, @PathParam("score") int score) {
        if (!playerDao.playerExiste(pseudo)) {
            playerDao.create(new Player(pseudo, score));
            LOGGER.log(Level.INFO, "Player {0} created with score {1}", new Object[]{pseudo, score});
            return new WSResponse(true);
        } else {
            LOGGER.log(Level.INFO, "Player {0} already created", pseudo);
            return new WSResponse(false);
        }
    }

    /**
     * Modifie le score un joueur dont le pseudo est passé en paramètre.
     *
     * @param pseudo
     * @param score
     * @return WSResponse indiquant la reussite ou non
     */
    @POST
    @Path("/updatePlayer/{pseudo}/{score}")
    public WSResponse updatePlayer(@PathParam("pseudo") String pseudo, @PathParam("score") int score) {

        if (playerDao.playerExiste(pseudo)) {
            playerDao.updatePlayerByPseudo(pseudo, score);
            return new WSResponse(true);
        } else {
            return new WSResponse(false);
        }

    }

    /**
     * Récupère les données d'un joueur (pseudo, nombre de points et classement
     * dans le tournoi)
     *
     * @param pseudo
     * @return le joueursi celui-ci existe, null sinon
     */
    @GET
    @Path("/getPlayer/{pseudo}")
    public PlayerComposite getPlayer(@PathParam("pseudo") String pseudo) {
        PlayerComposite pc = PlayerFactory.getInstance().toPlayerComposite(playerDao.getPlayerByPseudo(pseudo));
        pc.setClassement(playerDao.getClassement(pc.getScore()));

        return pc;
    }

    /**
     * Récupère la liste de tous les joueurs classés par score
     *
     * @param start
     * @param end
     * @return le joueursi celui-ci existe, null sinon
     */
    @GET
    @Path("/getClassement/{start}/{end}")
    @Produces({"application/json"})
    public WSClassement getClassement(int start, int end) {
        LOGGER.log(Level.INFO, "Return classement");
        WSClassement result = new WSClassement(playerDao.findRangeOrdered(start, end));
        result.setTotal(playerDao.count());
        return result;

    }

    /**
     * Récupère la liste de tous les joueurs classés par score
     *
     * @return le classement total
     */
    @GET
    @Path("/getClassement/")
    @Produces({"application/json"})
    public WSClassement getClassement() {
        WSClassement result = new WSClassement(playerDao.findRangeOrdered(0, MAX_PLAYER));
        result.setTotal(playerDao.count());
        return result;
    }

    /**
     * Supprime tous les joueurs en fin de tournoi
     *
     * @return le classement total
     */
    @POST
    @Path("/deleteAll/")
    @Produces({"application/json"})
    public WSResponse deleteAll() {
        playerDao.removeAll();
        return new WSResponse(true);
    }
}

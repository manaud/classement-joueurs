package fr.mable.classement.joueurs.services.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mable
 */
@XmlRootElement
public class PlayerComposite implements Serializable {

    private String pseudo;

    private int score;

    private Long classement;

    /**
     *
     * @return
     */
    public Long getClassement() {
        return classement;
    }

    /**
     *
     * @param classement
     */
    public void setClassement(Long classement) {
        this.classement = classement;
    }

    /**
     *
     * @return
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     *
     * @param pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     *
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     */
    public PlayerComposite() {
    }

}

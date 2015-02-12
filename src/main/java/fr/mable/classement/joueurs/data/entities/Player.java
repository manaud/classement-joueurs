package fr.mable.classement.joueurs.data.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mable
 */
@Entity
@Table(name = "player")
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "play_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "play_pseudo",unique=true, nullable=false) 
    private String pseudo;

    @Column(name = "play_score")
    private int score;

    /**
     *
     */
    public Player() {
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @param pseudo
     * @param score
     */
    public Player(String pseudo, int score) {

        this.pseudo = pseudo;
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.mable.classement.joueurs.data.entities.PLayer[ id=" + id + " ]";
    }

}

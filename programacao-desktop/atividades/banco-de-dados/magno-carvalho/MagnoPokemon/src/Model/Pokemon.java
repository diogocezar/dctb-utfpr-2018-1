/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MAGNO
 */
@Entity
@Table(name = "pokemon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pokemon.findAll", query = "SELECT p FROM Pokemon p")
    , @NamedQuery(name = "Pokemon.findById", query = "SELECT p FROM Pokemon p WHERE p.id = :id")
    , @NamedQuery(name = "Pokemon.findByName", query = "SELECT p FROM Pokemon p WHERE p.name = :name")
    , @NamedQuery(name = "Pokemon.findByLevel", query = "SELECT p FROM Pokemon p WHERE p.level = :level")
    , @NamedQuery(name = "Pokemon.findByHp", query = "SELECT p FROM Pokemon p WHERE p.hp = :hp")
    , @NamedQuery(name = "Pokemon.findByAgility", query = "SELECT p FROM Pokemon p WHERE p.agility = :agility")
    , @NamedQuery(name = "Pokemon.findByAttack", query = "SELECT p FROM Pokemon p WHERE p.attack = :attack")
    , @NamedQuery(name = "Pokemon.findByDefese", query = "SELECT p FROM Pokemon p WHERE p.defese = :defese")
    , @NamedQuery(name = "Pokemon.findBySpecialAttack", query = "SELECT p FROM Pokemon p WHERE p.specialAttack = :specialAttack")
    , @NamedQuery(name = "Pokemon.findBySpecialDefense", query = "SELECT p FROM Pokemon p WHERE p.specialDefense = :specialDefense")
    , @NamedQuery(name = "Pokemon.findBySeason", query = "SELECT p FROM Pokemon p WHERE p.season = :season")})
public class Pokemon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "level")
    private int level;
    @Basic(optional = false)
    @Column(name = "hp")
    private int hp;
    @Basic(optional = false)
    @Column(name = "agility")
    private int agility;
    @Basic(optional = false)
    @Column(name = "attack")
    private int attack;
    @Basic(optional = false)
    @Column(name = "defese")
    private int defese;
    @Basic(optional = false)
    @Column(name = "specialAttack")
    private int specialAttack;
    @Basic(optional = false)
    @Column(name = "specialDefense")
    private int specialDefense;
    @Basic(optional = false)
    @Column(name = "season")
    private int season;

    public Pokemon() {
    }

    public Pokemon(Integer id) {
        this.id = id;
    }

    public Pokemon(Integer id, String name, int level, int hp, int agility, int attack, int defese, int specialAttack, int specialDefense, int season) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.agility = agility;
        this.attack = attack;
        this.defese = defese;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.season = season;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefese() {
        return defese;
    }

    public void setDefese(int defese) {
        this.defese = defese;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
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
        if (!(object instanceof Pokemon)) {
            return false;
        }
        Pokemon other = (Pokemon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Pokemon[ id=" + id + " ]";
    }
    
}

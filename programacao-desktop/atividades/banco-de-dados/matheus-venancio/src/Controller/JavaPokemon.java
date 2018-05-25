/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "java_pokemon", catalog = "atividade_06", schema = "")
@NamedQueries({
    @NamedQuery(name = "JavaPokemon.findAll", query = "SELECT j FROM JavaPokemon j")
    , @NamedQuery(name = "JavaPokemon.findByLevel", query = "SELECT j FROM JavaPokemon j WHERE j.level = :level")
    , @NamedQuery(name = "JavaPokemon.findByName", query = "SELECT j FROM JavaPokemon j WHERE j.name = :name")
    , @NamedQuery(name = "JavaPokemon.findByHp", query = "SELECT j FROM JavaPokemon j WHERE j.hp = :hp")
    , @NamedQuery(name = "JavaPokemon.findByAgility", query = "SELECT j FROM JavaPokemon j WHERE j.agility = :agility")
    , @NamedQuery(name = "JavaPokemon.findByAttack", query = "SELECT j FROM JavaPokemon j WHERE j.attack = :attack")
    , @NamedQuery(name = "JavaPokemon.findByDefense", query = "SELECT j FROM JavaPokemon j WHERE j.defense = :defense")
    , @NamedQuery(name = "JavaPokemon.findBySpecialAttack", query = "SELECT j FROM JavaPokemon j WHERE j.specialAttack = :specialAttack")
    , @NamedQuery(name = "JavaPokemon.findBySpecialDefense", query = "SELECT j FROM JavaPokemon j WHERE j.specialDefense = :specialDefense")})
public class JavaPokemon implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "level")
    private Integer level;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
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
    @Column(name = "defense")
    private int defense;
    @Basic(optional = false)
    @Column(name = "specialAttack")
    private int specialAttack;
    @Basic(optional = false)
    @Column(name = "specialDefense")
    private int specialDefense;

    public JavaPokemon() {
    }

    public JavaPokemon(Integer level) {
        this.level = level;
    }

    public JavaPokemon(Integer level, String name, int hp, int agility, int attack, int defense, int specialAttack, int specialDefense) {
        this.level = level;
        this.name = name;
        this.hp = hp;
        this.agility = agility;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        Integer oldLevel = this.level;
        this.level = level;
        changeSupport.firePropertyChange("level", oldLevel, level);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        int oldHp = this.hp;
        this.hp = hp;
        changeSupport.firePropertyChange("hp", oldHp, hp);
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        int oldAgility = this.agility;
        this.agility = agility;
        changeSupport.firePropertyChange("agility", oldAgility, agility);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        int oldAttack = this.attack;
        this.attack = attack;
        changeSupport.firePropertyChange("attack", oldAttack, attack);
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        int oldDefense = this.defense;
        this.defense = defense;
        changeSupport.firePropertyChange("defense", oldDefense, defense);
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        int oldSpecialAttack = this.specialAttack;
        this.specialAttack = specialAttack;
        changeSupport.firePropertyChange("specialAttack", oldSpecialAttack, specialAttack);
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        int oldSpecialDefense = this.specialDefense;
        this.specialDefense = specialDefense;
        changeSupport.firePropertyChange("specialDefense", oldSpecialDefense, specialDefense);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (level != null ? level.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JavaPokemon)) {
            return false;
        }
        JavaPokemon other = (JavaPokemon) object;
        if ((this.level == null && other.level != null) || (this.level != null && !this.level.equals(other.level))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.JavaPokemon[ level=" + level + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

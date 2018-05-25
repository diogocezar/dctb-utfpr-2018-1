/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.utfpr.pokedex.Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.utfpr.pokedex.Configurations.ConfigurationsMySQL;
import src.utfpr.pokedex.DataBase.DataBase;
import src.utfpr.pokedex.Model.Interfaces.ImplementPokemon;
import src.utfpr.pokedex.Model.Move;
import src.utfpr.pokedex.Model.Pokemon;
import src.utfpr.pokedex.Model.Type;

/**
 *
 * @author Pedro
 */
public class PokemonDAO implements ImplementPokemon {

    private List<Pokemon> list;
    private final DataBase connection = new DataBase(new ConfigurationsMySQL());

    //Tabela pokemon
    public static final String TABLE_POKEMON = "pokemon";
    public static final String COLUMN_POKEMON_ID = "id";
    public static final String COLUMN_POKEMON_NAME = "name";
    public static final String COLUMN_POKEMON_HP = "hp";
    public static final String COLUMN_POKEMON_ATTACK = "attack";
    public static final String COLUMN_POKEMON_DEFENSE = "defense";
    public static final String COLUMN_POKEMON_SP_ATK = "sp_atk";
    public static final String COLUMN_POKEMON_SP_DEF = "sp_def";
    public static final String COLUMN_POKEMON_SPEED = "speed";
    public static final String COLUMN_POKEMON_HEIGHT = "height";
    public static final String COLUMN_POKEMON_WEIGHT = "weight";
    public static final String COLUMN_POKEMON_NEXT_EVOLUTION = "next_evolution0num";
    public static final String COLUMN_POKEMON_PREV_EVOLUTION = "prev_evolution0num";
    public static final String COLUMN_POKEMON_TYPE = "id_type";

    //Tabela type
    public static final String TABLE_TYPE = "type";
    public static final String COLUMN_TYPE_ID = "id_type";
    public static final String COLUMN_TYPE_0 = "type0";
    public static final String COLUMN_TYPE_1 = "type1";
    public static final String COLUMN_TYPE_WEAK0 = "weaknesses0";
    public static final String COLUMN_TYPE_WEAK1 = "weaknesses1";
    public static final String COLUMN_TYPE_WEAK2 = "weaknesses2";
    public static final String COLUMN_TYPE_WEAK3 = "weaknesses3";
    public static final String COLUMN_TYPE_WEAK4 = "weaknesses4";
    public static final String COLUMN_TYPE_WEAK5 = "weaknesses5";
    public static final String COLUMN_TYPE_WEAK6 = "weaknesses6";

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    public static final String TABLE_POKEMON_VIEW = "pokemon_list";

    public static final String CREATE_POKEMON_VIEW = "CREATE OR REPLACE VIEW "
            + TABLE_POKEMON_VIEW + " AS SELECT * FROM " + TABLE_POKEMON
            + " INNER JOIN " + TABLE_TYPE + " USING (" + COLUMN_TYPE_ID
            + ")" + " ORDER BY " + TABLE_POKEMON + "." + COLUMN_POKEMON_ID;

    public static final String VIEW_ALL_POKEMON = "SELECT * FROM "
            + TABLE_POKEMON_VIEW;

    public static final String INSERT_POKEMON = "INSERT INTO " + TABLE_POKEMON
            + '(' + COLUMN_POKEMON_NAME + "," + COLUMN_POKEMON_ATTACK + "," + COLUMN_POKEMON_DEFENSE
            + "," + COLUMN_POKEMON_HP + "," + COLUMN_POKEMON_SP_ATK + "," + COLUMN_POKEMON_SP_DEF
            + "," + COLUMN_POKEMON_SPEED + "," + COLUMN_POKEMON_HEIGHT + "," + COLUMN_POKEMON_WEIGHT
            + "," + COLUMN_POKEMON_TYPE + ") VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    
    public static final String INSERT_POKEMON_FUNC = "SELECT create_pokemon (?,?,?,?,?,?,?,?,?,?)";

    public static final String DELETE_POKEMON = "DELETE FROM "
            + TABLE_POKEMON + " WHERE id=? LIMIT 1";

    public static final String UPDATE_POKEMON = "UPDATE " + TABLE_POKEMON
            + " SET name=?, attack=?, defense=?, hp=?, sp_atk=?, sp_def=?"
            + ", speed=?, height=?, weight=? WHERE id=?";

    public static final String CONSULT_POKEMON = "SELECT * FROM "
            + TABLE_POKEMON_VIEW + " WHERE name LIKE ";

    @Override
    public void create() {
        connection.execute(CREATE_POKEMON_VIEW);
    }

    @Override
    public void insert(Pokemon pokemon) {
        this.connection.query(INSERT_POKEMON_FUNC,
                pokemon.getName(),
                pokemon.getMove().getAttack(),
                pokemon.getMove().getDefense(),
                pokemon.getMove().getHp(),
                pokemon.getMove().getSp_atk(),
                pokemon.getMove().getSp_def(),
                pokemon.getMove().getSpeed(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                pokemon.getType().getType().get(0)
        );
    }

    @Override
    public void update(Pokemon pokemon) {
        this.connection.execute(UPDATE_POKEMON,
                pokemon.getName(),
                pokemon.getMove().getAttack(),
                pokemon.getMove().getDefense(),
                pokemon.getMove().getHp(),
                pokemon.getMove().getSp_atk(),
                pokemon.getMove().getSp_def(),
                pokemon.getMove().getSpeed(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                pokemon.getId());
        this.connection.execute("UPDATE " + TABLE_POKEMON
                + " INNER JOIN " + TABLE_TYPE + " USING(" + COLUMN_POKEMON_TYPE + ")"
                + " SET type0 ='" + pokemon.getType().getType().get(0) + "'"
                + " WHERE id = " + pokemon.getId());
    }

    @Override
    public void delete(int id) {
        this.connection.execute(DELETE_POKEMON, id);
    }

    @Override
    public List<Pokemon> getPokemon(String name) {
        list = new ArrayList<Pokemon>();
        try {
            ResultSet rs = this.connection.query(CONSULT_POKEMON + "'%" + name + "%'");
            while (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt(COLUMN_POKEMON_ID));
                pokemon.setName(rs.getString(COLUMN_POKEMON_NAME));
                pokemon.setMove(
                        new Move(
                                rs.getInt(COLUMN_POKEMON_HP),
                                rs.getInt(COLUMN_POKEMON_ATTACK),
                                rs.getInt(COLUMN_POKEMON_DEFENSE),
                                rs.getInt(COLUMN_POKEMON_SP_ATK),
                                rs.getInt(COLUMN_POKEMON_SP_DEF),
                                rs.getInt(COLUMN_POKEMON_SPEED)));
                pokemon.setType(
                        new Type(
                                rs.getInt(COLUMN_TYPE_ID),
                                rs.getString(COLUMN_TYPE_0),
                                rs.getString(COLUMN_TYPE_1),
                                rs.getString(COLUMN_TYPE_WEAK0),
                                rs.getString(COLUMN_TYPE_WEAK1),
                                rs.getString(COLUMN_TYPE_WEAK2),
                                rs.getString(COLUMN_TYPE_WEAK3),
                                rs.getString(COLUMN_TYPE_WEAK4),
                                rs.getString(COLUMN_TYPE_WEAK5),
                                rs.getString(COLUMN_TYPE_WEAK6)
                        )
                );
                pokemon.setHeight(rs.getString(COLUMN_POKEMON_HEIGHT));
                pokemon.setWeight(rs.getString(COLUMN_POKEMON_WEIGHT));
                list.add(pokemon);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        list = new ArrayList<>();
        ResultSet rs = this.connection.query(VIEW_ALL_POKEMON);
        try {
            while (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt(COLUMN_POKEMON_ID));
                pokemon.setName(rs.getString(COLUMN_POKEMON_NAME));
                pokemon.setMove(
                        new Move(
                                rs.getInt(COLUMN_POKEMON_HP),
                                rs.getInt(COLUMN_POKEMON_ATTACK),
                                rs.getInt(COLUMN_POKEMON_DEFENSE),
                                rs.getInt(COLUMN_POKEMON_SP_ATK),
                                rs.getInt(COLUMN_POKEMON_SP_DEF),
                                rs.getInt(COLUMN_POKEMON_SPEED)));
                pokemon.setType(
                        new Type(
                                rs.getInt(COLUMN_TYPE_ID),
                                rs.getString(COLUMN_TYPE_0),
                                rs.getString(COLUMN_TYPE_1),
                                rs.getString(COLUMN_TYPE_WEAK0),
                                rs.getString(COLUMN_TYPE_WEAK1),
                                rs.getString(COLUMN_TYPE_WEAK2),
                                rs.getString(COLUMN_TYPE_WEAK3),
                                rs.getString(COLUMN_TYPE_WEAK4),
                                rs.getString(COLUMN_TYPE_WEAK5),
                                rs.getString(COLUMN_TYPE_WEAK6)
                        )
                );
                pokemon.setHeight(rs.getString(COLUMN_POKEMON_HEIGHT));
                pokemon.setWeight(rs.getString(COLUMN_POKEMON_WEIGHT));
                list.add(pokemon);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }

    public List<Pokemon> getList() {
        return list;
    }

}

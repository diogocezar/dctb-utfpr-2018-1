package model.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import model.Pokemon;
import model.interfaces.IPokemon;
import database.DataBase;
import config.ConfigurationMySql;
import java.sql.SQLException;

/**
 *
 * @author christian
 */
public class PokemonDAO implements IPokemon {
    
    private List<Pokemon> list;
    
    private final DataBase database = new DataBase(new ConfigurationMySql());

    @Override
    /**
     * Método que realiza a inserção de um
     * objeto no banco de dados.
     * @param pokemon Objeto do tipo @see Pokemon
     */
    public void insert(Pokemon pokemon) {
        String sql = "insert into pokemon"
                + " (nome, nivel, hp, agilidade, ataque, defesa, atqespecial, defespecial)"
                + " values(?,?,?,?,?,?,?,?);";
        this.database.execute(
                sql,
                pokemon.getName(),
                pokemon.getLevel(),
                pokemon.getHp(),
                pokemon.getAgility(),
                pokemon.getAttack(),
                pokemon.getDefense(),
                pokemon.getSpecialAttack(),
                pokemon.getSpecialDefense()
        );
    }

    @Override
    public void update(Pokemon pokemon) {
        String sql = "update pokemon"
                + " set nome = ?," 
                + " nivel = ?," 
                + " hp = ?"
                + " agilidade = ?"
                + " ataque = ?"
                + " defesa = ?"
                + " atqespecial = ?"
                + " defespecial = ?"
                + " where id = ?";
        this.database.execute(
                sql,
                pokemon.getName(),
                pokemon.getLevel(),
                pokemon.getHp(),
                pokemon.getAgility(),
                pokemon.getAttack(),
                pokemon.getDefense(),
                pokemon.getSpecialAttack(),
                pokemon.getSpecialDefense(),
                pokemon.getId()
        );
    }

    @Override
    public void delete(int id) {
        String sql = "delete from pokemon where id = ?";
        this.database.execute(sql, id);
    }

    @Override
    public List<Pokemon> getPokemon(String name) {
        this.list = new ArrayList<>();
        String sql = "select * from pokemon where nome like '" + name
                + "%' order by id;";
        
        try {
            ResultSet result = this.database.query(sql);
            while (result.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(result.getInt("id"));
                pokemon.setName(result.getString("nome"));
                pokemon.setLevel(result.getInt("nivel"));
                pokemon.setHp(result.getInt("hp"));
                pokemon.setAgility(result.getInt("agilidade"));
                pokemon.setAttack(result.getInt("ataque"));
                pokemon.setDefense(result.getInt("defesa"));
                pokemon.setSpecialAttack(result.getInt("atqespecial"));
                pokemon.setSpecialDefense(result.getInt("defespecial"));
                list.add(pokemon);
            }
            
            return list;
            
        } catch (SQLException e) {
            System.out.println("Error on getting a query.\n" + e.getMessage());
            System.out.println("[SQL] " + sql);
        }
        return null;
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return this.getPokemon("");
    }

}

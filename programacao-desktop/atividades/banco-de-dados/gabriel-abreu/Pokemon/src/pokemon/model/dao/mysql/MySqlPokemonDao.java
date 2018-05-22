/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.model.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pokemon.ControllerMaster;
import pokemon.model.dao.PokemonDAO;
import pokemon.model.objects.Pokemon;

/**
 *
 * @author gabriel
 */
public class MySqlPokemonDao extends PokemonDAO {

    Connection connect = null;

    public MySqlPokemonDao() {
        connect = ControllerMaster.getInstance().getDatabaseConnection().getConnection();

    }

    @Override
    public void insertPokemon(Pokemon pokemon) throws Exception {
        PreparedStatement statement = connect.prepareStatement("INSERT INTO `Pokemon`(`name`, `level`, `hp`, "
                + "`agility`, `attack`, "
                + "`defense`, `specialAttack`, `specialDefense`) "
                + "VALUES (?,?,?,?,?,?,?,?)");
        statement.setString(1, pokemon.getName());
        statement.setInt(2, pokemon.getLevel());
        statement.setInt(3, pokemon.getHp());
        statement.setInt(4, pokemon.getAgility());
        statement.setInt(5, pokemon.getAttack());
        statement.setInt(6, pokemon.getDefense());
        statement.setInt(7, pokemon.getSpecialAttack());
        statement.setInt(8, pokemon.getSpecialDefense());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void removePokemon(Pokemon pokemon) throws Exception{
        PreparedStatement statement = connect.prepareStatement("DELETE FROM `Pokemon`"
                + " WHERE name = ?");
        statement.setString(1, pokemon.getName());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void updatePokemon(String oldname, Pokemon pokemon) throws Exception {
        PreparedStatement statement = connect.prepareStatement("UPDATE `Pokemon` "
                + "SET `name`=?,`level`=?,`hp`=?,`agility`=?,"
                + "`attack`=?,`defense`=?,"
                + "`specialAttack`=?,`specialDefense`=? WHERE name= ?");
        statement.setString(1, pokemon.getName());
        statement.setInt(2, pokemon.getLevel());
        statement.setInt(3, pokemon.getHp());
        statement.setInt(4, pokemon.getAgility());
        statement.setInt(5, pokemon.getAttack());
        statement.setInt(6, pokemon.getDefense());
        statement.setInt(7, pokemon.getSpecialAttack());
        statement.setInt(8, pokemon.getSpecialDefense());
        statement.setString(9, oldname);
        statement.executeUpdate();
        statement.close();
    }
    @Override
    public ArrayList<Pokemon> getALlPokemons() throws Exception {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery("Select * from Pokemon");
        while (rs.next()) {
            Pokemon pokemon = new Pokemon();
            pokemon.setAgility(rs.getInt("agility"));
            pokemon.setAttack(rs.getInt("attack"));
            pokemon.setDefense(rs.getInt("defense"));
            pokemon.setHp(rs.getInt("hp"));
            pokemon.setLevel(rs.getInt("level"));
            pokemon.setName(rs.getString("name"));
            pokemon.setSpecialAttack(rs.getInt("specialAttack"));
            pokemon.setSpecialDefense(rs.getInt("specialDefense"));
            pokemons.add(pokemon);
        }
        return pokemons;
    }

}

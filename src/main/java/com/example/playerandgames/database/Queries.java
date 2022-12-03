package com.example.playerandgames.database;

import com.example.playerandgames.models.DisplayRecordDto;
import com.example.playerandgames.models.Game;
import com.example.playerandgames.models.Player;
import com.example.playerandgames.models.PlayerGameDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Queries {

  public static void createTables() throws SQLException {
    Statement statement = DBConnection.con.createStatement();

    String createPlayerTableQuery = "CREATE TABLE IF NOT EXISTS player " +
      "(player_id SERIAL, " +
      "first_name VARCHAR(255), " +
      "last_name VARCHAR(255), " +
      "address VARCHAR(255), " +
      "postal_code VARCHAR(255), " +
      "province VARCHAR(255), " +
      "phone_number INTEGER, " +
      "PRIMARY KEY (player_id))";

    String createGameTableQuery = "CREATE TABLE IF NOT EXISTS game " +
      "(game_id SERIAL, " +
      "game_title VARCHAR(255), " +
      "PRIMARY KEY (game_id))";

    String createPlayerAndGameTable = "CREATE TABLE IF NOT EXISTS playerAndGame " +
      "(player_game_id SERIAL, " +
      "game_id INTEGER, " +
      "player_id INTEGER, " +
      "playing_date DATE, " +
      "score INTEGER, " +
      "PRIMARY KEY (player_game_id), " +
      "CONSTRAINT fk_game_id FOREIGN KEY (game_id) REFERENCES game(game_id), " +
      "CONSTRAINT fk_player_id FOREIGN KEY (player_id) REFERENCES player(player_id))";


    statement.execute(createGameTableQuery);
    System.out.println("Game table created");
    statement.execute(createPlayerTableQuery);
    System.out.println("Player table created");
    statement.execute(createPlayerAndGameTable);
    System.out.println("PlayerAndGame table created");
  }

  public static void insertGameData(Game game) throws SQLException {

    String insertGameQuery = "INSERT INTO game (game_title) values(?)";
    PreparedStatement statement = DBConnection.con.prepareStatement(insertGameQuery);
    statement.setString(1, game.getGame_title());
    statement.execute();

    System.out.println("Game data inserted into table.");
  }

  public static void insertPlayerData(Player player) throws SQLException {

    String insertGameQuery = "INSERT INTO player (first_name, " +
      "last_name, address, " +
      "postal_code, province, " +
      "phone_number) " +
      "values(?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = DBConnection.con.prepareStatement(insertGameQuery);
    statement.setString(1, player.getFirst_name());
    statement.setString(2, player.getLast_name());
    statement.setString(3, player.getAddress());
    statement.setString(4, player.getPostal_code());
    statement.setString(5, player.getProvince());
    statement.setInt(6, player.getPhone_number());
    statement.execute();

    System.out.println("Player data inserted into table.");
  }

  public static void insertIntoPlayerGameTable(PlayerGameDTO playerGameDTO) throws SQLException {
    String insertGameQuery = "INSERT INTO playerAndGame (player_id, " +
      "game_id, score, playing_date) " +
      "values(?, ?, ?, ?)";
    PreparedStatement statement = DBConnection.con.prepareStatement(insertGameQuery);
    statement.setInt(1, playerGameDTO.getPlayer_id());
    statement.setInt(2, playerGameDTO.getGame_id());
    statement.setInt(3, playerGameDTO.getScore());
    statement.setDate(4, playerGameDTO.getPlaying_date());
    statement.execute();

    System.out.println("Player Game data inserted into table.");
  }

  public static List<DisplayRecordDto> getRecordsByGameId(Integer gameId) throws SQLException {
    String getRecordsByGameId = "SELECT * FROM playerandgame " +
      "join public.player on playerandgame.player_id = player.player_id " +
      "join public.game on playerandgame.game_id = game.game_id " +
      "where playerandgame.game_id = ?";

    PreparedStatement statement = DBConnection.con.prepareStatement(getRecordsByGameId);
    statement.setInt(1, gameId);
    ResultSet result = statement.executeQuery();
    List<DisplayRecordDto> records = new ArrayList<>();
    while (result.next()) {
      DisplayRecordDto recordDto = new DisplayRecordDto();
      recordDto.setAddress(result.getString("address"));
      recordDto.setGame_id(result.getInt("game_id"));
      recordDto.setGame_title(result.getString("game_title"));
      recordDto.setFirst_name(result.getString("first_name"));
      recordDto.setLast_name(result.getString("last_name"));
      recordDto.setPostal_code(result.getString("postal_code"));
      recordDto.setProvince(result.getString("province"));
      recordDto.setPlaying_date(result.getDate("playing_date"));
      recordDto.setScore(result.getInt("score"));
      records.add(recordDto);
    }
    return records;
  }

  public static List<DisplayRecordDto> getRecordsByPlayerId(Integer playerId) throws SQLException {
    String getRecordsByGameId = "SELECT * FROM playerandgame " +
      "join public.player on playerandgame.player_id = player.player_id " +
      "join public.game on playerandgame.game_id = game.game_id " +
      "where playerandgame.player_id = ?";

    PreparedStatement statement = DBConnection.con.prepareStatement(getRecordsByGameId);
    statement.setInt(1, playerId);
    ResultSet result = statement.executeQuery();
    List<DisplayRecordDto> records = new ArrayList<>();
    while (result.next()) {
      DisplayRecordDto recordDto = new DisplayRecordDto();
      recordDto.setAddress(result.getString("address"));
      recordDto.setGame_id(result.getInt("game_id"));
      recordDto.setGame_title(result.getString("game_title"));
      recordDto.setFirst_name(result.getString("first_name"));
      recordDto.setLast_name(result.getString("last_name"));
      recordDto.setPostal_code(result.getString("postal_code"));
      recordDto.setProvince(result.getString("province"));
      recordDto.setPlaying_date(result.getDate("playing_date"));
      recordDto.setScore(result.getInt("score"));
      records.add(recordDto);
    }
    return records;
  }

  public static List<Integer> getAllPlayerIds() throws SQLException {
    String getPlayerIdsQuery = "SELECT player_id from player";
    PreparedStatement statement = DBConnection.con.prepareStatement(getPlayerIdsQuery);
    ResultSet reselt = statement.executeQuery();
    List<Integer> playerIds = new ArrayList<>();
    while (reselt.next()) {
      playerIds.add(reselt.getInt("player_id"));
    }
    return playerIds;
  }

  public static List<Game> getAllGames() throws SQLException {
    String getAllGamesQuery = "SELECT * from game";
    PreparedStatement statement = DBConnection.con.prepareStatement(getAllGamesQuery);
    ResultSet reselt = statement.executeQuery();
    List<Game> games = new ArrayList<>();
    while (reselt.next()) {
      Game game = new Game();
      game.setGame_title(reselt.getString("game_title"));
      game.setGame_id(reselt.getInt("game_id"));
      games.add(game);
    }
    return games;
  }

  public static List<Player> getAllPlayers() throws SQLException {
    String getAllPlayersQuery = "SELECT * from player";

    PreparedStatement statement = DBConnection.con.prepareStatement(getAllPlayersQuery);
    ResultSet result = statement.executeQuery();
    List<Player> players = new ArrayList<>();
    while (result.next()) {
      Player player = new Player();
      player.setAddress(result.getString("address"));
      player.setFirst_name(result.getString("first_name"));
      player.setLast_name(result.getString("last_name"));
      player.setPostal_code(result.getString("postal_code"));
      player.setProvince(result.getString("province"));
      player.setPlayer_id(result.getInt("player_id"));
      player.setPhone_number(result.getInt("phone_number"));
      players.add(player);
    }
    return players;
  }

  public static Player getPlayerbyId(Integer playerId) throws SQLException {
    String getPlayerByIdQuery = "SELECT * from player WHERE player_id = ?";
    PreparedStatement statement = DBConnection.con.prepareStatement(getPlayerByIdQuery);
    statement.setInt(1, playerId);
    ResultSet result = statement.executeQuery();
    Player player = new Player();
    while (result.next()) {
      player.setAddress(result.getString("address"));
      player.setFirst_name(result.getString("first_name"));
      player.setLast_name(result.getString("last_name"));
      player.setPostal_code(result.getString("postal_code"));
      player.setProvince(result.getString("province"));
      player.setPlayer_id(result.getInt("player_id"));
      player.setPhone_number(result.getInt("phone_number"));
    }
    return player;
  }

  public static void updatePlayer(Player player) throws SQLException {
    String updatePlayerQuery = "UPDATE player " +
      "SET first_name = ?, " +
      "last_name = ?, " +
      "address = ?, " +
      "postal_code = ?, " +
      "province = ?, " +
      "phone_number = ? " +
      "WHERE player_id = ?";

    PreparedStatement statement = DBConnection.con.prepareStatement(updatePlayerQuery);
    statement.setString(1, player.getFirst_name());
    statement.setString(2, player.getLast_name());
    statement.setString(3, player.getAddress());
    statement.setString(4, player.getPostal_code());
    statement.setString(5, player.getProvince());
    statement.setInt(6, player.getPhone_number());
    statement.setInt(7, player.getPlayer_id());
    statement.execute();
    System.out.println("Player updated.");
  }
}

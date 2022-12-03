package com.example.playerandgames;

import com.example.playerandgames.database.Queries;
import com.example.playerandgames.models.DisplayRecordDto;
import com.example.playerandgames.models.Game;
import com.example.playerandgames.models.GameMaster;
import com.example.playerandgames.models.Player;
import com.example.playerandgames.models.PlayerGameDTO;
import com.example.playerandgames.models.PlayerGameMaster;
import com.example.playerandgames.models.PlayerMaster;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class PlayerGameController {

  @FXML
  public TextField datePlayed;

  @FXML
  public TextField score;

  @FXML
  public TextField playerrId;

  @FXML
  public TextField gameId;

  @FXML
  public Label gameDetailsAdded;

  @FXML
  public TableView<PlayerMaster> playerTableView;
  @FXML
  public TableColumn<PlayerMaster, String> playerTablePlayerId;
  @FXML
  public TableColumn<PlayerMaster, String> playerTableFirstName;
  @FXML
  public TableColumn<PlayerMaster, String> playerTableLastName;
  @FXML
  public TableColumn<PlayerMaster, String> playerTablePhoneNumber;

  @FXML
  public TableView<GameMaster> gameTableView;
  @FXML
  public TableColumn<GameMaster, String> gameTableId;
  @FXML
  public TableColumn<GameMaster, String> gameTableTile;

  @FXML
  public TableView<PlayerGameMaster> playerGameDetailTable;
  @FXML
  public TableColumn<PlayerGameMaster, String> playerGameTableFirstName;
  @FXML
  public TableColumn<PlayerGameMaster, String> playerGameTableLastName;
  @FXML
  public TableColumn<PlayerGameMaster, String> playerGameTableGamePlayed;
  @FXML
  public TableColumn<PlayerGameMaster, String> playerGameTableScore;
  @FXML
  public TableColumn<PlayerGameMaster, String> playerGameTablePlayedOn;
  @FXML
  public TextField playerGameId;


  @FXML
  private  Label gameAdded;

  @FXML
  private Label playerAdded;

  @FXML
  private TextField playerId;

  @FXML
  private TextField firstName;

  @FXML
  private TextField lastName;

  @FXML
  private TextField address;

  @FXML
  private TextField province;

  @FXML
  private TextField postalCode;

  @FXML
  private TextField phoneNumber;

  @FXML
  private TextField gameTitle;

  @FXML
  public static ComboBox playerIdList;

  @FXML
  private ObservableList playerIds = FXCollections
    .observableArrayList(Queries.getAllPlayerIds());

  public PlayerGameController() throws SQLException {
  }

  @FXML
  protected void onAddPlayerButtonClick(ActionEvent actionEvent) throws SQLException {
    Player player = new Player();
    player.setAddress(address.getText());
    player.setFirst_name(firstName.getText());
    player.setLast_name(lastName.getText());
    player.setPostal_code(postalCode.getText());
    player.setProvince(province.getText());
    player.setPhone_number(Integer.parseInt(phoneNumber.getText()));
    Queries.insertPlayerData(player);
    playerAdded.setText("Player added successfully!!!");
    clearPlayerFields();
    onGetAllPlayersClick(actionEvent);
  }

  @FXML
  protected void onCreateGameButtonClick(ActionEvent actionEvent) throws SQLException {
    Game game = new Game();
    game.setGame_title(gameTitle.getText());
    Queries.insertGameData(game);
    gameAdded.setText(gameTitle.getText() + " added successfully!!!");
    gameTitle.clear();
    onGetAllGamesClick(actionEvent);
  }

  private void clearPlayerFields() {
    firstName.clear();
    lastName.clear();
    address.clear();
    province.clear();
    postalCode.clear();
    phoneNumber.clear();
  }


  @FXML
  public void onGetPlayerButtonClicked(ActionEvent actionEvent) throws SQLException {

    Player player = Queries.getPlayerbyId(Integer.parseInt(playerId.getText()));
    firstName.setText(player.getFirst_name());
    lastName.setText(player.getLast_name());
    address.setText(player.getAddress());
    postalCode.setText(player.getPostal_code());
    province.setText(player.getProvince());
    phoneNumber.setText(player.getPhone_number().toString());
    playerId.setText(player.getPlayer_id().toString());
  }

  public void onUpdatePlayerButtonClicked(ActionEvent actionEvent) throws SQLException {
    Player player = new Player();
    player.setAddress(address.getText());
    player.setFirst_name(firstName.getText());
    player.setLast_name(lastName.getText());
    player.setPostal_code(postalCode.getText());
    player.setProvince(province.getText());
    player.setPhone_number(Integer.parseInt(phoneNumber.getText()));
    player.setPlayer_id(Integer.parseInt(playerId.getText()));
    Queries.updatePlayer(player);
    playerAdded.setText("Player updated successfully!!!");
    clearPlayerFields();
    playerId.clear();
    onGetAllPlayersClick(actionEvent);

  }

  public void onPlayerGameButtonClick(ActionEvent actionEvent) throws SQLException {
    PlayerGameDTO playerGameDTO = new PlayerGameDTO();
    playerGameDTO.setPlaying_date(Date.valueOf(datePlayed.getText()));
    playerGameDTO.setGame_id(Integer.parseInt(gameId.getText()));
    playerGameDTO.setScore(Integer.parseInt(score.getText()));
    playerGameDTO.setPlayer_id(Integer.parseInt(playerrId.getText()));
    Queries.insertIntoPlayerGameTable(playerGameDTO);
    gameDetailsAdded.setText("Details added successfully!!!");

    System.out.println("Player game details added!");

  }


  @FXML
  public void onGetAllGamesClick(ActionEvent actionEvent) throws SQLException {
    gameTableId.setCellValueFactory(new PropertyValueFactory<GameMaster, String>("gameTableId"));
    gameTableTile.setCellValueFactory(new PropertyValueFactory<GameMaster, String>("gameTableTitle"));
    List<Game> games = Queries.getAllGames();

    ObservableList<GameMaster> gameData = FXCollections.observableArrayList();

    for(Game game: games) {
      GameMaster gameMaster = new GameMaster();
      gameMaster.setGameTableId(game.getGame_id());
      gameMaster.setGameTableTitle(game.getGame_title());
      gameData.add(gameMaster);
    }
    gameTableView.setItems(gameData);
  }

  public void onGetAllPlayersClick(ActionEvent actionEvent) throws SQLException {
    playerTablePlayerId.setCellValueFactory(new PropertyValueFactory<PlayerMaster, String>("playerTablePlayerId"));
    playerTableFirstName.setCellValueFactory(new PropertyValueFactory<PlayerMaster, String>("playerTableFirstName"));
    playerTableLastName.setCellValueFactory(new PropertyValueFactory<PlayerMaster, String>("playerTableLastName"));
    playerTablePhoneNumber.setCellValueFactory(new PropertyValueFactory<PlayerMaster, String>("playerTablePhoneNumber"));
    List<Player> players = Queries.getAllPlayers();

    ObservableList<PlayerMaster> playerData = FXCollections.observableArrayList();
    for(Player player : players) {
      PlayerMaster playerMaster = new PlayerMaster();
      playerMaster.setPlayerTablePlayerId(player.getPlayer_id());
      playerMaster.setPlayerTableFirstName(player.getFirst_name());
      playerMaster.setPlayerTableLastName(player.getLast_name());
      playerMaster.setPlayerTablePhoneNumber(player.getPhone_number());
      playerData.add(playerMaster);
    }
    playerTableView.setItems(playerData);
  }

  public void onGetAllPlayerGamesClick(ActionEvent actionEvent) throws SQLException {
    playerGameTableFirstName.setCellValueFactory(new PropertyValueFactory<PlayerGameMaster, String>("playerGameTableFirstName"));
    playerGameTableLastName.setCellValueFactory(new PropertyValueFactory<PlayerGameMaster, String>("playerGameTableLastName"));
    playerGameTableGamePlayed.setCellValueFactory(new PropertyValueFactory<PlayerGameMaster, String>("playerGameTableGamePlayed"));
    playerGameTableScore.setCellValueFactory(new PropertyValueFactory<PlayerGameMaster, String>("playerGameTableScore"));
    playerGameTablePlayedOn.setCellValueFactory(new PropertyValueFactory<PlayerGameMaster, String>("playerGameTablePlayedOn"));
    List<DisplayRecordDto> playerGamess = Queries.getRecordsByPlayerId(Integer.parseInt(playerGameId.getText()));

    ObservableList<PlayerGameMaster> playerData = FXCollections.observableArrayList();
    for(DisplayRecordDto player : playerGamess) {
      PlayerGameMaster playerMaster = new PlayerGameMaster();
      playerMaster.setPlayerGameTableFirstName(player.getFirst_name());
      playerMaster.setPlayerGameTableLastName(player.getLast_name());
      playerMaster.setPlayerGameTablePlayedOn(player.getPlaying_date().toString());
      playerMaster.setPlayerGameTableGamePlayed(player.getGame_title());
      playerMaster.setPlayerGameTableScore(player.getScore());
      playerData.add(playerMaster);
    }
    playerGameDetailTable.setItems(playerData);
  }
}
package com.example.playerandgames.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PlayerGameMaster {
  public SimpleStringProperty playerGameTableFirstName = new SimpleStringProperty();
  public SimpleStringProperty playerGameTableLastName = new SimpleStringProperty();
  public SimpleStringProperty playerGameTableGamePlayed = new SimpleStringProperty();
  public SimpleIntegerProperty playerGameTableScore = new SimpleIntegerProperty();
  public SimpleStringProperty playerGameTablePlayedOn = new SimpleStringProperty();

  public String getPlayerGameTableFirstName() {
    return playerGameTableFirstName.get();
  }

  public void setPlayerGameTableFirstName(String playerGameTableFirstName) {
    this.playerGameTableFirstName.set(playerGameTableFirstName);
  }

  public SimpleStringProperty playerGameTableFirstNameProperty() {
    return playerGameTableFirstName;
  }

  public String getPlayerGameTableLastName() {
    return playerGameTableLastName.get();
  }

  public void setPlayerGameTableLastName(String playerGameTableLastName) {
    this.playerGameTableLastName.set(playerGameTableLastName);
  }

  public SimpleStringProperty playerGameTableLastNameProperty() {
    return playerGameTableLastName;
  }

  public String getPlayerGameTableGamePlayed() {
    return playerGameTableGamePlayed.get();
  }

  public void setPlayerGameTableGamePlayed(String playerGameTableGamePlayed) {
    this.playerGameTableGamePlayed.set(playerGameTableGamePlayed);
  }

  public SimpleStringProperty playerGameTableGamePlayedProperty() {
    return playerGameTableGamePlayed;
  }

  public int getPlayerGameTableScore() {
    return playerGameTableScore.get();
  }

  public void setPlayerGameTableScore(int playerGameTableScore) {
    this.playerGameTableScore.set(playerGameTableScore);
  }

  public SimpleIntegerProperty playerGameTableScoreProperty() {
    return playerGameTableScore;
  }

  public String getPlayerGameTablePlayedOn() {
    return playerGameTablePlayedOn.get();
  }

  public void setPlayerGameTablePlayedOn(String playerGameTablePlayedOn) {
    this.playerGameTablePlayedOn.set(playerGameTablePlayedOn);
  }

  public SimpleStringProperty playerGameTablePlayedOnProperty() {
    return playerGameTablePlayedOn;
  }
}

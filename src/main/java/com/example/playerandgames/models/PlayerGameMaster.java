package com.example.playerandgames.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;

public class PlayerGameMaster {
  public SimpleStringProperty playerGameTableFirstName = new SimpleStringProperty();
  public SimpleStringProperty playerGameTableLastName = new SimpleStringProperty();
  public SimpleStringProperty playerGameTableGamePlayed = new SimpleStringProperty();
  public SimpleIntegerProperty playerGameTableScore = new SimpleIntegerProperty();
  public SimpleStringProperty playerGameTablePlayedOn = new SimpleStringProperty();

  public String getPlayerGameTableFirstName() {
    return playerGameTableFirstName.get();
  }

  public SimpleStringProperty playerGameTableFirstNameProperty() {
    return playerGameTableFirstName;
  }

  public void setPlayerGameTableFirstName(String playerGameTableFirstName) {
    this.playerGameTableFirstName.set(playerGameTableFirstName);
  }

  public String getPlayerGameTableLastName() {
    return playerGameTableLastName.get();
  }

  public SimpleStringProperty playerGameTableLastNameProperty() {
    return playerGameTableLastName;
  }

  public void setPlayerGameTableLastName(String playerGameTableLastName) {
    this.playerGameTableLastName.set(playerGameTableLastName);
  }

  public String getPlayerGameTableGamePlayed() {
    return playerGameTableGamePlayed.get();
  }

  public SimpleStringProperty playerGameTableGamePlayedProperty() {
    return playerGameTableGamePlayed;
  }

  public void setPlayerGameTableGamePlayed(String playerGameTableGamePlayed) {
    this.playerGameTableGamePlayed.set(playerGameTableGamePlayed);
  }

  public int getPlayerGameTableScore() {
    return playerGameTableScore.get();
  }

  public SimpleIntegerProperty playerGameTableScoreProperty() {
    return playerGameTableScore;
  }

  public void setPlayerGameTableScore(int playerGameTableScore) {
    this.playerGameTableScore.set(playerGameTableScore);
  }

  public String getPlayerGameTablePlayedOn() {
    return playerGameTablePlayedOn.get();
  }

  public SimpleStringProperty playerGameTablePlayedOnProperty() {
    return playerGameTablePlayedOn;
  }

  public void setPlayerGameTablePlayedOn(String playerGameTablePlayedOn) {
    this.playerGameTablePlayedOn.set(playerGameTablePlayedOn);
  }
}

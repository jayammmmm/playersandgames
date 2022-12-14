package com.example.playerandgames.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class PlayerMaster {

  public SimpleIntegerProperty playerTablePlayerId = new SimpleIntegerProperty();
  public SimpleStringProperty playerTableFirstName = new SimpleStringProperty();
  public SimpleStringProperty playerTableLastName = new SimpleStringProperty();
  public SimpleLongProperty playerTablePhoneNumber = new SimpleLongProperty();

  public int getPlayerTablePlayerId() {
    return playerTablePlayerId.get();
  }

  public void setPlayerTablePlayerId(int playerTablePlayerId) {
    this.playerTablePlayerId.set(playerTablePlayerId);
  }

  public SimpleIntegerProperty playerTablePlayerIdProperty() {
    return playerTablePlayerId;
  }

  public String getPlayerTableFirstName() {
    return playerTableFirstName.get();
  }

  public void setPlayerTableFirstName(String playerTableFirstName) {
    this.playerTableFirstName.set(playerTableFirstName);
  }

  public SimpleStringProperty playerTableFirstNameProperty() {
    return playerTableFirstName;
  }

  public String getPlayerTableLastName() {
    return playerTableLastName.get();
  }

  public void setPlayerTableLastName(String playerTableLastName) {
    this.playerTableLastName.set(playerTableLastName);
  }

  public SimpleStringProperty playerTableLastNameProperty() {
    return playerTableLastName;
  }

  public long getPlayerTablePhoneNumber() {
    return playerTablePhoneNumber.get();
  }

  public void setPlayerTablePhoneNumber(long playerTablePhoneNumber) {
    this.playerTablePhoneNumber.set(playerTablePhoneNumber);
  }

  public SimpleLongProperty playerTablePhoneNumberProperty() {
    return playerTablePhoneNumber;
  }
}

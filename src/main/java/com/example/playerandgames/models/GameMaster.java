package com.example.playerandgames.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GameMaster {

  public SimpleIntegerProperty gameTableId = new SimpleIntegerProperty();
  public SimpleStringProperty gameTableTitle = new SimpleStringProperty();

  public int getGameTableId() {
    return gameTableId.get();
  }

  public void setGameTableId(int gameTableId) {
    this.gameTableId.set(gameTableId);
  }

  public SimpleIntegerProperty gameTableIdProperty() {
    return gameTableId;
  }

  public String getGameTableTitle() {
    return gameTableTitle.get();
  }

  public void setGameTableTitle(String gameTableTitle) {
    this.gameTableTitle.set(gameTableTitle);
  }

  public SimpleStringProperty gameTableTitleProperty() {
    return gameTableTitle;
  }
}

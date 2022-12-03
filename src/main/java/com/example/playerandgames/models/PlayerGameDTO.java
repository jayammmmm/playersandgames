package com.example.playerandgames.models;


import java.sql.Date;

public class PlayerGameDTO {

  private Integer game_id;

  private Integer player_id;

  private Date playing_date;

  private Integer score;

  public void setGame_id(Integer game_id) {
    this.game_id = game_id;
  }

  public void setPlayer_id(Integer player_id) {
    this.player_id = player_id;
  }

  public void setPlaying_date(Date playing_date) {
    this.playing_date = playing_date;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public Integer getGame_id() {
    return game_id;
  }

  public Integer getPlayer_id() {
    return player_id;
  }

  public Date getPlaying_date() {
    return playing_date;
  }

  public Integer getScore() {
    return score;
  }
}

package com.example.playerandgames.models;

import java.sql.Date;

public class DisplayRecordDto {

  private Integer game_id;

  private String game_title;

  private Integer player_id;

  private String first_name;

  private String last_name;

  private String address;

  private String postal_code;

  private String province;

  private Date playing_date;
  private Integer score;

  @Override
  public String toString() {
    return "DisplayRecordDto{" +
      "game_id=" + game_id +
      ", game_title='" + game_title + '\'' +
      ", player_id=" + player_id +
      ", first_name='" + first_name + '\'' +
      ", last_name='" + last_name + '\'' +
      ", address='" + address + '\'' +
      ", postal_code='" + postal_code + '\'' +
      ", province='" + province + '\'' +
      ", playing_date=" + playing_date +
      ", score=" + score +
      '}';
  }

  public Integer getGame_id() {
    return game_id;
  }

  public void setGame_id(Integer game_id) {
    this.game_id = game_id;
  }

  public String getGame_title() {
    return game_title;
  }

  public void setGame_title(String game_title) {
    this.game_title = game_title;
  }

  public Integer getPlayer_id() {
    return player_id;
  }

  public void setPlayer_id(Integer player_id) {
    this.player_id = player_id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPostal_code() {
    return postal_code;
  }

  public void setPostal_code(String postal_code) {
    this.postal_code = postal_code;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public Date getPlaying_date() {
    return playing_date;
  }

  public void setPlaying_date(Date playing_date) {
    this.playing_date = playing_date;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }
}

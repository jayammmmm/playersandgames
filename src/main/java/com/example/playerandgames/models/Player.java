package com.example.playerandgames.models;

import java.util.List;

public class Player {

  private Integer player_id;

  private String first_name;

  private String last_name;

  private String address;

  private String postal_code;

  private String province;

  private Integer phone_number;

  public void setPlayer_id(Integer player_id) {
    this.player_id = player_id;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setPostal_code(String postal_code) {
    this.postal_code = postal_code;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public void setPhone_number(Integer phone_number) {
    this.phone_number = phone_number;
  }

  public Integer getPlayer_id() {
    return player_id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public String getAddress() {
    return address;
  }

  public String getPostal_code() {
    return postal_code;
  }

  public String getProvince() {
    return province;
  }

  public Integer getPhone_number() {
    return phone_number;
  }
}

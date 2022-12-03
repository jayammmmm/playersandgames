package com.example.playerandgames;

import com.example.playerandgames.database.DBConnection;
import com.example.playerandgames.database.Queries;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
  public static void main(String[] args) throws Exception {
//    launch();
    DBConnection conn = new DBConnection();
    conn.setConnection();
//    Queries.createTables();
    launch();
  }

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 1500, 1500);
    stage.setTitle("Player Games Application!");
    stage.setScene(scene);
    stage.show();
  }
}
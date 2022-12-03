module com.example.playerandgames {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires org.kordamp.bootstrapfx.core;
  requires java.sql;

  opens com.example.playerandgames to javafx.fxml;
  exports com.example.playerandgames;
  exports com.example.playerandgames.models;
}
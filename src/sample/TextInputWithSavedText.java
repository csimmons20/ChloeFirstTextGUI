package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class TextInputWithSavedText extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

   //Load view form xml description
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

    // setOnHidden event happens when app is quit; tell controller to save model then
        Controller myController = loader.getController();
        primaryStage.setOnHidden(e -> myController.save());

   //Display the View
        primaryStage.setTitle("Picture Survey");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}

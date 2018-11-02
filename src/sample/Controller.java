package sample;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Controller {


    // Name fields that's been used in Sample
    public TextField textField;
    public ListView<Label> bottomListView;
    public ChoiceBox CB;
    public ImageView imageView;


    Image[] pictures;
    int currentPicture;


    //Keep track of previously saved and updates
    private Model model;

    public void initialize() {
        System.out.println("Controller initialize");

        //create images
        currentPicture = 0;
        pictures = new Image[4];
        pictures[0] = new Image("Cybertron.jpg");
        pictures[1] = new Image("dragoneye.jpg");
        pictures[2] = new Image("Crystals.jpeg");
        pictures[3] = new Image("Music.jpg");
        pictures[4] = new Image("AB.jpg");
        pictures[5] = new Image("CrayonHeart.jpg");
        pictures[6] = new Image("Jellyfish.jpg");
        pictures[7] = new Image("Kittens.jpeg");
        pictures[8] = new Image("Earth.jpg");
        pictures[9] = new Image("Autobots.jpg");
        pictures[10] = new Image("Decepticons.png");






        model = new Model();
        // Now that model has been initialized from a file, update View with saved values from Model
        textField.setText(model.getTextFieldText());
        CB.setValue(model.getCBchoice());
        ArrayList BottomListViewTexts = model.getBottomListViewTexts();
        for (int i = 0; i < BottomListViewTexts.size(); i++) {
            bottomListView.getItems().add(new Label((String) BottomListViewTexts.get(i)));
        }
        CB.getItems().addAll("I love it", "It's okay", "It's horrible");
        CB.setOnAction(e -> {
            textField.setEditable(true);
        });


    }

    void save() {
        System.out.println("Controller save");

        // Update Model text in view
        model.setAllData(textField.getText(), bottomListView.getItems(), (String) CB.getValue());
        model.save();
    }


    public void bottomTextFieldReady() {
        System.out.println("TextFieldReady: " + textField.getText());

        // Update the list view with the text from the bottom text field
        String choiceBoxAnswer = (String) CB.getValue();

        bottomListView.getItems().add(new Label(choiceBoxAnswer + " because " + textField.getText()));

        // Clear the bottom text field because it has been used.
        textField.setText("");

        StartAnew();
        Congrats();
    }


    //Once choice selected and return, move to the next image and start over.

    public void StartAnew() {

        //set cybertron image as first image
        currentPicture = currentPicture + 1;
        imageView.setImage(pictures[currentPicture]);

        String choiceFromCB = (String) CB.getValue();
        if (choiceFromCB.equals("")) {
            //return;
        } else {
            if (CB.getValue().equals("I love it")) {

                //move to next image
                System.out.println("They have moved!");

            } else if (CB.getValue().equals("It's okay")) {

                //move to next image
                System.out.println("They have moved!");


            } else  if (CB.getValue().equals("It's horrible")) {

                //move to next image
                System.out.println("They have moved!");


            }
            //Start Response over
            CB.setValue(null);

            

        }

    }

}

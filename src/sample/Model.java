package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

    //List all of the View's text
    private String TextFieldText;
    String CBchoice;
    private ArrayList<String> bottomListViewTexts;



    //Make it restored from saved data
    Model() {
        TextFieldText = "";
        CBchoice = "";
        bottomListViewTexts = new ArrayList();


        // Try restoring saved text from file
        try {
            // Open file to read saved text
            File savedText = new File(getClass().getResource("SavedText.txt").toURI());
            if (savedText.exists()) {
                BufferedReader input = new BufferedReader(new FileReader(savedText));

                TextFieldText = input.readLine();
                CBchoice = input.readLine();
                String newBottomListText = input.readLine();
                while (newBottomListText != null) {
                    bottomListViewTexts.add(newBottomListText);
                    newBottomListText = input.readLine();
                }

                // Close file
                input.close();
            }
        } catch (Exception e) {
            System.out.println("Controller initialize EXCEPTION");
        }
    }

    // write the model to a file
    void save() {
        try {

            // Write the final model to a saved file
            File savedText = new File(getClass().getResource("SavedText.txt").toURI());
            BufferedWriter writer = new BufferedWriter(new FileWriter(savedText));
            if (writer != null) {
                writer.newLine();
                if (TextFieldText != null) {
                    writer.write(TextFieldText);
                } else {
                    writer.write("");
                }
                if (CBchoice != null) {
                    writer.write(CBchoice);
                } else {
                    writer.write("");
                }
                writer.newLine();
                int length = bottomListViewTexts.size();
                if (length > 0) {
                    for (int i = 0; i < length; i++) {
                        writer.write(bottomListViewTexts.get(i));
                        writer.newLine();
                    }
                } else {
                    writer.write("");
                    writer.newLine();
                }
            }
            writer.close();

        } catch (Exception e) {
            System.out.println("Model.save() failed!!!");
        }

    }

    // Getter & Setter methods

    String getTextFieldText() {
        return TextFieldText;
    }

    String getCBchoice() {return CBchoice;}

    ArrayList<String> getBottomListViewTexts() {
        return bottomListViewTexts;
    }

    void setAllData(String updatedTextFieldText, List<Label> updatedBottomListViewTexts, String UpdateCBchoice) {
        // Update the model with all text currently seen in View
        TextFieldText = updatedTextFieldText;
        CBchoice = UpdateCBchoice;


        int length = updatedBottomListViewTexts.size();
        bottomListViewTexts.clear();
        for (int i = 0; i < length; i++) {
            bottomListViewTexts.add(updatedBottomListViewTexts.get(i).getText());
        }
    }

}



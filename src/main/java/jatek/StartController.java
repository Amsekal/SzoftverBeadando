package jatek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {
    @FXML
    private Button startButton;
    @FXML
    private TextField userName1;
    @FXML
    private TextField userName2;

    /**
     *
     * @param actionEvent a gomb lenyomasa
     * @throws IOException kivetel
     */
    public void gameStartScene(ActionEvent actionEvent) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DominoStart.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<DominoStartController>getController().setUsername(userName1.getText(),userName2.getText());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

}

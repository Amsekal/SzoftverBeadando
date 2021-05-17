package jatek;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import adatb.Handler;
import adatb.Result;

import java.io.IOException;
import java.util.List;

@Slf4j
public class EndController {

    ObservableList list = FXCollections.observableArrayList();

    @FXML
    ListView<String> toplistanezet;


    /**
     * Inicializalo fuggveny.
     */
    @FXML
    public void initialize() {
        List<Result> toplista = Handler.listResults();
        loadData(toplista);
    }

    /**
     * Toplista betolto fuggveny.
     * @param toplista top 10 jatek objektumat tartalmazza.
     */
    private void loadData(List<Result> toplista){
        for(Result game : toplista){
            String tmp = "";
            tmp = game.getWinner()+" won with the "+game.getWinColor()+" color, Points: "+game.getPoint();
            list.add(tmp);
        }
        toplistanezet.getItems().setAll(list);
        System.out.println(list.size());
    }

}

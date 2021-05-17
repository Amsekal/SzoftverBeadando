package jatek;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import Model.Player;
import Model.GameModel;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class DominoStartController {

    private GameModel gameState;

    private Player player;


    @FXML
    private Label blueName;
    @FXML
    private Label redName;
    @FXML
    private Label rpoint;
    @FXML
    private Label bpoint;

    private String username;
    private String username2;
    public void setUsername(String username, String username2){
        this.username = username;
        this.username2 = username2;
        redName.setText(username);
        blueName.setText(username2);
    }



        @FXML
        private GridPane board;

        @FXML
        private void initialize() {
            gameState= new GameModel();
            player=GameModel.activePlayer;
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7/*board.getColumnCount()*/; j++) {
                    var square = createSquare();
                    board.add(square, j, i);
                }
            }
        }

        private StackPane createSquare() {
            var square = new StackPane();
            square.getStyleClass().add("square");
            var piece = new Circle(50);
            piece.setFill(Color.WHITE);
            square.getChildren().add(piece);
            square.setOnMouseClicked(this::handleMouseClick);
            return square;
        }

        @FXML
        private void handleMouseClick(MouseEvent event) {
            var square = (StackPane) event.getSource();
            var row = GridPane.getRowIndex(square);
            var col = GridPane.getColumnIndex(square);
            System.out.printf("Click on square (%d,%d)\n", row, col);
            var coin = (Circle) square.getChildren().get(0);




            if(gameState.didEnd()==false) {
                if (coin.getFill().equals(Color.WHITE)) {
                    if (player == Player.ONE) {
                        player = Player.TWO;
                        coin.setFill(Color.RED);
                        gameState.NewRed();

                    } else if (player == Player.TWO) {
                        player = Player.ONE;
                        coin.setFill(Color.BLUE);
                        gameState.NewBlue();


                    }
                } else if (coin.getFill().equals(Color.BLUE)) {
                    if (player == Player.ONE) {
                        player = Player.TWO;
                        coin.setFill(Color.GREEN);
                        gameState.LessBlue();
                    } else if (player == Player.TWO) {
                        player = Player.ONE;
                        coin.setFill(Color.GREEN);
                        gameState.LessBlue();


                    }
                } else if (coin.getFill().equals(Color.RED)) {
                    if (player == Player.ONE) {
                        player = Player.TWO;
                        coin.setFill(Color.GREEN);
                        gameState.LessRed();
                    } else if (player == Player.TWO) {
                        player = Player.ONE;
                        coin.setFill(Color.GREEN);
                        gameState.LessRed();
                    }
                } else if (coin.getFill().equals(Color.GREEN)) {
                    if (player == Player.ONE) {
                        player = Player.TWO;
                        coin.setFill(Color.ORANGE);
                        gameState.NewOrange();

                    } else if (player == Player.TWO) {
                        player = Player.ONE;
                        coin.setFill(Color.ORANGE);
                        gameState.NewOrange();


                    }
                }

            }
            rpoint.setText(Integer.toString(gameState.R_num()));
            bpoint.setText(Integer.toString(gameState.B_num()));

        }

    @FXML
    public void endScene(ActionEvent actionEvent) throws IOException {
            if(gameState.didEnd()) {
                if(gameState.finalPoint()==1)
                    adatb.Handler.insertResults(username,"RED",gameState.R_num()-gameState.B_num());
                if(gameState.finalPoint()==2)
                    adatb.Handler.insertResults(username2,"BLUE",gameState.B_num()-gameState.R_num());
                if(gameState.finalPoint()==0)
                    adatb.Handler.insertResults("Deuce","No",0);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/End.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            }


    }



    }


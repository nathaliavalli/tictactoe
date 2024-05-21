import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class ticTacToe extends Application {

    String player1 = "X";
    String player2 = "O";
    String currentPlayer = player1;
    private TextField player1Name;
    private TextField player2Name;  
    
    @Override
    public void start(Stage primaryStage) throws Exception {
      
      Button buttonNewGame = new Button("Restart");
      buttonNewGame.setOnAction(new ButtonClickHandler1());
      Button buttonTutorial = new Button("Tutorial");
      buttonTutorial.setOnAction(new ButtonClickHandler2());

                    
        Label labelBox1 = new Label("Insert player 1 name"); 
        player1Name = new TextField("");
        Label labelBox2 = new Label ("Player 1 is X");
        HBox HBoxPlayer1 = new HBox (20, labelBox1, player1Name, labelBox2);
        HBoxPlayer1.setAlignment(Pos.CENTER);
                           
        Label labelBox3 = new Label("Insert player 2 name"); 
        player2Name = new TextField("");
        Label labelBox4 = new Label ("Player 2 is O ");
        HBox HBoxPlayer2 = new HBox (20, labelBox3, player2Name, labelBox4);
        HBoxPlayer2.setAlignment(Pos.CENTER);
        
        
        //Root node in the scene
        VBox gameRoot = new VBox(20, HBoxPlayer1,HBoxPlayer2, buttonNewGame, buttonTutorial);
        HBox playerField = new HBox();
        
        
        
        //Adding root node the scene
        Scene scene = new Scene(gameRoot, 800,800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TIC-TAC-TOE");
        primaryStage.show();
         
        GridPane playFieldPane = new GridPane();
        Button[][] buttonArray = new Button[3][3];

        GridPane shadowFieldPane = new GridPane();
        Button[][] shadowArray = new Button[3][3];
         //set uo the main pane
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                buttonArray[i][j] = new Button();
                buttonArray[i][j].setMinSize(100,100);
                buttonArray[i][j].setMaxSize(100,100);
                playFieldPane.add(buttonArray[i][j], j , i);
            }
        }
         //set uo the shadow pane
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                shadowArray[i][j] = new Button();
                shadowArray[i][j].setMouseTransparent(true);//to block the user of clicking on the shadow
                shadowArray[i][j].setMinSize(100,100);
                shadowArray[i][j].setMaxSize(100,100);
                shadowFieldPane.add(shadowArray[i][j], j , i);
            }
        }

        buttonArray[0][0].setOnAction(event ->  {
            buttonArray[0][0].setText(currentPlayer);
            buttonArray[0][0].setMouseTransparent(true);
            shadowArray[0][2].setText(currentPlayer);

            popUpIfWinnerIsFound(buttonArray, shadowArray, primaryStage);

            if(currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        });

        buttonArray[0][1].setOnAction(event ->  {
            buttonArray[0][1].setText(currentPlayer);
            buttonArray[0][1].setMouseTransparent(true);
            shadowArray[2][1].setText(currentPlayer);

            popUpIfWinnerIsFound(buttonArray, shadowArray, primaryStage);

            if(currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        });

        buttonArray[0][2].setOnAction(event ->  {
            buttonArray[0][2].setText(currentPlayer);
            buttonArray[0][2].setMouseTransparent(true);
            shadowArray[0][0].setText(currentPlayer);

            popUpIfWinnerIsFound(buttonArray, shadowArray, primaryStage);

            if(currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        });

        buttonArray[1][0].setOnAction(event ->  {
            buttonArray[1][0].setText(currentPlayer);
            buttonArray[1][0].setMouseTransparent(true);
            shadowArray[1][2].setText(currentPlayer);

            popUpIfWinnerIsFound(buttonArray, shadowArray, primaryStage);

            if(currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        });

        buttonArray[1][1].setOnAction(event ->  {
            buttonArray[1][1].setText(currentPlayer);
            buttonArray[1][1].setMouseTransparent(true);
            shadowArray[2][0].setText(currentPlayer);

            popUpIfWinnerIsFound(buttonArray, shadowArray, primaryStage);

            if(currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        });

        buttonArray[1][2].setOnAction(event ->  {
            buttonArray[1][2].setText(currentPlayer);
            buttonArray[1][2].setMouseTransparent(true);
            shadowArray[1][0].setText(currentPlayer);

            popUpIfWinnerIsFound(buttonArray, shadowArray, primaryStage);

            if(currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        });

        buttonArray[2][0].setOnAction(event ->  {
            buttonArray[2][0].setText(currentPlayer);
            buttonArray[2][0].setMouseTransparent(true);
            shadowArray[2][2].setText(currentPlayer);

            popUpIfWinnerIsFound(buttonArray, shadowArray, primaryStage);

            if(currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        });

        buttonArray[2][1].setOnAction(event ->  {
            buttonArray[2][1].setText(currentPlayer);
            buttonArray[2][1].setMouseTransparent(true);
            shadowArray[0][1].setText(currentPlayer);

            popUpIfWinnerIsFound(buttonArray, shadowArray, primaryStage);

            if(currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        });

        buttonArray[2][2].setOnAction(event ->  {
            buttonArray[2][2].setText(currentPlayer);
            buttonArray[2][2].setMouseTransparent(true);
            shadowArray[1][1].setText(currentPlayer);

            popUpIfWinnerIsFound(buttonArray, shadowArray, primaryStage);

            if(currentPlayer.equals(player1)) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        });

        playerField.setAlignment(Pos.CENTER);
        playerField.setSpacing(30);
        playerField.getChildren().addAll(playFieldPane, shadowFieldPane);

        gameRoot.getChildren().add(playerField);
    }

    public void popUpIfWinnerIsFound(Button[][] buttonArray, Button[][] shadowArray, Stage primaryStage){
        if(isWinner(buttonArray,currentPlayer) || isWinner(shadowArray,currentPlayer)) {
            Stage popUpStage = new Stage();
            popUpStage.initModality(Modality.APPLICATION_MODAL);
            popUpStage.initOwner(primaryStage);
            VBox popUpBox = new VBox(20);
            if(currentPlayer.equals(player1)) {
               popUpBox.getChildren().add(new Text(player1Name.getText() + " IS THE WINNER!!"));
            } else {
               popUpBox.getChildren().add(new Text(player2Name.getText() + " IS THE WINNER!!"));
            }
            
            Scene dialogScene = new Scene(popUpBox, 300, 200);
            popUpStage.setScene(dialogScene);
            popUpStage.show();
        }
    }



    public boolean isWinner(Button[][] buttons, String currentPlayer){

        if(buttons[0][0].getText().equals(currentPlayer) &&
                buttons[1][0].getText().equals(currentPlayer) &&
                buttons[2][0].getText().equals(currentPlayer) ) {
            return true;
        }

        if(buttons[0][1].getText().equals(currentPlayer) &&
                buttons[1][1].getText().equals(currentPlayer) &&
                buttons[2][1].getText().equals(currentPlayer) ) {
            return true;
        }

        if(buttons[0][2].getText().equals(currentPlayer) &&
                buttons[1][2].getText().equals(currentPlayer) &&
                buttons[2][2].getText().equals(currentPlayer) ) {
            return true;
        }

        if(buttons[0][0].getText().equals(currentPlayer) &&
                buttons[0][1].getText().equals(currentPlayer) &&
                buttons[0][2].getText().equals(currentPlayer) ) {
            return true;
        }

        if(buttons[1][0].getText().equals(currentPlayer) &&
                buttons[1][1].getText().equals(currentPlayer) &&
                buttons[1][2].getText().equals(currentPlayer) ) {
            return true;
        }

        if(buttons[2][0].getText().equals(currentPlayer) &&
                buttons[2][1].getText().equals(currentPlayer) &&
                buttons[2][2].getText().equals(currentPlayer) ) {
            return true;
        }

        if(buttons[0][0].getText().equals(currentPlayer) &&
                buttons[1][1].getText().equals(currentPlayer) &&
                buttons[2][2].getText().equals(currentPlayer) ) {
            return true;
        }

        if(buttons[0][2].getText().equals(currentPlayer) &&
                buttons[1][1].getText().equals(currentPlayer) &&
                buttons[2][0].getText().equals(currentPlayer) ) {
            return true;
        }

        return false;
    }
    
    class ButtonClickHandler1 implements EventHandler<ActionEvent>
         {
        @Override
           public void handle(ActionEvent event)
           {
            primaryStage.close();
            primaryStage.setScene( new Scene( new Pane( buttonNewGame ) ) );
            primaryStage.show();  
           } 
         }
        class ButtonClickHandler2 implements EventHandler<ActionEvent>
         {
        @Override
           public void handle(ActionEvent event)
           {
            System.out.println ("info about the game");
           } 
         }
       
    public static void main(String[] args) {
        launch(args);
    }
}

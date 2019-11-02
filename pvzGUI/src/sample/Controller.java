package sample;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Controller {
    public Button clickToSignup;
    public Button clickToStart;
    public Button clickToLogin;
    public ImageView textonlevelscreen;
    public Button level1Button;
    public GridPane lawngrid;
    public  Stage inGameMenuwindow;
    public StackPane sp00;
    public StackPane sp01;
    public StackPane sp02;
    public StackPane sp03;
    public StackPane sp04;
    public StackPane sp10;
    public StackPane sp11;
    public StackPane sp12;
    public StackPane sp13;
    public StackPane sp14;
    public StackPane sp20;
    public StackPane sp21;
    public StackPane sp22;
    public StackPane sp23;
    public StackPane sp24;
    public StackPane sp30;
    public StackPane sp31;
    public StackPane sp32;
    public StackPane sp33;
    public StackPane sp34;
    public StackPane sp40;
    public StackPane sp41;
    public StackPane sp42;
    public StackPane sp43;
    public StackPane sp44;
    public StackPane sp50;
    public StackPane sp51;
    public StackPane sp52;
    public StackPane sp53;
    public StackPane sp54;
    public StackPane sp60;
    public StackPane sp61;
    public StackPane sp62;
    public StackPane sp63;
    public StackPane sp64;
    public StackPane sp70;
    public StackPane sp71;
    public StackPane sp72;
    public StackPane sp73;
    public StackPane sp74;
    public StackPane sp80;
    public StackPane sp81;
    public StackPane sp82;
    public StackPane sp83;
    public StackPane sp84;


    @FXML
    private Pane sunflower;

    public void handleStart() throws IOException {
       LoginBox.getLogin();
       Main.window.close();
    }
    public void handleSignup() throws IOException {

        LoginBox.getSignup();
        LoginBox.loginwindow.close();
    }
    public void handleleveltexttransition(){
        FadeTransition ft = new FadeTransition();
        ft.setNode(textonlevelscreen);
      //  System.out.println(textonlevelscreen);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.playFromStart();

    }
    public void handleLogin() throws IOException {

        LoginBox.getLevelpage();
        LoginBox.loginwindow.close();
    }

    public void getInGameMenu() throws IOException {
        inGameMenuwindow = new Stage();
        inGameMenuwindow.initModality(Modality.APPLICATION_MODAL);
        Parent login = FXMLLoader.load(getClass().getResource("inGameMenu.fxml"));
        Scene scene1 = new Scene(login, 1028,702);
        Button inGameResume = (Button)scene1.lookup("#inGameResumeButton");
        inGameResume.setOnAction(event -> {
            inGameMenuwindow.close();
        });
        Button inGameMainMenuButton = (Button)scene1.lookup("#inGameMainMenuButton");
        inGameMainMenuButton.setOnAction(event -> {
            try {
                LoginBox.getLevelpage();
                inGameMenuwindow.close();
                Level1.level1window.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        inGameMenuwindow.setScene(scene1);
        inGameMenuwindow.setResizable(false);
        inGameMenuwindow.show();
    }

    public void dragSunflower(MouseEvent event){
        Dragboard db  = sunflower.startDragAndDrop(TransferMode.ANY);
        String sf = "sunflower";
        ClipboardContent cp = new ClipboardContent();
        cp.putString(sf);
        db.setContent(cp);
        event.consume();
    }
    public void dragOver(DragEvent event){
        if (event.getDragboard().hasString()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }
    public void dragDropped00(DragEvent event){
        String str = event.getDragboard().getString();
        drop(sp00, str);
    }
    public void dragDropped01(DragEvent event){
        String str = event.getDragboard().getString();
        drop(sp01, str);
    }
    public void dragDropped02(DragEvent event){
        String str = event.getDragboard().getString();
        drop(sp02, str);
    }
    public void dragDropped03(DragEvent event){
        String str = event.getDragboard().getString();
        drop(sp03, str);
    }
    public void dragDropped04(DragEvent event) {
        String str = event.getDragboard().getString();
        drop(sp04, str);
    }
    

    private void drop(Pane s, String str){
        if (str.equals("sunflower")){
            s.getChildren().add(new ImageView(new Image(String.valueOf(getClass().getResource("resources/spritesNStuff/sun_flower.gif")))));
        }
    }



    public void handleDrag(){
        System.out.println("sir arka god");
    }

}

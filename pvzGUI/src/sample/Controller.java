package sample;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

//import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class Controller {
    public static GameScreen gameScreen;
    public Button clickToSignup;
    public Button clickToStart;
    public Button clickToLogin;
    public ImageView textonlevelscreen;
    public Button level1Button;
    public GridPane lawngrid;
    public Stage inGameMenuwindow;
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
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Pane sunflower;

    @FXML
    private Pane wallnut;
    @FXML
    private Pane peaShooter;
    @FXML
    private Pane shovel;
    private MediaPlayer shovelSound= new MediaPlayer(new Media(Paths.get("D:\\Rachit\\Semester 3\\AP\\Plants-vs-Zombies\\pvzGUI\\src\\sample\\resources\\sounds\\shovel.mp3").toUri().toString()));

    public void handleStart() throws IOException {
//        i
            LoginBox.getLogin();
            Main.window.close();
//        }
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
//        System.out.println(username.getText()+ " "+ password);
//        if (username.getText().equals("admin") && password.getText().equals("admin")) {
            LoginBox.getLevelpage();
            LoginBox.loginwindow.close();
//        }
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
                Level1.levelwindow.close();
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
    public void dragPeaShooter(MouseEvent event){
        Dragboard db  = peaShooter.startDragAndDrop(TransferMode.ANY);
        String sf = "peaShooter";
        ClipboardContent cp = new ClipboardContent();
        cp.putString(sf);
        db.setContent(cp);
        event.consume();
    }
    public void dragShovel(MouseEvent event){
        Dragboard db  = shovel.startDragAndDrop(TransferMode.ANY);
        String sf = "shovel";
        ClipboardContent cp = new ClipboardContent();
        cp.putString(sf);
        db.setContent(cp);
        event.consume();
    }

    public void dragWallNut(MouseEvent event) {
        Dragboard db  = wallnut.startDragAndDrop(TransferMode.ANY);
        String sf = "wallnut";
        System.out.println("drag ho raha hai tera bhai");
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
    public void dragDropped00(DragEvent event){ String str = event.getDragboard().getString(); drop(sp00, str, new int[]{0,0});}
    public void dragDropped01(DragEvent event){ String str = event.getDragboard().getString(); drop(sp01, str, new int[]{0,1});}
    public void dragDropped02(DragEvent event){ String str = event.getDragboard().getString(); drop(sp02, str, new int[]{0,2});}
    public void dragDropped03(DragEvent event){ String str = event.getDragboard().getString(); drop(sp03, str, new int[]{0,3});}
    public void dragDropped04(DragEvent event){ String str = event.getDragboard().getString(); drop(sp04, str, new int[]{0,4});}
    public void dragDropped10(DragEvent event){ String str = event.getDragboard().getString(); drop(sp10, str, new int[]{1,0});}
    public void dragDropped11(DragEvent event){ String str = event.getDragboard().getString(); drop(sp11, str, new int[]{1,1});}
    public void dragDropped12(DragEvent event){ String str = event.getDragboard().getString(); drop(sp12, str, new int[]{1,2});}
    public void dragDropped13(DragEvent event){ String str = event.getDragboard().getString(); drop(sp13, str, new int[]{1,3});}
    public void dragDropped14(DragEvent event){ String str = event.getDragboard().getString(); drop(sp14, str, new int[]{1,4});}
    public void dragDropped20(DragEvent event){ String str = event.getDragboard().getString(); drop(sp20, str, new int[]{2,0});}
    public void dragDropped21(DragEvent event){ String str = event.getDragboard().getString(); drop(sp21, str, new int[]{2,1});}
    public void dragDropped22(DragEvent event){ String str = event.getDragboard().getString(); drop(sp22, str, new int[]{2,2});}
    public void dragDropped23(DragEvent event){ String str = event.getDragboard().getString(); drop(sp23, str, new int[]{2,3});}
    public void dragDropped24(DragEvent event){ String str = event.getDragboard().getString(); drop(sp24, str, new int[]{2,4});}
    public void dragDropped30(DragEvent event){ String str = event.getDragboard().getString(); drop(sp30, str, new int[]{3,0});}
    public void dragDropped31(DragEvent event){ String str = event.getDragboard().getString(); drop(sp31, str, new int[]{3,1});}
    public void dragDropped32(DragEvent event){ String str = event.getDragboard().getString(); drop(sp32, str, new int[]{3,2});}
    public void dragDropped33(DragEvent event){ String str = event.getDragboard().getString(); drop(sp33, str, new int[]{3,3});}
    public void dragDropped34(DragEvent event){ String str = event.getDragboard().getString(); drop(sp34, str, new int[]{3,4});}
    public void dragDropped40(DragEvent event){ String str = event.getDragboard().getString(); drop(sp40, str, new int[]{4,0});}
    public void dragDropped41(DragEvent event){ String str = event.getDragboard().getString(); drop(sp41, str, new int[]{4,1});}
    public void dragDropped42(DragEvent event){ String str = event.getDragboard().getString(); drop(sp42, str, new int[]{4,2});}
    public void dragDropped43(DragEvent event){ String str = event.getDragboard().getString(); drop(sp43, str, new int[]{4,3});}
    public void dragDropped44(DragEvent event){ String str = event.getDragboard().getString(); drop(sp44, str, new int[]{4,4});}
    public void dragDropped50(DragEvent event){ String str = event.getDragboard().getString(); drop(sp50, str, new int[]{5,0});}
    public void dragDropped51(DragEvent event){ String str = event.getDragboard().getString(); drop(sp51, str, new int[]{5,1});}
    public void dragDropped52(DragEvent event){ String str = event.getDragboard().getString(); drop(sp52, str, new int[]{5,2});}
    public void dragDropped53(DragEvent event){ String str = event.getDragboard().getString(); drop(sp53, str, new int[]{5,3});}
    public void dragDropped54(DragEvent event){ String str = event.getDragboard().getString(); drop(sp54, str, new int[]{5,4});}
    public void dragDropped60(DragEvent event){ String str = event.getDragboard().getString(); drop(sp60, str, new int[]{6,0});}
    public void dragDropped61(DragEvent event){ String str = event.getDragboard().getString(); drop(sp61, str, new int[]{6,1});}
    public void dragDropped62(DragEvent event){ String str = event.getDragboard().getString(); drop(sp62, str, new int[]{6,2});}
    public void dragDropped63(DragEvent event){ String str = event.getDragboard().getString(); drop(sp63, str, new int[]{6,3});}
    public void dragDropped64(DragEvent event){ String str = event.getDragboard().getString(); drop(sp64, str, new int[]{6,4});}
    public void dragDropped70(DragEvent event){ String str = event.getDragboard().getString(); drop(sp70, str, new int[]{7,0});}
    public void dragDropped71(DragEvent event){ String str = event.getDragboard().getString(); drop(sp71, str, new int[]{7,1});}
    public void dragDropped72(DragEvent event){ String str = event.getDragboard().getString(); drop(sp72, str, new int[]{7,2});}
    public void dragDropped73(DragEvent event){ String str = event.getDragboard().getString(); drop(sp73, str, new int[]{7,3});}
    public void dragDropped74(DragEvent event){ String str = event.getDragboard().getString(); drop(sp74, str, new int[]{7,4});}
    public void dragDropped80(DragEvent event){ String str = event.getDragboard().getString(); drop(sp80, str, new int[]{8,0});}
    public void dragDropped81(DragEvent event){ String str = event.getDragboard().getString(); drop(sp81, str, new int[]{8,1});}
    public void dragDropped82(DragEvent event){ String str = event.getDragboard().getString(); drop(sp82, str, new int[]{8,2});}
    public void dragDropped83(DragEvent event){ String str = event.getDragboard().getString(); drop(sp83, str, new int[]{8,3});}
    public void dragDropped84(DragEvent event){ String str = event.getDragboard().getString(); drop(sp84, str, new int[]{8,4});}


    private void drop(Pane s, String str, int[] position){
        if (s.getChildren().size()==0 && str.equals("sunflower") && gameScreen.getSunFlowerAvailable()){
            int prev = gameScreen.getSunTokens();
            if(prev-50>=0){
                Sunflower p = new Sunflower(position,gameScreen);
                gameScreen.addPlant(position,p);
                gameScreen.setSunTokens(prev - p.getCost());
                s.getChildren().add(p.getPlantImage());
                p.produceSuns();
            }
        }
        else if (s.getChildren().size()==0 && str.equals("peaShooter") && gameScreen.getPeaShooterAvailable()){
            int prev = gameScreen.getSunTokens();
            if(prev-100>=0){
                NormalPeaShooter p = new NormalPeaShooter(position,gameScreen);
                gameScreen.addPlant(position,p);
                gameScreen.setSunTokens(prev - p.getCost());
                s.getChildren().add(p.getPlantImage());
            }
        }
        else if(s.getChildren().size()==0 && str.equals("wallnut") && gameScreen.getWallNutAvailable()){
            System.out.println("drag ho gaya hu mai chutiye");
            int prev = gameScreen.getSunTokens();
            if(prev-50>=0){
                WallNut p = new WallNut(position,gameScreen);
                gameScreen.addPlant(position,p);
                gameScreen.setSunTokens(prev - p.getCost());
                s.getChildren().add(p.getPlantImage());
            }
        }
        else if (str.equals("shovel")){
            if (gameScreen.getGarden()[position[0]][position[1]]!=null){
                shovelSound.play();
                gameScreen.removePlant(position[0],position[1]);
            }
        }
    }



    public void handleDrag(){
        System.out.println("sir arka god");
    }

    public  static  void setGameScreen(GameScreen g) {
        gameScreen = g;

    }

}

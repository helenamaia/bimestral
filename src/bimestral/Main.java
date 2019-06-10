package bimestral;


import bimestral.control.JanelaBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import bimestral.model.Jogo;


import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        Pane root = loadMainPane();

        stage.setScene(new Scene(root,800,600));

        stage.setTitle("Jogo");
        stage.show();

    }


    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();




        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        NavegadorCenas.BASE
                )
        );

        JanelaBase controller = loader.getController();

        NavegadorCenas.setControlador(controller);
        NavegadorCenas.loadJanela(NavegadorCenas.PRINCIPAL);

        return mainPane;
    }


    @Override
    public void init() throws Exception {
        super.init();

        try{
            Jogo.getInstance().carregaDados();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();

        try{
            Jogo.getInstance().salvaDados();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}


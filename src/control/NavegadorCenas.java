package control;

import control.JanelaBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class NavegadorCenas {

    public static final String BASE    = "../view/base1.fxml";
    public static final String PRINCIPAL = "../view/principal1.fxml";


    private static JanelaBase controlador;

    public static void setControlador(JanelaBase controlador) {
        NavegadorCenas.controlador = controlador;
    }


    public static void loadJanela(String fxml) {
        try {
            controlador.setJanela(
                    (Node) FXMLLoader.load(
                            NavegadorCenas.class.getResource(
                                    fxml
                            )
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

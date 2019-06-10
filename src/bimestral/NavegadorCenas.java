package bimestral;

import bimestral.control.JanelaBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import java.io.IOException;

public class NavegadorCenas {

    public static final String BASE    = "/bimestral/view/base.fxml";
    public static final String PRINCIPAL = "/bimestral/view/principal.fxml";


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

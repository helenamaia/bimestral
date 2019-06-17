package bimestral;

import bimestral.control.JanelaBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class NavegadorCenas {

    public static final String BASE    = "/bimestral/view/base.fxml";
    public static final String PRINCIPAL = "/bimestral/view/principal.fxml";
    public static final String ENTRAR = "/bimestral/view/entrar.fxml";
    public static final String AJUDA = "/bimestral/view/ajuda.fxml";
    public static final String CADASTRAR = "/bimestral/view/cadastrar.fxml";
    public static final String JOGAR = "/bimestral/view/jogar.fxml";
    public static final String FIM = "/bimestral/view/fim.fxml";
    public static final String RANKING = "/bimestral/view/ranking.fxml";


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

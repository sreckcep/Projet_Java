package GUI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * classe principale qui contiendra le reste des composants
 */
public class MainFrame extends Frame {

    public MainFrame(){
        super("Board display");
        setSize(720, 480);
        setVisible(true);

        //assure l'arrêt du programme à la fermeture de la fenêtre
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  dispose();
                                  System.exit(0);
                              }
                          }
        );
    }
}

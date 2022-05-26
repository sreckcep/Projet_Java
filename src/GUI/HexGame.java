package GUI;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Hexagons.Layout;
import Hexagons.Point;

/**
 * classe principale qui contiendra le reste des composants
 */
public class HexGame extends Frame {

    public HexGame(){
        initUI();
    }

    private void initUI(){
        setTitle("HexGame");
        setSize(1000, 1000);
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

    public static void main(String[] args){
        HexGame game = new HexGame();
        Board board = new Board(new Layout(Layout.pointy, new Point(40, 40), new Point(300, 300)));
        game.add(board);
        game.validate();
        board.start();
    }

    
}

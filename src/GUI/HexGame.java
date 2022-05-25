package GUI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Game.Cell;
import Hexagons.Hex;

/**
 * classe principale qui contiendra le reste des composants
 */
public class HexGame extends Frame {

    public HexGame(){
        initUI();
    }

    private void initUI(){
        setTitle("HexGame");
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

    public Map<int[],Cell> getGameCells(){
        //temporary
        int mapSize = 3;
        //creates a map of size mapSize
        Map<int[], Cell> cells = new HashMap<int[], Cell>();
        Hex baseHex = 
        cells.add(new Hex(0, 0, 0));
        for (int i = 0; i < mapSize; i++) {
            for (Hex hex : cells) {
                cells.addAll(hex.neighbors());
            } 
        }
    }
    public static void main(String[] args){
        HexGame game = new HexGame();
        Board board = new Board();
        game.add(board);
        game.validate();
    }

    
}

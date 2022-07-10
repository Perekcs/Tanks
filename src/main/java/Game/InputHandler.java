package Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;


public class InputHandler implements KeyListener {
    private int moveHorizontal = 0;
    private int moveVertical = 0;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    public int getMoveHorizontal() {
        return moveHorizontal;
    }
    public int getMoveVertical() {
        return moveVertical;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (VK_W == e.getKeyCode()){
            moveVertical = -1;
        }
        if  (VK_S == e.getKeyCode()){
           moveVertical = 1;
        }
        if (VK_D == e.getKeyCode()){
            moveHorizontal = 1;
        }
        if (VK_A == e.getKeyCode()){
            moveHorizontal = -1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (VK_W == e.getKeyCode()){
            moveVertical = 0;
        }
        if  (VK_S == e.getKeyCode()){
            moveVertical = 0;
        }
        if (VK_D == e.getKeyCode()){
            moveHorizontal = 0;
        }
        if (VK_A == e.getKeyCode()){
            moveHorizontal = 0;
        }

    }
}

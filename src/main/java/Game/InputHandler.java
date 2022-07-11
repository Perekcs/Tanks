package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;


public class InputHandler implements KeyListener {
    private int moveHorizontal = 0;
    private int moveVertical = 0;
    private boolean isFiring = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public int getMoveHorizontal() {
        return moveVertical != 0 ? 0 : moveHorizontal;
    }

    public int getMoveVertical() {
        return moveVertical;
    }

    public boolean isFiring() {
        return isFiring;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_W -> moveVertical = 1;
            case VK_S -> moveVertical = -1;
            case VK_D -> moveHorizontal = 1;
            case VK_A -> moveHorizontal = -1;
            case VK_SPACE -> isFiring = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_W, VK_S -> moveVertical = 0;
            case VK_D, VK_A -> moveHorizontal = 0;
            case VK_SPACE -> isFiring = false;
        }
    }
}

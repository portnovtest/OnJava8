package onjava;

// Helper interface to allow lambda expressions.

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Default everything except mouseClicked():
public interface MouseClick extends MouseListener {
    @Override
    default void mouseEntered(MouseEvent e) {
    }

    @Override
    default void mouseExited(MouseEvent e) {
    }

    @Override
    default void mousePressed(MouseEvent e) {
    }

    @Override
    default void mouseReleased(MouseEvent e) {
    }


}

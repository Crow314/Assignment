import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MouseEvListener implements MouseInputListener {
    private Frame frame;
    private Graphics graphics;

    MouseEvListener(JFrame frame, Graphics graphics){
        this.frame = frame;
        this.graphics = graphics;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        graphics.fillOval(e.getX(), e.getY(), 2, 2);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        graphics.fillOval(e.getX(), e.getY(), 2, 2);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        graphics.fillOval(e.getX(), e.getY(), 2, 2);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
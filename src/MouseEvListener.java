import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MouseEvListener implements MouseInputListener {
    public static final int MODE_DRAW = 0;
    public static final int MODE_LINE = 1;
    public static final int MODE_TRIANGLE = 2;

    private Frame frame;
    private Graphics graphics;
    private int mode;
    private MouseEvent[] clickEventLog;
    private MouseEvent dragLastEvent;

    MouseEvListener(JFrame frame, Graphics graphics){
        this.frame = frame;
        this.graphics = graphics;
        this.clickEventLog = new MouseEvent[2];
        this.mode = MODE_DRAW;
    }

    public void setMode(int mode) {
        this.mode = mode;
        clickEventLog[0] = null;
        clickEventLog[1] = null;
    }

    private void drawLine(MouseEvent e1, MouseEvent e2){
        graphics.drawLine(e1.getX(), e1.getY(), e2.getX(), e2.getY());
    }

    private void drawTriangle(MouseEvent e1, MouseEvent e2, MouseEvent e3){
        drawLine(e1, e2);
        drawLine(e2, e3);
        drawLine(e3, e1);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (mode){
            case MODE_DRAW:
                break;

            case MODE_LINE:
                if(clickEventLog[0] == null){
                    clickEventLog[0] = e;
                }else {
                    drawLine(clickEventLog[0], e);
                    clickEventLog[0] = null;
                    setMode(MODE_DRAW);
                }
                break;

            case MODE_TRIANGLE:
                if(clickEventLog[0] == null){
                    clickEventLog[0] = e;
                }else if(clickEventLog[1] == null){
                    clickEventLog[1] = e;
                }else {
                    drawTriangle(clickEventLog[0], clickEventLog[1], e);
                    clickEventLog[0] = null;
                    clickEventLog[1] = null;
                    setMode(MODE_DRAW);
                }
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        dragLastEvent = null;
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
        if(dragLastEvent != null){
            drawLine(dragLastEvent, e);
        }
        dragLastEvent = e;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
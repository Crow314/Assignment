import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorPickerFrame extends JFrame implements ChangeListener {

    public static final int MODE_STROKE_COLOR = 0;
    public static final int MODE_BG_COLOR = 1;

    private PaintCanvas canvas;
    private int mode;

    private JColorChooser colorChooser;

    ColorPickerFrame(PaintCanvas canvas){
        super("色を選ぶドン");

        this.canvas = canvas;
        this.mode = MODE_STROKE_COLOR;

        setSize(480, 270);
        setLocation(300, 200);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        setAlwaysOnTop(true);

        colorChooser = new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(this);

        getContentPane().add(colorChooser, BorderLayout.CENTER);
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        Color color = colorChooser.getColor();

        switch (mode){
            case MODE_STROKE_COLOR:
                canvas.setStrokeColor(color);
                break;

            case MODE_BG_COLOR:
                canvas.setBGColor(color);
                break;
        }
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}

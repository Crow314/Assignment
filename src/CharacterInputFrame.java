import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterInputFrame extends JFrame {

    private PaintCanvas canvas;

    private JTextField textField;
    private JLabel posLabel;
    private JButton drawButton;

    private Point characterPos;

    CharacterInputFrame(PaintCanvas canvas){
        super("文字入力");

        this.canvas = canvas;
        characterPos = null;

        setSize(300, 200);
        setLocation(300, 200);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 28));
        textField.setBounds(20,10, 250, 28);
        textField.addActionListener(new DrawAction());
        this.add(textField);

        posLabel = new JLabel();
        posLabel.setBounds(20, 50, 80, 56);
        this.add(posLabel);

        drawButton = new JButton("Draw");
        drawButton.setBounds(200, 130, 80, 28);
        drawButton.addActionListener(new DrawAction());
        this.add(drawButton);
    }

    public void setPosition(Point pos){
        this.characterPos = pos;
        posLabel.setText("<html>" + "X:" + (int)pos.getX() + "<br>" + "Y:" + (int)pos.getY() + "</html>");
    }

    private class DrawAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.drawText(characterPos, textField.getText());
            textField.setText("");
            CharacterInputFrame.this.setVisible(false);
        }
    }
}

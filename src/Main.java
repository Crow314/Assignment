import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("えむえすぺいんと");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        Graphics graphics = frame.getGraphics();

        MouseInputListener mouseEvListener = new MouseEvListener(frame, graphics);

        JButton blackButton = new JButton("black");
        blackButton.setSize(80, 28);
        blackButton.setLocation(20, 400);
        frame.add(blackButton);
        blackButton.addActionListener(new ActionListener() {
            Graphics graphics;

            @Override
            public void actionPerformed(ActionEvent e) {
                graphics.setColor(new Color(0, 0, 0));
            }

            public ActionListener setParam(Graphics graphics){
                this.graphics = graphics;
                return this;
            }
        }.setParam(graphics));

        JButton redButton = new JButton("red");
        redButton.setSize(80, 28);
        redButton.setLocation(120, 400);
        frame.add(redButton);
        redButton.addActionListener(new ActionListener() {
            Graphics graphics;

            @Override
            public void actionPerformed(ActionEvent e) {
                graphics.setColor(new Color(255, 0, 0));
            }

            public ActionListener setParam(Graphics graphics){
                this.graphics = graphics;
                return this;
            }
        }.setParam(graphics));

        frame.addMouseListener(mouseEvListener);
        frame.addMouseMotionListener(mouseEvListener);
    }
}
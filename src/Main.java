import javax.swing.*;
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

        frame.setVisible(false);

        MouseEvListener mouseEvListener = new MouseEvListener(frame, graphics);

        JButton blackButton = new JButton("black");
        blackButton.setSize(80, 28);
        blackButton.setLocation(20, 400);
        frame.add(blackButton);
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphics.setColor(new Color(0, 0, 0));
            }
        });

        JButton redButton = new JButton("red");
        redButton.setSize(80, 28);
        redButton.setLocation(120, 400);
        frame.add(redButton);
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphics.setColor(new Color(255, 0, 0));
            }
        });

        frame.addMouseListener(mouseEvListener);
        frame.addMouseMotionListener(mouseEvListener);

        JButton lineButton = new JButton("line");
        lineButton.setSize(80, 28);
        lineButton.setLocation(300, 400);
        frame.add(lineButton);
        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mouseEvListener.setMode(MouseEvListener.MODE_LINE);
            }
        });

        JButton triangleButton = new JButton("triangle");
        triangleButton.setSize(80, 28);
        triangleButton.setLocation(400, 400);
        frame.add(triangleButton);
        triangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mouseEvListener.setMode(MouseEvListener.MODE_TRIANGLE);
            }
        });

        frame.setVisible(true);
    }
}
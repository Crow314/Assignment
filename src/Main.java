import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("加減算器");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        JLabel countLabel = new JLabel("0");
        countLabel.setBounds(90, 10, 20, 28);
        frame.add(countLabel);

        JButton minusButton = new JButton("-1");
        minusButton.setSize(80, 28);
        minusButton.setLocation(10, 50);
        frame.add(minusButton);
        minusButton.addActionListener(new ActionListener() {
            JLabel mLabel;

            @Override
            public void actionPerformed(ActionEvent e) {
                int count = Integer.parseInt(mLabel.getText());
                count--;
                mLabel.setText(Integer.toString(count));
            }

            public ActionListener setParam(JLabel label){
                mLabel = label;
                return this;
            }
        }.setParam(countLabel));

        JButton plusButton = new JButton("+1");
        plusButton.setSize(80, 28);
        plusButton.setLocation(100, 50);
        frame.add(plusButton);
        plusButton.addActionListener(new ActionListener() {
            JLabel mLabel;

            @Override
            public void actionPerformed(ActionEvent e) {
                int count = Integer.parseInt(mLabel.getText());
                count++;
                mLabel.setText(Integer.toString(count));
            }

            public ActionListener setParam(JLabel label){
                mLabel = label;
                return this;
            }
        }.setParam(countLabel));

        frame.setVisible(true);
    }
}
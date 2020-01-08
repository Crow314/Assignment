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

        int[] count = {0};

        JLabel countLabel = new JLabel(Integer.toString(count[0]));
        countLabel.setBounds(90, 10, 20, 28);
        frame.add(countLabel);

        JButton minusButton = new JButton("-1");
        minusButton.setSize(80, 28);
        minusButton.setLocation(10, 50);
        frame.add(minusButton);
        minusButton.addActionListener(new ActionListener() {
            JLabel mLabel;
            int[] mCount;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("- : " + mCount[0]);
                mCount[0]--;
                mLabel.setText(Integer.toString(mCount[0]));
            }

            public ActionListener setParam(JLabel label, int[] count){
                mLabel = label;
                mCount = count;
                return this;
            }
        }.setParam(countLabel, count));

        JButton plusButton = new JButton("+1");
        plusButton.setSize(80, 28);
        plusButton.setLocation(100, 50);
        frame.add(plusButton);
        plusButton.addActionListener(new ActionListener() {
            JLabel mLabel;
            int[] mCount;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("+ : " + mCount[0]);
                mCount[0]++;
                mLabel.setText(Integer.toString(mCount[0]));
            }

            public ActionListener setParam(JLabel label, int[] count){
                mLabel = label;
                mCount = count;
                return this;
            }
        }.setParam(countLabel, count));

        frame.setVisible(true);
    }
}
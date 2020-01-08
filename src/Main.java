import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("加減算器");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        int initValue = 50;

        JLabel countLabel = new JLabel(Integer.toString(initValue));
        countLabel.setBounds(80, 10, 40, 28);
        countLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(countLabel);

        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL, initValue, 10, 0, 110);
        scrollBar.setBounds(20, 50, 160, 30);
        frame.add(scrollBar);

        JLabel graph = new JLabel();
        graph.setBounds(20, 100, (int)(160*((double)initValue/100)), 28);
        graph.setBorder(new LineBorder(Color.BLACK, 1, false));
        frame.add(graph);

        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            JLabel mCount;
            JLabel mGraph;

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                mCount.setText(Integer.toString(e.getValue()));
                graph.setBounds(20, 100, (int)(160*((double)e.getValue()/100)), 28);
            }

            public AdjustmentListener setParam(JLabel count, JLabel graph){
                mCount = count;
                mGraph = graph;
                return this;
            }
        }.setParam(countLabel, graph));

        frame.setVisible(true);
    }
}
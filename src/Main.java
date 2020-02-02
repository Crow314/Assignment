import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("えむえすぺいんと");
        int windowWidth = 1440;
        int windowHeight = 810;
        int sideMenuWidth = 250;
        frame.setSize(windowWidth, windowHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        JMenuBar menuBar = new JMenuBar();

        //ColorMenu
        JMenu colorMenu = new JMenu("Color");
        ButtonGroup colorChoiceGroup = new ButtonGroup();
        List<JMenuItem> colorMenuItems = new ArrayList<>();
        colorMenuItems.add(new JRadioButtonMenuItem("Black"));
        colorMenuItems.add(new JRadioButtonMenuItem("Red"));
        colorMenuItems.add(new JRadioButtonMenuItem("Blue"));
        colorMenuItems.add(new JRadioButtonMenuItem("Yellow"));
        colorMenuItems.add(new JRadioButtonMenuItem("Green"));
        colorMenuItems.get(0).setSelected(true);
        for(JMenuItem menuItem : colorMenuItems){
            colorChoiceGroup.add(menuItem);
            colorMenu.add(menuItem);
        }
        menuBar.add(colorMenu);

        JMenu thicknessMenu = new JMenu("Thickness");
        ButtonGroup thicknessChoiceGroup = new ButtonGroup();
        List<JMenuItem> thicknessMenuItems = new ArrayList<>();
        thicknessMenuItems.add(new JRadioButtonMenuItem("Thin"));
        thicknessMenuItems.add(new JRadioButtonMenuItem("Regular"));
        thicknessMenuItems.add(new JRadioButtonMenuItem("Thick"));
        thicknessMenuItems.get(1).setSelected(true);
        for(JMenuItem menuItem : thicknessMenuItems){
            thicknessChoiceGroup.add(menuItem);
            thicknessMenu.add(menuItem);
        }
        menuBar.add(thicknessMenu);

        frame.setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        //panel.setSize(new Dimension(windowWidth - sideMenuWidth, windowHeight - menuBar.getHeight()));
        panel.setBounds(0, menuBar.getHeight(), windowWidth - sideMenuWidth, windowHeight - menuBar.getHeight());
        frame.getContentPane().add(panel);

        PaintCanvas canvas = new PaintCanvas(windowWidth - sideMenuWidth, windowHeight - menuBar.getHeight());
        panel.add(canvas);

        frame.setVisible(true);

        for(JMenuItem menuItem : colorMenuItems){
            menuItem.addActionListener(e -> {
                JMenuItem sourceItem = (JMenuItem) e.getSource();
                canvas.setStrokeColor(sourceItem.getText());
            });
        }

        for(JMenuItem menuItem : thicknessMenuItems){
            menuItem.addActionListener(e -> {
                JMenuItem sourceItem = (JMenuItem) e.getSource();
                canvas.setStrokeThickness(sourceItem.getText());
            });
        }

    }
}
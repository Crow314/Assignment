import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("えむえすぺいんと");
        JMenuBar menuBar = new JMenuBar();

        int canvasWidth = 1440;
        int canvasHeight = 810;
        int toolBoxWidth = 300;
        frame.setSize(canvasWidth + toolBoxWidth, canvasHeight + menuBar.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        // ColorMenu
        JMenu colorMenu = new JMenu("Color");
        ButtonGroup colorChoiceGroup = new ButtonGroup();
        List<JMenuItem> colorMenuItems = new ArrayList<>();
        colorMenuItems.add(new JRadioButtonMenuItem("Black"));
        colorMenuItems.add(new JRadioButtonMenuItem("Red"));
        colorMenuItems.add(new JRadioButtonMenuItem("Blue"));
        colorMenuItems.add(new JRadioButtonMenuItem("Yellow"));
        colorMenuItems.add(new JRadioButtonMenuItem("Green"));
        colorMenuItems.add(new JRadioButtonMenuItem("Rainbow"));
        colorMenuItems.get(0).setSelected(true);
        for(JMenuItem menuItem : colorMenuItems){
            colorChoiceGroup.add(menuItem);
            colorMenu.add(menuItem);
        }
        menuBar.add(colorMenu);

        // ThicknessMenu
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

        // Canvas
        JPanel paintPanel = new JPanel();
        paintPanel.setBounds(0, menuBar.getHeight(), canvasWidth, canvasHeight);
        frame.getContentPane().add(paintPanel);

        PaintCanvas canvas = new PaintCanvas(canvasWidth, canvasHeight);
        paintPanel.add(canvas);

        // ToolBox
        JPanel toolBoxPanel = new JPanel();
        toolBoxPanel.setBounds(canvasWidth, menuBar.getHeight(), toolBoxWidth, canvasHeight);
        toolBoxPanel.setLayout(new FlowLayout());
        frame.getContentPane().add(toolBoxPanel);

        String[] modeComboData = {"Pen", "Line", "Triangle"};
        JComboBox<String> modeComboBox = new JComboBox<>(modeComboData);
        modeComboBox.setPreferredSize(new Dimension(toolBoxWidth, 40));
        toolBoxPanel.add(modeComboBox);

        JButton clearButton = new JButton("CLEAR");
        toolBoxPanel.add(clearButton);


        frame.setVisible(true);

        for(JMenuItem menuItem : colorMenuItems){
            menuItem.addActionListener(actionEvent -> {
                JMenuItem sourceItem = (JMenuItem) actionEvent.getSource();
                canvas.setStrokeColor(sourceItem.getText());
            });
        }

        for(JMenuItem menuItem : thicknessMenuItems){
            menuItem.addActionListener(actionEvent -> {
                JMenuItem sourceItem = (JMenuItem) actionEvent.getSource();
                canvas.setStrokeThickness(sourceItem.getText());
            });
        }

        modeComboBox.addActionListener(actionEvent -> {
            @SuppressWarnings("unchecked")
            JComboBox<String> sourceComboBox = (JComboBox<String>) actionEvent.getSource();
            canvas.setMode(sourceComboBox.getItemAt(sourceComboBox.getSelectedIndex()));
        });

        clearButton.addActionListener(actionEvent -> canvas.clear());

    }
}
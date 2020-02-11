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

        // FileMenu
        JMenu fileMenu = new JMenu("File");
        JMenuItem openFileItem = new JMenuItem("Open");
        JMenuItem saveFileItem = new JMenuItem("Save");
        fileMenu.add(openFileItem);
        fileMenu.add(saveFileItem);
        menuBar.add(fileMenu);

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
        colorMenuItems.add(new JRadioButtonMenuItem("Select"));
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
        toolBoxPanel.setLayout(new BoxLayout(toolBoxPanel, BoxLayout.Y_AXIS));
        frame.getContentPane().add(toolBoxPanel);

        String[] modeComboData = {"Pen", "Line", "Triangle", "Character", "Eraser", "Star Stamp"};
        JComboBox<String> modeComboBox = new JComboBox<>(modeComboData);
        modeComboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        toolBoxPanel.add(modeComboBox);

        JScrollBar thicknessScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, canvas.getStrokeThickness(), 1, 1, 10);
        thicknessScrollBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        toolBoxPanel.add(thicknessScrollBar);

        JButton clearButton = new JButton("CLEAR");
        toolBoxPanel.add(clearButton);

        JButton changeBGButton = new JButton("Change BG");
        toolBoxPanel.add(changeBGButton);


        frame.setVisible(true);

        openFileItem.addActionListener(actionEvent -> canvas.openImage());
        saveFileItem.addActionListener(actionEvent -> canvas.saveImage());

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
                thicknessScrollBar.setValue(PaintCanvas.parseThickness(sourceItem.getText()));
            });
        }

        modeComboBox.addActionListener(actionEvent -> {
            @SuppressWarnings("unchecked")
            JComboBox<String> sourceComboBox = (JComboBox<String>) actionEvent.getSource();
            canvas.setMode(sourceComboBox.getItemAt(sourceComboBox.getSelectedIndex()));
        });

        thicknessScrollBar.addAdjustmentListener(adjustmentEvent -> canvas.setStrokeThickness(adjustmentEvent.getValue()));

        clearButton.addActionListener(actionEvent -> canvas.clear());

        changeBGButton.addActionListener(actionEvent -> canvas.showColorPicker(ColorPickerFrame.MODE_BG_COLOR));

    }
}
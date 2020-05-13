package sample;


import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Class name");
    private final JTextField classNameField = new JTextField(30);
    private final JLabel textLabel = new JLabel("Default text");
    private final JTextField textField = new JTextField(10);
    private final JButton createButton = new JButton("Add component");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        frame.setVisible(true);

        add(classNameLabel);
        add(classNameField);
        add(textLabel);
        add(textField);
        add(createButton);

        createButton.addActionListener(e -> {
            if(e.getSource() == createButton && classNameField.getText().length() > 0) {

                JComponent comp = null;
                try {
                    comp = createComponent(classNameField.getText());
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
                setComponentText(comp, textField.getText());
                frame.designPanel.addAtRandomLocation(comp);
            }
        });
    }

    private JComponent createComponent(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ClassLoader loader = this.getClass().getClassLoader();
        Class cls = loader.loadClass(className);

        Object obj = cls.getDeclaredConstructor().newInstance();

        JComponent comp = null;

        if(obj instanceof JComponent) {
            comp = (JComponent) obj;
        }

        return comp;
    }

    private void setComponentText(JComponent comp, String text) {
        JLabel label = new JLabel(text);

        comp.add(label);
    }
}
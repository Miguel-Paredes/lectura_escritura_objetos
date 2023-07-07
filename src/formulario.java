import javax.swing.*;

public class formulario {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel Panel;
    private JButton okButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("formulario");
        frame.setContentPane(new formulario().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

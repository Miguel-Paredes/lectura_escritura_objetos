import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formulario {
    private JTextField IngreNombre;
    private JTextField IngreEdad;
    private JTextField IngreCed;
    private JPanel Panel;
    private JButton okButton;
    private JLabel Nombre;
    private JLabel Cedula;
    private JLabel Edad;
    private JLabel resultado;

    public static void main(String[] args) {
        JFrame frame = new JFrame("formulario");
        frame.setContentPane(new formulario().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public formulario() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText(IngreNombre.getText()+IngreCed.getText()+IngreEdad.getText());
            }
        });
    }
}

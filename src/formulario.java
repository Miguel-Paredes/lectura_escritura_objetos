import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formulario {
    private JTextField IngreNombre;
    private JTextField IngreEdad;
    private JTextField IngreCed;
    private JPanel Panel;
    private JLabel Nombre;
    private JLabel Cedula;
    private JLabel Edad;
    private JButton guardar;
    private JButton cargar;
    private JLabel xd;

    public static void main(String[] args) {
        JFrame frame = new JFrame("formulario");
        frame.setContentPane(new formulario().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public formulario() {
        cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xd.setText(IngreNombre.getText()+IngreCed.getText()+IngreEdad.getText());
            }
        });
    }
}

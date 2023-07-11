import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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

    public String nomb = "";
    public int cedu;
    public int eda;

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public int getCedu() {
        return cedu;
    }

    public void setCedu(int cedu) {
        this.cedu = cedu;
    }

    public int getEda() {
        return eda;
    }

    public void setEda(int eda) {
        this.eda = eda;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario");
        formulario formulario = new formulario();
        frame.setContentPane(formulario.Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        String filePath = "datos.dat";
        MiClase datos = new MiClase(formulario.getNomb(), formulario.getCedu(), formulario.getEda());

        formulario.guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formulario.setNomb(formulario.IngreNombre.getText());
                formulario.setCedu(Integer.parseInt(formulario.IngreCed.getText()));
                formulario.setEda(Integer.parseInt(formulario.IngreEdad.getText()));

                formulario.xd.setText(formulario.getNomb() + formulario.getCedu() + formulario.getEda());

                try (FileOutputStream fileOut = new FileOutputStream(filePath);
                     ObjectOutputStream obOut = new ObjectOutputStream(fileOut)) {
                    obOut.writeObject(datos);
                    System.out.println("Archivo escrito correctamente");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        formulario.cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (FileInputStream fileIn = new FileInputStream(filePath);
                     ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
                    MiClase readObject = (MiClase) objIn.readObject();
                    formulario.setNomb(readObject.getNombre());
                    formulario.setCedu(readObject.getCedula());
                    formulario.setEda(readObject.getEdad());

                    formulario.xd.setText(formulario.getNomb() + formulario.getCedu() + formulario.getEda());
                    System.out.println("El objeto en disco es:\n" + readObject);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public formulario() {
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNomb(IngreNombre.getText());
                setCedu(Integer.parseInt(IngreCed.getText()));
                setEda(Integer.parseInt(IngreEdad.getText()));
                xd.setText(getNomb() + getCedu() + getEda());
            }
        });
    }
}

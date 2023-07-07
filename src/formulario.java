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

    public String nomb="";
    public String cedu;
    public String eda;

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getCedu() {
        return cedu;
    }

    public void setCedu(String cedu) {
        this.cedu = cedu;
    }

    public String getEda() {
        return eda;
    }

    public void setEda(String eda) {
        this.eda = eda;
    }

    public void main(String[] args) {
        JFrame frame = new JFrame("formulario");
        frame.setContentPane(new formulario().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        String filePath="datos.dat";
        MiClase formulario = new MiClase(nomb,cedu,eda);
        try (FileOutputStream fileOut=new FileOutputStream(filePath);
             ObjectOutputStream obOut=new ObjectOutputStream(fileOut);
        ) {
            obOut.writeObject(formulario);
            System.out.println("archivo escrito correctamente");
        }catch(IOException e){
            throw new RuntimeException(e);
        }

        try(FileInputStream fileIn=new FileInputStream(filePath);
            ObjectInputStream objIn= new ObjectInputStream(fileIn);
        ){
            MiClase readObject=(MiClase) objIn.readObject();
            System.out.println("El objeto en disco es: \n"+readObject);
        }catch(IOException e){
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e){
            throw new RuntimeException();
        }
    }
    public formulario() {
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xd.setText(IngreNombre.getText()+IngreCed.getText()+IngreEdad.getText());
                nomb=IngreNombre.getText();
                cedu=IngreCed.getText();
                eda=IngreEdad.getText();
            }
        });
    }

}

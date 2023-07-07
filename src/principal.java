import java.io.*;

public class principal {
    public static void main(String[] args) {
        String filePath="datos.dat";
        MiClase miObjeto = new MiClase("Miguel",19);
        try (FileOutputStream fileOut=new FileOutputStream(filePath);
             ObjectOutputStream obOut=new ObjectOutputStream(fileOut);
        ) {
            obOut.writeObject(miObjeto);
            System.out.println("archivo escrito correctamente");
        }catch(IOException e){
            throw new RuntimeException(e);
        }

        try(FileInputStream fileIn=new FileInputStream(filePath);
            ObjectInputStream obIn= new ObjectInputStream(fileIn);){
            MiClase readObject= new MiClase();
        }catch(IOException e){
            throw new RuntimeException(e);
        }


    }
}

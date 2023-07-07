import java.io.*;

public class principal {
    public static void main(String[] args) {
        String filePath="datos.dat";
        MiClase miObjeto = new MiClase("Miguel",19,1726744327);
        try (FileOutputStream fileOut=new FileOutputStream(filePath);
             ObjectOutputStream obOut=new ObjectOutputStream(fileOut);
        ) {
            obOut.writeObject(miObjeto);
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
}

package data_access;

// import entities.Player;
import java.io.*;

// public class InMemoryPlayerDataAccessObject implements PlayerDataAccessInterface{
    
//     private final String filepath;

//     public InMemoryPlayerDataAccessObject(String filePath){
//         this.filePath = filePath;
//     }

//     @Override
//     public void save(Player player){
//         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
//             oos.writeObject(player);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public Player load() {
//         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
//             return (Player) ois.readObject();
//         } catch (IOException | ClassNotFoundException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
// }

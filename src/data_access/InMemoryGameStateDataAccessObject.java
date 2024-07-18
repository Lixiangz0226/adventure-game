package data_access;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// import entities.Game; TODO

// public class InMemoryGameStateDataAccessObject implements GameStateDataAccessObject{
    
//     private final String filePath;

//     public FileGameStateRepository(String filePath) {
//         this.filePath = filePath;
//     }

//     @Override
//     public void save(GameState gameState) {
//         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
//             oos.writeObject(gameState);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public GameState load() {
//         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
//             return (GameState) ois.readObject();
//         } catch (IOException | ClassNotFoundException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
// }

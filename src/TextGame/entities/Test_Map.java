package TextGame.entities;

import javax.swing.*;
import java.awt.*;

public class Test_Map {

    public static void main(String[] args) {
        Player p = new Player("Vergil", 500);
        Container con = new Container();
        JTextArea mainTextArea = new JTextArea();
        Map m = new Map0(con, p, mainTextArea);

        System.out.println(m.get_playerroom().getName());
        System.out.println(m.get_playerroom().getN().getName());
        System.out.println(m.get_playerroom().getS().getName());
        System.out.println(m.get_playerroom().getE().getName());
        System.out.println(m.get_playerroom().getW().getName());
        System.out.println(m.get_playerroom().getN().getN().getName());
        System.out.println(m.get_playerroom().getS().getS().getE().getName());
    }
}

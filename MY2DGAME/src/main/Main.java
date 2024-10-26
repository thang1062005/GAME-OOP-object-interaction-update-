package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // window set up
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close on exit
        window.setResizable(false); // fixed size
        window.setTitle("OUT OF THE WHITE NIGHTS"); // game title
        window.setLocationRelativeTo(null);
   
        
        Gamepanel gamepanel = new Gamepanel();
        window.add(gamepanel);
        window.pack();
        gamepanel.setup();
        gamepanel.startgamethread();
        window.setVisible(true);
    }
}

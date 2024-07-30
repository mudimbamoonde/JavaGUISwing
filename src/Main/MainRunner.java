/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author moondem
 */
public class MainRunner {
    public static void main(String[]args){
      new Thread(()-> {
            new Menu().setVisible(true);
    }).start();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package barbeiro.dorminhoco;

/**
 *
 * @author SolanoK
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Barbearia barbearia = new Barbearia();
        Barbeiro barbeiro = new Barbeiro(barbearia);
        barbeiro.start();

        for (int i = 0; i < 10; i++) {
            Cliente cliente = new Cliente(barbearia);
            cliente.start();
            try {
                Thread.sleep(500); // Simula o intervalo entre a chegada de clientes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbeiro.dorminhoco;

/**
 *
 * @author SolanoK
 */
public class Barbeiro extends Thread {
    private Barbearia barbearia;

    public Barbeiro(Barbearia barbearia) {
        this.barbearia = barbearia;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Interface.atualizarStatus("Barbeiro dormindo...");
                System.out.println("Barbeiro dormindo...");
                Thread.sleep(3000); //tempo dormindo
                synchronized (barbearia) {
                    while (!barbearia.proximoCliente()) {
                        barbearia.wait(); // esperando cliente
                    }
                }
                Interface.atualizarStatus("Barbeiro atendendo um cliente.");
                System.out.println("Barbeiro atendendo um cliente.");
                Interface.atualizarAtendidos();
                Thread.sleep(5000); //tempo cortando cabelo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


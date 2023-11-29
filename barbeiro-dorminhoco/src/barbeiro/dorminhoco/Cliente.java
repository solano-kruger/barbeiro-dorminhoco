package barbeiro.dorminhoco;

public class Cliente extends Thread {
    private static int count = 1;
    private int id;
    private Barbearia barbearia;

    public Cliente(Barbearia barbearia) {
        this.id = count++;
        this.barbearia = barbearia;
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente chegou à barbearia.");
            barbearia.novoCliente();
            synchronized (barbearia) {
                barbearia.notify(); // Notifica o barbeiro que há um cliente
            }
            Thread.sleep(1000); // Aguarda um pouco antes de possivelmente adicionar outro cliente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


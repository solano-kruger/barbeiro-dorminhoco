package barbeiro.dorminhoco;

public class Barbearia {
    private static final int NUM_CADEIRAS = 5;
    private int clientesEsperando = 0;

    public synchronized void novoCliente() throws InterruptedException {
        while (clientesEsperando == NUM_CADEIRAS) {
            System.out.println("Barbearia cheia. Cliente aguardando fora.");
            Interface.atualizarNaoAtendidos();
            clientesEsperando--;
            wait();
        }
        clientesEsperando++;
        Interface.atualizarFila(clientesEsperando);
        System.out.println("Cliente chegou à barbearia. Total de clientes esperando: " + clientesEsperando);
        notify(); // Notifica o barbeiro que há um novo cliente
    }

    public synchronized boolean proximoCliente() {
        if (clientesEsperando > 0) {
            clientesEsperando--;
            
            System.out.println("Barbeiro cortando o cabelo de um cliente. Total de clientes esperando: " + clientesEsperando);
            Interface.atualizarFila(clientesEsperando);
            notify(); // Notifica um cliente que o barbeiro está pronto para atendê-lo
            return true;
        }else if(clientesEsperando == 0){
           Interface.atualizarFila(0); 
        }
        return false;
    }
}



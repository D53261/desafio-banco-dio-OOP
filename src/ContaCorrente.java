public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente, String senha) {
        super(cliente, senha);
    }

    @Override
    public void imprimirInfos() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfos();
    }

}

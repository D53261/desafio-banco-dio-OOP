public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, String senha) {
        super(cliente, senha);
    }

    @Override
    public void imprimirInfos() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfos();
    }
}

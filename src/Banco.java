import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public void removeConta(Conta conta) {
        this.contas.remove(conta);
    }

    public Conta acessarConta(int cpf, String senha) {
        Conta conta = null;
        for (Conta c : contas) {
            if (c.getCliente().getCpf() == cpf && c.getSenha().equals(senha)) {
                conta = c;
            }
        }
        if (conta == null) {
            System.out.println("Conta não encontrada ou senha incorreta.");
        } else {
            System.out.println("Acesso à conta autorizado.");
        }
        return conta;
    }

    public Conta buscarConta(int cpf) {
        Conta conta = null;
        for (Conta c : contas) {
            if (c.getCliente().getCpf() == cpf) {
                conta = c;
            }
        }
        if (conta == null) {
            System.out.println("Conta não encontrada.");
        } else {
            System.out.println("Conta encontrada.");  
        }
        return conta;
    }
}

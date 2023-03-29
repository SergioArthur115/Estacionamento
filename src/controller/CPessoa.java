
package controller;

import java.util.ArrayList;
import model.Pessoa;


public class CPessoa {

    ArrayList<Pessoa> pessoas = new ArrayList<>();
    int idPessoa = 1;

  
    public int geraID() {
        return this.idPessoa++;
    }

    /**
     *
     * addPessoa adiciona uma pessoa na lista de pessoas
     *
     * @param p
     */
    public void addPessoa(Pessoa p) {
        this.pessoas.add(p);
    }

    /**
     * getPessoas retorna a lista de pessoas
     *
     * @return
     */
    public ArrayList<Pessoa> getPessoas() {
        return this.pessoas;
    }

    /**
     * removePessoa remove Pessoa da lista de pessoas
     *
     * @param p
     */
    public void removePessoa(Pessoa p) {
        this.pessoas.remove(p);
    }

    /**
     * mockPessoas inicializa a aplicação com pessoas
     */
    public void mockPessoas() {
        Pessoa p1 = new Pessoa();
        p1.setIdPessoa(this.geraID());
        p1.setNomePessoa("Jair Ferraz");
        p1.setCpf("81550241052");
        p1.setEndereco("Avenida Nilópolis, 111");
        p1.setTelefone("51999889988");
        this.addPessoa(p1);

        Pessoa p2 = new Pessoa();
        p2.setIdPessoa(this.geraID());
        p2.setNomePessoa("Kuirmegoe");
        p2.setCpf("49838050016");
        p2.setEndereco("Av. Venâncio Aires, 10");
        p2.setTelefone("5140028922");
        this.addPessoa(p2);
    }

    /**
     * getPessoaCPF pesquisa e retorna pessoa pelo CPF e caso não encontre
     * retorna nulo podendo cadastrar
     *
     * @param cpf
     * @return
     */
    public Pessoa getPessoaCPF(String cpf) {
        Pessoa p = null;
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                p = pessoa;
                break;
            }
        }
        return p;
    }
}

package controller;

import estacionamento.Estacionamento;
import java.util.ArrayList;
import model.Carro;

public class CCarro {

    ArrayList<Carro> Carros = new ArrayList<>();
    private int idCarro = 1;

    public int geraID() {
        return this.idCarro++;
    }

    public void addCarro(Carro c) {
        this.Carros.add(c);
    }

    public ArrayList<Carro> getCarros() {
        return this.Carros;
    }

    public void removeCarro(Carro c) {
        this.Carros.remove(c);
    }

    public void mockCarro() {
        Carro c1 = new Carro();
        c1.setIdCarro(this.geraID());
        c1.setPlaca("LBW5154");
        c1.setCor("rosa");
        c1.setModelo("Hyundai");
        c1.setIdPessoa(Estacionamento.cadPessoa.getPessoaCPF("81550241052"));
        c1.setRenavam("57021446591");
        this.addCarro(c1);

        Carro c2 = new Carro();
        c2.setIdCarro(this.geraID());
        c2.setPlaca("ATV7385");
        c2.setCor("Vermelho");
        c2.setModelo("Ferrari");
        c2.setIdPessoa(Estacionamento.cadPessoa.getPessoaCPF("81550241052"));
        c2.setRenavam("48686021651");
        this.addCarro(c2);

        Carro c3 = new Carro();
        c3.setIdCarro(this.geraID());
        c3.setPlaca("LUR2743");
        c3.setCor("Roxo");
        c3.setModelo("Fiat");
        c3.setIdPessoa(Estacionamento.cadPessoa.getPessoaCPF("49838050016"));
        c3.setRenavam("78528464856");
        this.addCarro(c3);

    }

    public Carro getCarro(String renavam) {
        Carro c = null;
        for (Carro Carros : Carros) {
            if (Carros.getRenavam().equals(renavam)) {
                c = Carros;
                break;
            }
        }

        return c;
    }

}

package controller;

import java.util.ArrayList;
import model.Carro;

public class CCarros {

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

    public void removeCliente(Carro c) {
        this.Carros.remove(c);
    }

    public void mockCarro() {
        Carro c1 = new Carro();
        c1.setIdCarro(this.geraID());
        c1.setPlaca("1234567");
        c1.setCor("rosa");
        c1.setModelo("Hyundai");
        c1.setIdCarro(idCarro);
        c1.setRenavam("1098765323");
        this.addCarro(c1);
        Carro c2 = new Carro();
        c2.setCor("Roxo");
        c2.setModelo("Fiat");
        c2.setPlaca("1532Rsdf");
        c2.setRenavam("1982734782");

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

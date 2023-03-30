package model;


public class Carro {

    private int idCarro;
    private String placa;
    private String cor;
    private String modelo;
    private Pessoa idPessoa;
    private String renavam;

    public Carro(int idCarro, String placa, String cor, String modelo, Pessoa idPessoa, String renavam) {
        this.idCarro = idCarro;
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.idPessoa = idPessoa;
        this.renavam = renavam;
    }

    public Carro() {
    }

    public int getIdCarro() {
        return idCarro;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    @Override
    public String toString() {
        return "Carro{" + "idCarro=" + idCarro + ", placa=" + placa + ", cor=" + cor + ", modelo=" + modelo + ", idPessoa=" + idPessoa + ", renavam=" + renavam + '}';
    }
}

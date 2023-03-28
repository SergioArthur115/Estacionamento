/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 182120042
 */
public class Pessoa {

    private int idPessoa;
    private int idadePessoa;
    private String cpf;
    private String nomePessoa;
    private String endereco;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(int idPessoa, int idadePessoa, String cpf, String nomePessoa, String endereco, String telefone) {
        this.idPessoa = idPessoa;
        this.idadePessoa = idadePessoa;
        this.cpf = cpf;
        this.nomePessoa = nomePessoa;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdadePessoa() {
        return idadePessoa;
    }

    public void setIdadePessoa(int idadePessoa) {
        this.idadePessoa = idadePessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "idPessoa=" + idPessoa + ", idadePessoa=" + idadePessoa + ", cpf=" + cpf + ", nomePessoa=" + nomePessoa + ", endereco=" + endereco + ", telefone=" + telefone + '}';
    }

}

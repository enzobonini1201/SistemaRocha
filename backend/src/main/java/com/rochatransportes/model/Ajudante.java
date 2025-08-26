package com.rochatransportes.model;

import jakarta.persistence.*;

import javax.swing.JOptionPane;

@Entity
public class Ajudante { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    // Novos atributos
    private String cpf;
    private String dataNascimento;
    private String cep;
    private String pix;
    private String telefone;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPix() {
        return pix;
    }
    public void setPix(String pix) {
        this.pix = pix;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static void main(String[] args) {
        // Cria um ajudante
        Ajudante ajudante = new Ajudante();

        // Pede o ID
        String idStr = JOptionPane.showInputDialog("Digite o ID do ajudante:");
        ajudante.setId(Long.parseLong(idStr));

        // Pede os dados
        String nome = JOptionPane.showInputDialog("Digite o nome do ajudante:");
        ajudante.setNome(nome);

        String cpf = JOptionPane.showInputDialog("Digite o CPF do ajudante:");
        ajudante.setCpf(cpf);

        String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento:");
        ajudante.setDataNascimento(dataNascimento);

        String cep = JOptionPane.showInputDialog("Digite o CEP:");
        ajudante.setCep(cep);

        String pix = JOptionPane.showInputDialog("Digite a chave PIX:");
        ajudante.setPix(pix);

        String telefone = JOptionPane.showInputDialog("Digite o telefone:");
        ajudante.setTelefone(telefone);

        // Mostra os dados
        JOptionPane.showMessageDialog(
            null,
            "Ajudante cadastrado:\n" +
            "ID: " + ajudante.getId() + 
            "\nNome: " + ajudante.getNome() +
            "\nCPF: " + ajudante.getCpf() +
            "\nData Nascimento: " + ajudante.getDataNascimento() +
            "\nCEP: " + ajudante.getCep() +
            "\nPIX: " + ajudante.getPix() +
            "\nTelefone: " + ajudante.getTelefone()
        );
    }
}
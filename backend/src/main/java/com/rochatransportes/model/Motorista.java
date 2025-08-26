package com.rochatransportes.model;

import jakarta.persistence.*;

import javax.swing.JOptionPane;

@Entity
public class Motorista { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String buonny;
    private String cnh;
    private String nomeCompleto;
    private String dataNascimento;
    private String cep;
    private String pix;
    private String telefone;
    private String cpf;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getBuonny() {
        return buonny;
    }
    public void setBuonny(String buonny) {
        this.buonny = buonny;
    }

    public String getCnh() {
        return cnh;
    }
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static void main(String[] args) {
        // Cria um motorista
        Motorista motorista = new Motorista();

        // Pede o ID
        String idStr = JOptionPane.showInputDialog("Digite o ID do motorista:");
        motorista.setId(Long.parseLong(idStr));

        // Pede os novos dados
        String buonny = JOptionPane.showInputDialog("Digite o código Buonny:");
        motorista.setBuonny(buonny);

        String cnh = JOptionPane.showInputDialog("Digite a CNH do motorista:");
        motorista.setCnh(cnh);

        String nomeCompleto = JOptionPane.showInputDialog("Digite o nome completo do motorista:");
        motorista.setNomeCompleto(nomeCompleto);

        String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento:");
        motorista.setDataNascimento(dataNascimento);

        String cep = JOptionPane.showInputDialog("Digite o CEP:");
        motorista.setCep(cep);

        String pix = JOptionPane.showInputDialog("Digite a chave PIX:");
        motorista.setPix(pix);

        String telefone = JOptionPane.showInputDialog("Digite o telefone:");
        motorista.setTelefone(telefone);

        String cpf = JOptionPane.showInputDialog("Digite o CPF:");
        motorista.setCpf(cpf);

        // Mostra os dados
        JOptionPane.showMessageDialog(
            null,
            "Motorista cadastrado:\n" +
            "ID: " + motorista.getId() + 
            "\nBuonny: " + motorista.getBuonny() +
            "\nCNH: " + motorista.getCnh() +
            "\nNome Completo: " + motorista.getNomeCompleto() +
            "\nData Nascimento: " + motorista.getDataNascimento() +
            "\nCEP: " + motorista.getCep() +
            "\nPIX: " + motorista.getPix() +
            "\nTelefone: " + motorista.getTelefone() +
            "\nCPF: " + motorista.getCpf()
        );
    }
}
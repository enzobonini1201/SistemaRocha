package com.rochatransportes.model;

import jakarta.persistence.*;

import javax.swing.JOptionPane;

@Entity
public class Agregado { 
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
        // Cria um agregado
        Agregado agregado = new Agregado();

        // Pede o ID
        String idStr = JOptionPane.showInputDialog("Digite o ID do agregado:");
        agregado.setId(Long.parseLong(idStr));

        // Pede os novos dados
        String buonny = JOptionPane.showInputDialog("Digite o código Buonny:");
        agregado.setBuonny(buonny);

        String cnh = JOptionPane.showInputDialog("Digite a CNH do agregado:");
        agregado.setCnh(cnh);

        String nomeCompleto = JOptionPane.showInputDialog("Digite o nome completo do agregado:");
        agregado.setNomeCompleto(nomeCompleto);

        String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento:");
        agregado.setDataNascimento(dataNascimento);

        String cep = JOptionPane.showInputDialog("Digite o CEP:");
        agregado.setCep(cep);

        String pix = JOptionPane.showInputDialog("Digite a chave PIX:");
        agregado.setPix(pix);

        String telefone = JOptionPane.showInputDialog("Digite o telefone:");
        agregado.setTelefone(telefone);

        String cpf = JOptionPane.showInputDialog("Digite o CPF:");
        agregado.setCpf(cpf);

        // Mostra os dados
        JOptionPane.showMessageDialog(
            null,
            "Agregado cadastrado:\n" +
            "ID: " + agregado.getId() + 
            "\nBuonny: " + agregado.getBuonny() +
            "\nCNH: " + agregado.getCnh() +
            "\nNome Completo: " + agregado.getNomeCompleto() +
            "\nData Nascimento: " + agregado.getDataNascimento() +
            "\nCEP: " + agregado.getCep() +
            "\nPIX: " + agregado.getPix() +
            "\nTelefone: " + agregado.getTelefone() +
            "\nCPF: " + agregado.getCpf()
        );
    }
}
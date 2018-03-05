package com.qgdagraciela.ecommerce.ecommerce.api.v1.cliente;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    private String endereco;
    private String estado;
    private String cidade;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UsuarioDTO that = (UsuarioDTO) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(nome, that.nome)
                .append(email, that.email)
                .append(senha, that.senha)
                .append(cpf, that.cpf)
                .append(telefone, that.telefone)
                .append(endereco, that.endereco)
                .append(estado, that.estado)
                .append(cidade, that.cidade)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(nome)
                .append(email)
                .append(senha)
                .append(cpf)
                .append(telefone)
                .append(endereco)
                .append(estado)
                .append(cidade)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("nome", nome)
                .append("email", email)
                .append("senha", senha)
                .append("cpf", cpf)
                .append("telefone", telefone)
                .append("endereco", endereco)
                .append("estado", estado)
                .append("cidade", cidade)
                .toString();
    }
}

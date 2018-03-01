package com.qgdagraciela.ecommerce.ecommerce.entities.usuario;

import com.qgdagraciela.ecommerce.ecommerce.entities.role.Role;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String nome;

    @Column(nullable = false)
    @NotNull
    private String email;

    @Column(nullable = false)
    @NotNull
    private String senha;

    @Column
    private String cpf;
    @Column
    private String telefone;
    @Column
    private String endereco;
    @Column
    private String estado;
    @Column
    private String cidade;

    @Column
    @NotNull
    private Boolean ativo;

    @ManyToMany
    @JoinTable(
            name = "clientes_roles",
            joinColumns = @JoinColumn(
                    name = "cliente_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    @NotNull
    private List<Role> roles;

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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return new EqualsBuilder()
                .append(id, usuario.id)
                .append(nome, usuario.nome)
                .append(email, usuario.email)
                .append(senha, usuario.senha)
                .append(cpf, usuario.cpf)
                .append(telefone, usuario.telefone)
                .append(endereco, usuario.endereco)
                .append(estado, usuario.estado)
                .append(cidade, usuario.cidade)
                .append(ativo, usuario.ativo)
                .append(roles, usuario.roles)
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
                .append(ativo)
                .append(roles)
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
                .append("ativo", ativo)
                .append("roles", roles)
                .toString();
    }
}

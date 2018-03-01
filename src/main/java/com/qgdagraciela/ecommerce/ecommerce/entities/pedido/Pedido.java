package com.qgdagraciela.ecommerce.ecommerce.entities.pedido;

import com.qgdagraciela.ecommerce.ecommerce.entities.usuario.Usuario;
import com.qgdagraciela.ecommerce.ecommerce.entities.produto.Produto;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    @NotNull
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @NotNull
    private Usuario usuario;

    @Column
    @NotNull
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        return new EqualsBuilder()
                .append(id, pedido.id)
                .append(produto, pedido.produto)
                .append(usuario, pedido.usuario)
                .append(quantidade, pedido.quantidade)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(produto)
                .append(usuario)
                .append(quantidade)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("produto", produto)
                .append("usuario", usuario)
                .append("quantidade", quantidade)
                .toString();
    }
}

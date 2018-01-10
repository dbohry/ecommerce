package com.qgdagraciela.ecommerce.ecommerce.entities.pedido;

import com.qgdagraciela.ecommerce.ecommerce.entities.cliente.Cliente;
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
    private Cliente cliente;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
                .append(cliente, pedido.cliente)
                .append(quantidade, pedido.quantidade)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(produto)
                .append(cliente)
                .append(quantidade)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("produto", produto)
                .append("cliente", cliente)
                .append("quantidade", quantidade)
                .toString();
    }
}

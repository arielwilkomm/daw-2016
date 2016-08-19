/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ariel
 */
@Entity
@Table(name = "vendaItens")
public class VendaItens implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_vendaItens", sequenceName = "seq_vendaItens_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_vendaItens", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A quantidade nao pode ser nula")
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    @Column(name = "valor", columnDefinition = "numeric(10,2)")
    private Double valor;
    @Column(name = "valor_total", columnDefinition = "numeric(10,2)")
    private Double valorTotal;
    @NotNull(message = "A produto nao pode ser nula")
    @ManyToOne
    @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false)
    private Produto produto;
    @NotNull(message = "A venda nao pode ser nula")
    @ManyToOne
    @JoinColumn(name = "venda", referencedColumnName = "id", nullable = false)
    private Venda venda;

    public VendaItens() {
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendaItens other = (VendaItens) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
        
}

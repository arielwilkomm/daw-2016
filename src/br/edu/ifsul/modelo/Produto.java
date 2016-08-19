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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ariel
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50, message = "O nome não pode ser ser maior que {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar em Branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotNull(message = "A descrição não pode ser nulo")
    @Column(name = "descricao", nullable = false, columnDefinition = "text")
    private String descricao;
    @NotNull(message = "O valor não pode ser nulo")
    @Min(value = 0, message = "O valor não pode ser abaixo de {value}")
    @Column(name = "preco", nullable = false, columnDefinition = "numeric(10,2)")
    private Double preco;
    @NotNull(message = "O preço não pode ser nulo")
    @Min(value = 0, message = "O estoque não pode ser abaixo de {value}")
    @Column(name = "estoque", nullable = false)
    private Double estoque;
    @ManyToOne
    @NotNull(message = "A marca não pode ser nula")
    @JoinColumn(name = "marca", referencedColumnName = "id", nullable = false)
    private Marca marca;
    @ManyToOne
    @NotNull(message = "O grupo não pode ser nulo")
    @JoinColumn(name = "grupo", referencedColumnName = "id", nullable = false)
    private Grupo grupo;

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}

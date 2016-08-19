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
@Table(name = "telefone")
public class Telefone implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_telefone", sequenceName = "seq_telefone_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_telefone", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "o numero nao pode ser nulo")
    @Length(max = 14, message = "O numero não pode ter mais que {max} caracters")
    @NotBlank(message = "O numero não pode estar em branco")
    @Column(name = "numero", length = 14, nullable = false)
    private String numero;
    @NotNull(message = "A descricao nao pode ser nula")
    @Length(max = 20, message = "A descricao não pode ter mais que {max} caracters")
    @NotBlank(message = "A descricao não pode estar em branco")
    @Column(name = "descricao", length = 20, nullable = false)
    private String descricao;
    @NotNull(message = "A pessoa nao pode ser nula")
    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;

    public Telefone() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}

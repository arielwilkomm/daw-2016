/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ariel
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Pessoa implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_pessoas", sequenceName = "seq_pessoas_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoas", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50, message = "O nome não pode ser ser maior que {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar em Branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Length(max = 50, message = "O endereço não pode ser ser maior que {max} caracteres")
    @NotNull(message = "O endereço não pode ser nulo")
    @NotBlank(message = "O endereço não pode estar em Branco")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    @Length(max = 150, message = "O email não pode ser ser maior que {max} caracteres")
    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode estar em Branco")
    @Email(message = "O email deve ser valido")
    @Column(name = "email", length = 150, nullable = false)
    private String email;
    @Length(max = 30, message = "O bairro não pode ser ser maior que {max} caracteres")
    @NotNull(message = "O bairro não pode ser nulo")
    @NotBlank(message = "O bairro não pode estar em Branco")
    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;
    @Length(max = 9, min = 9, message = "O cep deve ter {max} caraters")
    @NotNull(message = "O cep não pode ser nulo")
    @NotBlank(message = "O cep não pode estar em Branco")
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    @Length(max = 150, message = "O complemento não pode ser ser maior que {max} caracteres")
    @NotNull(message = "O complemento não pode ser nulo")
    @NotBlank(message = "O complemento não pode estar em Branco")
    @Column(name = "complemento", length = 150, nullable = false)
    private String complemento;   
    @NotNull(message = "A cidade não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "cidade", nullable = false, referencedColumnName = "id")
    private Cidade cidade;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Telefone> telefone = new ArrayList<>();
    
    public Pessoa() {
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }
   
    public void adicionarTelefone(Telefone obj){
        obj.setPessoa(this);
        this.telefone.add(obj);
    }
    
    public void removerTelefone(int index) {
        this.telefone.remove(index);
    }
    
}

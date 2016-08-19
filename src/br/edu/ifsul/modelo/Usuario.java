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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Ariel
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario extends PessoaFisica implements Serializable {
    @Length(max = 50, message = "O Login não pode ser ser maior que {max} caracteres")
    @NotNull(message = "O Login não pode ser nulo")
    @NotBlank(message = "O Login não pode estar em Branco")
    @Column(name = "apelido", length = 50, nullable = false, unique = true)
    private String apelido;
    @Length(max = 50, message = "A senha não pode ser ser maior que {max} caracteres")
    @NotNull(message = "A senha não pode ser nulo")
    @NotBlank(message = "A senha não pode estar em Branco")
    @Column(name = "senha", length = 50, nullable = false)
    private String senha;
    @Column(name = "ativo")
    private boolean ativo;
    @Column(name = "adimin")
    private boolean adimin;

    public Usuario() {
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAdimin() {
        return adimin;
    }

    public void setAdimin(boolean adimin) {
        this.adimin = adimin;
    }

   
    
    
   
       
    
}

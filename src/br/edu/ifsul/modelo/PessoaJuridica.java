/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Ariel
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable {
    @Length(max = 9, message = "O IE não pode ser ser maior que {max} caracteres")
    @NotNull(message = "O IE não pode ser nulo")
    @NotBlank(message = "O IE não pode estar em Branco")
    @Column(name = "IE", length = 9, nullable = false)
    private String ie;
    @CNPJ(message = "O CNPJ deve ser valido")
    @Length(max = 14, message = "O CNPJ não pode ser ser maior que {max} caracteres")
    @NotNull(message = "O CNPJ não pode ser nulo")
    @NotBlank(message = "O CNPJ não pode estar em Branco")
    @Column(name = "CNPJ", length = 14, nullable = false)
    private String cnpj;

    public PessoaJuridica() {
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    } 
    
    
}

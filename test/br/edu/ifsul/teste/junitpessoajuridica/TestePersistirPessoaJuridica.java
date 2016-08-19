/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junitpessoajuridica;

import br.edu.ifsul.teste.junitpessoafisica.*;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.testes.junitproduto.*;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.PessoaJuridica;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.hibernate.validator.ap.util.CollectionHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel
 */
public class TestePersistirPessoaJuridica {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPessoaJuridica() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {
            PessoaJuridica pj = new PessoaJuridica();
            pj.setBairro("Centro");
            pj.setCep("99010-100");
            pj.setCidade(em.find(Cidade.class, 1));
            pj.setComplemento("Perto da farmacia");
            pj.setCnpj("26832834000157");
            pj.setEmail("empresa@hotmail.com");
            pj.setEndereco("Paissandu, 20");
            pj.setNome("empres");
            pj.setIe("12035592");
            
            
            em.getTransaction().begin();
            em.persist(pj);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

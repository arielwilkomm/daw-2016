/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junitpessoafisica;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.testes.junitproduto.*;
import br.edu.ifsul.modelo.PessoaFisica;
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
public class TestePersistirPessoaFisica {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
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
            PessoaFisica pf = new PessoaFisica();
            pf.setBairro("Centro");
            pf.setCep("99010-100");
            pf.setCidade(em.find(Cidade.class, 1));
            pf.setComplemento("Perto da escola");
            pf.setCpf("716.236.700-39");
            pf.setEmail("arielwilkomm@hotmail.com");
            pf.setEndereco("Paissandu, 41");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Ariel");
            pf.setRg("1203559260");
            
            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

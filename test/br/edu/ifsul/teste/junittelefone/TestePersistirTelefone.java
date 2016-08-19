/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junittelefone;

import br.edu.ifsul.teste.junitpessoafisica.*;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.testes.junitproduto.*;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Telefone;
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
public class TestePersistirTelefone {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirTelefone() {
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
            PessoaFisica pf = em.find(PessoaFisica.class, 6);
            Telefone t = new Telefone();
            t.setNumero("(54)99660987");
            t.setDescricao("celular");
            pf.adicionarTelefone(t);
                        
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

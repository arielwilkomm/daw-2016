/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junitusuario;

import br.edu.ifsul.teste.junitpessoafisica.*;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Usuario;
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
public class TestePersistirUsuario {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirUsuario() {
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
            Usuario u = new Usuario();
            u.setBairro("Centro");
            u.setCep("99010-100");
            u.setCidade(em.find(Cidade.class, 1));
            u.setComplemento("Perto da escola");
            u.setCpf("716.236.700-39");
            u.setEmail("arielwilkomm@hotmail.com");
            u.setEndereco("Paissandu, 41");
            u.setNascimento(Calendar.getInstance());
            u.setNome("Ariel");
            u.setRg("1203559260");
            u.setAdimin(true);
            u.setApelido("arielwilkomm");
            u.setAtivo(true);
            u.setSenha("ariel");
            
            
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

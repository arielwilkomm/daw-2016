/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junitvenda;

import br.edu.ifsul.teste.junittelefone.*;
import br.edu.ifsul.teste.junitpessoafisica.*;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.testes.junitproduto.*;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Telefone;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.modelo.Venda;
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
public class TestePersistirVenda {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirVenda() {
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
            Usuario u = em.find(Usuario.class, 6);
            Venda v = new Venda();
            v.setData(Calendar.getInstance());
            v.setPagamento("Nao");
            v.setParcela(1);
            v.setPessoa(pf);
            v.setUsuario(u);
            v.setValor_total(12.10);
            
                        
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

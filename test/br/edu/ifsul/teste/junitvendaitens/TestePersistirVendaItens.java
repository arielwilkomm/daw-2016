/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junitvendaitens;

import br.edu.ifsul.teste.junittelefone.*;
import br.edu.ifsul.teste.junitpessoafisica.*;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.testes.junitproduto.*;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Telefone;
import br.edu.ifsul.modelo.Venda;
import br.edu.ifsul.modelo.VendaItens;
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
public class TestePersistirVendaItens {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirVendaItens() {
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
            Venda v = em.find(Venda.class, 7);
            Produto p = em.find(Produto.class, 5);
            VendaItens vi = new VendaItens();
            vi.setProduto(p);
            vi.setQuantidade(1);
            vi.setValor(10.20);
            vi.setValorTotal(10.20);
            v.adicionarVendaItens(vi);
                        
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

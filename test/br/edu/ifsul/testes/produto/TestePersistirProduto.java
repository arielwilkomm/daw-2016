/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.produto;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Produto;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Ariel
 */
public class TestePersistirProduto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Marca m = em.find(Marca.class, 1);
        Grupo g = em.find(Grupo.class, 3);
        Produto p = new Produto();
        p.setNome("Mouse RazerNaga");
        p.setDescricao("Mouse de computador");
        p.setEstoque(50.0);
        p.setPreco(15.76);
        p.setGrupo(g);
        p.setMarca(m);
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Produto>> erros = validador.validate(p);
        
        if (erros.size() > 0) {
            for(ConstraintViolation<Produto> erro : erros){
                System.out.println("Erro: " + erro.getMessage());
            
            }
            
        } else {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }
        
        
        em.close();
        emf.close();
        
    }
    
}

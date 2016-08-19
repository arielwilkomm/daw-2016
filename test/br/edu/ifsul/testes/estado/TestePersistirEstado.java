/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.estado;

import br.edu.ifsul.modelo.Estado;
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
public class TestePersistirEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Estado e = new Estado();
        e.setNome("Rio de Janeiro");
        e.setUf("RJ");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Estado>> erros = validador.validate(e);
        
        if (erros.size() > 0) {
            for(ConstraintViolation<Estado> erro : erros){
                System.out.println("Erro: " + erro.getMessage());
            
            }
            
        } else {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        }
        
        
        em.close();
        emf.close();
        
    }
    
}

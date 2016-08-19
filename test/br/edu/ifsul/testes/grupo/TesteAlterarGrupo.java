/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.grupo;

import br.edu.ifsul.modelo.Grupo;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ariel
 */
public class TesteAlterarGrupo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Grupo g = em.find(Grupo.class, 3);
        g.setNome("Fruta");
        
        em.getTransaction().begin();
        em.merge(g);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}

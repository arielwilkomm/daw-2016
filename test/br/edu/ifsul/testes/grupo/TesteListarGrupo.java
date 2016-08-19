/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.grupo;

import br.edu.ifsul.modelo.Grupo;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ariel
 */
public class TesteListarGrupo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        List<Grupo> lista = em.createQuery("from Grupo order by nome").getResultList();
        
        for (Grupo g : lista){
            System.err.println("ID: "+g.getId()+" Nome: "+g.getNome());
        }
        
        em.close();
        emf.close();
        
    }
    
}

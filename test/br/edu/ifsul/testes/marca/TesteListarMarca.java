/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.marca;

import br.edu.ifsul.modelo.Marca;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ariel
 */
public class TesteListarMarca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        List<Marca> lista = em.createQuery("from Marca order by nome").getResultList();
        
        for (Marca m : lista){
            System.err.println("ID: "+m.getId()+" Nome: "+m.getNome());
        }
        
        em.close();
        emf.close();
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.udea.DAO;

import com.udea.modelo.Actor;
import com.udea.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author farley.rua
 */
public class ActorDAO 
{
    private Session sesion;
    private Transaction tx;
    
    
    private void iniciaOperacion() throws HibernateException
    {
    sesion = HibernateUtil.getSessionFactory().openSession();
    tx = sesion.beginTransaction();
    }
    
    private void manejaExcepcion(HibernateException he) throws HibernateException
    {
    tx.rollback();
    throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
    
    public long guardaActor(Actor actor)
    { 
    long id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Short)sesion.save(actor); 
            tx.commit(); 
        }catch(HibernateException he) 
        { 
            manejaExcepcion(he);
            throw he; 
        }finally 
        { 
            sesion.close(); 
        }  
    return id; 
    }
    
    public void actualizaActor(Actor actor) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(actor); 
            tx.commit(); 
        }catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        }finally 
        { 
            sesion.close(); 
        } 
    }
    
    public void eliminaActor(Short idActor) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion();
            Actor actorEliminar=obenerActor(idActor);
            sesion.delete(actorEliminar);
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        }finally 
        { 
          sesion.close(); 
        } 
    }
    
    public Actor obenerActor(Short idActor) throws HibernateException 
    {
      Actor actor=null;
      try{
          iniciaOperacion();
          actor=(Actor)sesion.get(Actor.class,idActor);
      }finally{
         // sesion.close();
             
      }
     return actor;   
    }
}

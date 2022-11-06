package com.objectDB.objectDB.dao;

import com.objectDB.objectDB.models.Plan;
import com.objectDB.objectDB.models.Usuario;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public String registrar(Usuario usuario) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/objectDB.odb");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            return "OK";

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "FAIL";
        }

    }

    @Override
    public String getUsuarios() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/objectDB.odb");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select u from Usuario u");
        List<Usuario> listaUsuario = (List<Usuario>) query.getResultList();
        String datosUsuario = "";
        for (Usuario u : listaUsuario) {
            datosUsuario = datosUsuario + "\n" + u.getDatosUsuario();
        }

        return datosUsuario;
    }

    @Override
    public String agregarPlan(String email, int plan) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/objectDB.odb");
        EntityManager em = emf.createEntityManager();
        Usuario usuario = em.find(Usuario.class, email);
        Plan plan_agregar = em.find(Plan.class, plan);
        if(usuario==null){
            JSONObject obj=new JSONObject();
            obj.put("error","No existe un usuario con ese email");
            return obj.toString();
        }else if(plan_agregar==null){
            JSONObject obj=new JSONObject();
            obj.put("error","No existe un plan con ese id");
            return obj.toString();
        }else {
            usuario.agregarPlan(plan_agregar);
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            return "OK";
        }

    }

    @Override
    public boolean verifacarEmailPasswordUsuario(String email, String password) {
        boolean existe=false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/objectDB.odb");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select u from Usuario u");
        List<Usuario> listaUsuario = (List<Usuario>) query.getResultList();
        for (Usuario u:listaUsuario){
            if(u.getEmail().equals(email)&&u.getPassword().equals(password)){
                existe=true;
            }
        }
        return existe;
    }
}
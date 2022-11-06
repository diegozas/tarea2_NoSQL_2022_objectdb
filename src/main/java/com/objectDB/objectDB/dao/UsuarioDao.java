package com.objectDB.objectDB.dao;

import com.objectDB.objectDB.models.Plan;
import com.objectDB.objectDB.models.Usuario;
import java.util.List;
public interface UsuarioDao {
    String registrar(Usuario usuario);
    String getUsuarios();

    String agregarPlan(String email,int plan);


    boolean verifacarEmailPasswordUsuario(String email,String password);

}

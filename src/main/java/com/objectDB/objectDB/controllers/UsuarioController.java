package com.objectDB.objectDB.controllers;



import com.objectDB.objectDB.dao.UsuarioDao;
import com.objectDB.objectDB.models.Usuario;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "prueba")
    public String prueba() {
        return usuarioDao.agregarPlan("nuevo@nuevo", 1);
    }

    @RequestMapping(value = "usuarios", method = RequestMethod.GET)
    public String getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "usuarios/registrar", method = RequestMethod.POST)
    public String registrarUsuario(@RequestBody Usuario usuario) {
        JSONObject obj = new JSONObject();
        String respuesta = usuarioDao.registrar(usuario);
        if (respuesta.equals("FAIL")) {
            obj.put("error", "101");
            obj.put("description", "Ya existe un usuario con ese mail");
            return obj.toString();
        }else
            return "OK";
    }

    @RequestMapping(value = "usuarios/agregarplan/{email}/{id}", method = RequestMethod.GET)
    public String agregarPlan(@PathVariable String email,@PathVariable int id) {
        return usuarioDao.agregarPlan(email,id);
    }

    @RequestMapping(value = "usuarios/iniciarsesion/{email}/{password}", method = RequestMethod.GET)
    public boolean iniciarSesion(@PathVariable String email,@PathVariable String password) {
        return usuarioDao.verifacarEmailPasswordUsuario(email,password);
    }





}

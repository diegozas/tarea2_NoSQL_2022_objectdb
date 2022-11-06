package com.objectDB.objectDB.models;


import org.json.JSONObject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Usuario {
    @Id
    private String email;
    private String nombre;
    private int edad;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Plan> planes=new ArrayList<>();


    public Usuario(){}




    public Usuario(String email, String nombre, int edad,String password) {
        this.email = email;
        this.nombre = nombre;
        this.edad = edad;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void agregarPlan(Plan p) {
        this.planes.add(p);
    }


    public String getDatosUsuario(){
        JSONObject obj=new JSONObject();
        obj.put("email",this.email);
        obj.put("nombre",this.nombre);
        obj.put("edad",this.edad);
        obj.put("password",this.password);
        if(planes.isEmpty()){
            obj.put("planes","VACIO");
        }else{
            for (Plan p:planes){
                obj.put(String.valueOf(p.getId()),p.getPlan());
                obj.put("cantidad",planes.size());
            }
        }
        return obj.toString();
    }

    /*
Buscar puerto
netstat -ano | findstr LISTENING | findstr 8080

eliminar proceso
taskkill -PID 7700 -F
 */




}

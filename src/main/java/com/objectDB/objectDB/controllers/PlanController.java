package com.objectDB.objectDB.controllers;

import com.objectDB.objectDB.dao.PlanDao;
import com.objectDB.objectDB.models.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlanController {
    @Autowired
    PlanDao plandao;

    @RequestMapping(value = "plan/agregar")
    public String prueba(){
        return plandao.registrar();
    }

    @RequestMapping(value = "planes",method = RequestMethod.GET)
    public List<Plan> getPlanes(){
        return plandao.getPlanes();
    }

}

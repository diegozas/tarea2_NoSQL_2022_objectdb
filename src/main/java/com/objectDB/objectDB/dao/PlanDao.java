package com.objectDB.objectDB.dao;


import com.objectDB.objectDB.models.Plan;

import java.util.List;

public interface PlanDao{
    String registrar();
    List<Plan> getPlanes();
}

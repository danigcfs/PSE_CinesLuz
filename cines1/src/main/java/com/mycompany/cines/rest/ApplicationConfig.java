/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cines.rest;

import java.util.Set;
import javax.ws.rs.core.Application;
import javax.inject.Named;


/**
 *
 * @author 2004p
 */
@Named
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.cines.rest.MovieFacadeREST.class);
        resources.add(com.mycompany.cines.rest.PointsFacadeREST.class);
        resources.add(com.mycompany.cines.rest.SalesFacadeREST.class);
        resources.add(com.mycompany.cines.rest.ShowTimingFacadeREST.class);
        resources.add(com.mycompany.cines.rest.TheaterFacadeREST.class);
        resources.add(com.mycompany.cines.rest.TimeslotFacadeREST.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cines.client;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import com.mycompany.cines.entities.Movie;
import javax.ws.rs.client.ClientBuilder;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Entity;
import com.mycompany.cines.json.MovieReader;
import com.mycompany.cines.json.MovieWriter;


@Named
@RequestScoped
public class MovieClientBean {

    private Client client;
    private WebTarget target;

    @Inject
    private MovieBackingBean bean;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/cines/webresources/com.mycompany.cines.entities.movie");
    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    public Movie[] getMovies() {
        return target
                .request()
                .get(Movie[].class);
    }

    public Movie getMovie() {
        return target
                .register(MovieReader.class)
                .path("{movieId}")
                .resolveTemplate("movieId", bean.getMovieId())
                .request(MediaType.APPLICATION_JSON)
                .get(Movie.class);
    }

    public void deleteMovie() {
        target
                .path("{movieId}")
                .resolveTemplate("movieId", bean.getMovieId())
                .request()
                .delete();
    }

    public void addMovie() {
        Movie m = new Movie();
        m.setId(1);
        m.setName(bean.getMovieName());
        m.setActors(bean.getActors());
        target
                .register(MovieWriter.class)
                .request()
                .post(Entity.entity(m, MediaType.APPLICATION_JSON));
    }
}


package com.mycompany.cines.booking;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import com.mycompany.cines.entities.Movie;
import com.mycompany.cines.entities.ShowTiming;



@Named
@FlowScoped("booking")
public class Booking implements Serializable {

    private int movieId;
    String startTime;
    private int startTimeId;
    private double precio;
    
    
    @PersistenceContext
    private EntityManager em;
private String tarjeta;
private Date fecha;

public String getTarjeta() {
    return tarjeta;
}

public void setTarjeta(String tarjeta) {
    this.tarjeta = tarjeta;
}

public Date getFecha() {
    return fecha;
}

public void setFecha(Date fecha) {
    this.fecha = fecha;
}

 public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setStartTime(String startTime) {
        StringTokenizer tokens = new StringTokenizer(startTime, ",");
        startTimeId = Integer.parseInt(tokens.nextToken());
        this.startTime = tokens.nextToken();
    }

    public String getStartTime() {
        return startTime;
    }

    public int getStartTimeId() {
        return startTimeId;
    }

    public String getMovieName() {
        try {
            return em.createNamedQuery("Movie.findById", Movie.class)
                     .setParameter("id", movieId)
                     .getSingleResult()
                     .getName();
        } catch (NoResultException e) {
            return "";
        }
    }

    public String getTheater() {
        try {
            List<ShowTiming> list =
                em.createNamedQuery("ShowTiming.findByMovieAndTimingId", ShowTiming.class)
                  .setParameter("movieId", movieId)
                  .setParameter("timingId", startTimeId)
                  .getResultList();
            
            if (list.isEmpty()) {
                return "none";
            }
            
            return list.get(0).getId().toString();
        } catch (NoResultException e) {
            return "none";
        }
    }
}

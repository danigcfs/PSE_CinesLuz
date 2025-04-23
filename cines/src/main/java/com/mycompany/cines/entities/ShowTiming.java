/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cines.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2004p
 */
@Entity
@Table(name = "show_timing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShowTiming.findAll", query = "SELECT s FROM ShowTiming s"),
    @NamedQuery(name = "ShowTiming.findById", query = "SELECT s FROM ShowTiming s WHERE s.id = :id"),
    @NamedQuery(name = "ShowTiming.findByDay", query = "SELECT s FROM ShowTiming s WHERE s.day = :day"),
    @NamedQuery(name = "ShowTiming.findByTheaterId", query = "SELECT s FROM ShowTiming s WHERE s.theaterId = :theaterId"),
    @NamedQuery(name = "ShowTiming.findByMovieId", query = "SELECT s FROM ShowTiming s WHERE s.movieId = :movieId"),
    @NamedQuery(name = "ShowTiming.findByTimingId", query = "SELECT s FROM ShowTiming s WHERE s.timingId = :timingId"),
    @NamedQuery(name = "ShowTiming.findByMovieAndTimingId", query = "SELECT s FROM ShowTiming s WHERE s.movieId = :movieId AND s.timingId = :timingId")})
public class ShowTiming implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "day")
    private int day;
    @Basic(optional = false)
    @NotNull
    @Column(name = "theater_id")
    private int theaterId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movie_id")
    private int movieId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timing_id")
    private int timingId;

    public ShowTiming() {
    }

    public ShowTiming(Integer id) {
        this.id = id;
    }

    public ShowTiming(Integer id, int day, int theaterId, int movieId, int timingId) {
        this.id = id;
        this.day = day;
        this.theaterId = theaterId;
        this.movieId = movieId;
        this.timingId = timingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTimingId() {
        return timingId;
    }

    public void setTimingId(int timingId) {
        this.timingId = timingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShowTiming)) {
            return false;
        }
        ShowTiming other = (ShowTiming) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cines.entities.ShowTiming[ id=" + id + " ]";
    }
    
}

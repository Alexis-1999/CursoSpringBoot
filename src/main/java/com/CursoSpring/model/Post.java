package com.CursoSpring.model;

// import java.lang.reflect.Constructor;
import java.util.Date;

// import org.yaml.snakeyaml.constructor.Construct;

// import jakarta.annotation.PostConstruct;


public class Post {
    private int id; 
    private String descripcion;
    private String urlImg;
    private Date fecha;
    private String titulo;

    //Get
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlImg() {
        return urlImg;
    }
    public Date getFecha() {
        return fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    //Set
    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Post(int id, String descripcion, String urlImg, Date fecha, String titulo) {
        this.id = id;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
        this.fecha = fecha;
        this.titulo = titulo;
    }


    
}

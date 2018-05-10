/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modeloJPA.Evento;

/**
 *
 * @author PC
 */

@ManagedBean(name="manejadorEventos", eager=true)
@SessionScoped
public class ManejadorEventos implements Serializable{
    
    private List<Evento> eventos;
    private String nombreEvento;
    private Evento evento;
    
    public ManejadorEventos(){
        eventos = new ArrayList<>();
        eventos.add(new Evento(1L,"Salida a la montaña",new Date(2018,6,18),"Malaga",300,30,"salida a la montaña un dia de verano"));
        eventos.add(new Evento(2L,"Salida a la playa",new Date(2018,7,28),"Granada",300,30,"salida a la playa un dia de verano"));
        eventos.add(new Evento(3L,"Salida a la ciudad",new Date(2018,8,8),"Sevilla",300,30,"salida por la ciudad durante todo el dia"));
        eventos.add(new Evento(4L,"Salida a Madrid",new Date(2018,10,15),"Madrid",300,30,"Excursion a Madrid, a ver la gran capital"));
        
    }
    
    public List<Evento> getEventos(){      
        return eventos;
    }
    
    public void setNombreEvento(String nombreEvento){
        this.nombreEvento=nombreEvento;
    }
    
    public String getNombreEvento(){
        return nombreEvento;
    }

    /**
     * @return the evento
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}

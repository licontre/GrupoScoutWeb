/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modeloJPA.Cuota;
import modeloJPA.PagoCuota;
import modeloJPA.Usuario;
import modeloJPA.Usuario.Cargo;

/**
 *
 * @author MARTA
 */
@Named(value = "controlPagos")
@SessionScoped
public class ControlPagos implements Serializable {

    private Usuario usuario;
    private Cuota cuota;
    private List <Cuota> listaCuotas;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public List<Cuota> getListaCuotas() {
        return listaCuotas;
    }

    public void setListaCuotas(List<Cuota> listaCuotas) {
        this.listaCuotas = listaCuotas;
    }
    
    
    
    
    
    public ControlPagos() {
        
        List<PagoCuota> listac1= new ArrayList<PagoCuota>();
        List<PagoCuota> listac2= new ArrayList<PagoCuota>();
        
        Usuario u1 = new Usuario("castor", "castor", Cargo.CASTORES);
        Usuario u2 = new Usuario ("admin", "admin", Cargo.ADMIN);
        
        Cuota c1 = new Cuota (1L, 100, "primera cuota", "inscripcion",listac1);
        
        PagoCuota pago1 = new PagoCuota (1L, new Date(2017, 5 , 28),u1 , c1);
        PagoCuota pago2 = new PagoCuota (2L, new Date(2017, 9 , 28),u1 , c1);
        
        listac1.add(pago1);
        listac1.add(pago2);
        
        
        Cuota c2 = new Cuota (2L, 120, "primera cuota", "inscripcion",listac2);
        
        PagoCuota pago3 = new PagoCuota (3L, new Date(2017, 5 , 30),u1 , c1);
        PagoCuota pago4 = new PagoCuota (4L, new Date(2017, 9 , 8),u1 , c1);
        
        listac2.add(pago3);
        listac2.add(pago4);
        
        listaCuotas = new ArrayList<Cuota>();
        listaCuotas.add(c1);
        listaCuotas.add(c2);
        
        
        
    }
    
}

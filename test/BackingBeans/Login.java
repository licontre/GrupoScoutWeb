/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBeans;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import modeloJPA.Usuario;
import modeloJPA.Usuario.Cargo;

public class Login implements Controlador{
    
    private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;
    
    @Inject
    ControlAutorizacion ctrl;
    
    public Login(){
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("castor", "castor", Cargo.CASTORES));
        usuarios.add(new Usuario("admin", "admin", Cargo.ADMIN));
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String autenticar() {
               
        Iterator<Usuario> it = usuarios.iterator();
        Usuario aux =null;
        boolean find = false;
        String cad=null;
        do{
            aux = it.next();
            if(aux.getNombreusuario().equals(usuario))
                find = true;
        }while(it.hasNext() && !find);
        FacesContext ctx = FacesContext.getCurrentInstance();
        if(!find)
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no existe", "El usuario no existe"));
        else if(!aux.getContrasenia().equals(contrasenia))
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña es incorrecta","La contraseña es incorrecta"));
        
        else{
            
            ctrl.setUsuario(aux);
            cad=ctrl.home();
        }
        
        return cad;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       this.autenticar();
    }
}

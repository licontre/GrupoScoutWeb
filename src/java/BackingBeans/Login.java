package BackingBeans;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.*;
import modeloJPA.Usuario;
import modeloJPA.Usuario.Cargo;

/**
 *
 * @author PC
 */
@Named(value = "login")
@RequestScoped
public class Login implements Controlador{
    
    private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;
    
    @Inject
    private ControlAutorizacion ctrl;
    
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
               
        Iterator<Usuario> it = getUsuarios().iterator();
        Usuario aux =null;
        boolean find = false;
        String cad=null;
        do{
            aux = it.next();
            if(aux.getNombreusuario().equals(getUsuario()))
                find = true;
        }while(it.hasNext() && !find);
        FacesContext ctx = FacesContext.getCurrentInstance();
        if(!find)
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no existe", "El usuario no existe"));
        else if(!aux.getContrasenia().equals(contrasenia))
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña es incorrecta","La contraseña es incorrecta"));
        
        else{
            
            getCtrl().setUsuario(aux);
            cad=getCtrl().home();
        }
        
        return cad;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.autenticar();
    }

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the ctrl
     */
    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    /**
     * @param ctrl the ctrl to set
     */
    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
}
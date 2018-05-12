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
import modeloJPA.Documento;
import modeloJPA.Evento;

/**
 *
 * @author PC
 */

@ManagedBean(name="manejadorDocumentos", eager=true)
@SessionScoped
public class ManejadorDocumentos implements Serializable{
    
    private List<Documento> documentos;
    private String nombreDocumento;
    private Documento documento;
    
    public ManejadorDocumentos(){
        documentos = new ArrayList<>();
        documentos.add(new Documento(1L,"Documento 1","Modificandose", "contenido del documentos",".txt"));
        documentos.add(new Documento(2L,"Documento 2","Actualizado", "contenido del documentos2 esta lleno",".txt"));
        documentos.add(new Documento(3L,"Documento 3","Finalizado", "contenido del documentos, final",".txt"));
        documentos.add(new Documento(4L,"Documento 4","Actualizado", "contenido del documento4 esta completo",".txt"));
    }

    /**
     * @return the documentos
     */
    public List<Documento> getDocumentos() {
        return documentos;
    }

    /**
     * @param documentos the documentos to set
     */
    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    /**
     * @return the nombreDocumento
     */
    public String getNombreDocumento() {
        return nombreDocumento;
    }

    /**
     * @param nombreDocumento the nombreDocumento to set
     */
    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    /**
     * @return the documento
     */
    public Documento getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
   
}

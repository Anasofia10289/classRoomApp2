package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.repositorios.IDocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DocenteServicio {

    @Autowired
    IDocenteRepositorio repositorio;

    //Metodo para guardar
    public Docente guardarDocente(Docente datosDocente)throws Exception{
        try{
            return this.repositorio.save(datosDocente);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //metodo para buscarTodos
    public List<Docente> listarDocentes()throws Exception{
        try{
            return this.repositorio.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }

    //metodo para buscarUnoPorId
    public Docente buscarDocentePorId(Integer id)throws Exception{
        try{
            Optional<Docente> docenteQueEstoyBuscando=this.repositorio.findById(id);
            if(docenteQueEstoyBuscando.isPresent()){
                return docenteQueEstoyBuscando.get();
            }else{
                throw new Exception(MensajesAPI.ERROR_DOCENTE_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //metodo para modificar
    public Docente modificarDocente(Integer id, Docente datosNuevosDocente)throws Exception{
        try{
            Optional<Docente>docenteQueEstoyBuscandoParaEditar=this.repositorio.findById(id);
            if(docenteQueEstoyBuscandoParaEditar.isPresent()){
                //Modifico ese docente
                docenteQueEstoyBuscandoParaEditar.get().setEspecialidad(datosNuevosDocente.getEspecialidad());

                //guardo las modificaciones en BD
                return this.repositorio.save(docenteQueEstoyBuscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_DOCENTE_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //metodo para eliminar
    public boolean eliminarDocente(Integer id)throws Exception{
        try{
            Optional<Docente>docenteQueBusco=this.repositorio.findById(id);
            if(docenteQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_DOCENTE_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }




}

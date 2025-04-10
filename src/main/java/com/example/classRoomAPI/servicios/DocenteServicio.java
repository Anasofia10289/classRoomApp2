package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.repositorios.IDocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

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

    //metodo para modificar

    //metodo para eliminar



}

package com.example.colegioelite.servicios;

import com.example.colegioelite.entidades.Acudiente;
import com.example.colegioelite.repositorio.AcudienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class Acudienteservicio implements ServicioBase <Acudiente> {


    @Autowired //inyectar una dependecia.
    protected AcudienteRepositorio acudienteRepositorio;

    //el throws es por si no se encuentra nada en la base de datos envia un mensaje.
    @Override
    public List<Acudiente> buscartodos() throws Exception {
       try{
           List<Acudiente>acudientes=acudienteRepositorio.findAll();
           return acudientes;

       }catch(Exception error){
           throw new Exception(error.getMessage());

           }


    }

    @Override
    public Acudiente buscarporId(Integer id) throws Exception {
        try{
           Optional<Acudiente>acudienteopcional =acudienteRepositorio.findById(id);
            if (acudienteopcional.isPresent()){
                return acudienteopcional.get();
            }else{
                throw new Exception("USUARIO NO ENCONTRADO");  //no lo encontro
            }

         }catch(Exception error){
        throw new Exception(error.getMessage()); //error interno

        }


    }

    @Override
    public Acudiente registrar(Acudiente datosaregistrar) throws Exception {
        try {

            Acudiente acudienteguardado = acudienteRepositorio.save(datosaregistrar);
            return acudienteguardado;

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Acudiente actualizar(Integer ID, Acudiente datosnuevos) throws Exception {
        try{
            Optional<Acudiente>acudienteopcional =acudienteRepositorio.findById(ID);
            if (acudienteopcional.isPresent()){
               Acudiente acudienteExisitente=acudienteopcional.get();
               acudienteExisitente.setNombre(datosnuevos.getNombre());
               acudienteExisitente.setTelefono(datosnuevos.getTelefono());
               Acudiente acudienteActualizado=acudienteRepositorio.save(acudienteExisitente);
               return acudienteActualizado;
            }else{
                throw new Exception("USUARIO NO ENCONTRADO");
            }

        }catch (Exception error) {
           throw new Exception(error.getMessage());
       }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try{
            Optional<Acudiente>acudienteopcional =acudienteRepositorio.findById(id);
            if (acudienteopcional.isPresent()){
                acudienteRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("USUARIO NO ENCONTRADO");
            }

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

}

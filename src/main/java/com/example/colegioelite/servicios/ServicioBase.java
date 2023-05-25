package com.example.colegioelite.servicios;

import java.util.List;

//Poner E significa que puede bucar en cualquier tabla y la vuelve generica.
public interface ServicioBase<E> {
    public List<E> buscartodos() throws Exception;
    public E buscarporId (Integer id) throws Exception;
    public E registrar(E datosaregistrar) throws Exception;
    public E actualizar (Integer ID, E datosnuevos) throws Exception;
    public boolean eliminar(Integer id) throws Exception;

}

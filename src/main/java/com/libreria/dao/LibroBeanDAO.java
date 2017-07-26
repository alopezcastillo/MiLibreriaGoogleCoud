package com.libreria.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;
import com.libreria.data.LibroBean;
import java.util.List;
import java.util.logging.Logger;

/**
 * Acceso a datos de Libro
 */
public class LibroBeanDAO {

    private static final Logger LOGGER = Logger.getLogger(LibroBeanDAO.class.getName());

    /**
     * @return Devuelve una lista de libros.
     */
    public List<LibroBean> list() {
        LOGGER.info("Retrieving list of beans");
        return ofy().load().type(LibroBean.class).list();
    }
    /**
     * @return Lista de libros ordenada por autor.
     */
    public List<LibroBean> listPorAutor() {
        LOGGER.info("Recuperando libros ordenados por autor");
        List<LibroBean> retorno = ofy().load().type(LibroBean.class).order("autor").list();
        LOGGER.info("Recuperados " +retorno.size()+" libros ");
        return retorno;
    }

    /**
     * @param id
     * @return devuelve un libro a partir de su id.
     */
    public LibroBean get(Long id) {
        LOGGER.info("Retrieving bean " + id);
        return ofy().load().type(LibroBean.class).id(id).now();
    }

    /**
     * Guarda el libro dado
     * @param libro
     */
    public void save(LibroBean libro) {
        if (libro == null) {
            throw new IllegalArgumentException("null object");
        }
        LOGGER.info("Guardando libro con id: " + libro.getId()+" titulo:  "+libro.getNombre());
        ofy().save().entity(libro).now();
    }

    /**
     * Borra el ibro dado
     * @param bean
     */
    public void delete(LibroBean bean) {
        if (bean == null) {
            throw new IllegalArgumentException("null test object");
        }
        LOGGER.info("Borrando libro: " + bean.getId());
        ofy().delete().entity(bean);
    }
}

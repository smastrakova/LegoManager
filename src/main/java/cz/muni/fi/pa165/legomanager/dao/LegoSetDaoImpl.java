package cz.muni.fi.pa165.legomanager.dao;

import cz.muni.fi.pa165.legomanager.entities.LegoSet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Marek Abaffy <abaffy.m@gmail.com>
 * @date 24.10.2015
 */

@Repository
public class LegoSetDaoImpl implements LegoSetDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public LegoSet findById(Long id) {
        return em.find(LegoSet.class, id);
    }

    @Override
    public void create(LegoSet ls) {
        em.persist(ls);
    }

    @Override
    public void delete(LegoSet ls) {
        em.remove(ls);
    }

    @Override
    public List<LegoSet> findAll() {
        return em.createQuery("SELECT ls FROM LegoSet ls", LegoSet.class).getResultList();
    }
}
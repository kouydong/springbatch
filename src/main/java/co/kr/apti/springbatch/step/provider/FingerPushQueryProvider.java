package co.kr.apti.springbatch.step.provider;

import org.springframework.batch.item.database.orm.AbstractJpaQueryProvider;


import javax.persistence.EntityManager;
import javax.persistence.Query;

/*
public class FingerPushQueryProvider extends AbstractJpaQueryProvider {


    public Query createQuery() {

        EntityManager entiMana = getEntityManager();

        Query query = entiMana.createQuery("select ");

        query.setParameter("aa","bb");

        return query;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public EntityManager getEntityManager() {
        EntityManager entiMana = getEntityManager();
        return entiMana;
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }


}

 */

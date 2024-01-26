package com.project.test.validator;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import org.apache.commons.lang3.math.NumberUtils;


@Stateless
public class ValidatorEjb implements Serializable {

    public <T> T getSingleResult(final TypedQuery<T> query) {
        return query.setMaxResults(NumberUtils.INTEGER_ONE).getResultList()
                .parallelStream().findFirst().orElse(null);
    }

}

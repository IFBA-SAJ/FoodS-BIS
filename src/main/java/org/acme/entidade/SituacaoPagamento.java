package org.acme.entidade;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;


@Entity
@Table(name = "situacaoPagamento")
public class SituacaoPagamento extends PanacheEntity{

    @Enumerated(EnumType.STRING)
    public StatusPagamento status;

    public StatusPagamento getStatus() {
        return status;
    }

    
}

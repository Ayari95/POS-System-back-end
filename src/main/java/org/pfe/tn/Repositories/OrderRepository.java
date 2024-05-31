package org.pfe.tn.Repositories;

import org.pfe.tn.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long > {
}

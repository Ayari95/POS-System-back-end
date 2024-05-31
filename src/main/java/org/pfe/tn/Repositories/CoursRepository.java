package org.pfe.tn.Repositories;

import org.pfe.tn.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Product,Long > {


}

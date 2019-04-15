package pl.ave.dao;

import org.springframework.stereotype.Repository;
import pl.ave.model.Product;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long> {
}

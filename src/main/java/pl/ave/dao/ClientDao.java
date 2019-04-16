package pl.ave.dao;

import org.springframework.stereotype.Repository;
import pl.ave.model.Client;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {

}

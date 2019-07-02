package duoc.banco.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import duoc.banco.modelo.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, String> {

}

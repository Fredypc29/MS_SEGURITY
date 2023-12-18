package tda.MsSegurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tda.MsSegurity.model.UsuarioModel;

@Repository
public interface IAuthRepository extends CrudRepository<UsuarioModel, Integer> {
}

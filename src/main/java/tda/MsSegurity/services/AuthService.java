package tda.MsSegurity.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import TDA.MsSecurity.model.UsuarioModel;
import TDA.MsSecurity.repository.IAuthRepository;

public class AuthService implements IAuthService {

    @Autowired
    IAuthRepository authRepository;

    @Override
    public UsuarioModel add(UsuarioModel model) {
        return authRepository.save(model);
    }

    @Override
    public UsuarioModel update(UsuarioModel model) {
        return authRepository.save(model);
    }    
}

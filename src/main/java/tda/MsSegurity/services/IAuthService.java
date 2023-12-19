package tda.MsSegurity.services;
import java.util.List;

import tda.MsSegurity.model.UsuarioModel;

public interface IAuthService {
    public UsuarioModel add (UsuarioModel model);
    public UsuarioModel update (UsuarioModel model);
    public boolean delete (int id);
    public List<UsuarioModel> findAll ();
    public UsuarioModel findById (int id);
}

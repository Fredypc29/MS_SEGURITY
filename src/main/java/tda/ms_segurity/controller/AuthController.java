
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TDA.MsSecurity.config.UtilsProperties;
import TDA.MsSecurity.dto.AuthDTO;
import TDA.MsSecurity.model.UsuarioModel;
import TDA.MsSecurity.services.IAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private Logger logger = LoggerFactory.getLogger(AuthController.class);
	@Autowired
	private IAuthService authService;

	@Autowired
	private UtilsProperties prop;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			List<UsuarioModel> listaAuth = authService.findAll();

			List<AuthDTO> listaDTO = listaAuth.stream().map(x -> {
				ModelMapper m = new ModelMapper();
				return m.map(x, AuthDTO.class);
			}).collect(Collectors.toList());

			return new ResponseEntity<>(listaDTO, HttpStatus.OK);
			
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(prop.MSG_ERROR_RECUPERAR);
		}
	}

	@GetMapping("/getById")
	public ResponseEntity<?> getById(int id) {
		try {
			ModelMapper m = new ModelMapper();
			UsuarioModel obj = authService.findById(id);
			
			if(obj != null) {
				AuthDTO dto = m.map(authService.findById(id), AuthDTO.class);

				return new ResponseEntity<>(dto, HttpStatus.OK);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(prop.MSG_NO_ENCONTRADO);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(prop.MSG_ERROR_RECUPERAR);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody AuthDTO model) {
		try {
			ModelMapper m = new ModelMapper();
			UsuarioModel obj = m.map(model, UsuarioModel.class);
			authService.add(obj);
			return ResponseEntity.status(HttpStatus.OK).body(prop.MSG_EXITO_GUARDAR);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(prop.MSG_ERROR_PROCESAR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody AuthDTO model) {
		try {
			ModelMapper m = new ModelMapper();
			UsuarioModel obj = m.map(model, UsuarioModel.class);
			authService.update(obj);
			return ResponseEntity.status(HttpStatus.OK).body(prop.MSG_EXITO_ACTUALIZAR);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(prop.MSG_ERROR_PROCESAR);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(int id) {
		try {
			UsuarioModel obj = authService.findById(id);
			
			if(obj != null) {
				authService.delete(id);
				
				return ResponseEntity.status(HttpStatus.OK).body(prop.MSG_EXITO_ELIMINAR);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(prop.MSG_NO_ENCONTRADO);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(prop.MSG_ERROR_PROCESAR);
		}
	}
}

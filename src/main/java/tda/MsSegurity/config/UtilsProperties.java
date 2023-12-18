package tda.MsSegurity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UtilsProperties {

    @Value("${prop.MSG1}")
    public String MSG_EXITO_GUARDAR;

    @Value("${prop.MSG2}")
    public String MSG_EXITO_ACTUALIZAR;

    @Value("${prop.MSG3}")
    public String MSG_EXITO_ELIMINAR;

    @Value("${prop.MSG4}")
    public String MSG_NO_ENCONTRADO;

    @Value("${prop.MSG5}")
    public String MSG_ERROR_RECUPERAR;

    @Value("${prop.MSG6}")
    public String MSG_ERROR_PROCESAR;
}



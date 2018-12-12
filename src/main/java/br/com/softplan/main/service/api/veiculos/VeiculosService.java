package br.com.softplan.main.service.api.veiculos;

import java.util.Map;

public interface VeiculosService {
    Map< Object, String > getVeiculos();

    Veiculo findVeiculoByName(String name) throws Exception;
}

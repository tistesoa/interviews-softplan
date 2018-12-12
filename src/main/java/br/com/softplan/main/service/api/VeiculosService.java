package br.com.softplan.main.service.api;

import br.com.softplan.main.service.api.veiculos.Veiculo;

import java.util.Map;

public interface VeiculosService {
    Map< Object, String > getVeiculosAsMap();

    Veiculo findVeiculoByName(String name) throws Exception;
}

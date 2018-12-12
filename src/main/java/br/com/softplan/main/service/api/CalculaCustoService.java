package br.com.softplan.main.service.api;


import br.com.softplan.main.service.api.veiculos.Carga;
import br.com.softplan.main.service.api.commons.LogisticaDTO;

public interface CalculaCustoService {

    double calculaCustoServico(LogisticaDTO dto, Carga carga) throws Exception;
}

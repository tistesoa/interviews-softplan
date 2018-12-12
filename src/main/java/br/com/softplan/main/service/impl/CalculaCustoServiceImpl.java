package br.com.softplan.main.service.impl;

import br.com.softplan.main.service.api.CalculaCustoService;
import br.com.softplan.main.service.api.commons.LogisticaDTO;
import br.com.softplan.main.service.api.veiculos.Carga;
import br.com.softplan.main.service.api.commons.TipoVia;
import br.com.softplan.main.service.api.veiculos.Veiculo;
import br.com.softplan.main.service.api.VeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculaCustoServiceImpl implements CalculaCustoService {

    @Autowired
    VeiculosService veiculosService;

    @Override
    public double calculaCustoServico(LogisticaDTO dto, Carga carga) throws Exception {
        return calculaCustoManutencaoVeiculoPelaDistancia(dto) + carga.calculaCustoCarga(dto.getCargaTransp(),
                dto.getDistRodNaoPavimentada()+dto.getDistRodPavimentada()) ;
    }

    public double calculaCustoDistanciaPercorrida(LogisticaDTO dto){
        return (TipoVia.Pavimentada.getCusto() * dto.getDistRodPavimentada())
                + (TipoVia.Nao_Pavimentada.getCusto() * dto.getDistRodNaoPavimentada());
    }

    public double calculaCustoManutencaoVeiculoPelaDistancia(LogisticaDTO dto) throws Exception {
        Veiculo veiculoByName = veiculosService.findVeiculoByName(dto.getVeiculo());
        return calculaCustoDistanciaPercorrida(dto) * veiculoByName.getFatorMultiplicador();
    }
}

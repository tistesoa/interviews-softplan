package br.com.softplan.main.service.impl.veiculos;

import br.com.softplan.main.service.api.veiculos.Veiculo;
import org.springframework.stereotype.Component;

@Component
public class CaminhaoCacamba implements Veiculo {
    private final double fator = 1.05;


    public double getFatorMultiplicador() {
        return fator;
    }

    @Override
    public String getLabel() {
        return "Caminhão Caçamba";
    }

}

package br.com.softplan.main.service.impl.veiculos;

import br.com.softplan.main.service.api.veiculos.VeiculosService;
import br.com.softplan.main.service.api.veiculos.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@ApplicationScope
public class VeiculosServiceImpl implements VeiculosService {


    @Autowired
    private List<? extends Veiculo> veiculos;

    @Override
    public Map< Object, String > getVeiculos(){
        Map< Object, String > veiculos = new HashMap<>();
        for (Veiculo veiculo : this.veiculos) {
            veiculos.put(veiculo.getName(),veiculo.getLabel());
        }
        return veiculos;
    }

    @Override
    public Veiculo findVeiculoByName(String name) throws Exception{
        return veiculos.stream().filter(veiculo -> ((Veiculo) veiculo).getName().equals(name)).findAny().orElseThrow(Exception::new);
    }
}

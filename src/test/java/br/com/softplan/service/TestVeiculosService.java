package br.com.softplan.service;


import br.com.softplan.main.service.api.veiculos.Veiculo;
import br.com.softplan.main.service.impl.VeiculosServiceImpl;
import br.com.softplan.main.service.impl.veiculos.CaminhaoBau;
import br.com.softplan.main.service.impl.veiculos.CaminhaoCacamba;
import br.com.softplan.main.service.impl.veiculos.Carreta;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestVeiculosService {


    @Spy
    private List<Veiculo> veiculos;


    @InjectMocks
    VeiculosServiceImpl service;


    public TestVeiculosService() {
        this.veiculos = new ArrayList<>();
        veiculos.add(new Carreta());
        veiculos.add(new CaminhaoBau());
        veiculos.add(new CaminhaoCacamba());
    }

    @Before
    public void configura() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindVeiculosbyNameCarreta() throws Exception {
        Veiculo veiculo = veiculos.get(0);
        assertEquals(veiculo, service.findVeiculoByName(veiculo.getName()));
    }

    @Test
    public void testFindVeiculosbyNameCaminhaoBau() throws Exception {
        Veiculo veiculo = veiculos.get(1);
        assertEquals(veiculo, service.findVeiculoByName(veiculo.getName()));
    }

    @Test
    public void testFindVeiculosbyNameCaminhaoCacamba() throws Exception {
        Veiculo veiculo = veiculos.get(2);
        assertEquals(veiculo, service.findVeiculoByName(veiculo.getName()));
    }
}

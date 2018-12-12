package br.com.softplan.service;

import br.com.softplan.main.service.api.veiculos.Carga;
import br.com.softplan.main.service.api.commons.LogisticaDTO;
import br.com.softplan.main.service.api.veiculos.Veiculo;
import br.com.softplan.main.service.api.veiculos.VeiculosService;
import br.com.softplan.main.service.impl.CalculaCustoServiceImpl;
import br.com.softplan.main.service.impl.carga.CargaPadrao;
import br.com.softplan.main.service.impl.veiculos.CaminhaoBau;
import br.com.softplan.main.service.impl.veiculos.CaminhaoCacamba;
import br.com.softplan.main.service.impl.veiculos.Carreta;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class TestCalculaCustoServiceParaCargaPadrao {

    @InjectMocks
    CalculaCustoServiceImpl service;

    @Mock
    VeiculosService veiculosService;

    private Carga carga;

    private LogisticaDTO createDTO(int distanciaPavimentada,
                                   int distanciaNaoPavimentada,
                                   Veiculo veiculo,
                                   int cargaTransportadora){
        LogisticaDTO dto = new LogisticaDTO();
        dto.setDistRodPavimentada(distanciaPavimentada);
        dto.setDistRodNaoPavimentada(distanciaNaoPavimentada);
        dto.setVeiculo(veiculo.getName());
        dto.setCargaTransp(cargaTransportadora);
        return dto;
    }


    @Before
    public void configura() {
        carga = new CargaPadrao();
    }

    @Test
    public void testCalculaCustoDistanciaPercorrida() throws Exception {
        Veiculo caminhaoCacamba = new CaminhaoCacamba();
        LogisticaDTO dto = createDTO(100, 0, caminhaoCacamba, 8);
        double result = service.calculaCustoDistanciaPercorrida(dto);
        assertEquals(54.0, result);
    }

    @Test
    public void testCalculaCustoManutencaoVeiculoPelaDistanciaPercorrida() throws Exception {
        Veiculo caminhaoCacamba = new CaminhaoCacamba();
        when(veiculosService.findVeiculoByName(any())).thenReturn(caminhaoCacamba);
        LogisticaDTO dto = createDTO(100, 0, caminhaoCacamba, 8);
        double result = service.calculaCustoManutencaoVeiculoPelaDistancia(dto);
        assertEquals(56.70, result);
    }


    @Test
    public void testCalculaCustoServicoCaminhaoCacamba() throws Exception {
        Veiculo veiculo = new CaminhaoCacamba();
        when(veiculosService.findVeiculoByName(any())).thenReturn(veiculo);
        LogisticaDTO dto = createDTO(100, 0,veiculo, 8);
        assertEquals(62.70, service.calculaCustoServico(dto, carga));

        veiculo = new CaminhaoCacamba();
        when(veiculosService.findVeiculoByName(any())).thenReturn(veiculo);
        dto = createDTO(50, 30, veiculo,5);
        assertEquals(47.88, service.calculaCustoServico(dto, carga));
    }

    @Test
    public void testCalculaCustoServicoCaminhaoBau() throws Exception {
        Veiculo veiculo = new CaminhaoBau();
        when(veiculosService.findVeiculoByName(any())).thenReturn(veiculo);
        LogisticaDTO dto = createDTO(0, 60, veiculo,4);
        assertEquals(37.20, service.calculaCustoServico(dto, carga));

        veiculo = new CaminhaoBau();
        when(veiculosService.findVeiculoByName(any())).thenReturn(veiculo);
        dto = createDTO(80, 20, veiculo,6);
        assertEquals(57.60, service.calculaCustoServico(dto, carga));

    }

    public void testCalculaCustoServicoCarreta() throws Exception {
        Veiculo veiculo = new Carreta();
        when(veiculosService.findVeiculoByName(any())).thenReturn(veiculo);
        LogisticaDTO dto = createDTO(0, 180, veiculo,12);
        assertEquals(150.192, service.calculaCustoServico(dto, carga));

    }
}

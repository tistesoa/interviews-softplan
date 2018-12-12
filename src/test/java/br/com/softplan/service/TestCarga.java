package br.com.softplan.service;

import br.com.softplan.main.service.api.veiculos.Carga;
import br.com.softplan.main.service.impl.carga.CargaPadrao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestCarga {

    private Carga carga;


    @Before
    public void configura() {
        carga = new CargaPadrao();
    }

    @Test
    public void testCalculaCustoCargaPadrao() {
        double result = carga.calculaCustoCarga(8,100);
        assertEquals(6.0, result);
    }
}

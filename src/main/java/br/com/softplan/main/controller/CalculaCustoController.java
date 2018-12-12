package br.com.softplan.main.controller;

import br.com.softplan.main.service.api.CalculaCustoService;
import br.com.softplan.main.service.api.VeiculosService;
import br.com.softplan.main.service.api.commons.LogisticaDTO;
import br.com.softplan.main.service.impl.carga.CargaPadrao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.NumberFormat;

@Controller
public class CalculaCustoController {


    @Autowired
    CalculaCustoService service;

    @Autowired
    VeiculosService veiculosService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView init() {
        ModelAndView modelAndView = new ModelAndView("index", "logisticaDTO", new LogisticaDTO());
        modelAndView.getModel().put("veiculos", veiculosService.getVeiculosAsMap());
        return modelAndView;
    }


    @RequestMapping(value = "/calcCusto", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("logisticaDTO") LogisticaDTO logisticaDTO,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        try {
            double valor = service.calculaCustoServico(logisticaDTO, new CargaPadrao());
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
            String total = currencyInstance.format(valor);
            model.addAttribute("distRodPavimentada", logisticaDTO.getDistRodPavimentada());
            model.addAttribute("distRodNaoPavimentada", logisticaDTO.getDistRodNaoPavimentada());
            model.addAttribute("veiculo", logisticaDTO.getVeiculo());
            model.addAttribute("cargaTransp", logisticaDTO.getCargaTransp());
            model.addAttribute("total", total);
            logisticaDTO.getVeiculo();
            return "result";
        } catch (Exception e) {
            return "error";
        }

    }

}
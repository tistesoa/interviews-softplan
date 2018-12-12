package br.com.softplan.main.service.api.veiculos;

public interface Veiculo {

    double getFatorMultiplicador();

    default String getName() {
        return this.getClass().getSimpleName();
    }

    String getLabel();
}

package br.com.softplan.main.service.api.veiculos;

public abstract class Carga {
    private double pesoMinimo;
    private double custoManutencao;



    public Carga(double pesoMinimo, double custoManutencao){

        this.pesoMinimo = pesoMinimo;
        this.custoManutencao = custoManutencao;
    }


    public double calculaCustoCarga(int peso, int distancia){
        return pesoMinimo > peso ? 0 : distancia * (peso - pesoMinimo) * custoManutencao;
    }
}

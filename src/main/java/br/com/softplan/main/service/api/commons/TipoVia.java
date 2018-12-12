package br.com.softplan.main.service.api.commons;

public enum TipoVia {
    Pavimentada(0.54), Nao_Pavimentada(0.62);


    double custo;

    TipoVia(double custo){
        this.custo = custo;
    }

    public double getCusto(){
        return custo;
    }

}

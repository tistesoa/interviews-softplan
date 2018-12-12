package br.com.softplan.main.service.api.commons;



public class LogisticaDTO {

    private int distRodPavimentada;
    private int distRodNaoPavimentada;
    private String veiculo;
    private int cargaTransp;



    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }


    public int getDistRodPavimentada() {
        return distRodPavimentada;
    }

    public void setDistRodPavimentada(int distRodPavimentada) {
        this.distRodPavimentada = distRodPavimentada;
    }

    public int getDistRodNaoPavimentada() {
        return distRodNaoPavimentada;
    }

    public void setDistRodNaoPavimentada(int distRodNaoPavimentada) {
        this.distRodNaoPavimentada = distRodNaoPavimentada;
    }

    public int getCargaTransp() {
        return cargaTransp;
    }

    public void setCargaTransp(int cargaTransp) {
        this.cargaTransp = cargaTransp;
    }
}

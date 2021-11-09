package br.com.unoseg.services;

public class CEPService {
    private String CEP;
    public CEPService(String cep) {
        this.CEP = cep;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Boolean iscep() {
        return getCEP().matches("[0-9]{5}-[0-9]3");
    }
}

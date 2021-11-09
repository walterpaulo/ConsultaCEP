package br.com.unoseg.services;

import br.com.unoseg.config.APICEP;
import br.com.unoseg.models.CEPModel;

import java.util.Optional;

public class CEPService {
    private CEPModel cepModel;

    public CEPService(CEPModel cepModel) {
        this.setCepModel(cepModel);
    }

    public CEPModel getCepModel() {
        return cepModel;
    }

    public void setCepModel(CEPModel cepModel) {
        this.cepModel = cepModel;
    }

    public Boolean iscep() {
        return cepModel.getCEP().matches("[0-9]{5}-[0-9]{3}");
    }

    public CEPModel getCEP() {
        Optional<CEPModel> obj = null;
        APICEP apicep = new APICEP(cepModel.getCEP());
        if (iscep()){
            return apicep.getvalor();
        }
        return null;
    }
}

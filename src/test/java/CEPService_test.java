import br.com.unoseg.models.CEPModel;
import br.com.unoseg.services.CEPService;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CEPService_test {

    @Test
    public void isCEP_TEST(){
        CEPModel cepModel = new CEPModel("01311-000");
        CEPService cepService = new CEPService(cepModel);
        final Boolean obtido = cepService.iscep();
        final Boolean achei = true;
        Assert.assertEquals(achei,obtido);
    }

    @Test
    public void getCEP_Test(){
        CEPModel cepModel = new CEPModel("74020-200");
        CEPService cepService = new CEPService(cepModel);
        final CEPModel obtido = cepService.getCEP();
        Assert.assertEquals(obtido.getCEP(), "74020-200");
        Assert.assertEquals(obtido.getLogradouro(), "Avenida Goiás");
        Assert.assertEquals(obtido.getComplemento(), "de 550 a 1118 - lado par");
        Assert.assertEquals(obtido.getBairro(), "Setor Central");
        Assert.assertEquals(obtido.getLocalidade(), "Goiânia");
        Assert.assertEquals(obtido.getUf(), "GO");
        Assert.assertEquals(obtido.getIbge(), "5208707");
        Assert.assertEquals(obtido.getGia(), "");
        Assert.assertEquals(obtido.getDdd(), "62");
        Assert.assertEquals(obtido.getSiafi(), "9373");

    }
    @Test
    public void getCEPNull_Test(){
        CEPModel cepModel = new CEPModel("12344-200");
        CEPService cepService = new CEPService(cepModel);
        final CEPModel obtido = cepService.getCEP();
        Assert.assertEquals(obtido.getError(), true);
    }
}

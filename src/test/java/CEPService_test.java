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
    String cep = "01311-000";
    CEPService cepService = new CEPService(cep);
    final Boolean obtido = cepService.iscep();
    final Boolean achei = true;
        Assert.assertEquals(achei,obtido);
    }

    @Test
    public void getCEP_Test(){
        String cep = "01311-000";
        CEPService cepService = new CEPService(cep);
        final List<CEPModel> obtido = cepService.getCEP();
    }
}

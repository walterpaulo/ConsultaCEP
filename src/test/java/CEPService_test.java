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
        CEPModel cepModel = new CEPModel("01311-000");
        CEPService cepService = new CEPService(cepModel);
        final CEPService obtido = cepService.getCEP();
    }
}

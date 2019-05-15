package fligths.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fligths.pages.ConfirmacionPage;
import fligths.utils.TestContext;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ConfirmacionPageSteps {
    private ConfirmacionPage confirmacionPage;
    private TestContext testContext;
    private WebDriver driver;

    public ConfirmacionPageSteps(TestContext testContext){
        this.testContext = testContext;
        driver = this.testContext.getWebDriverManager().getDriver();
        confirmacionPage = new ConfirmacionPage(driver);
    }

    @Then("^verifico que estoy en la pagina de confirmacion de reserva$")
    public void verificoQueEstoyEnLaPaginaDeConfirmacionDeReserva() {
        Assert.assertTrue(confirmacionPage.verificarTitulo(),
                "la pagina actual no es la esperada");
    }

    @And("^verico que mi reserva fue confirmada$")
    public void vericoQueMiReservaFueConfirmada() {
        Assert.assertTrue(confirmacionPage.verificarEstado("CONFIRMADA"), "el estado de la reserva no es el esperado");
    }

    @And("^verifico datos de pago \"([^\"]*)\", \"([^\"]*)\", tipo de tarjeta \"([^\"]*)\" y \"([^\"]*)\"$")
    public void verificoDatosDePagoTipoDeTarjetaY(String nombre, String apellido, String tipo, String pais){
        Assert.assertEquals(nombre, confirmacionPage.getNombre(), "el nombres no es correcto");
        Assert.assertEquals(apellido, confirmacionPage.getApellido(), "el apellido no es correcto");
        Assert.assertEquals(tipo, confirmacionPage.getTipoTarjeta(), "el tipo de tarjeta no es correcto");
        Assert.assertEquals(pais, confirmacionPage.getPais(), "el pais no es correcto");
    }
}

package fligths.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fligths.pages.VuelosPage;
import fligths.utils.TestContext;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VuelosPageSteps {
    private VuelosPage vuelosPage;
    private TestContext testContext;
    private WebDriver driver;

    public VuelosPageSteps(TestContext testContext){
        this.testContext = testContext;
        driver = this.testContext.getWebDriverManager().getDriver();
        vuelosPage = new VuelosPage(driver);
    }

    @Then("^verifico que estoy en la pagina de vuelos$")
    public void verificoQueEstoyEnLaPaginaDeVuelos() {
        Assert.assertTrue(vuelosPage.verificarTitulo(), "la pagina actual no es la esperada");
    }

    @And("^verifico los datos de mi busqueda \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" y \"([^\"]*)\"$")
    public void verificoLosDatosDeMiBusquedaY(int pasajeros, String clase, String salida, String regreso){
        Assert.assertTrue(vuelosPage.verificarDatos(pasajeros, clase, salida, regreso), "los datos de la busqueda no coinciden");
    }

    @And("^verifico que hay resultados para mi busqueda$")
    public void verificoQueHayResultadosParaMiBusqueda() {
        Assert.assertTrue(vuelosPage.verificarHayResultados(), "no hay resultados para la busqueda");
    }

    @Then("^selecciono el primer resultado$")
    public void seleccionoElPrimerResultado() {
        vuelosPage.seleccionarPrimerResultado();
    }
}

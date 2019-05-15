package fligths.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(how = How.NAME, using = "optradio1")
    @CacheLookup
    private WebElement radioIdaVuelta;

    @FindBy(how = How.ID, using = "from")
    @CacheLookup
    private WebElement selectDesde;

    @FindBy(how = How.ID, using = "to")
    @CacheLookup
    private WebElement selectA;

    @FindBy(how = How.CSS, using = "input[type='text'][ng-model='dateFrom']")
    @CacheLookup
    private WebElement fechaSalida;

    @FindBy(how = How.CSS, using = "input[type='text'][ng-model='dateto']")
    @CacheLookup
    private WebElement fechaRegreso;

    @FindBy(how = How.ID, using = "classId")
    @CacheLookup
    private WebElement selectClase;

    @FindBy(how = How.ID, using = "passenger")
    @CacheLookup
    private WebElement selectPasajeros;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Buscar')]")
    @CacheLookup
    private WebElement botonBuscar;

    private By diaActivoLocator = By.cssSelector("td.active");

    private String url = properties.getString("URL");

    public HomePage(WebDriver driver) {
        super(driver);
        titulo = "AUT Vuelos – Verstand QA";
        PageFactory.initElements(driver, this);
    }

    public void buscarVuelo(String desde, String a, String fechaSalida, String fechaRegreso,
                                    String clase, int cantPasajeros){
        selectByText(selectDesde, desde);
        selectByText(selectA, a);
        this.fechaSalida.sendKeys(fechaSalida);
        findElement(diaActivoLocator).click();
        this.fechaRegreso.sendKeys(fechaRegreso);
        findElement(diaActivoLocator).click();
        selectByText(selectClase, clase);
        selectByText(selectPasajeros, String.valueOf(cantPasajeros));
    }

    public void navegarAInicio() {
        driver.get(url);
        addWait();
    }

    public boolean verificarTitulo() {
        return validateTitle(titulo);
    }

    public void buscar() {
        botonBuscar.click();
        addWait();
    }
}

package fligths.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PagoPage extends BasePage {

    @FindBy(how = How.ID, using = "cards")
    @CacheLookup
    private WebElement selectTipo;

    @FindBy(how = How.ID, using = "cardNumber")
    @CacheLookup
    private WebElement cardNumber;

    @FindBy(how = How.ID, using = "code")
    @CacheLookup
    private WebElement code;

    @FindBy(how = How.ID, using = "month")
    @CacheLookup
    private WebElement selectMes;

    @FindBy(how = How.ID, using = "year")
    @CacheLookup
    private WebElement selectYear;

    @FindBy(how = How.CSS, using = "input[placeholder='Nombre']")
    @CacheLookup
    private WebElement inputNombre;

    @FindBy(how = How.CSS, using = "input[placeholder='Apellido']")
    @CacheLookup
    private WebElement inputApellido;

    @FindBy(how = How.ID, using = "country")
    @CacheLookup
    private WebElement selectPais;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Comprar')]")
    @CacheLookup
    private WebElement botonComprar;


    public PagoPage(WebDriver driver) {
        super(driver);
        titulo = "AUT Vuelos Paso3 – Verstand QA";
        PageFactory.initElements(driver, this);
    }

    public boolean verificarTitulo() {
        return validateTitle(titulo);
    }

    public void completarDatosTarjeta(String tipo, String numero, String cvc, String mes, String year, String nombre,
                                      String apellido, String pais) {
        selectByText(selectTipo, tipo);
        cardNumber.sendKeys(numero);
        code.sendKeys(cvc);
        selectByText(selectMes,mes);
        selectByText(selectYear, year);
        inputNombre.sendKeys(nombre);
        inputApellido.sendKeys(apellido);
        selectByText(selectPais, pais);
    }

    public void comprar() {
        botonComprar.click();
        addWait();
    }
}

package fligths.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VuelosPage extends BasePage{

    private By pasajerosYClaseLocator = By.cssSelector("div.panel-heading div.pull-left");
    private By salidaYRegresoLocator = By.cssSelector("div.panel-heading div.pull-right");
    private By resultadosLocator = By.className("list-group-item");

    public VuelosPage(WebDriver driver) {
        super(driver);
        titulo = "AUT Vuelos Paso2 – Verstand QA";
    }

    public boolean verificarTitulo() {
        return validateTitle(titulo);
    }

    public boolean verificarDatos(int pasajeros, String clase, String salida, String regreso) {
        highlighterElement(findElement(pasajerosYClaseLocator));
        highlighterElement(findElement(salidaYRegresoLocator));
        return findElement(pasajerosYClaseLocator).getText().equals(pasajeros + " Pasajero | " + clase) &&
                findElement(salidaYRegresoLocator).getText().equals(salida + " - " + regreso);
    }

    public boolean verificarHayResultados() {
        return findElements(resultadosLocator).size() > 0;
    }

    public void seleccionarPrimerResultado() {
        findElements(resultadosLocator).get(0).click();
        addWait();
    }
}

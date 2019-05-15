package fligths.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmacionPage extends BasePage {

    private String estadoReservaXPATH = "//label[contains(text(), 'Su reserva está ?')]";
    private final String nombreXPATH = "//label[contains(text(), 'Nombre:')]";
    private final String apellidoXPATH = "//label[contains(text(), 'Apellido:')]";
    private final String tipoTarjetaXPATH = "//label[contains(text(), 'Tarjeta:')]";
    private final String paisXPATH = "//label[contains(text(), 'País:')]";

    public ConfirmacionPage(WebDriver driver) {
        super(driver);
        titulo = "AUT Vuelos Paso4 – Verstand QA";
    }

    public boolean verificarTitulo() {
        return validateTitle(titulo);
    }

    public boolean verificarEstado(String estado) {
        estadoReservaXPATH = estadoReservaXPATH.replace("?", estado);
        return findElement(By.xpath(estadoReservaXPATH)).isDisplayed();
    }

    public String getNombre() {
        highlighterElement(findElement(By.xpath(nombreXPATH)));
        return findElement(By.xpath(nombreXPATH)).getText().replace("Nombre: ", "");
    }

    public String getApellido() {
        highlighterElement(findElement(By.xpath(apellidoXPATH)));
        return findElement(By.xpath(apellidoXPATH)).getText().replace("Apellido: ", "");
    }

    public String getTipoTarjeta() {
        highlighterElement(findElement(By.xpath(tipoTarjetaXPATH)));
        return findElement(By.xpath(tipoTarjetaXPATH)).getText().replace("Tarjeta: ", "");
    }

    public String getPais() {
        highlighterElement(findElement(By.xpath(paisXPATH)));
        return findElement(By.xpath(paisXPATH)).getText().replace("País: ", "");
    }
}

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
        return findElement(By.xpath(nombreXPATH)).getText().replace("Nombre: ", "");
    }

    public String getApellido() {
        return findElement(By.xpath(apellidoXPATH)).getText().replace("Apellido: ", "");
    }

    public String getTipoTarjeta() {
        return findElement(By.xpath(tipoTarjetaXPATH)).getText().replace("Tarjeta: ", "");
    }

    public String getPais() {
        return findElement(By.xpath(paisXPATH)).getText().replace("País: ", "");
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[contains(text(),'Iniciar sesión')]")
    public WebElement btnIniciarSesion;

    @FindBy(xpath = "//a[contains(text(),'Cree una aquí')]")
    WebElement linkCrearCuenta;

    @FindBy(xpath = "//*[contains(normalize-space(),'Cerrar sesión')]")
    private WebElement linkCerrarSesion;


    @FindBy(xpath = "//*[@id='_desktop_user_info']//*[contains(@class,'account')]")
    private WebElement lblNombreUsuario;


    public void clickIniciarSesion(){
        btnIniciarSesion.click();
    }
    public void clickLinkCrearCuenta() {
        linkCrearCuenta.click();
    }
    public boolean usuarioEstaLogueado() {
        return linkCerrarSesion.isDisplayed() && lblNombreUsuario.isDisplayed();
    }

    public String obtenerNombreUsuario() {
        return lblNombreUsuario.getText().trim();
    }


}

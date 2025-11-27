package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistroPage {
    WebDriver driver;


    public RegistroPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-id_gender-2")
    WebElement radioTratamiento;
    @FindBy(id = "field-firstname")
    WebElement txtNombre;
    @FindBy(id = "field-lastname")
    WebElement txtApellidos;
    @FindBy(id = "field-email")
    WebElement txtEmail;
    @FindBy(id = "field-password")
    WebElement txtPassword;
    @FindBy(id = "field-birthday")
    WebElement txtFechaNacimiento;
    @FindBy(name = "psgdpr")
    WebElement chkTerminos;
    @FindBy(name = "customer_privacy")
    WebElement chkPrivacidadDatos;
    @FindBy(css = "button[type='submit'].form-control-submit")
    WebElement btnGuardar;

    public void seleccionarTratamientoSra() {
        radioTratamiento.click();
    }

    public void completarFormulario(String nombre, String apellido,
                                    String email, String password,
                                    String fechaNacimiento) {
        txtNombre.clear();
        txtNombre.sendKeys(nombre);

        txtApellidos.clear();
        txtApellidos.sendKeys(apellido);

        txtEmail.clear();
        txtEmail.sendKeys(email);

        txtPassword.clear();
        txtPassword.sendKeys(password);

        txtFechaNacimiento.clear();
        txtFechaNacimiento.sendKeys(fechaNacimiento);
    }

    public void aceptarTerminos() {
        if (!chkTerminos.isSelected()) {
            chkTerminos.click();
        }
    }

    public void aceptarPrivacidadDatos() {
        if (!chkPrivacidadDatos.isSelected()) {
            chkPrivacidadDatos.click();
        }
    }

    public void clickGuardar() {
        btnGuardar.click();
    }

}

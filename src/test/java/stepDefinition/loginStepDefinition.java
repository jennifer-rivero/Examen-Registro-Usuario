package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pages.HomePage;
import utility.BrowserDriver;
import pages.RegistroPage;



public class loginStepDefinition {

    private WebDriver driver;
    private HomePage HomePage;
    private RegistroPage RegistroPage;


    //Scenario: Registro en la web

    @Given("que estoy en la página principal de My Store")
    public void que_estoy_en_la_pagina_principal_de_my_store(){
        driver = BrowserDriver.getDriver();
        HomePage = new HomePage(driver);
    }
    @When("hago clic en el botón Iniciar sesión")
    public void doy_clic_en_el_boton_iniciar_sesion() {
        HomePage.clickIniciarSesion();
    }
    @When("doy clic en el link ¿No tiene una cuenta? Cree una aquí")
    public void doy_clic_en_el_link_no_tiene_una_cuenta_cree_una_aqui() {
        HomePage.clickLinkCrearCuenta();
        RegistroPage = new RegistroPage(driver);
    }


    @When("selecciono el tratamiento {string}")
    public void selecciono_el_tratamiento(String tratamiento) {
        // Por ahora solo manejamos "Sra."
        if (tratamiento.equalsIgnoreCase("Sra.")) {
            RegistroPage.seleccionarTratamientoSra();
        }
    }

    @When("completo el formulario de registro con {string}, {string}, {string}, {string}, {string}")
    public void completo_el_formulario_con_datos(String nombre, String apellido,
                                                 String email, String password,
                                                 String fecha) {
        RegistroPage.completarFormulario(nombre, apellido, email, password, fecha);
    }

    @When("acepto los términos y la política de privacidad")
    public void acepto_los_terminos_y_la_politica_de_privacidad() {
        RegistroPage.aceptarTerminos();
    }

    @When("acepto la privacidad de los datos del cliente")
    public void acepto_la_privacidad_de_los_datos_del_cliente() {
        RegistroPage.aceptarPrivacidadDatos();
    }

    @When("hago clic en el botón Guardar")
    public void hago_clic_en_el_boton_guardar() {
        RegistroPage.clickGuardar();
    }

    @Then("debería ver mi cuenta creada con éxito")
    public void deberia_ver_mi_cuenta_creada_con_exito() {

        Assert.assertTrue(
                "No se muestra la información de usuario logueado",
                HomePage.usuarioEstaLogueado()
        );
    }








}

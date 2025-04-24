package Page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    BasePage basePage;

    By inputUsusario = By.xpath("//input[@name='username']");
    By inputClave = By.xpath("//input[@name='password']");
    By buttonLogin = By.xpath("//button[contains(normalize-space(.),'Login')]");
    By pMensajeCredencialesIncorrectas = By.xpath("//p[contains(normalize-space(.),'Invalid credentials')]");
    By spinner = By.xpath("//div[contains(@class,'spinner')]");

    public void seMuestraElFormularioDelLogin() throws Exception {
        System.out.println("INFORMATIVO: Inicia la validacion para verificar la visibilidad del formulario del login");

        if(basePage.waitVisibleBooleanByTime(spinner, 6)){
            Serenity.takeScreenshot();
            basePage.waitInvisibleByTime(spinner, 180);
            basePage.waitForSeconds(1);
        }

        basePage.waitVisible(inputUsusario);
        System.out.println("Campo usuario visible");
        basePage.waitVisible(inputClave);
        System.out.println("Campo clave visible");
        basePage.waitVisible(buttonLogin);
        System.out.println("Boton Login visible");
        System.out.println("INFORMATIVO: Finaliza la validacion para verificar la visibilidad del formulario del login");
    }

    public void elUsuarioIngresaElUsuarioYClave(String usuario, String clave) throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion para ingresar el usuario y clave");

        basePage.sendKey(inputUsusario,usuario);
        basePage.waitForSeconds(1);
        System.out.println("Se ingreso el usuario: "+usuario);
        basePage.sendKey(inputClave,clave);
        basePage.waitForSeconds(1);
        System.out.println("Se ingreso la clave: "+clave);

        System.out.println("INFORMATIVO: Finaliza la accion para ingresar el usuario y clave");
    }

    public void elUsuarioHaceClickEnElBotonLOGIN() throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion para hacer click en el boton LOGIN");
        basePage.click(buttonLogin);
        System.out.println("Se hizo click en el boton LOGIN");
        System.out.println("INFORMATIVO: Finaliza la accion para hacer click en el boton LOGIN");
    }

    public void seMuestraElMensajeInvalidCredentials() {
        System.out.println("INFORMATIVO: Inicia la accion para validar que se muestre el mensaje InvalidCredentials");

        if(basePage.waitVisibleBooleanByTime(pMensajeCredencialesIncorrectas,15)){
            System.out.println("SUCCESS:Se muestra el mensaje InvalidCredentials cuando se ingresa credenciales incorrectas");
            Assert.assertTrue("SUCCESS: Se muestra el mensaje InvalidCredentials cuando se ingresa credenciales incorrectas",true);
        }else{
            System.out.println("FAIL:NO se muestra el mensaje InvalidCredentials cuando se ingresa credenciales incorrectas");
            Assert.fail("FAIL:NO se muestra el mensaje InvalidCredentials cuando se ingresa credenciales incorrectas");
        }

        System.out.println("INFORMATIVO: Finaliza la accion para validar que se muestre el mensaje InvalidCredentials");
    }
}

package Page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    BasePage basePage;

    By LabelDashboard = By.xpath("//h6[contains(normalize-space(.),'Dashboard')]");
    By spinner = By.xpath("//div[contains(@class,'spinner')]");
    By menuAdmin = By.xpath("//span[contains(normalize-space(.),'Admin')]/parent::a");

    public void seMuestraLaPaginaPrincipalDelHome() throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion para validar la visibilidad de un elemento seguro que identifique que estamos en la pagina HOME");

        if(basePage.waitVisibleBooleanByTime(spinner, 6)){
            Serenity.takeScreenshot();
            basePage.waitInvisibleByTime(spinner, 180);
            basePage.waitForSeconds(1);
        }

        basePage.waitVisible(LabelDashboard);
        System.out.println("LabelDashboard es visible");
        System.out.println("El login se realizo satisfactoriamente");
        System.out.println("INFORMATIVO: Finaliza la accion para validar la visibilidad de un elemento seguro que identifique que estamos en la pagina HOME");
    }

    public void seMuestraElMenuAdmin() {
        System.out.println("INFORMATIVO: Inicia la accion para validar la visibilidad de un elemento seguro que identifique que estamos en la pagina HOME");

        if(basePage.waitVisibleBooleanByTime(spinner, 3)){
            Serenity.takeScreenshot();
            basePage.waitInvisibleByTime(spinner, 180);
            basePage.waitForSeconds(1);
        }

        if(basePage.waitVisibleBooleanByTime(menuAdmin,15)){
            System.out.println("SUCCESS:Se muestra el menu Admin en la seccion izquierda de la pagina Home");
            Assert.assertTrue("SUCCESS:Se muestra el menu Admin en la seccion izquierda de la pagina Home",true);
        }else{
            System.out.println("FAIL:NO se muestra el menu Admin en la seccion izquierda de la pagina Home");
            Assert.fail("FAIL:NO se muestra el menu Admin en la seccion izquierda de la pagina Home");
        }
        System.out.println("INFORMATIVO: Finaliza la accion para validar la visibilidad de un elemento seguro que identifique que estamos en la pagina HOME");
    }

    public void elUsuarioHaceClickEnElMenuAdmin() throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion para hacer click en el menu Admin");
        basePage.click(menuAdmin);
        System.out.println("Se hizo click en el menu Admin");
        System.out.println("INFORMATIVO: Finaliza la accion para hacer click en el menu Admin");

    }
}

package Page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserManagementPage extends PageObject {
    BasePage basePage;
    int rowResultListSize;
    By spinner = By.xpath("//div[contains(@class,'spinner')]");
    By comboBoxUserRole = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[normalize-space()='User Role']]//div[contains(text(), 'Select')]/parent::div");
    By optionAdmin = By.xpath("//span[normalize-space(text())='Admin']/parent::div");
    By buttonSearch = By.xpath("//button[contains(normalize-space(.),'Search')]");
    By columnActions = By.xpath("//div[@class='oxd-table-header']//div[contains(normalize-space(.),'Actions') and contains(@class,'cell')]");
    By rowResults = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']");
    By buttonBis = By.xpath("//div[@class='oxd-table-body']//button[contains(@class,'icon-button')]/i");
    By userRoleColumnResults = By.xpath("//div[@class='oxd-table-card']//div[@role='row']/div[3]");
    By recordsFound = By.xpath("//span[contains(normalize-space(.),'Found')]");
    public void seMuestraElFiltroUserRoleYElBotonSearch() {
        System.out.println("INFORMATIVO: Inicia la accion validar la visibilidad del filtro User Role y el boton Search");
        if(basePage.waitVisibleBooleanByTime(spinner, 10)){
            Serenity.takeScreenshot();
            basePage.waitInvisibleByTime(spinner, 180);
            basePage.waitForSeconds(1);
        }

        if(basePage.waitVisibleBooleanByTime(comboBoxUserRole,15)){
            System.out.println("SUCCESS:Se muestra el boton Search en la pagina User Management");
            Assert.assertTrue("SUCCESS:Se muestra el boton Search en la pagina User Management",true);
        }else{
            System.out.println("FAIL:NO se muestra el boton Search en la pagina User Management");
            Assert.fail("FAIL:NO se muestra el boton Search en la pagina User Management");
        }

        basePage.waitForSeconds(3);

        if(basePage.waitVisibleBooleanByTime(buttonSearch,15)){
            System.out.println("SUCCESS:Se muestra el boton Search en la pagina User Management");
            Assert.assertTrue("SUCCESS:Se muestra el boton Search en la pagina User Management",true);
        }else{
            System.out.println("FAIL:NO se muestra el boton Search en la pagina User Management");
            Assert.fail("FAIL:NO se muestra el boton Search en la pagina User Management");
        }

        System.out.println("Se hizo click en el menu Admin");
        System.out.println("INFORMATIVO: Finaliza la accion validar la visibilidad del filtro User Role y el boton Search");
    }

    public void validamosQueLaOpcionAdminSeEncuentreEnElComboBoxUserRole() throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion para validar la visibilidad del la opcion Admin dentro del combobox User Role");
        System.out.println("Hacemo click en el combo box User Role");
        basePage.click(comboBoxUserRole);
        basePage.waitForSeconds(2);
        System.out.println("Se hizo click en el combobox User Role");
        if(basePage.waitVisibleBooleanByTime(optionAdmin,15)){
            System.out.println("SUCCESS:Se muestra la opcion Admin dentro del combobox User Role");
            Assert.assertTrue("SUCCESS:Se muestra la opcion Admin dentro del combobox User Role",true);
        }else{
            System.out.println("FAIL:NO se muestra la opcion Admin dentro del combobox User Role");
            Assert.fail("FAIL:NO se muestra la opcion Admin dentro del combobox User Role");
        }

        System.out.println("INFORMATIVO: Finaliza la accion para validar la visibilidad del la opcion Admin dentro del combobox User Role");
    }

    public void elUsuarioSeleccionaLaOpcionAdmin() throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion para hacer click en la opcion Admin dentro del combobox User Role");
        basePage.click(optionAdmin);
        System.out.println("Se hizo click en la opcion Admin");
        basePage.waitForSeconds(2);
        System.out.println("INFORMATIVO: Finaliza la accion para hacer click en la opcion Admin dentro del combobox User Role");

    }

    public void seleccionaElBotonSearch() throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion para hacer click en el boton Search");
        basePage.click(buttonSearch);
        System.out.println("Se hizo click en el boton Search");
        basePage.waitForSeconds(2);
        System.out.println("INFORMATIVO: Finaliza la accion para hacer click en el boton Search");
    }

    public void seMuestraLaColumnaActions() {
        System.out.println("INFORMATIVO: Inicia la accion para hacer click en el boton Search");
        if(basePage.waitVisibleBooleanByTime(spinner, 6)){
            Serenity.takeScreenshot();
            basePage.waitInvisibleByTime(spinner, 180);
            basePage.waitForSeconds(1);
        }

        basePage.scrollToY(100000);
        basePage.waitForSeconds(1);
        Serenity.takeScreenshot();
        basePage.scrollToElement(recordsFound);
        basePage.waitForSeconds(1);
        Serenity.takeScreenshot();

        if(basePage.waitVisibleBooleanByTime(columnActions,15)){
            System.out.println("SUCCESS:Se muestra la columna Actions en el resultado de filtrar roles de tipo Admin");
            Assert.assertTrue("SUCCESS:Se muestra la columna Actions en el resultado de filtrar roles de tipo Admin",true);
        }else{
            System.out.println("FAIL:NO se muestra la columna Actions en el resultado de filtrar roles de tipo Admin");
            Assert.fail("FAIL:NO se muestra la columna Actions en el resultado de filtrar roles de tipo Admin");
        }
        basePage.waitForSeconds(1);
        System.out.println("INFORMATIVO: Finaliza la accion para hacer click en el boton Search");
    }

    public void seMuestraAlMenosUnResultadoFiltrado() {
        System.out.println("INFORMATIVO: Inicia la accion para validar que se muestre al menos un resultado filtrado");
        if(basePage.waitVisibleBooleanByTime(spinner, 2)){
            Serenity.takeScreenshot();
            basePage.waitInvisibleByTime(spinner, 180);
            basePage.waitForSeconds(1);
        }
        List<WebElement> rowResultList = basePage.findElements(rowResults);
        rowResultListSize = rowResultList.size();
        if(!rowResultList.isEmpty()){
            System.out.println("SUCCESS:Se encontraron "+rowResultListSize+ "resultados");
            Assert.assertTrue("SUCCESS:Se encontraron "+rowResultListSize+ "resultados",true);
        }else{
            System.out.println("FAIL:NO se encontraron resultados, hay "+rowResultListSize+ "resultados");
            Assert.fail("FAIL:NO se encontraron resultados, hay "+rowResultListSize+ "resultados");
        }

        System.out.println("INFORMATIVO: Finaliza la accion para validar que se muestre al menos un resultado filtrado");

    }

    public void seMuestraElIconoBorrarYEditar() {
        System.out.println("INFORMATIVO: Inicia la accion para validar que se muestre los botones BORRAR y EDITAR de acuerdo al numero de filas como resultados");

        if(basePage.waitVisibleBooleanByTime(buttonBis,15)){
            System.out.println("SUCCESS:Se muestra los botones BORRAR y EDITAR");
            Assert.assertTrue("SUCCESS:Se muestra los botones BORRAR y EDITAR",true);
            List<WebElement> buttonBiList = basePage.findElements(buttonBis);
            basePage.waitForSeconds(1);
            System.out.println("Numero de botones encontrados en total: "+buttonBiList.size());
            System.out.println("Numero de pares de botones encontrados: "+buttonBiList.size()/2);
            if(rowResultListSize == buttonBiList.size()/2){
                System.out.println("SUCCESS:La cantidad de botones BORRAR y EDITAR coincide con los resultados encontrados");
                Assert.assertTrue("SUCCESS:La cantidad de botones BORRAR y EDITAR coincide con los resultados encontrados",true);
            }else{
                System.out.println("FAIL:La cantidad de botones BORRAR y EDITAR NO coincide con los resultados encontrados."+ "TOTAL DE BOTONES: "+buttonBiList.size()+"-----"+"NUMERO DE PAR DE BOTONES: "+buttonBiList.size()/2);
                Assert.fail("FAIL:La cantidad de botones BORRAR y EDITAR NO coincide con los resultados encontrados."+ "TOTAL DE BOTONES: "+buttonBiList.size()+"-----"+"NUMERO DE PAR DE BOTONES: "+buttonBiList.size()/2);
            }
        }else{
            System.out.println("FAIL:NO se muestra los botones BORRAR y EDITAR");
            Assert.fail("FAIL:NO se muestra los botones BORRAR y EDITAR");
        }
        System.out.println("INFORMATIVO: Finaliza la accion para validar que se muestre los botones BORRAR y EDITAR de acuerdo al numero de filas como resultados");

    }

    public void todosLosRegistrosFiltradosContienenElRolAdmin() {
        System.out.println("INFORMATIVO: Inicia la accion para validar que todos los registros filtrados contengan el rol Admin");
        if(basePage.waitVisibleBooleanByTime(spinner, 5)){
            Serenity.takeScreenshot();
            basePage.waitInvisibleByTime(spinner, 180);
            basePage.waitForSeconds(1);
        }

        basePage.scrollToY(100000);
        basePage.waitForSeconds(1);
        Serenity.takeScreenshot();
        basePage.scrollToElement(recordsFound);
        basePage.waitForSeconds(1);
        Serenity.takeScreenshot();

        List<WebElement> userRoleColumnResultList = basePage.findElements(userRoleColumnResults);
        basePage.waitForSeconds(1);
        System.out.println("Numero de registros: "+ userRoleColumnResultList.size());
        for(WebElement userRoleColumnResult: userRoleColumnResultList){
            String result =  userRoleColumnResult.getText().trim();
            System.out.println("valor de userRoleColumnResult: "+result);
            if(!result.equalsIgnoreCase("Admin")){
                System.out.println("FAIL:NO todos los resultados tienen Admin como valor en la columna User Role");
                Assert.fail("FAIL:NO todos los resultados tienen Admin como valor en la columna User Role");
            }
        }
        System.out.println("SUCCESS: Todos los resultados tienen Admin como valor en la columna User Role");
        Assert.assertTrue("SUCCESS:Todos los resultados tienen Admin como valor en la columna User Role",true);
        System.out.println("INFORMATIVO: Finaliza la accion para validar que todos los registros filtrados contengan el rol Admin");

    }
}

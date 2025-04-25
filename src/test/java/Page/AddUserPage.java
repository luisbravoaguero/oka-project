package Page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AddUserPage extends PageObject {
    BasePage basePage;
    By subtitileAddUser = By.xpath("//h6[contains(normalize-space(.),'Add User')]");
    By buttonSave = By.xpath("//button[contains(normalize-space(.),'Save')]");
    By spinner = By.xpath("//div[contains(@class,'spinner')]");
//div[contains(@class,'oxd-input-group')][.//label[contains(normalize-space(.),'Employee Name')]]//span[normalize-space(text())='James Butler']/parent::div
    public void seMuestraLaPaginaAddUser() {
        System.out.println("INFORMATIVO: Inicia la accion para validar la visibilidad del subtitulo Add User en la pagina Add User");
        if(basePage.waitVisibleBooleanByTime(spinner, 5)){
            Serenity.takeScreenshot();
            basePage.waitInvisibleByTime(spinner, 180);
            basePage.waitForSeconds(1);
        }

        if(basePage.waitVisibleBooleanByTime(subtitileAddUser,15)){
            System.out.println("SUCCESS:Se muestra el subtitulo Add User en la pagina Add User");
        }else{
            System.out.println("FAIL:NO se muestra el subtitulo Add User en la pagina Add User");
            Assert.fail("FAIL:NO se muestra el subtitulo Add User en la pagina Add User");
        }
        System.out.println("INFORMATIVO: Finaliza la accion para validar la visibilidad del subtitulo Add User en la pagina Add User");
    }

    public void seMuestraElFiltro(String campoFiltro) {
        System.out.println("INFORMATIVO: Inicia la accion validar la visibilidad del campo combobox "+campoFiltro+" en la pagina Add User");
        basePage.waitForSeconds(1);
        By comboBoxLocator = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[normalize-space()='"+campoFiltro.trim()+"']]//div[contains(text(), 'Select')]/parent::div");
        if(basePage.waitVisibleBooleanByTime(comboBoxLocator,15)){
            System.out.println("SUCCESS:Se muestra el campo combobox "+campoFiltro+" en la pagina Add User");
        }else{
            System.out.println("FAIL:No se muestra el campo combobox "+campoFiltro+" en la pagina Add User");
            Assert.fail("FAIL:No se muestra el campo combobox "+campoFiltro+" en la pagina Add User");
        }

        System.out.println("INFORMATIVO: Finaliza la accion validar la visibilidad del campo combobox "+campoFiltro+" en la pagina Add User");
    }

    public void seMuestraElCampo(String campoInput) {
        System.out.println("INFORMATIVO: Inicia la accion validar la visibilidad del campo "+campoInput+" en la pagina Add User");
        By inputBoxLocator = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[normalize-space()='"+campoInput+"']]//input");
        if(basePage.waitVisibleBooleanByTime(inputBoxLocator,15)){
            System.out.println("SUCCESS:Se muestra el campo "+campoInput+" en la pagina Add User");
        }else{
            System.out.println("FAIL:No se muestra el campo "+campoInput+" en la pagina Add User");
            Assert.fail("FAIL:No se muestra el campo "+campoInput+" en la pagina Add User");
        }
        System.out.println("INFORMATIVO: Finaliza la accion validar la visibilidad del campo "+campoInput+" en la pagina Add User");
    }

    public void seMuestraElBoton(String botonInput) {
        System.out.println("INFORMATIVO: Inicia la accion validar la visibilidad del boton "+botonInput+" en la pagina Add User");
        basePage.waitForSeconds(1);
        By botonLocator = By.xpath("//button[contains(normalize-space(.),'"+botonInput.trim()+"')]");
        if(basePage.waitVisibleBooleanByTime(botonLocator,15)){
            System.out.println("SUCCESS:Se muestra el boton "+botonInput+" en la pagina Add User");
        }else{
            System.out.println("FAIL:No se muestra el boton "+botonInput+" en la pagina Add User");
            Assert.fail("FAIL:No se muestra el boton "+botonInput+" en la pagina Add User");
        }
        System.out.println("INFORMATIVO: Finaliza la accion validar la visibilidad del boton "+botonInput+" en la pagina Add User");
    }

    public void validamosQueLaOpcionSeEncuentreEnElComboBox(String nombreOpcion, String nombreCombobox) throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion validar la visibilidad de la opcion  "+nombreOpcion+" en el combobox "+nombreCombobox);
        System.out.println("Hacemos click en el combobox "+nombreCombobox);
        By comboBoxLocator = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[normalize-space()='"+nombreCombobox.trim()+"']]//div[contains(text(), 'Select')]/parent::div");
        basePage.click(comboBoxLocator);
        basePage.waitForSeconds(2);
        System.out.println("Se hizo click en el combobox "+nombreCombobox);

        By opcionLocator = By.xpath("//span[normalize-space(text())='"+nombreOpcion.trim()+"']/parent::div");
        if(basePage.waitVisibleBooleanByTime(opcionLocator,15)){
            System.out.println("SUCCESS:Se muestra la opcion "+nombreOpcion+" dentro del combobox "+nombreCombobox);
        }else{
            System.out.println("FAIL:No se muestra la opcion "+nombreOpcion+" dentro del combobox "+nombreCombobox);
            Assert.fail("FAIL:No se muestra la opcion "+nombreOpcion+" dentro del combobox "+nombreCombobox);
        }
        System.out.println("INFORMATIVO: Finaliza la accion validar la visibilidad de la opcion  "+nombreOpcion+" en el combobox "+nombreCombobox);
    }

    public void elUsuarioSeleccionaLaOpcionDelComboBox(String nombreOpcion, String nombreCombobox) throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion para hacer click en la opcion  "+nombreOpcion+" del combobox "+nombreCombobox);
        By opcionLocator = By.xpath("//span[normalize-space(text())='"+nombreOpcion.trim()+"']/parent::div");
        if(basePage.waitVisibleBooleanByTime(opcionLocator,15)){
            basePage.click(opcionLocator);
            basePage.waitForSeconds(2);
            System.out.println("SUCCESS:Se hizo click en la opcion "+nombreOpcion+" dentro del combobox "+nombreCombobox);
        }else{
            System.out.println("FAIL:No se hizo click en la opcion "+nombreOpcion+" dentro del combobox "+nombreCombobox);
            Assert.fail("FAIL:No se hizo click en la opcion "+nombreOpcion+" dentro del combobox "+nombreCombobox);
        }
        System.out.println("INFORMATIVO: Finaliza la accion para hacer click en la opcion  "+nombreOpcion+" del combobox "+nombreCombobox);
    }

    public void elUsuarioIngresaEnElCampo(String textoInput, String filtroCampo) throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion para ingresar el texto "+textoInput+" en el campo "+filtroCampo);
        By inputBoxLocator = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[contains(normalize-space(.),'"+filtroCampo.trim()+"')]]//input");
        if(basePage.waitVisibleBooleanByTime(inputBoxLocator,15)){
            basePage.sendKey(inputBoxLocator,textoInput);
            basePage.waitForSeconds(2);
            System.out.println("SUCCESS:Se ingresa el texto "+textoInput+" dentro del combobox "+filtroCampo);
        }else{
            System.out.println("FAIL:NO se ingresa el texto "+textoInput+" dentro del combobox "+filtroCampo);
            Assert.fail("FAIL:NO se ingresa el texto "+textoInput+" dentro del combobox "+filtroCampo);
        }
        System.out.println("INFORMATIVO: Finaliza la accion para ingresar el texto "+textoInput+" en el campo "+filtroCampo);
    }

    public void validamosQueLaOpcionSeEncuentreEnElFiltro(String opcionBuscada, String filtroCampo) {
        System.out.println("INFORMATIVO: Inicia la accion para validar que la opcion  "+opcionBuscada+" se encuentre en el campo "+filtroCampo);
        By opcionLocator = By.xpath("//div[contains(@class,'oxd-input-group')][.//label[contains(normalize-space(.),'"+filtroCampo.trim()+"')]]//span[normalize-space(text())='"+opcionBuscada.trim()+"']/parent::div");
        if(basePage.waitVisibleBooleanByTime(opcionLocator,15)){
            System.out.println("SUCCESS:La opcion "+opcionBuscada+" se encuentra dentro del combobox "+filtroCampo);
        }else{
            System.out.println("FAIL:La opcion "+opcionBuscada+" NO se encuentra dentro del combobox "+filtroCampo);
            Assert.fail("FAIL:La opcion "+opcionBuscada+" NO se encuentra dentro del combobox "+filtroCampo);
        }
        System.out.println("INFORMATIVO: Finaliza la accion para validar que la opcion  "+opcionBuscada+" se encuentre en el campo "+filtroCampo);
    }


    public void elUsuarioSeleccionaLaOpcionEnElResultadoDelCampo(String opcionBuscada, String filtroCampo) throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion para seleccionar el texto "+opcionBuscada+" del resultado en el campo "+filtroCampo);
        By opcionBuscadaLocator = By.xpath("//div[contains(@class, 'oxd-input-group')][.//label[normalize-space()='"+filtroCampo.trim()+"']]//span[contains(normalize-space(.),'"+opcionBuscada.trim()+"')]/parent::div");
        if(basePage.waitVisibleBooleanByTime(opcionBuscadaLocator,15)){
            basePage.click(opcionBuscadaLocator);
            basePage.waitForSeconds(2);
            System.out.println("SUCCESS:Se selecciono el texto "+opcionBuscada+" dentro del resultado del campo filtro "+filtroCampo);
        }else{
            System.out.println("FAIL:NO se selecciono el texto "+opcionBuscada+" dentro del resultado del campo filtro "+filtroCampo);
            Assert.fail("FAIL:NO se selecciono el texto "+opcionBuscada+" dentro del resultado del campo filtro "+filtroCampo);
        }
        System.out.println("INFORMATIVO: Finaliza la accion para seleccionar el texto "+opcionBuscada+" del resultado en el campo "+filtroCampo);
    }

    public void elUsuarioHaceClickEnElBotonSave() throws Exception {
        System.out.println("INFORMATIVO: Inicia la accion para hacer click en el boton Save");
        basePage.click(buttonSave);
        System.out.println("Se hizo click en el boton Search");
        System.out.println("INFORMATIVO: Finaliza la accion para hacer click en el boton Save");
    }
}

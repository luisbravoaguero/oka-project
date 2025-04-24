package Step;

import Page.BasePage;
import Page.HomePage;
import Page.LoginPage;
import Page.UserManagementPage;
import net.serenitybdd.annotations.Screenshots;
import net.thucydides.core.steps.ScenarioSteps;

public class OrangeStep extends ScenarioSteps {
    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;
    UserManagementPage userManagementPage;

    @Screenshots(afterEachStep = true)
    public void UrlPre() throws Exception {
        System.out.println("Inicializando la pagina web https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        basePage.open();
    }

    public void seMuestraElFormularioDelLogin() throws Exception {
        loginPage.seMuestraElFormularioDelLogin();
    }

    public void elUsuarioIngresaElUsuarioYClave(String usuario, String clave) throws Exception {
        loginPage.elUsuarioIngresaElUsuarioYClave(usuario,clave);
    }

    public void elUsuarioHaceClickEnElBotonLOGIN() throws Exception {
        loginPage.elUsuarioHaceClickEnElBotonLOGIN();
    }

    public void seMuestraLaPaginaPrincipalDelHome() throws Exception {
        homePage.seMuestraLaPaginaPrincipalDelHome();
    }

    public void seMuestraElMensajeInvalidCredentials() {
        loginPage.seMuestraElMensajeInvalidCredentials();
    }

    public void seMuestraElMenuAdmin() {
        homePage.seMuestraElMenuAdmin();
    }

    public void elUsuarioHaceClickEnElMenuAdmin() throws Exception {
        homePage.elUsuarioHaceClickEnElMenuAdmin();
    }

    public void seMuestraElFiltroUserRoleYElBotonSearch() {
        userManagementPage.seMuestraElFiltroUserRoleYElBotonSearch();
    }

    public void validamosQueLaOpcionAdminSeEncuentreEnElComboBoxUserRole() throws Exception {
        userManagementPage.validamosQueLaOpcionAdminSeEncuentreEnElComboBoxUserRole();
    }

    public void elUsuarioSeleccionaLaOpcionAdmin() throws Exception {
        userManagementPage.elUsuarioSeleccionaLaOpcionAdmin();
    }

    public void seleccionaElBotonSearch() throws Exception {
        userManagementPage.seleccionaElBotonSearch();
    }

    public void seMuestraLaColumnaActions() {
        userManagementPage.seMuestraLaColumnaActions();
    }

    public void seMuestraAlMenosUnResultadoFiltrado() {
        userManagementPage.seMuestraAlMenosUnResultadoFiltrado();
    }

    public void seMuestraElIconoBorrarYEditar() {
        userManagementPage.seMuestraElIconoBorrarYEditar();
    }

    public void todosLosRegistrosFiltradosContienenElRolAdmin() {
        userManagementPage.todosLosRegistrosFiltradosContienenElRolAdmin();
    }
}

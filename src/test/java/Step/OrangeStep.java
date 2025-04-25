package Step;

import Page.*;
import net.serenitybdd.annotations.Screenshots;
import net.thucydides.core.steps.ScenarioSteps;

public class OrangeStep extends ScenarioSteps {
    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;
    UserManagementPage userManagementPage;
    AddUserPage addUserPage;

    @Screenshots(afterEachStep = true)
    public void UrlPre() throws Exception {
        System.out.println("Inicializando la pagina web https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        basePage.open();
    }

    @Screenshots(afterEachStep = true)
    public void seMuestraElFormularioDelLogin() throws Exception {
        loginPage.seMuestraElFormularioDelLogin();
    }

    @Screenshots(afterEachStep = true)
    public void elUsuarioIngresaElUsuarioYClave(String usuario, String clave) throws Exception {
        loginPage.elUsuarioIngresaElUsuarioYClave(usuario,clave);
    }

    @Screenshots(afterEachStep = true)
    public void elUsuarioHaceClickEnElBotonLOGIN() throws Exception {
        loginPage.elUsuarioHaceClickEnElBotonLOGIN();
    }

    @Screenshots(afterEachStep = true)
    public void seMuestraLaPaginaPrincipalDelHome() throws Exception {
        homePage.seMuestraLaPaginaPrincipalDelHome();
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraElMensajeInvalidCredentials() {
        loginPage.seMuestraElMensajeInvalidCredentials();
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraElMenuAdmin() {
        homePage.seMuestraElMenuAdmin();
    }
    @Screenshots(afterEachStep = true)
    public void elUsuarioHaceClickEnElMenuAdmin() throws Exception {
        homePage.elUsuarioHaceClickEnElMenuAdmin();
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraElFiltroUserRoleYElBotonSearch() {
        userManagementPage.seMuestraElFiltroUserRoleYElBotonSearch();
    }
    @Screenshots(afterEachStep = true)
    public void validamosQueLaOpcionAdminSeEncuentreEnElComboBoxUserRole() throws Exception {
        userManagementPage.validamosQueLaOpcionAdminSeEncuentreEnElComboBoxUserRole();
    }
    @Screenshots(afterEachStep = true)
    public void elUsuarioSeleccionaLaOpcionAdmin() throws Exception {
        userManagementPage.elUsuarioSeleccionaLaOpcionAdmin();
    }
    @Screenshots(afterEachStep = true)
    public void seleccionaElBotonSearch() throws Exception {
        userManagementPage.seleccionaElBotonSearch();
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraLaColumnaActions() {
        userManagementPage.seMuestraLaColumnaActions();
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraAlMenosUnResultadoFiltrado() {
        userManagementPage.seMuestraAlMenosUnResultadoFiltrado();
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraElIconoBorrarYEditar() {
        userManagementPage.seMuestraElIconoBorrarYEditar();
    }
    @Screenshots(afterEachStep = true)
    public void todosLosRegistrosFiltradosContienenElRolAdmin() {
        userManagementPage.todosLosRegistrosFiltradosContienenElRolAdmin();
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraElCampoUsername() {
        userManagementPage.seMuestraElCampoUsername();
    }
    @Screenshots(afterEachStep = true)
    public void elUsuarioIngresaElTextoEnElCampoUsername(String texto) throws Exception {
        userManagementPage.elUsuarioIngresaElTextoEnElCampoUsername(texto);
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraElMensajeEnLaCabceraDeLaTablaDeResultados(String mensaje) throws Exception {
        userManagementPage.seMuestraElMensajeEnLaCabceraDeLaTablaDeResultados(mensaje);
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraPopupConElMensaje(String mensaje) throws Exception {
        userManagementPage.seMuestraPopupConElMensaje(mensaje);
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraElFiltroUserRole() {
        userManagementPage.seMuestraElFiltroUserRole();
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraElBotonSearch() {
        userManagementPage.seMuestraElBotonSearch();

    }
    @Screenshots(afterEachStep = true)
    public void seMuestraElBotonAdd() {
        userManagementPage.seMuestraElBotonAdd();
    }
    @Screenshots(afterEachStep = true)
    public void elUsuarioHaceClickEnElBotonAdd() throws Exception {
        userManagementPage.elUsuarioHaceClickEnElBotonAdd();
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraLaPaginaAddUser() {
        addUserPage.seMuestraLaPaginaAddUser();
    }
    @Screenshots(afterEachStep = true)
    public void seMuestraElFiltro(String campoFiltro) {
        addUserPage.seMuestraElFiltro(campoFiltro);
    }

    public void seMuestraElCampo(String campoInput) {
        addUserPage.seMuestraElCampo(campoInput);
    }

    public void seMuestraElBoton(String botonInput) {
        addUserPage.seMuestraElBoton(botonInput);
    }

    public void validamosQueLaOpcionSeEncuentreEnElComboBox(String nombreOpcion, String nombreCombobox) throws Exception {
        addUserPage.validamosQueLaOpcionSeEncuentreEnElComboBox(nombreOpcion,nombreCombobox);
    }

    public void elUsuarioSeleccionaLaOpcionDelComboBox(String nombreOpcion, String nombreCombobox) throws Exception {
        addUserPage.elUsuarioSeleccionaLaOpcionDelComboBox(nombreOpcion,nombreCombobox);
    }

    public void validamosQueLaOpcionSeEncuentreEnElFiltro(String opcionBuscada, String filtroCampo) {
        addUserPage.validamosQueLaOpcionSeEncuentreEnElFiltro(opcionBuscada,filtroCampo);
    }

    public void elUsuarioIngresaEnElCampo(String textoInput, String filtroCampo) throws Exception {
        addUserPage.elUsuarioIngresaEnElCampo(textoInput,filtroCampo);
    }

    public void elUsuarioSeleccionaLaOpcionEnElResultadoDelCampo(String opcionBuscada, String filtroCampo) throws Exception {
        addUserPage.elUsuarioSeleccionaLaOpcionEnElResultadoDelCampo(opcionBuscada,filtroCampo);
    }

    public void elUsuarioHaceClickEnElBotonSave() throws Exception {
        addUserPage.elUsuarioHaceClickEnElBotonSave();
    }

    public void seMuestraLaPaginaUserManagement() {
        userManagementPage.seMuestraLaPaginaUserManagement();
    }

    public void seVisualizaEl(String usernameFila, String usernameFilaValor) throws Exception {
        userManagementPage.seVisualizaEl(usernameFila,usernameFilaValor);
    }
}

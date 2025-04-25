package StepDefinition;

import Step.OrangeStep;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;

public class OrangeStepDefinition {
    @Steps
    OrangeStep orangeStep;

    @Dado("que el usuario se conecta a la pagina web DemoOrangehrmlive")
    public void queElUsuarioSeConectaALaPaginaWebDemoOrangehrmlive() throws Exception{
        orangeStep.UrlPre();
    }

    @Entonces("se muestra el formulario del login")
    public void seMuestraElFormularioDelLogin() throws Exception {
        orangeStep.seMuestraElFormularioDelLogin();
    }

    @Y("el usuario ingresa el usuario y clave {string} {string}")
    public void elUsuarioIngresaElUsuarioYClave(String usuario, String clave) throws Exception {
        orangeStep.elUsuarioIngresaElUsuarioYClave(usuario,clave);
    }

    @Y("el usuario hace click en el boton LOGIN")
    public void elUsuarioHaceClickEnElBotonLOGIN() throws Exception {
        orangeStep.elUsuarioHaceClickEnElBotonLOGIN();
    }

    @Entonces("se muestra la pagina principal del home")
    public void seMuestraLaPaginaPrincipalDelHome() throws Exception {
        orangeStep.seMuestraLaPaginaPrincipalDelHome();
    }

    @Entonces("se muestra el mensaje Invalid credentials")
    public void seMuestraElMensajeInvalidCredentials() {
        orangeStep.seMuestraElMensajeInvalidCredentials();
    }

    @Y("se muestra el menu Admin")
    public void seMuestraElMenuAdmin() {
        orangeStep.seMuestraElMenuAdmin();
    }

    @Entonces("el usuario hace click en el menu Admin")
    public void elUsuarioHaceClickEnElMenuAdmin() throws Exception {
        orangeStep.elUsuarioHaceClickEnElMenuAdmin();
    }

    @Entonces("se muestra el filtro UserRole y el boton Search")
    public void seMuestraElFiltroUserRoleYElBotonSearch() {
        orangeStep.seMuestraElFiltroUserRoleYElBotonSearch();
    }

    @Y("validamos que la opcion Admin se encuentre en el combo box User Role")
    public void validamosQueLaOpcionAdminSeEncuentreEnElComboBoxUserRole() throws Exception {
        orangeStep.validamosQueLaOpcionAdminSeEncuentreEnElComboBoxUserRole();
    }

    @Entonces("el usuario selecciona la opcion Admin")
    public void elUsuarioSeleccionaLaOpcionAdmin() throws Exception {
        orangeStep.elUsuarioSeleccionaLaOpcionAdmin();
    }

    @Y("selecciona el boton Search")
    public void seleccionaElBotonSearch() throws Exception {
        orangeStep.seleccionaElBotonSearch();
    }

    @Entonces("se muestra la columna Actions")
    public void seMuestraLaColumnaActions() {
        orangeStep.seMuestraLaColumnaActions();
    }

    @Y("se muestra al menos un resultado filtrado")
    public void seMuestraAlMenosUnResultadoFiltrado() {
        orangeStep.seMuestraAlMenosUnResultadoFiltrado();
    }

    @Y("se muestra el icono borrar y editar")
    public void seMuestraElIconoBorrarYEditar() {
        orangeStep.seMuestraElIconoBorrarYEditar();
    }

    @Entonces("todos los registros filtrados contienen el rol Admin")
    public void todosLosRegistrosFiltradosContienenElRolAdmin() {
        orangeStep.todosLosRegistrosFiltradosContienenElRolAdmin();
    }

    @Y("se muestra el campo Username")
    public void seMuestraElCampoUsername() {
        orangeStep.seMuestraElCampoUsername();
    }

    @Y("el usuario ingresa el texto {string} en el campo Username")
    public void elUsuarioIngresaElTextoEnElCampoUsername(String texto) throws Exception {
        orangeStep.elUsuarioIngresaElTextoEnElCampoUsername(texto);
    }

    @Y("se muestra el mensaje {string} en la cabcera de la tabla de resultados")
    public void seMuestraElMensajeEnLaCabceraDeLaTablaDeResultados(String mensaje) throws Exception {
        orangeStep.seMuestraElMensajeEnLaCabceraDeLaTablaDeResultados(mensaje);
    }

    @Entonces("se muestra popup con el mensaje {string}")
    public void seMuestraPopupConElMensaje(String mensaje) throws Exception {
        orangeStep.seMuestraPopupConElMensaje(mensaje);
    }

    @Entonces("se muestra el filtro UserRole")
    public void seMuestraElFiltroUserRole() {
        orangeStep.seMuestraElFiltroUserRole();
    }

    @Y("se muestra el boton Search")
    public void seMuestraElBotonSearch() {
        orangeStep.seMuestraElBotonSearch();
    }

    @Y("se muestra el boton Add")
    public void seMuestraElBotonAdd() {
        orangeStep.seMuestraElBotonAdd();
    }

    @Y("el usuario hace click en el boton Add")
    public void elUsuarioHaceClickEnElBotonAdd() throws Exception {
        orangeStep.elUsuarioHaceClickEnElBotonAdd();
    }

    @Entonces("se muestra la pagina AddUser")
    public void seMuestraLaPaginaAddUser() {
        orangeStep.seMuestraLaPaginaAddUser();
    }

    @Y("se muestra el filtro {string}")
    public void seMuestraElFiltro(String campoFiltro) {
        orangeStep.seMuestraElFiltro(campoFiltro);
    }

    @Y("se muestra el campo {string}")
    public void seMuestraElCampo(String campoInput) {
        orangeStep.seMuestraElCampo(campoInput);
    }

    @Y("se muestra el boton {string}")
    public void seMuestraElBoton(String botonInput) {
        orangeStep.seMuestraElBoton(botonInput);
    }

    @Y("validamos que la opcion {string} se encuentre en el combo box {string}")
    public void validamosQueLaOpcionSeEncuentreEnElComboBox(String nombreOpcion, String nombreCombobox) throws Exception {
        orangeStep.validamosQueLaOpcionSeEncuentreEnElComboBox(nombreOpcion,nombreCombobox);
    }

    @Entonces("el usuario selecciona la opcion {string} del combo box {string}")
    public void elUsuarioSeleccionaLaOpcionDelComboBox(String nombreOpcion, String nombreCombobox) throws Exception {
        orangeStep.elUsuarioSeleccionaLaOpcionDelComboBox(nombreOpcion,nombreCombobox);
    }

    @Y("validamos que la opcion {string} se encuentre en el filtro {string}")
    public void validamosQueLaOpcionSeEncuentreEnElFiltro(String opcionBuscada, String filtroCampo) {
        orangeStep.validamosQueLaOpcionSeEncuentreEnElFiltro(opcionBuscada,filtroCampo);
    }

    @Y("el usuario ingresa {string} en el campo {string}")
    public void elUsuarioIngresaEnElCampo(String textoInput, String filtroCampo) throws Exception {
        orangeStep.elUsuarioIngresaEnElCampo(textoInput,filtroCampo);
    }

    @Entonces("el usuario selecciona la opcion {string} en el resultado del campo {string}")
    public void elUsuarioSeleccionaLaOpcionEnElResultadoDelCampo(String opcionBuscada, String filtroCampo) throws Exception {
        orangeStep.elUsuarioSeleccionaLaOpcionEnElResultadoDelCampo(opcionBuscada,filtroCampo);
    }

    @Y("el usuario hace click en el boton Save")
    public void elUsuarioHaceClickEnElBotonSave() throws Exception {
        orangeStep.elUsuarioHaceClickEnElBotonSave();
    }

    @Entonces("se muestra la pagina UserManagement")
    public void seMuestraLaPaginaUserManagement() {
        orangeStep.seMuestraLaPaginaUserManagement();
    }

    @Entonces("se visualiza el {string} {string}")
    public void seVisualizaEl(String usernameFila, String usernameFilaValor) throws Exception {
        orangeStep.seVisualizaEl(usernameFila,usernameFilaValor);
    }
}

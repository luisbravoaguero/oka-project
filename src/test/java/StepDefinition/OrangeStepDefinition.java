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
}

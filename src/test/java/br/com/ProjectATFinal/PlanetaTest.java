package br.com.ProjectATFinal;


import br.com.ProjectATFinal.Exception.ResourceNotFoundException;
import br.com.ProjectATFinal.Model.Planeta;
import br.com.ProjectATFinal.Util.PersonagemUtil;
import br.com.ProjectATFinal.Util.PlanetaUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlanetaTest {
    @Test
    @DisplayName("Retornar planeta pelo ID")
    public void getById(){
        PlanetaUtil planetaUtil = new PlanetaUtil();
        Planeta planeta = planetaUtil.getById(1);
        assertEquals("Namek",planeta.getName());
    }
    @Test
    @DisplayName("Retornar uma exception para um planeta inexistente ID")
    public void testaPlanetaInexistente(){
        PlanetaUtil planetaUtil = new PlanetaUtil();
        assertThrows(ResourceNotFoundException.class, () ->{
            planetaUtil.getById(-1);
        });

    }
}

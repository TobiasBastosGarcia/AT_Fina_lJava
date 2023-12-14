package br.com.ProjectATFinal;

import br.com.ProjectATFinal.Exception.ResourceNotFoundException;
import br.com.ProjectATFinal.Model.Personagem;
import br.com.ProjectATFinal.Util.PersonagemUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class PersonagemTest {
    Logger Logger = LoggerFactory.getLogger(PersonagemTest.class);

    @Test
    @DisplayName("Retornar personagem pela URL")
    public void TestarByURL(){

        PersonagemUtil personagemUtil = new PersonagemUtil();
        Personagem personagem = personagemUtil.getByURL("https://dragonball-api.com/api/characters/1");
        assertEquals("Goku",personagem.getName());
        Logger.info("Passou no teste com sucesso");
    }
    @Test
    @DisplayName("Retornar personagem pelo ID")
    public void TestarById(){

        PersonagemUtil personagemUtil = new PersonagemUtil();
        Personagem personagem = personagemUtil.getById(1);
        assertEquals("Goku",personagem.getName());
    }
    @Test
    @DisplayName("Retornar uma exception para personagem inexistente ID")
    public void testaPersonagemInexistente(){
        PersonagemUtil personagemUtil = new PersonagemUtil();
        assertThrows(ResourceNotFoundException.class, () ->{
            personagemUtil.getById(-1);
        });

    }
}

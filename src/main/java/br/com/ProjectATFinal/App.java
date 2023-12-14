package br.com.ProjectATFinal;


import br.com.ProjectATFinal.Exception.ResourceNotFoundException;
import br.com.ProjectATFinal.Model.Personagem;
import br.com.ProjectATFinal.Model.Planeta;
import br.com.ProjectATFinal.Util.PersonagemUtil;
import br.com.ProjectATFinal.Util.PlanetaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        Logger Logger = LoggerFactory.getLogger(App.class);


        Logger.info( "Seja bem vindo a API de Dragon Ball Z!" );
        Scanner scanner = new Scanner(System.in);
        Logger.info("Escolha uma opção");
        Logger.info("1 - Buscar Personagem pelo ID  ");
        Logger.info("2 - Buscar Planeta pelo ID  ");
        int opcaoUsuario = scanner.nextInt();
        switch (opcaoUsuario){
            case 1:
                PersonagemUtil personagemUtil = new PersonagemUtil();
                Logger.info("Digite o ID do personagem");
                int personagemID = scanner.nextInt();

                try {
                    Personagem personagem = personagemUtil.getById(personagemID);
                    Logger.info("Nome: " + personagem.getName());
                    Logger.info("Ki: " + personagem.getKi());
                    Logger.info("Raça: " + personagem.getRace());
                    Logger.info("Descrição: " + personagem.getDescription());
                    Logger.info("Planeta de Origem: " + personagem.getOriginPlanet().getName());
                }catch (ResourceNotFoundException ex){
                    Logger.info(ex.getMessage());
                }
                break;
                case 2:

                PlanetaUtil planetaUtil = new PlanetaUtil();
                    Logger.info("Digite o ID do planeta");
                int planetaID = scanner.nextInt();
                try {
                    Planeta planeta = planetaUtil.getById(planetaID);
                    Logger.info("Nome: " + planeta.getName());
                    Logger.info("Descrição: " + planeta.getDescription());
                }catch (ResourceNotFoundException ex){
                    Logger.info(ex.getMessage());
                }


        }
    }
}

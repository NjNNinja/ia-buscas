import espacoDeEstados.*;
import estrategiasDeBusca.heuristica.*;
import estrategiasDeBusca.cega.*;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		//char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
		//char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
		char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
		//char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory
                char[] cfgFim = {'3','2',' ','7','4','1','5','8','6'};
                
		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );
			
		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado(Puzzle8.TABULEIRO_ORGANIZADO);
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);
		
                /*
		BuscaInformada busca = new AStar();
		busca.setInicio(puzzleInicial);
		busca.setObjetivo(puzzleFinal);
		busca.buscar();
		for(Estado e : busca.getCaminhoSolucao()) {
			System.out.println(e);
		}
                */
                
                BuscaEmProfundidadeLimitada buscaPL = new BuscaEmProfundidadeLimitada();
                int lower_limit = 2;
                int upper_limit = 20;
                
                buscaPL.setInicio(puzzleInicial);
                buscaPL.setObjetivo(puzzleFinal);
                
                for(int i=lower_limit;i <= upper_limit; i++){
                    
                    buscaPL.setLimite(i);
                    buscaPL.buscar();
                    for(Estado e : buscaPL.getCaminhoSolucao()) {
			System.out.println(e);
                    }
                }
                
             
		System.exit(0);
	}

}

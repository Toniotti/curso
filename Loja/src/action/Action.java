package action;

import dados.Dados;
import interf.Interface;
import java.nio.file.Path;
import bd.Write;
import beans.Pessoal;

public class Action {
	
	//Separa os dados do "banco de dados" e insere no ArrayList
	public void cadastrarUsuario(String fileName) {
		Write w = new Write();
		String str = w.readFile(Path.of(fileName), true);
	}
	
	public int validaLogin(String log, String pass) {
		int valid = 3;
			for (int i = 0; i < Dados.dadosPessoal.size(); i++) {
				if((log.equals(Dados.dadosPessoal.get(i).getNome()))) {
					if(pass.equals(Dados.dadosPessoal.get(i).getPass())) {
						Interface.nome = log;
						Interface.nivel = Dados.dadosPessoal.get(i).getNivel();
						valid = 1;
						break;	
					}else {
						valid = 2;
						break;
					}
				}
			}
		return valid;
	}
	
	public void addCarrinho() {
		
	}
}

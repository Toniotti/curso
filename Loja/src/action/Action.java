package action;

import dados.Dados;
import interf.Interface;
import java.nio.file.Path;
import bd.Write;

public class Action {
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

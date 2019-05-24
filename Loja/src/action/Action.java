package action;

import dados.Dados;
import interf.Interface;
import interf.Login;

import java.nio.file.Path;

import bd.Write;
import beans.Pessoal;

public class Action {
	//Separa os dados do "banco de dados" e insere no ArrayList
	public void cadastrarUsuario(String fileName) {
		Write w = new Write();
		String str = w.readFile(Path.of(fileName));
		String[] newStr = str.split(",");
		
			//seta as informações do beans
			Pessoal p = new Pessoal();
			p.setNome(newStr[0]);
			p.setPass(newStr[1]);
			p.setNivel(Integer.parseInt(newStr[2]));
			
			Dados.dadosPessoal.add(p);//add ao ArrayList
	}
	
	public int validaLogin(String log, String pass) {
		int valid = 3;
			for (int i = 0; i < Dados.dadosPessoal.size(); i++) {
				if((log.equals(Dados.dadosPessoal.get(i).getNome()))) {
					if(pass.equals(Dados.dadosPessoal.get(i).getPass())) {
						Interface in = new Interface();
						in.nome = log;
						in.nivel = Dados.dadosPessoal.get(i).getNivel();
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

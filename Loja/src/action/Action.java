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
		System.out.println(w.lineCounter(Path.of("bd.txt")));
		String str = w.readFile(Path.of(fileName));
		String[] newStr = str.split(",");
		
			//seta as informa��es do beans
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

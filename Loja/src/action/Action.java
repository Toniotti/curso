package action;

import dados.Dados;
import beans.Pessoal;

public class Action {
	public boolean validate() {
		boolean valid = false;
		Pessoal p = new Pessoal();
		String log = p.getNome();
		String pass = p.getPass();
			for (int i = 0; i < Dados.dadosPessoal.size(); i++) {
				if((log.equals(Dados.dadosPessoal.get(i).getNome())) && (log.equals(Dados.dadosPessoal.get(i).getPass()))) {
					valid = true;
					break;
				}
			}
		System.out.println(valid);
		return valid;
	}
}

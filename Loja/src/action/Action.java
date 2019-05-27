package action;

import javax.swing.table.DefaultTableModel;
import dados.Dados;
import beans.Assassins;
import interf.Interface;

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

	
	public void addCarrinho(Assassins a) {
		Dados.dadosCarrinho.add(a);
	}
	
	public DefaultTableModel Carrinho() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nome");
		modelo.addColumn("Custo");

		
		for (int i = 0; i < Dados.dadosCarrinho.size(); i++) {
			modelo.addRow(new Object[] {
					Dados.dadosCarrinho.get(i).getNome(),
					Dados.dadosCarrinho.get(i).getCustoA(),
			});
		}
		
		return modelo;
		
	}
	
	
public DefaultTableModel selecionar() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nome");
		modelo.addColumn("Idade");
		modelo.addColumn("Restriçoes");
		modelo.addColumn("Estilo");
		modelo.addColumn("Custo");
		modelo.addColumn("local");

		for (int indice = 0; indice < Dados.dadosAssassin.size(); indice++) {
			modelo.addRow(new Object[] {
					Dados.dadosAssassin.get(indice).getNome(),
					Dados.dadosAssassin.get(indice).getIdade(),
					Dados.dadosAssassin.get(indice).getExceA(), 
					Dados.dadosAssassin.get(indice).getEstiloA(),
					Dados.dadosAssassin.get(indice).getCustoA(),
					Dados.dadosAssassin.get(indice).getLocal()

			});

		}

		return modelo;
	}
public void excluir(int row) {
	Dados.dadosCarrinho.remove(row);
}
}

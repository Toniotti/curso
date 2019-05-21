package beans;

public class Assassins extends Pessoal{
//variables
//name, local, exception, style(of killing)
private String ExceA, EstiloA;
private int DistanciaA;
private Double CustoA;

//set and get
public String getExceA() {
	return ExceA;
}
public void setExceA(String exceA) {
	ExceA = exceA;
}
public String getEstiloA() {
	return EstiloA;
}
public void setEstiloA(String estiloA) {
	EstiloA = estiloA;
}
public Double getCustoA() {
	return CustoA;
}
public void setCustoA(Double custoA) {
	CustoA = custoA;
}

public int getDistanciaA() {
	return DistanciaA;
}
public void setDistanciaA(int distanciaA) {
	DistanciaA = distanciaA;
}
}

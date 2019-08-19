package controller;

import controller.ControllerLogin;

public class homeBean {
	
	public static String username;
	public static String nickname;
	private String password;
    public static String tipo;
    
    
    
    public String ConvalidaLogin() {//Funzione che controlla il login chiamando il metodo del ControlloView e ritorna il tipo(Locatore,Locatario)
    	/*ControllerLogin vv=ControllerLogin.getInstance();
		String tipo=vv.Login(this.username,this.password);
		this.setTipo(tipo);
		return tipo;*/
    	
    	if(ControllerLogin.ricercaLogin(nickname, password)) return "Locatario";
    	else return "errore";
	}
    
    /*public void setTipo(String tipo) {
		this.tipo = tipo;
	}*/

}

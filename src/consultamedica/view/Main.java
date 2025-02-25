package consultamedica.view;

import consultamedica.dao.Database;

public class Main {
	
//chamando a tela Principal
	
	public static void main(String[] args) {
	 try {
		 Database banco = new Database();
		 banco.conectar();
		 
		 TelaPrincipal tl = new TelaPrincipal();
		 tl.setVisible(true);
	 }catch(Exception e){
		 System.out.println(e.getMessage());
		 
	 }

	}

}

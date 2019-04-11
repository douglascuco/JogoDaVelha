import javax.swing.JOptionPane;

public class Regra {
	private int emp = 0; //contador de rodada
	private boolean acabou = false; //variavel para finalizar a rodada
	private String[][] m = new String[][]  {{"0","0","0"},
											{"0","0","0"},
											{"0","0","0"}};
											
	public Regra() {
	}
	
	public String[][] getM(){
		return m;
	}
	
	public void setM(String m, int x, int y) {
		this.m[x][y] = m;
		
//		for(int i = 0;i<3;i++) {
//			for(int j = 0;j<3;j++) {
//				System.out.println(this.m[i][j] );
//			}
//		}
		this.emp++;
	}
	
	public void setEmp(int emp) {
		this.emp = emp;
	}
	
	public int getEmp() {
		return emp;
	}
	
	public void setAcabou(boolean acabou) {
		this.acabou = acabou;
	}
	
	public boolean getAcabou(){
		return acabou;
	}
	
	public void ZerarM() { //zera a matriz e o contador
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				this.m[i][j] = "0";
			}
		}
		this.emp = 0;
		JOptionPane.showMessageDialog(null,"COMEÇOU");
	}
	
	public void Ganhou() {  //regra pra definir quais as areas devem estar preenchidas para ganhar
		String[] g = new String[10]; 
		g[0] = m[0][0] + m[0][1] + m[0][2];
		g[1] = m[1][0] + m[1][1] + m[1][2];
		g[2] = m[2][0] + m[2][1] + m[2][2];
		
		g[3] = m[0][0] + m[1][0] + m[2][0];
		g[4] = m[0][1] + m[1][1] + m[2][1];
		g[5] = m[0][2] + m[1][2] + m[2][2];
		
		g[6] = m[0][0] + m[1][1] + m[2][2];
		g[7] = m[2][0] + m[1][1] + m[0][2];
		g[8] = "0";
		g[9] = "0";
		
		for(int i= 0; i<10; i++) {
			if(g[i].equals("XXX")){
				JOptionPane.showMessageDialog(null,"X GANHOU");
				acabou = true;
				emp = 0;  
				break;
			} else if (g[i].equals("OOO")) {
				JOptionPane.showMessageDialog(null,"O GANHOU");
				acabou = true;
				break;
			} 
		}
		
		if (emp == 9) {
			JOptionPane.showMessageDialog(null,"EMPATOU");	
			acabou = true;
		}
	}
}

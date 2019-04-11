import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
// https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html //
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyListener.html //
// https://docs.oracle.com/javase/8/docs/api/javax/swing/event/MouseInputListener.html //
public class Tela extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;
	private String title;
	private int width;
	private int height;
	private Image image1, image2, image3, image4, image5, image6, image7, image8, image9;
	private Boolean jogador;
	private Regra n;
	
	ImageIcon imageiconNull = new ImageIcon( "res\\null.png" );
	ImageIcon imageiconX = new ImageIcon( "res\\x.png" );
	ImageIcon imageiconO = new ImageIcon( "res\\o.png" );

	
	public Tela( String title, int width, int height ){
		// construtor da classe JFrame //
		super( title );
		// metodo de definicao das dimensoes da janela //
		super.setSize( width, height );
		// metodo de definicao do estado da janela //
		super.setVisible( false );
		
		this.title = title;
		this.width = width;
		this.height = height;
		setLocationRelativeTo (null);//deixa a janela centralizada no meio da tela//
		this.n = new Regra();
		this.Zerar();
		
		// permite que a frame processo os eventos de teclas e mouse //
		addKeyListener( this );
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	public boolean getJogador() {
		return jogador;
	}
	
	public void setJogador(boolean jogador) {
		this.jogador = jogador;
	}
	// https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
	public void paint( Graphics g ){
		ImageIcon imageIcon = new ImageIcon( "res\\jogo.png" );
		Image imagem  = imageIcon.getImage();
		g.drawImage( imagem, 10, 35, null );
		
		g.drawImage(image7, 20, 45, null );  //num_pad 07 103	
		g.drawImage(image8, 120, 45, null);  //num_pad 08 104 
		g.drawImage(image9, 220, 45, null);  //num_pad 09 105
		g.drawImage(image4, 20, 145, null);  //num_pad 04 100
		g.drawImage(image5, 120, 145, null); //num_pad 05 101 
		g.drawImage(image6, 220, 145, null); //num_pad 06 102 
		g.drawImage(image1, 20, 245, null);  //num_pad 01 97
		g.drawImage(image2, 120, 245, null); //num_pad 02 98
		g.drawImage(image3, 220, 245, null); //num_pad 03 99	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println( "keyTyped" );
		//System.out.println( e.getKeyCode() );
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println( "keyPressed" );
		System.out.println( e.getKeyCode() );
		action(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println( "keyReleased" );
		//System.out.println( e.getKeyCode() );
		//action(e.getKeyCode());
	}
	
	public void Zerar() {//zerar totalmente o jogo, deixa igual quando ele é iniciado
		this.image1  = imageiconNull.getImage();
		this.image2  = imageiconNull.getImage();
		this.image3  = imageiconNull.getImage();
		this.image4  = imageiconNull.getImage();
		this.image5  = imageiconNull.getImage();
		this.image6  = imageiconNull.getImage();
		this.image7  = imageiconNull.getImage();
		this.image8  = imageiconNull.getImage();
		this.image9  = imageiconNull.getImage();
		this.n.ZerarM();
		this.n.setAcabou(false);
		this.jogador = true;
		super.repaint();
	}
	
	public void Reset() { //reseta o jogo cada vez que acabar
		if(this.n.getAcabou() == true){
			this.Zerar();
		}
	}
	
	public void trocar() { //troca os jogadores x e o
		if(jogador == true) {
			jogador = false;
		}else {
			jogador = true;
		}
	}
	
	private void action( int key ) {
		if(key == 103 ) { //numpad 7
			if(jogador == true && this.n.getM()[0][0] == "0") { //vez do jogador X e matriz vazia
				this.image7  = imageiconX.getImage();
				this.n.setM("X",0,0);
				this.trocar();
			}
			else if(jogador == false && this.n.getM()[0][0] == "0"){ //vez do jogador O e matriz vazia
				this.image7 = imageiconO.getImage();
				this.n.setM("O",0,0);
				this.trocar();
			}
			else {
				JOptionPane.showMessageDialog(null,"JOGADA INVÁLIDA"); //caso a matriz ja esteja preenchida com X ou O
			}
		}
		if(key == 104) {
			if(jogador == true && this.n.getM()[0][1] == "0") {
				this.image8  = imageiconX.getImage();
				this.n.setM("X",0,1);
				this.trocar();
			}else if(jogador == false && this.n.getM()[0][1] == "0"){
				this.image8 = imageiconO.getImage();
				this.n.setM("O",0,1);
				this.trocar();
			}else {
				JOptionPane.showMessageDialog(null,"JOGADA INVÁLIDA");
			}
		}
		if(key == 105) {
			if(jogador == true && this.n.getM()[0][2] == "0") {
				this.image9  = imageiconX.getImage();
				this.n.setM("X",0,2);
				this.trocar();
			}else if(jogador == false && this.n.getM()[0][2] == "0"){
				this.image9 = imageiconO.getImage();
				this.n.setM("O",0,2);
				this.trocar();
			}else {
				JOptionPane.showMessageDialog(null,"JOGADA INVÁLIDA");
			}
		}
		if(key == 100) {
			if(jogador == true && this.n.getM()[1][0] == "0") {
				this.image4  = imageiconX.getImage();
				this.n.setM("X",1,0);
				this.trocar();
			}else if(jogador == false && this.n.getM()[1][0] == "0"){
				this.image4 = imageiconO.getImage();
				this.n.setM("O",1,0);
				this.trocar();
			}else {
				JOptionPane.showMessageDialog(null,"JOGADA INVÁLIDA");
			}
		}
		if(key == 101) {
			if(jogador == true && this.n.getM()[1][1] == "0") {
				this.image5  = imageiconX.getImage();
				this.n.setM("X",1,1);
				this.trocar();
			}else if(jogador == false && this.n.getM()[1][1] == "0"){
				this.image5 = imageiconO.getImage();
				this.n.setM("O",1,1);
				this.trocar();
			}else {
				JOptionPane.showMessageDialog(null,"JOGADA INVÁLIDA");
			}
		}
		if(key == 102) {
			if(jogador == true && this.n.getM()[1][2] == "0") {
				this.image6  = imageiconX.getImage();
				this.n.setM("X",1,2);
				this.trocar();
			}else if(jogador == false && this.n.getM()[1][2] == "0"){
				this.image6 = imageiconO.getImage();
				this.n.setM("O",1,2);
				this.trocar();
			}else {
				JOptionPane.showMessageDialog(null,"JOGADA INVÁLIDA");
			}
		}
		if(key == 97) {
			if(jogador == true && this.n.getM()[2][0] == "0") {
				this.image1  = imageiconX.getImage();
				this.n.setM("X",2,0);
				this.trocar();
			}else if(jogador == false && this.n.getM()[2][0] == "0"){
				this.image1 = imageiconO.getImage();
				this.n.setM("O",2,0);
				this.trocar();
			}else {
				JOptionPane.showMessageDialog(null,"JOGADA INVÁLIDA");
			}
		}
		if(key == 98) {
			if(jogador == true && this.n.getM()[2][1] == "0") {
				this.image2  = imageiconX.getImage();
				this.n.setM("X",2,1);
				this.trocar();
			}else if(jogador == false && this.n.getM()[2][1] == "0"){
				this.image2 = imageiconO.getImage();
				this.n.setM("O",2,1);
				this.trocar();
			}else {
				JOptionPane.showMessageDialog(null,"JOGADA INVÁLIDA");
			}
		}
		if(key == 99) {
			if(jogador == true && this.n.getM()[2][2] == "0") {
				this.image3  = imageiconX.getImage();
				this.n.setM("X",2,2);
				this.trocar();
			}else if(jogador == false && this.n.getM()[2][2] == "0"){
				this.image3 = imageiconO.getImage();
				this.n.setM("O",2,2);
				this.trocar();
			}else {
				JOptionPane.showMessageDialog(null,"JOGADA INVÁLIDA");
			}
		}
		if(key == 82) {//pressione R para resetar
			this.Zerar();
		}
		super.repaint();
		this.n.Ganhou();
		this.Reset();
	}
}
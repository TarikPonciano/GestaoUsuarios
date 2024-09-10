package sistema.Visualização;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelComFundo extends JPanel {
	private String caminhoImagem;

	public JPanelComFundo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JPanelComFundo(String caminho) {
		super();
		this.caminhoImagem = caminho;
		// TODO Auto-generated constructor stub
	}

	public JPanelComFundo(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public JPanelComFundo(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public JPanelComFundo(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}
	
	
		@Override
		public void paintComponent(final Graphics g) {
		    super.paintComponent(g);
		    BufferedImage imagemOriginal = null;
		    Image image = null;
			try {
				imagemOriginal = ImageIO.read(getClass().getResource(caminhoImagem));
				image = imagemOriginal.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    		if (image != null)
		        g.drawImage(image, 0, 0, null);
		}
	

}

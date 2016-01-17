
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
/**
 * ±³¾°Ãæ°å
 * 2012-6-23
 */
public class BackgroundPanel extends JPanel {	
	private Image image;// ±³¾°Í¼Æ¬
	public BackgroundPanel() {
		setOpaque(false);
		setLayout(null);
	}

	public void setImage(Image image) {
		this.image = image;
	}
	/**
	 * »­³ö±³¾°
	 */
	protected void paintComponent(Graphics g) {
		if (image != null) {
			// Í¼Æ¬¿í¶È
			int width = getWidth();
			// Í¼Æ¬¸ß¶È
			int height = getHeight();
			// »­³öÍ¼Æ¬
			g.drawImage(image, 0, 0, width, height, this);
		}
		super.paintComponent(g);
	}
}

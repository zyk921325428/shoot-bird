
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
/**
 * �������
 * 2012-6-23
 */
public class BackgroundPanel extends JPanel {	
	private Image image;// ����ͼƬ
	public BackgroundPanel() {
		setOpaque(false);
		setLayout(null);
	}

	public void setImage(Image image) {
		this.image = image;
	}
	/**
	 * ��������
	 */
	protected void paintComponent(Graphics g) {
		if (image != null) {
			// ͼƬ���
			int width = getWidth();
			// ͼƬ�߶�
			int height = getHeight();
			// ����ͼƬ
			g.drawImage(image, 0, 0, width, height, this);
		}
		super.paintComponent(g);
	}
}

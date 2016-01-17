import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;
public class BirdLabel extends JLabel implements Runnable {
    // ��������̵߳�����ʱ�䣬������С���ƶ��ٶ�
//	public static int degree=50;
	private static int wait=0;
	private int sleepTime = (int) (Math.random() * 5) + 35+wait;
    private int y = 100;
    private Thread thread;// ���߳���Ϊ��Ա����
    private Container parent;
    public static int remainbirds=50;
    

   
	/**
     * ���췽��
     */
    public BirdLabel() {
        super();
        // ����С��ͼ�����
        ImageIcon icon = new ImageIcon(getClass().getResource(
                "images/bird.gif"));
        setIcon(icon);// ���ÿؼ�ͼ��
        addMouseListener(new MouseAction());// �������¼�������
        // ��ӿؼ��¼�������
        addComponentListener(new ComponentAction());
        thread = new Thread(this);// �����̶߳���
    }
    /**
     * �ؼ��Ŀؼ��¼�������    
     */
    private final class ComponentAction extends ComponentAdapter {
        public void componentResized(final ComponentEvent e) {
            thread.start();// �߳�����
        }
    }
    
    /**
     * �ؼ�������¼�������
     */
    private final class MouseAction extends MouseAdapter  {
        public void mousePressed(final MouseEvent e) {
            MainFrame.useAmmo();// �����ӵ�
            appScore();// �ӷ�
          //  remainbirds=remainbirds-1;
            wait=wait-3;
            destory();
           
            
            
            if(MainFrame.getAmmoNum()<=1||BirdLabel.getRemainbirds()<=0){
            setframe.getFrame().dispose();
            account.finalaccount();
            	
            }
            if(MainFrame.getAmmoNum()<0)
            	MainFrame.setAmmoNum(0);// ���ٱ����
        }
        
    }

    public void run() {
        parent = null;
        int width = 0;
        try {
            while (width <= 0 || parent == null) {
                if (parent == null){
                    parent = getParent();// ��ȡ������
                } else {
                    width = parent.getWidth();// ��ȡ�������Ŀ��
                }
                Thread.sleep(10);
            }
            for (int i =0; i < width && parent != null; i += 5) {
            	y=(int)(50* Math.cos(i/40))+200;
            	if(MainFrame.getAmmoNum()<=0||BirdLabel.getRemainbirds()<=0){
                	
            		destory();
            		break;
                }
                setLocation(i, y);
                // ���������ƶ������λ��
                Thread.sleep(sleepTime);// ����Ƭ��
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      remainbirds--;
     //System.out.println(remainbirds);
      wait++;
        destory();// �ƶ���ϣ����ٱ����
    }
    
    /**
     * �������Ƴ�������ķ���
     */
    public void destory() {
        if (parent == null)
            return;
        parent.remove(this);// �Ӹ��������Ƴ�����
        parent.repaint();
        parent = null; // ͨ���������ֹ�߳�ѭ��
    }
    
    /**
     * �ӷֵķ���
     */
    private void appScore() {
        MainFrame.appScore(1);;
        
    }

	public static int getRemainbirds() {
		return remainbirds;
	}

	public static void setRemainbirds(int remainbirds) {
		BirdLabel.remainbirds = remainbirds;
	}

 
}

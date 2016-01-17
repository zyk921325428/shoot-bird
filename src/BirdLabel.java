import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;
public class BirdLabel extends JLabel implements Runnable {
    // 随机生成线程的休眠时间，即控制小鸟移动速度
//	public static int degree=50;
	private static int wait=0;
	private int sleepTime = (int) (Math.random() * 5) + 35+wait;
    private int y = 100;
    private Thread thread;// 将线程作为成员变量
    private Container parent;
    public static int remainbirds=50;
    

   
	/**
     * 构造方法
     */
    public BirdLabel() {
        super();
        // 创建小鸟图标对象
        ImageIcon icon = new ImageIcon(getClass().getResource(
                "images/bird.gif"));
        setIcon(icon);// 设置控件图标
        addMouseListener(new MouseAction());// 添加鼠标事件监听器
        // 添加控件事件监听器
        addComponentListener(new ComponentAction());
        thread = new Thread(this);// 创建线程对象
    }
    /**
     * 控件的控件事件监听器    
     */
    private final class ComponentAction extends ComponentAdapter {
        public void componentResized(final ComponentEvent e) {
            thread.start();// 线程启动
        }
    }
    
    /**
     * 控件的鼠标事件监听器
     */
    private final class MouseAction extends MouseAdapter  {
        public void mousePressed(final MouseEvent e) {
            MainFrame.useAmmo();// 消耗子弹
            appScore();// 加分
          //  remainbirds=remainbirds-1;
            wait=wait-3;
            destory();
           
            
            
            if(MainFrame.getAmmoNum()<=1||BirdLabel.getRemainbirds()<=0){
            setframe.getFrame().dispose();
            account.finalaccount();
            	
            }
            if(MainFrame.getAmmoNum()<0)
            	MainFrame.setAmmoNum(0);// 销毁本组件
        }
        
    }

    public void run() {
        parent = null;
        int width = 0;
        try {
            while (width <= 0 || parent == null) {
                if (parent == null){
                    parent = getParent();// 获取父容器
                } else {
                    width = parent.getWidth();// 获取父容器的宽度
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
                // 从右向左移动本组件位置
                Thread.sleep(sleepTime);// 休眠片刻
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      remainbirds--;
     //System.out.println(remainbirds);
      wait++;
        destory();// 移动完毕，销毁本组件
    }
    
    /**
     * 从容器移除本组件的方法
     */
    public void destory() {
        if (parent == null)
            return;
        parent.remove(this);// 从父容器中移除本逐渐
        parent.repaint();
        parent = null; // 通过该语句终止线程循环
    }
    
    /**
     * 加分的方法
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

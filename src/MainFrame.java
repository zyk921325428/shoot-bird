
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainFrame extends JFrame {
    private static long score = 0;// 分数
    private static Integer ammoNum = 100;// 子弹数量
    private static JLabel scoreLabel;// 分数
    private BackgroundPanel backgroundPanel;
    private static JLabel ammoLabel;
    private static JPanel infoPane;
    public static int ifclose=0;
  //  public static int degree;
   public static long getScore() {
		return score;
	}
	public static void setScore(long score) {
		MainFrame.score = score;
	}
	public static Integer getAmmoNum() {
		return ammoNum;
	}
	public static void setAmmoNum(Integer ammoNum) {
		MainFrame.ammoNum = ammoNum;
	}
	// private static Integer remainbirds = 50;
    /**
     * 构造方法
     */
    public MainFrame() {
        super();
        setResizable(false);// 进制调整窗体大小
        setTitle("打飞鸟");
        infoPane = (JPanel) getGlassPane();// 获取玻璃面板

        infoPane.setLayout(new BorderLayout());
       
        
        setAlwaysOnTop(true);// 是窗体保持在最顶层
        setBounds(100, 100, 573, 411);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {//关闭窗口时确认
                 public void windowClosing(WindowEvent e) {
                    int i=JOptionPane.showConfirmDialog(null, "确定要退出系统吗？", "退出系统", JOptionPane.YES_NO_OPTION);
                 if(i==JOptionPane.YES_OPTION){
                  System.exit(0);
                 }
                 }
            });

        
        backgroundPanel = new BackgroundPanel();// 创建带背景的面板
        backgroundPanel.setImage(new ImageIcon(getClass()
                .getResource("images/background.jpg")).getImage());// 设置背景图片
        getContentPane().add(backgroundPanel,
                BorderLayout.CENTER);
        
        // 添加鼠标事件适配器
        addMouseListener(new FrameMouseListener());
        scoreLabel = new JLabel();// 显示分数的标签组件
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setForeground(Color.ORANGE);
        scoreLabel.setText("击中飞鸟数：");
        scoreLabel.setBounds(25, 15, 120, 18);
        backgroundPanel.add(scoreLabel);
        ammoLabel = new JLabel();// 显示自动数量的标签组件
        ammoLabel.setForeground(Color.ORANGE);
        ammoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        ammoLabel.setText("子弹数量：" + ammoNum);
        ammoLabel.setBounds(422, 15, 93, 18);
        backgroundPanel.add(ammoLabel);
        
    }
   
    /**
     * 加分方法
     */
    public synchronized static void appScore(int num) {
        score += num;
        scoreLabel.setText("击中飞鸟数： " + score);
        music.shotsound();//击中音效
    }
    
    /**
     * 消耗子弹的方法
      */
    public synchronized static void useAmmo() {
        synchronized (ammoNum) {
            ammoNum--;// 子弹数量递减
            ammoLabel.setText("子弹数量：" + ammoNum);
           
                new Thread(new Runnable() {
                    public void run() {
                        // 显示提示信息面板
                        infoPane.setVisible(true);
                        
                        infoPane.setVisible(false);// 隐藏提示信息面板
                    }
                }).start();
            
        }
    }
    
    /**
     * 判断子弹是否够用
     * 
     */
    public synchronized static boolean readyAmmo() {
        synchronized (ammoNum) {
            return ammoNum > 0;
        }
    }    

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pre.start();
                  
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
    }
    

    
    /**
     * 启动游戏的方法
     */
    public void start() {
        new BirdThread().start();
        music.backgroundsound();//开启背景音乐
    }
    
    /**
     * 窗体的鼠标事件监听器
     * 
     */
    private final class FrameMouseListener extends MouseAdapter {
        public void mousePressed(final MouseEvent e) {
            Component at = backgroundPanel.getComponentAt(e
                    .getPoint());
            if (at instanceof BackgroundPanel) {// 如果点到面板也扣除子弹
                MainFrame.useAmmo();// 消耗子弹
            }
            
        }
    }
    
    
   
    
    
    	
    
    /**
     * 生成鸟角色的线程
     * 
     */
    class BirdThread extends Thread {
        @Override
        
        
        public void run() {
        int times=0;
      //  long time=0;
            while (true) {
            	
                // 创建代表小鸟的标签控件
            	if(ammoNum<=0||BirdLabel.getRemainbirds()<=0){
                	dispose();
                	account.finalaccount();
                	break;
                }
            	if(times>0&&times<=50){
            	 BirdLabel bird;
                bird = new BirdLabel();              
                bird.setSize(50, 50);// 设置控件初始大小
                backgroundPanel.add(bird);
               // BirdLabel.setRemainbirds(BirdLabel.getRemainbirds()-1);
                
                }
                try {
                    // 线程随机休眠一段时间
                   // sleep((long)((100-BirdLabel.remainbirds)-score)*100+1);
                	sleep(1000);
                	
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    
                	
                }
              
              times++;  
            }
        }
    }
    }   
    
    


class account{
	public static JFrame frameac;
	public static void finalaccount(){
		//frame.closewin();
		JButton again;
		JLabel bac=new JLabel();
		frameac=new JFrame();
		again= new JButton();
		again= new JButton(new ImageIcon(MainFrame.class.getClass().getResource("/images/again.jpg")));
		JLabel accountam =new JLabel();
		JLabel accounthit =new JLabel();
		accountam.setText("剩余子弹数： "+MainFrame.getAmmoNum());
		accounthit.setText("总共击中飞鸟数： "+ MainFrame.getScore());
		JLabel image=new JLabel(new ImageIcon(MainFrame.class.getClass().getResource("/images/account.jpg")));
		frameac.setLayout(null);
		again.setLayout(null);
		accountam.setLayout(null);
		accounthit.setLayout(null);
		image.setLayout(null);
		again.addActionListener(new again());
		bac.setLayout(null);
		bac.setBounds(0, 0, 573, 411);
		image.setBounds(0, 0, 274, 411);
		accountam.setBounds(274, 0, 299, 100);
		accounthit.setBounds(274, 100, 299, 100);
		accountam.setFont(new java.awt.Font("Dialog", 1, 30));
		accounthit.setFont(new java.awt.Font("Dialog", 1, 30));
		again.setBounds(354, 250, 189, 61);
		bac.add(again);
		bac.add(image);
		bac.add(accounthit);
		bac.add(accountam);
		frameac.setResizable(false);
		frameac.setBounds(100, 100, 573, 411);
		frameac.setTitle("打飞鸟");
		frameac.add(bac);
		frameac.setVisible(true);
	}
	public static void CloseWin(){
		frameac.dispose();
		}
	}
	class again implements ActionListener{

    	@Override
    	
    	public void actionPerformed(ActionEvent e) {
    		// TODO Auto-generated method stub
    		//JFrame.DISPOSE_ON_CLOSE
    		MainFrame.setAmmoNum(100);
        	MainFrame.setScore(0);
        	BirdLabel.setRemainbirds(50);
        //	MainFrame.
        	//BirdLabel.setRemainbirds(50);
        	account.frameac.dispose();
        	try {
                pre.start();
              
            } catch (Exception e1) {
                e1.printStackTrace();
            }
    		
    	}
}
	
 class setframe {
	 static MainFrame frame = new MainFrame();
	public static MainFrame getFrame() {
		return frame;
	}
	public static void setFrame(MainFrame frame) {
		setframe.frame = frame;
	}
	static void setframe (){
		 
         frame.setVisible(true);
         frame.start();
         
	 }
	 }
 class pre {
		static JFrame frame; 
		public static  void start(){
			MainFrame.setAmmoNum(100);
        	MainFrame.setScore(0);
        	BirdLabel.setRemainbirds(50);
				JButton start ;
				JLabel info=new JLabel();
				info.setText("本游戏已实现自动调节游戏难度");
				
				JPanel contentPanel=new JPanel();		
				frame = new JFrame();
				frame.setLocation(0, 0);
				start= new JButton();
				start= new JButton(new ImageIcon(MainFrame.class.getClass().getResource("/images/start.jpg")));
				JLabel bac=new JLabel();
				Icon icon1=new ImageIcon(MainFrame.class.getClass().getResource("/images/startbackground.jpg"));     
				bac.setIcon(icon1);
				//两个元素加入panel
				contentPanel.add(start);	
				//取消布局管理器 设置各元素位置
				contentPanel.setLayout(null);
				contentPanel.setBounds(0, 0, 573, 411);
				bac.setLayout(null);
				bac.setBounds(0, 0, 573, 411);
				start.setLayout(null);
				start.setBounds(400, 230, 93, 31);
				info.setLayout(null);
				info.setBounds(350, 160, 200, 62);
				frame.setLayout(null);
				bac.add(info);
				frame.setBounds(100, 100, 573, 411);
				frame.setTitle("打飞鸟");
				frame.setSize(573, 411);
				start.addActionListener(new startx());

				contentPanel.setOpaque(false);
				frame.add(contentPanel);
				frame.add(bac);
				//设为可视
				frame.setVisible(true);
			
		} 
		public  static void CloseWin()
		{
			frame.dispose();
			
		}
	}
 class startx implements ActionListener{

		@Override
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//JFrame.DISPOSE_ON_CLOSE
			setframe.setframe();
			pre.CloseWin();
			
		}
	}
 /*class easy implements ActionListener{

		@Override
		
		public void actionPerformed(ActionEvent e) {
			MainFrame.degree=3000;
			
		}
	}
 class normal implements ActionListener{

		@Override
		
		public void actionPerformed(ActionEvent e) {
			MainFrame.degree=500;
		}
	}
 class hard implements ActionListener{
 
		@Override
		
		public void actionPerformed(ActionEvent e) {
			MainFrame.degree=200;
		}
	}*/
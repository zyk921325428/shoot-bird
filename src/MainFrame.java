
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainFrame extends JFrame {
    private static long score = 0;// ����
    private static Integer ammoNum = 100;// �ӵ�����
    private static JLabel scoreLabel;// ����
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
     * ���췽��
     */
    public MainFrame() {
        super();
        setResizable(false);// ���Ƶ��������С
        setTitle("�����");
        infoPane = (JPanel) getGlassPane();// ��ȡ�������

        infoPane.setLayout(new BorderLayout());
       
        
        setAlwaysOnTop(true);// �Ǵ��屣�������
        setBounds(100, 100, 573, 411);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {//�رմ���ʱȷ��
                 public void windowClosing(WindowEvent e) {
                    int i=JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˳�ϵͳ��", "�˳�ϵͳ", JOptionPane.YES_NO_OPTION);
                 if(i==JOptionPane.YES_OPTION){
                  System.exit(0);
                 }
                 }
            });

        
        backgroundPanel = new BackgroundPanel();// ���������������
        backgroundPanel.setImage(new ImageIcon(getClass()
                .getResource("images/background.jpg")).getImage());// ���ñ���ͼƬ
        getContentPane().add(backgroundPanel,
                BorderLayout.CENTER);
        
        // �������¼�������
        addMouseListener(new FrameMouseListener());
        scoreLabel = new JLabel();// ��ʾ�����ı�ǩ���
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setForeground(Color.ORANGE);
        scoreLabel.setText("���з�������");
        scoreLabel.setBounds(25, 15, 120, 18);
        backgroundPanel.add(scoreLabel);
        ammoLabel = new JLabel();// ��ʾ�Զ������ı�ǩ���
        ammoLabel.setForeground(Color.ORANGE);
        ammoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        ammoLabel.setText("�ӵ�������" + ammoNum);
        ammoLabel.setBounds(422, 15, 93, 18);
        backgroundPanel.add(ammoLabel);
        
    }
   
    /**
     * �ӷַ���
     */
    public synchronized static void appScore(int num) {
        score += num;
        scoreLabel.setText("���з������� " + score);
        music.shotsound();//������Ч
    }
    
    /**
     * �����ӵ��ķ���
      */
    public synchronized static void useAmmo() {
        synchronized (ammoNum) {
            ammoNum--;// �ӵ������ݼ�
            ammoLabel.setText("�ӵ�������" + ammoNum);
           
                new Thread(new Runnable() {
                    public void run() {
                        // ��ʾ��ʾ��Ϣ���
                        infoPane.setVisible(true);
                        
                        infoPane.setVisible(false);// ������ʾ��Ϣ���
                    }
                }).start();
            
        }
    }
    
    /**
     * �ж��ӵ��Ƿ���
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
     * ������Ϸ�ķ���
     */
    public void start() {
        new BirdThread().start();
        music.backgroundsound();//������������
    }
    
    /**
     * ���������¼�������
     * 
     */
    private final class FrameMouseListener extends MouseAdapter {
        public void mousePressed(final MouseEvent e) {
            Component at = backgroundPanel.getComponentAt(e
                    .getPoint());
            if (at instanceof BackgroundPanel) {// ����㵽���Ҳ�۳��ӵ�
                MainFrame.useAmmo();// �����ӵ�
            }
            
        }
    }
    
    
   
    
    
    	
    
    /**
     * �������ɫ���߳�
     * 
     */
    class BirdThread extends Thread {
        @Override
        
        
        public void run() {
        int times=0;
      //  long time=0;
            while (true) {
            	
                // ��������С��ı�ǩ�ؼ�
            	if(ammoNum<=0||BirdLabel.getRemainbirds()<=0){
                	dispose();
                	account.finalaccount();
                	break;
                }
            	if(times>0&&times<=50){
            	 BirdLabel bird;
                bird = new BirdLabel();              
                bird.setSize(50, 50);// ���ÿؼ���ʼ��С
                backgroundPanel.add(bird);
               // BirdLabel.setRemainbirds(BirdLabel.getRemainbirds()-1);
                
                }
                try {
                    // �߳��������һ��ʱ��
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
		accountam.setText("ʣ���ӵ����� "+MainFrame.getAmmoNum());
		accounthit.setText("�ܹ����з������� "+ MainFrame.getScore());
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
		frameac.setTitle("�����");
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
				info.setText("����Ϸ��ʵ���Զ�������Ϸ�Ѷ�");
				
				JPanel contentPanel=new JPanel();		
				frame = new JFrame();
				frame.setLocation(0, 0);
				start= new JButton();
				start= new JButton(new ImageIcon(MainFrame.class.getClass().getResource("/images/start.jpg")));
				JLabel bac=new JLabel();
				Icon icon1=new ImageIcon(MainFrame.class.getClass().getResource("/images/startbackground.jpg"));     
				bac.setIcon(icon1);
				//����Ԫ�ؼ���panel
				contentPanel.add(start);	
				//ȡ�����ֹ����� ���ø�Ԫ��λ��
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
				frame.setTitle("�����");
				frame.setSize(573, 411);
				start.addActionListener(new startx());

				contentPanel.setOpaque(false);
				frame.add(contentPanel);
				frame.add(bac);
				//��Ϊ����
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

import java.io.*;
import java.net.URL;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class music {
public static void backgroundsound(){//��ʼ�������ַ���(����/�ӵ���������)
	new Thread(new Runnable() {
		@Override
		public void run() {
			AePlayWave apw=new AePlayWave(music.class.getResource("sounds/backgroundsound.wav")); 
			apw.start();
//			System.out.println("��ʼ����");
				boolean isRun=true;
		while(isRun){//ѭ��ѯ���Ƿ���Ҫ����
		if(MainFrame.getAmmoNum()<=0||BirdLabel.getRemainbirds()<=0){
						apw.stop();
//						System.out.println("��������");
						isRun=false;
		}

		try {
		Thread.sleep(1000);//���ʱ��
//		System.out.println("ѯ��");
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		}  
		}
		}).start();
} 

//��ʼ�������� ����apw
/*	AePlayWave apw=new AePlayWave("./sounds/backgroundsound.wav"); 
	apw.start();
	System.out.println("��ʼ����");
		boolean isRun=true;
		while(isRun){
//			System.out.println("ѯ��ǰ");
			if(MainFrame.getAmmoNum()<=0||BirdLabel.getRemainbirds()<=0){
				apw.stop();
//				System.out.println("��������");
				isRun=false;
			}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
}
*/

/*	if(MainFrame.getAmmoNum()<=0||BirdLabel.getRemainbirds()<=0){
		apw.stop();
	}*/

/*public static void stopbackgroundsound(){//ֹͣ�������ַ���
	AePlayWave apw=MainFrame.a;
	apw.stop();
	System.out.println("��������");
//	System.exit(0);
}*/

public static void shotsound() { //���������� ����
			AePlayWave apw=new AePlayWave(music.class.getResource("sounds/shotsound.wav")); 
			apw.start();
//			System.out.println("����");
} 
}
 class AePlayWave{//�������λ��
//	volatile boolean stop = false;
	AudioStream as=null;
	public AePlayWave(URL url) {
//		URL filename = url;
		try {
//			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			BufferedInputStream fileau = new BufferedInputStream(url.openStream());
	        as = new AudioStream(fileau); 

	}catch (Exception e) {
		e.printStackTrace();
		return;
	}
}
	public void start() {//����
		// TODO Auto-generated method stub
        AudioPlayer.player.start(as);
	}
	public void stop(){//ֹͣ
		AudioPlayer.player.stop(as);
	}
}

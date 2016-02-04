
import java.io.*;
import java.net.URL;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class music {
public static void backgroundsound(){//开始背景音乐方法(随鸟/子弹尽而结束)
	new Thread(new Runnable() {
		@Override
		public void run() {
			AePlayWave apw=new AePlayWave(music.class.getResource("sounds/backgroundsound.wav")); 
			apw.start();
//			System.out.println("开始播放");
				boolean isRun=true;
		while(isRun){//循环询问是否需要结束
		if(MainFrame.getAmmoNum()<=0||BirdLabel.getRemainbirds()<=0){
						apw.stop();
//						System.out.println("结束播放");
						isRun=false;
		}

		try {
		Thread.sleep(1000);//间隔时间
//		System.out.println("询问");
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		}  
		}
		}).start();
} 
public static void shotsound() { //射中鸟声音 方法
			AePlayWave apw=new AePlayWave(music.class.getResource("sounds/shotsound.wav")); 
			apw.start();
//			System.out.println("击中");
} 
}
 class AePlayWave{//获得音乐位置

	AudioStream as=null;
	public AePlayWave(URL url) {

		try {

			BufferedInputStream fileau = new BufferedInputStream(url.openStream());
	        as = new AudioStream(fileau); 

	}catch (Exception e) {
		e.printStackTrace();
		return;
	}
}
	public void start() {//播放
		// TODO Auto-generated method stub
        AudioPlayer.player.start(as);
	}
	public void stop(){//停止
		AudioPlayer.player.stop(as);
	}
}

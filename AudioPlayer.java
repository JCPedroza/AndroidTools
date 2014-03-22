import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
	
	private MediaPlayer mPlayer;
	private boolean     mIsPaused = false;
	
	public void stop() {
		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
		mIsPaused = false;
	}
	
	public void play(Context c) {
		if (mIsPaused) {  
			mPlayer.start();
			mIsPaused = false;
		} else {
			stop();
			mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
			mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					stop();
				}
			});
			mPlayer.start();
			mIsPaused = false;
		}
	}
	
	public void pause() {
		if (mPlayer != null && !mIsPaused) {
			mPlayer.pause();
			mIsPaused = true;
		}
	}
	
}

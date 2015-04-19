package service;

import java.util.HashMap;
import java.util.Map;
import com.example.checkin02.TakePhoto;
import util.HttpUtils;
import util.UploadUtil;
import util.UploadUtil.OnUploadProcessListener;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.widget.TextView;
import android.widget.Toast;

public class UploadService extends Service implements OnUploadProcessListener {
	private Binder localBinder = new localBinder();
	public final static int TO_UPLOAD_FILE = 0;
	public final static String requestURL = HttpUtils.BASE_URL+"AndroidUploadAction";
	private String picpath;
	private int status;
	private int ReplyStatus = 0;
	private String ReplyCode = null;
	private String username,course;
	

	public UploadService() {
		// TODO 自动生成的构造函数存根
	}

	public class localBinder extends Binder {
		public UploadService getService() {
			// 在这里返回当前Service对象，在Activity中调用此方法后即可得到Service的引用
			return UploadService.this;
		}

		@Override
		// data是传入的数据，reply是返回的数据
		protected boolean onTransact(int code, Parcel data, Parcel reply,
				int flags) throws RemoteException {
			// TODO 自动生成的方法存根
			username=data.readString();
			course=data.readString();
			status = data.readInt();
			picpath = data.readString();
			System.out.println("--->>username" + username);
			System.out.println("--->>course" + course);
			System.out.println("--->>status" + status);
			System.out.println("--->>picpath" + picpath);
			if (status == TO_UPLOAD_FILE) {
				System.out.println("---->>ok");
				toUploadFile();
			}
			
			return super.onTransact(code, data, reply, flags);
		}
	}

	private void toUploadFile() {
		UploadUtil uploadUtil = UploadUtil.getInstance();
		uploadUtil.setOnUploadProcessListener(this);
		String fileKey = "img";
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("course", course);
		System.out.println("--->>picpath" + picpath + "--->>fileKey" + fileKey
				+ "--->>requestURL" + requestURL);
		uploadUtil.uploadFile(picpath, fileKey, requestURL, params);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO 自动生成的方法存根
		return localBinder;
	}

	@Override
	public void onUploadDone(int responseCode, String message) {
		// TODO 自动生成的方法存根
		Message msg = Message.obtain();
		msg.what = 1;
		msg.arg1 = responseCode;
		msg.obj = message;
		handler.sendMessage(msg);
	}

	@Override
	public void initUpload(int fileSize) {
		// TODO 自动生成的方法存根
		Message msg = Message.obtain();
		msg.what = 3;
		msg.arg1 = fileSize;
		handler.sendMessage(msg);
	}

	@Override
	public void onUploadProcess(int uploadSize) {
		// TODO 自动生成的方法存根
		Message msg = Message.obtain();
		msg.what = 2;
		msg.arg1 = uploadSize;
		handler.sendMessage(msg);
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				
				ReplyCode = msg.obj + "";
				Toast.makeText(getApplicationContext(), ReplyCode, 1).show();
				break;
			
			}
		};
	};
}

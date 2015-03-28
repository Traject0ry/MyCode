package com.example.checkin02;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import service.UploadService;
import service.UploadService.localBinder;
import util.UploadUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TakePhoto extends Activity implements OnClickListener {
	private ImageButton imageButton;
	private Button uploadButton;
	private TextView txt;
	private ImageView imageView;
	public final static int TAKE_PHOTO = 100;
	public final static int TO_UPLOAD_FILE = 0;
	public final static String TAG = "UPLOADimg";
	private boolean flag;
	private Uri photoUri;
	private String picPath;
	private localBinder localBinder;
	private UploadService uploadService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_take_photo);
		imageButton = (ImageButton) this.findViewById(R.id.camera);
		uploadButton = (Button) this.findViewById(R.id.uploadImage);
		txt = (TextView) this.findViewById(R.id.txt1);
		imageView = (ImageView) this.findViewById(R.id.imageView);
		imageButton.setOnClickListener(this);
		uploadButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.camera:
			TakePhoto();
			break;
		case R.id.uploadImage:
			
			Parcel parcel = Parcel.obtain();
			System.out.println("--->>TO_UPLOAD_FILE"+TO_UPLOAD_FILE);
			System.out.println("--->>picPath"+picPath);
			parcel.writeInt(TO_UPLOAD_FILE);
			parcel.writeString(picPath);// 向service中传递的数据
			Parcel reply = Parcel.obtain();// 从service中获取的数据
			try {
				localBinder.transact(IBinder.LAST_CALL_TRANSACTION, parcel,
						reply, 0);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("---3->>" + reply.readInt());
			System.out.println("---4->>" + reply.readString());
			break;
			
		}
	}
@Override
protected void onStart() {
	// TODO 自动生成的方法存根
	super.onStart();
	Intent intent = new Intent(this, UploadService.class);
	bindService(intent, connection, Context.BIND_AUTO_CREATE);
}
	// 建立service的连接
	public ServiceConnection connection = new ServiceConnection() {
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO 自动生成的方法存根
			flag = false;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO 自动生成的方法存根
			localBinder=(localBinder)service;
			uploadService = localBinder.getService();
			System.out.println("---->>conn");
			// 在Activity中调用此方法后即可得到Service的引用
			flag = true;
		}
	};

	private void TakePhoto() {
		String SDState = Environment.getExternalStorageState();
		if (SDState.equals(Environment.MEDIA_MOUNTED)) {
			Intent intent = new Intent(
					android.provider.MediaStore.ACTION_IMAGE_CAPTURE);// "android.media.action.IMAGE_CAPTURE"
			String path = Environment.getExternalStorageDirectory().toString()
					+ "/aaaa";
			File path1 = new File(path);
			if (!path1.exists()) {
				path1.mkdirs();
			}
			File file = new File(path1, System.currentTimeMillis() + ".jpg");
			photoUri = Uri.fromFile(file);
			System.out.println("--->>photouri" + photoUri);
			intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, photoUri);
			intent.putExtra("return-data", true);
			startActivityForResult(intent, TAKE_PHOTO);
		} else {
			Toast.makeText(this, "内存卡不存在", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自动生成的方法存根
		if (requestCode == TAKE_PHOTO) {
			 try {
			 Bundle bundle = data.getExtras();
			 Bitmap bitmap = (Bitmap) bundle.get("data");
			 imageView.setImageBitmap(bitmap);
			 } catch(Exception e)
			{
				picPath = photoUri.toString().replace("file://", "");
				Log.i(TAG, "最终选择的图片=" + picPath);
				txt.setText("文件路径" + picPath);
				Bitmap bm = BitmapFactory.decodeFile(picPath);
				imageView.setImageURI(photoUri);
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}

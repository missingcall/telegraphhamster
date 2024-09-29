package com.aries.smart.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

import com.aries.smart.constant.ConstantsKey;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by damon on 2018/7/26.
 */

public class ShareUtils {
//    public static Tencent mTencent;
//    public static BaseUIListener baselistener;
    private static Activity context;
    private static String share_url = "http://www.hzshuyu.com";
//    private String title = "别睡了，起来嗨";
//    private static String content="千篇一律的直播，独一无二的"+ App.getInstance().getResources().getString(R.string.app_content)+"! ";
    private IWXAPI api;

    private ShareUtils(){}
    public static final ShareUtils getInstance(Activity activity) {
        context = activity;
/*
        CommonConfigResult configResult =
                ConfigFactory.getInstance().getCommonConfigResult();
        MineResult mineInfo = ConfigFactory.getInstance().getMineInfo();
        if (configResult != null)
        {
            share_url = configResult.getShare_url()+"?source="+CommonUtils.getChannelName(context);

        }

        if (mineInfo != null)
        {
            StringBuilder sb = new StringBuilder(content);
            sb.append("您的好友").append(mineInfo.getNickname()).append("在"+App.getInstance().getResources().getString(R.string.app_content)+"等你");
            content = sb.toString();
        }
*/


        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final ShareUtils INSTANCE = new ShareUtils();
    }

    public void initShareConfig(){
        initWx(context);
//        initQQ(context);
    }


/*    private void initQQ(Activity activity) {
        mTencent = Tencent.createInstance(ApiConstants.QQ_APPID, activity);
// 1.4版本:此处需新增参数，传入应用程序的全局context，可通过activity的getApplicationContext方法获取
// 初始化视图
        baselistener = new BaseUIListener(activity);
    }*/

    private void initWx(Activity activity) {
        api = WXAPIFactory.createWXAPI(activity, ConstantsKey.WECHAT_APPID,true);
        // 将该app注册到微信
        api.registerApp(ConstantsKey.WECHAT_APPID);
    }


    /**
     * @param title       分享的标题
     * @param openUrl     点击分享item打开的网页地址url
     * @param description 网页的描述
     * @param icon        分享item的图片
     * @param requestCode 0表示为分享到微信好友  1表示为分享到朋友圈 2表示微信收藏
     */
    public void sendToWeiXin(String title, String openUrl, String description, Bitmap icon, int requestCode) {
        //初始化一个WXWebpageObject对象，填写url
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = openUrl;
        //Y用WXWebpageObject对象初始化一个WXMediaMessage对象，填写标题、描述
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = title;//网页标题
        msg.description = description;//网页描述
//        msg.setThumbImage(icon);
//        msg.thumbData = CommonUtils.compressByQuality(icon,'耀',true);
        msg.setThumbImage(icon);
        //构建一个Req
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = "supplier";
        req.message = msg;
        req.scene = requestCode;
        api.sendReq(req);

    }

    /**
     * 官方参考文档地址：http://wiki.open.qq.com/index.php?title=Android_API%E8%B0%83%E7%94%A8%E8%AF%B4%E6%98%8E&=45038#1.13_.E5.88.86.E4.BA.AB.E6.B6.88.E6.81.AF.E5.88.B0QQ.EF.BC.88.E6.97.A0.E9.9C.80QQ.E7.99.BB.E5.BD.95.EF.BC.89
     *
     * @param imgUrl      分享item的图片地址
     * @param shareType   1分享到QQ空间 2分享到QQ好友
     */
/*    public void shareToQQ(String imgUrl, int shareType) {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);//消息类型 图文用默认的
        params.putString(QQShare.SHARE_TO_QQ_TITLE, title);//标题
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, content);//描述信息
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, share_url);//这条分享消息被好友点击后的跳转URL。
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, imgUrl);//分享图片的URL或者本地路径
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, context.getString(R.string.app_name));
        params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, shareType);//分享额外选项，两种类型可选（默认是不隐藏分享到QZone按钮且不自动打开分享到QZone的对话框）：QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN，分享时自动打开分享到QZone的对话框。QQShare.SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE，分享时隐藏分享到QZone按钮
        mTencent.shareToQQ(context, params, baselistener);
    }*/





    /**
     * 获取分享的文本模板。
     */
/*
    private String getSharedText() {
        String text = content;
        return text;
    }
*/


    /*public void downloadBitMap(int code,String imageUrl){
        if (!imageUrl.startsWith("/upload") && !imageUrl.startsWith("http"))
        {
            try {
                FileInputStream stream = new FileInputStream(imageUrl);
                Bitmap bitmap = BitmapFactory.decodeStream(stream);
                sendToWeiXin(title,share_url,content,bitmap,0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else  {
            new Thread(() -> {
                URL imageurl = null;
                try {
                    imageurl = new URL(ApiConstants.getImageUrl(imageUrl));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    HttpURLConnection conn = (HttpURLConnection)imageurl.openConnection();
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    Bitmap thumbnail = CommonUtils.createBitmapThumbnail(bitmap, false);
                    Message message = new Message();
                    message.what = 0;
                    message.obj = thumbnail;
                    message.arg1 = code;
                    handler.sendMessage(message);
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }*/

/*    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    sendToWeiXin(title, share_url
                            , content, bitmap
                            , msg.arg1);
                    break;
            }
        }
    };*/

}

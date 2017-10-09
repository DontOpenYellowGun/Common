package com.kelin.mvvmlight.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;

import java.io.File;

/**
 * Created by qyf on 2016/8/15.
 */

public enum BitmapUtil {
    INSTANCE;

    /**
     * 裁剪圆形位图
     *
     * @param bitmap 位图
     * @return 圆形位图
     */
    public Bitmap toRound(Bitmap bitmap) {
        Bitmap output =
                Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
                        Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xff000000);
        canvas.drawOval(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    /**
     * Drawable to Bitmap
     */
    public Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }


    /**
     * 转化为圆型的drawable，供glide之placehodler加载使用
     */
    public BitmapDrawable getCircleRes(Context mContext, int resId) {
        return new BitmapDrawable(mContext.getResources(), toRound(BitmapFactory.decodeResource(mContext.getResources(), resId)));
    }

    /**
     * 转化为圆型的drawable，供glide之placehodler加载使用
     */
    public BitmapDrawable getCircleRes(Context mContext, Drawable drawable) {
        return new BitmapDrawable(mContext.getResources(), toRound(drawableToBitmap(drawable)));
    }


    /**
     * 检查扩展名，得到图片格式的文件
     *
     * @param file
     * @return
     */
    @SuppressLint("DefaultLocale")
    public static boolean checkIsImageFile(File file, String bid) {
        boolean isImageFile = false;
        String fName = file.getPath();
        boolean findwithBid = fName.contains(bid);
        if (!findwithBid) return isImageFile;
        // 获取扩展名
        String FileEnd = fName.substring(fName.lastIndexOf(".") + 1, fName.length()).toLowerCase();
        if (FileEnd.equals("jpg") || FileEnd.equals("png") || FileEnd.equals("gif")
                || FileEnd.equals("jpeg") || FileEnd.equals("bmp")) {
            isImageFile = true;
        } else {
            isImageFile = false;
        }
        return isImageFile;
    }

    /**
     * 检查扩展名，得到图片格式的文件
     *
     * @param file
     * @return
     */
    @SuppressLint("DefaultLocale")
    public static boolean checkIsVideoFile(File file, String bid) {
        String fName = file.getPath();
        boolean findwithBid = fName.contains(bid);
        if (!findwithBid) return false;
        return checkIsVideoFile(fName);
    }

    public static boolean checkIsVideoFile(String path) {
        boolean isImageFile = false;
        // 获取扩展名
        String FileEnd = path.substring(path.lastIndexOf(".") + 1, path.length()).toLowerCase();
        if (FileEnd.equals("mp4")) {
            isImageFile = true;
        } else {
            isImageFile = false;
        }
        return isImageFile;
    }

    public static Bitmap getVideoThumbnail(String videoPath) {///storage/emulated/0/wisdudu/EHome/YingShi/724463719_2017-08-18 11:28:48.mp4
//        MediaMetadataRetriever media =new MediaMetadataRetriever();
//        File file=new File(videoPath);
//        media.setDataSource(file.getAbsolutePath());
//        Bitmap bitmap = media.getFrameAtTime();
//        media.release();
        Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, MediaStore.Video.Thumbnails.MINI_KIND);
        bitmap = ThumbnailUtils.extractThumbnail(bitmap, 210, 210);
        return bitmap;
    }

}

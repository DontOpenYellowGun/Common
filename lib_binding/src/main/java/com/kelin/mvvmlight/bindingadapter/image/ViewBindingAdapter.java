package com.kelin.mvvmlight.bindingadapter.image;

//import android.databinding.adapters.ImageViewBindingAdapter

import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.kelin.mvvmlight.util.BitmapUtil;
import com.kelin.mvvmlight.util.GlideCircleTransform;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by kelin on 16-3-24.
 */
public final class ViewBindingAdapter {


    @BindingAdapter(value = {"url", "isVague"}, requireAll = false)
    public static void setCircleImageUrlWithsVagueHolders(final ImageView imageView, String url, boolean isVague) {
        if (isVague) {//高斯模糊
            Glide.with(imageView.getContext()).load(url)
                    .dontAnimate()
                    .bitmapTransform(new BlurTransformation(imageView.getContext(), 14, 3))
                    .into(imageView);
        } else {
            Glide.with(imageView.getContext()).load(url).into(imageView);
        }
    }

    @BindingAdapter(value = {"placeholderDrawable"})
    public static void setImageResourse(final ImageView imageView, @DrawableRes int drawable) {
        imageView.setImageResource(drawable);
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

    @BindingAdapter(value = {"url"})
    public static void setImageUrl(final ImageView imageView, String url) {
//        if (!TextUtils.isEmpty(url)) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
//        }
    }

    @BindingAdapter(value = {"urldoorBell"})
    public static void setImageDoorUrl(final ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter(value = {"urldoorBell", "placeholderDrawable"})
    public static void setImageDoorUrlWithHolders(final ImageView imageView, String url, Drawable placeholderDrawable) {
        Glide.with(imageView.getContext()).load(url).placeholder(placeholderDrawable).into(imageView);
    }

    @BindingAdapter(value = {"url", "placeholderDrawable"})
    public static void setImageUrlWithHolders(final ImageView imageView, String url, Drawable placeholderDrawable) {
        Glide.with(imageView.getContext()).load(url).placeholder(placeholderDrawable).into(imageView);
    }

    @BindingAdapter(value = {"cameraUrl"})
    public static void setImageUrlWithCameraHolders(final ImageView imageView, String cameraUrl) {
        if (cameraUrl.endsWith("mp4")) {
            imageView.setImageBitmap(BitmapUtil.getVideoThumbnail(cameraUrl));
        } else {
            Glide.with(imageView.getContext()).load(cameraUrl).into(imageView);
        }
    }

    @BindingAdapter(value = {"placeholderImageRes"})
    public static void setImageUrlWithHolders(final ImageView imageView, @DrawableRes int placeholderImageRes) {
        Glide.with(imageView.getContext()).load(placeholderImageRes).placeholder(placeholderImageRes).into(imageView);
    }

    @BindingAdapter(value = {"url", "placeholderImageRes"})
    public static void setImageUrlWithHolders(final ImageView imageView, String url, @DrawableRes int placeholderImageRes) {
        Glide.with(imageView.getContext()).load(url).placeholder(placeholderImageRes).into(imageView);
    }

    @BindingAdapter(value = {"url", "placeholderDrawable", "circle"})
    public static void setCircleImageUrlWithHolders(final ImageView imageView, String url, Drawable placeholderDrawable, boolean isCircle) {
        if (isCircle) {
            Glide.with(imageView.getContext()).load(url).bitmapTransform(new CropCircleTransformation(imageView.getContext()))
                    .placeholder(BitmapUtil.INSTANCE.getCircleRes(imageView.getContext(), placeholderDrawable))
                    .into(imageView);
//            Glide.with(imageView.getContext()).load(url).placeholder(android.R.drawable.ic_delete).into(imageView);
        } else {
            Glide.with(imageView.getContext()).load(url).placeholder(placeholderDrawable).into(imageView);
        }
    }

    @BindingAdapter(value = {"placeholderDrawable", "circle"})
    public static void setCircleImageUrlWithHolders(final ImageView imageView, Drawable placeholderDrawable, boolean isCircle) {
        if (isCircle) {
            Glide.with(imageView.getContext()).load(placeholderDrawable).bitmapTransform(new CropCircleTransformation(imageView.getContext()))
                    .placeholder(BitmapUtil.INSTANCE.getCircleRes(imageView.getContext(), placeholderDrawable))
                    .into(imageView);
        } else {
            Glide.with(imageView.getContext()).load(placeholderDrawable).placeholder(placeholderDrawable).into(imageView);
        }
    }

    @BindingAdapter(value = {"url", "placeholderImageRes", "circle"})
    public static void setCircleImageUrlWithHolders(final ImageView imageView, String url, @DrawableRes int placeholderImageRes, boolean isCircle) {
        if (isCircle) {
            Glide.with(imageView.getContext()).load(url).bitmapTransform(new CropCircleTransformation(imageView.getContext()))
                    .placeholder(BitmapUtil.INSTANCE.getCircleRes(imageView.getContext(), placeholderImageRes))
                    .into(imageView);
//            Glide.with(imageView.getContext()).load(url).placeholder(android.R.drawable.ic_delete).into(imageView);
        } else {
            Glide.with(imageView.getContext()).load(url).placeholder(placeholderImageRes).into(imageView);
        }
    }

    @BindingAdapter(value = {"random"})
    public static void setRandomColor(final ImageView imageView,boolean random) {
        int num = (int) (Math.random() * 16777216);
        String hex = Integer.toHexString(num);
        GradientDrawable drawable = (GradientDrawable) imageView.getBackground();
        drawable.setColor(Color.parseColor("#" + hex));
    }

    @BindingAdapter(value = {"progressDrawable"})
    public static void setprogressDrawable(final ProgressBar progressBar, int res) {
        Resources resources = progressBar.getContext().getResources();
        progressBar.setProgressDrawable(resources.getDrawable(res));
    }

    @BindingAdapter(value = {"url", "placeholderDrawable", "circle", "frameWidth", "frameColor"})
    public static void setCircleImageUrlWithHolders(final ImageView imageView, String url, Drawable placeholderDrawable, boolean isCircle, int frameWidth, int frameColor) {
        if (isCircle) {
            Glide.with(imageView.getContext()).load(url)
                    .dontAnimate()
                    .transform(new GlideCircleTransform(imageView.getContext(), frameWidth, frameColor))
                    .placeholder(BitmapUtil.INSTANCE.getCircleRes(imageView.getContext(), placeholderDrawable))
                    .into(imageView);
        } else {
            Glide.with(imageView.getContext()).load(url).placeholder(placeholderDrawable).into(imageView);
        }
    }

    @BindingAdapter(value = {"backgroundDrawable"})
    public static void setCircleImageUrlWithHolders(final ImageView imageView, int resId) {
        imageView.setBackgroundResource(resId);
    }
}


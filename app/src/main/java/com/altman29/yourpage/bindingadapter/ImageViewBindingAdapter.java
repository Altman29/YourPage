package com.altman29.yourpage.bindingadapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.altman29.yourpage.R;
import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;

/**
 * Created by Csy on 1/25/21.
 * e-mail:altman29@foxmail.com
 * Desc:
 */
public class ImageViewBindingAdapter {
    @BindingAdapter(value = {"image","defaultImageResource"},requireAll = false)
    public  static  void  setImage(ImageView image, String imageUrl, int imageResource){
        if(!TextUtils.isEmpty(imageUrl)){
            Glide.with(image.getContext())
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(image);
        }else{
            image.setImageResource(imageResource);
        }
    }
}

package com.kelin.mvvmlight.bindingadapter.webview;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by kelin on 16-4-29.
 */
public class ViewBindingAdapter {
    @BindingAdapter({"render"})
    public static void loadHtml(WebView webView, final String html) {
        if (!TextUtils.isEmpty(html)) {
//            webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
            webView.loadUrl(html);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
        }
    }
}

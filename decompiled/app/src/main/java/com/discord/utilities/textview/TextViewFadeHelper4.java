package com.discord.utilities.textview;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;

/* compiled from: TextViewFadeHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b¸\u0006\u0000"}, d2 = {"com/discord/utilities/textview/TextViewFadeHelper$registerFadeHelper$1$1", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.textview.TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class TextViewFadeHelper4 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View.OnLayoutChangeListener $layoutListener;
    public final /* synthetic */ TextViewFadeHelper3 $textChangedListener;
    public final /* synthetic */ TextView $this_apply;

    public TextViewFadeHelper4(TextView textView, View.OnLayoutChangeListener onLayoutChangeListener, TextViewFadeHelper3 textViewFadeHelper3) {
        this.$this_apply = textView;
        this.$layoutListener = onLayoutChangeListener;
        this.$textChangedListener = textViewFadeHelper3;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        this.$this_apply.addOnLayoutChangeListener(this.$layoutListener);
        this.$this_apply.addTextChangedListener(this.$textChangedListener);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        this.$this_apply.removeOnLayoutChangeListener(this.$layoutListener);
        this.$this_apply.removeTextChangedListener(this.$textChangedListener);
    }
}

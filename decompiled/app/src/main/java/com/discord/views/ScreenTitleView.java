package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.ViewScreenTitleBinding;
import com.discord.R;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ScreenTitleView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/discord/views/ScreenTitleView;", "Landroid/widget/LinearLayout;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "subtitle", "setSubtitle", "Lb/a/i/e3;", "j", "Lb/a/i/e3;", "binding", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ScreenTitleView extends LinearLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewScreenTitleBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_screen_title, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.screen_title_subtitle;
        TextView textView = (TextView) viewInflate.findViewById(R.id.screen_title_subtitle);
        if (textView != null) {
            i = R.id.screen_title_title;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.screen_title_title);
            if (textView2 != null) {
                ViewScreenTitleBinding viewScreenTitleBinding = new ViewScreenTitleBinding((LinearLayout) viewInflate, textView, textView2);
                Intrinsics3.checkNotNullExpressionValue(viewScreenTitleBinding, "ViewScreenTitleBinding.i…rom(context), this, true)");
                this.binding = viewScreenTitleBinding;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.ScreenTitleView, 0, 0);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.ScreenTitleView, 0, 0)");
                    CharSequence text = typedArrayObtainStyledAttributes.getText(1);
                    CharSequence text2 = typedArrayObtainStyledAttributes.getText(0);
                    typedArrayObtainStyledAttributes.recycle();
                    if (text != null) {
                        setTitle(text);
                    }
                    setSubtitle(text2);
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setSubtitle(CharSequence subtitle) {
        TextView textView = this.binding.f105b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.screenTitleSubtitle");
        ViewExtensions.setTextAndVisibilityBy(textView, subtitle);
    }

    public final void setTitle(CharSequence title) {
        Intrinsics3.checkNotNullParameter(title, "title");
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.screenTitleTitle");
        textView.setText(title);
    }
}

package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewChatUploadBinding;
import com.discord.R;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: FailedUploadView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/discord/views/FailedUploadView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "title", "", "iconResId", "", "subtitle", "", "a", "(Ljava/lang/CharSequence;ILjava/lang/String;)V", "Lb/a/i/c2;", "j", "Lb/a/i/c2;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class FailedUploadView extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewChatUploadBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FailedUploadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_chat_upload, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.display_name;
        TextView textView = (TextView) viewInflate.findViewById(R.id.display_name);
        if (textView != null) {
            i = R.id.failed_alert_icon;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.failed_alert_icon);
            if (imageView != null) {
                i = R.id.file_image;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.file_image);
                if (imageView2 != null) {
                    i = R.id.subtitle_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.subtitle_text);
                    if (textView2 != null) {
                        ViewChatUploadBinding viewChatUploadBinding = new ViewChatUploadBinding((ConstraintLayout) viewInflate, textView, imageView, imageView2, textView2);
                        Intrinsics3.checkNotNullExpressionValue(viewChatUploadBinding, "ViewChatUploadBinding.in…rom(context), this, true)");
                        this.binding = viewChatUploadBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void a(CharSequence title, @DrawableRes int iconResId, String subtitle) {
        Intrinsics3.checkNotNullParameter(title, "title");
        TextView textView = this.binding.f91b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.displayName");
        textView.setText(title);
        TextView textView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.subtitleText");
        ViewExtensions.setTextAndVisibilityBy(textView2, subtitle);
        this.binding.c.setImageResource(iconResId);
    }
}

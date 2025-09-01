package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import b.a.i.IconRowBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: IconRow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/discord/views/IconRow;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "setText", "(Ljava/lang/String;)V", "", "imageRes", "setImageRes", "(Ljava/lang/Integer;)V", "Lb/a/i/a0;", "j", "Lb/a/i/a0;", "binding", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class IconRow extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final IconRowBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.icon_row, this);
        int i = R.id.divider;
        View viewFindViewById = findViewById(R.id.divider);
        if (viewFindViewById != null) {
            i = R.id.image;
            ImageView imageView = (ImageView) findViewById(R.id.image);
            if (imageView != null) {
                i = R.id.text;
                TextView textView = (TextView) findViewById(R.id.text);
                if (textView != null) {
                    IconRowBinding iconRowBinding = new IconRowBinding(this, viewFindViewById, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(iconRowBinding, "IconRowBinding.inflate(L…ater.from(context), this)");
                    this.binding = iconRowBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setImageRes(@DrawableRes Integer imageRes) {
        if (imageRes != null) {
            this.binding.f73b.setImageResource(imageRes.intValue());
        }
        ImageView imageView = this.binding.f73b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.image");
        imageView.setVisibility(imageRes == null || imageRes.intValue() != 0 ? 0 : 8);
    }

    public final void setText(String text) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.text");
        FormatUtils.a(textView, text);
    }
}

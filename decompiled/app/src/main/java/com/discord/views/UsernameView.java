package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import b.a.i.ViewUsernameBinding;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.user.profile.DraweeSpanStringBuilderExtensions;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: UsernameView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JC\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\b\b\u0001\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/discord/views/UsernameView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "isVerified", "", "setIsVerified", "(Z)V", "", "usernameText", "", "avatarUrl", "animateAvatar", "", "avatarSizePx", "roundingOverlayColor", "b", "(Ljava/lang/CharSequence;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;)V", ModelAuditLogEntry.CHANGE_KEY_COLOR, "setUsernameColor", "(I)V", "visible", "tagText", "a", "(ZIZ)V", "Lb/a/i/g4;", "j", "Lb/a/i/g4;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class UsernameView extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewUsernameBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UsernameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_username, this);
        int i = R.id.username_tag;
        TextView textView = (TextView) findViewById(R.id.username_tag);
        if (textView != null) {
            i = R.id.username_text;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R.id.username_text);
            if (simpleDraweeSpanTextView != null) {
                ViewUsernameBinding viewUsernameBinding = new ViewUsernameBinding(this, textView, simpleDraweeSpanTextView);
                Intrinsics3.checkNotNullExpressionValue(viewUsernameBinding, "ViewUsernameBinding.infl…ater.from(context), this)");
                this.binding = viewUsernameBinding;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.UsernameView, 0, 0);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…eable.UsernameView, 0, 0)");
                    try {
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.usernameText");
                        simpleDraweeSpanTextView.setText(typedArrayObtainStyledAttributes.getText(1));
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.usernameText");
                        simpleDraweeSpanTextView.setSingleLine(typedArrayObtainStyledAttributes.getBoolean(3, true));
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(4, 0);
                        if (resourceId != 0) {
                            TextViewCompat.setTextAppearance(simpleDraweeSpanTextView, resourceId);
                        }
                        simpleDraweeSpanTextView.setTextSize(0, getResources().getDimension(typedArrayObtainStyledAttributes.getResourceId(6, R.dimen.uikit_textsize_medium)));
                        Intrinsics3.checkNotNullExpressionValue(textView, "binding.usernameTag");
                        textView.setText(typedArrayObtainStyledAttributes.getText(0));
                        float f = typedArrayObtainStyledAttributes.getFloat(2, 0.0f);
                        if (f > 0) {
                            simpleDraweeSpanTextView.setLineSpacing(0.0f, f);
                        }
                        setUsernameColor(typedArrayObtainStyledAttributes.getColor(5, R.attr.colorInteractiveActive));
                        return;
                    } finally {
                        typedArrayObtainStyledAttributes.recycle();
                    }
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public static /* synthetic */ void c(UsernameView usernameView, CharSequence charSequence, String str, boolean z2, Integer num, Integer num2, int i) {
        int i2 = i & 2;
        int i3 = i & 8;
        int i4 = i & 16;
        usernameView.b(charSequence, null, (i & 4) != 0 ? false : z2, null, null);
    }

    private final void setIsVerified(boolean isVerified) {
        this.binding.f120b.setCompoundDrawablesWithIntrinsicBounds(isVerified ? R.drawable.ic_verified_10dp : 0, 0, 0, 0);
    }

    public final void a(boolean visible, @StringRes int tagText, boolean isVerified) {
        if (!visible) {
            TextView textView = this.binding.f120b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.usernameTag");
            textView.setVisibility(8);
        } else {
            TextView textView2 = this.binding.f120b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.usernameTag");
            textView2.setVisibility(0);
            this.binding.f120b.setText(tagText);
            setIsVerified(isVerified);
        }
    }

    public final void b(CharSequence usernameText, String avatarUrl, boolean animateAvatar, Integer avatarSizePx, @ColorInt Integer roundingOverlayColor) {
        Intrinsics3.checkNotNullParameter(usernameText, "usernameText");
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        DraweeSpanStringBuilder avatar$default = DraweeSpanStringBuilderExtensions.setAvatar$default(draweeSpanStringBuilder, context, avatarUrl, animateAvatar, avatarSizePx, roundingOverlayColor, null, 32, null);
        avatar$default.append(usernameText);
        this.binding.c.setDraweeSpanStringBuilder(avatar$default);
    }

    public final void setUsernameColor(@ColorInt int color) {
        this.binding.c.setTextColor(color);
    }
}

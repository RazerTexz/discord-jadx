package com.discord.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import b.a.i.ViewToolbarTitleBinding;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ToolbarTitleLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0003\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/discord/views/ToolbarTitleLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "title", "", "leftDrawableRes", "trailingDrawableRes", "", "a", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Ljava/lang/Integer;)V", ModelAuditLogEntry.CHANGE_KEY_COLOR, "setTitleColor", "(I)V", "subtitle", "setSubtitle", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "Lb/a/i/b4;", "k", "Lb/a/i/b4;", "binding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ToolbarTitleLayout extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewToolbarTitleBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolbarTitleLayout(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_toolbar_title, this);
        int i = R.id.toolbar_icon;
        ImageView imageView = (ImageView) findViewById(R.id.toolbar_icon);
        if (imageView != null) {
            i = R.id.toolbar_presence;
            StatusView statusView = (StatusView) findViewById(R.id.toolbar_presence);
            if (statusView != null) {
                i = R.id.toolbar_title;
                TextView textView = (TextView) findViewById(R.id.toolbar_title);
                if (textView != null) {
                    i = R.id.toolbar_title_subtext;
                    TextView textView2 = (TextView) findViewById(R.id.toolbar_title_subtext);
                    if (textView2 != null) {
                        i = R.id.toolbar_title_trailing_icon;
                        ImageView imageView2 = (ImageView) findViewById(R.id.toolbar_title_trailing_icon);
                        if (imageView2 != null) {
                            ViewToolbarTitleBinding viewToolbarTitleBinding = new ViewToolbarTitleBinding(this, imageView, statusView, textView, textView2, imageView2);
                            Intrinsics3.checkNotNullExpressionValue(viewToolbarTitleBinding, "ViewToolbarTitleBinding.…ater.from(context), this)");
                            this.binding = viewToolbarTitleBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(CharSequence title, @DrawableRes Integer leftDrawableRes, @DrawableRes Integer trailingDrawableRes) {
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.toolbarTitle");
        textView.setText(title);
        if (leftDrawableRes != null) {
            ImageView imageView = this.binding.f85b;
            Resources resources = getResources();
            int iIntValue = leftDrawableRes.intValue();
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, iIntValue, context.getTheme()));
            ImageView imageView2 = this.binding.f85b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.toolbarIcon");
            imageView2.setVisibility(0);
        } else {
            ImageView imageView3 = this.binding.f85b;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.toolbarIcon");
            imageView3.setVisibility(8);
        }
        if (trailingDrawableRes == null) {
            ImageView imageView4 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.toolbarTitleTrailingIcon");
            imageView4.setVisibility(8);
            return;
        }
        ImageView imageView5 = this.binding.f;
        Resources resources2 = getResources();
        int iIntValue2 = trailingDrawableRes.intValue();
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        imageView5.setImageDrawable(ResourcesCompat.getDrawable(resources2, iIntValue2, context2.getTheme()));
        ImageView imageView6 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView6, "binding.toolbarTitleTrailingIcon");
        imageView6.setVisibility(0);
    }

    public final TextView getTitle() {
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.toolbarTitle");
        return textView;
    }

    public final void setSubtitle(CharSequence subtitle) {
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.toolbarTitleSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView, subtitle);
    }

    public final void setTitleColor(@ColorInt int color) {
        this.binding.d.setTextColor(color);
    }
}

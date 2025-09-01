package com.discord.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import b.a.i.ViewUploadProgressBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: UploadProgressView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/discord/views/UploadProgressView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "title", "", "progress", "", "subtitle", "", "a", "(Ljava/lang/CharSequence;ILjava/lang/String;)V", "drawableResId", "setIcon", "(I)V", "Lb/a/i/c4;", "k", "Lb/a/i/c4;", "binding", "Landroid/graphics/drawable/Drawable;", "l", "Landroid/graphics/drawable/Drawable;", "drawableComplete", "m", "drawableInProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class UploadProgressView extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewUploadProgressBinding binding;

    /* renamed from: l, reason: from kotlin metadata */
    public final Drawable drawableComplete;

    /* renamed from: m, reason: from kotlin metadata */
    public final Drawable drawableInProgress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_upload_progress, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.progress_bar;
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R.id.progress_bar);
        if (progressBar != null) {
            i = R.id.progress_file_image;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.progress_file_image);
            if (imageView != null) {
                i = R.id.progress_subtext;
                TextView textView = (TextView) viewInflate.findViewById(R.id.progress_subtext);
                if (textView != null) {
                    i = R.id.progress_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.progress_text);
                    if (textView2 != null) {
                        ViewUploadProgressBinding viewUploadProgressBinding = new ViewUploadProgressBinding((ConstraintLayout) viewInflate, progressBar, imageView, textView, textView2);
                        Intrinsics3.checkNotNullExpressionValue(viewUploadProgressBinding, "ViewUploadProgressBindin…rom(context), this, true)");
                        this.binding = viewUploadProgressBinding;
                        this.drawableComplete = ContextCompat.getDrawable(getContext(), R.drawable.drawable_progress_green);
                        this.drawableInProgress = ContextCompat.getDrawable(getContext(), DrawableCompat.getThemedDrawableRes$default(this, R.attr.progress_gradient, 0, 2, (Object) null));
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void a(CharSequence title, int progress, String subtitle) {
        Intrinsics3.checkNotNullParameter(title, "title");
        ViewUploadProgressBinding viewUploadProgressBinding = this.binding;
        TextView textView = viewUploadProgressBinding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "progressText");
        textView.setText(title);
        if (progress >= 0) {
            ProgressBar progressBar = viewUploadProgressBinding.f93b;
            Intrinsics3.checkNotNullExpressionValue(progressBar, "progressBar");
            progressBar.setIndeterminate(false);
            if (Build.VERSION.SDK_INT >= 24) {
                ProgressBar progressBar2 = viewUploadProgressBinding.f93b;
                Intrinsics3.checkNotNullExpressionValue(progressBar2, "progressBar");
                viewUploadProgressBinding.f93b.setProgress(progress, progress >= progressBar2.getProgress());
            } else {
                ProgressBar progressBar3 = viewUploadProgressBinding.f93b;
                Intrinsics3.checkNotNullExpressionValue(progressBar3, "progressBar");
                progressBar3.setProgress(progress);
            }
            ProgressBar progressBar4 = viewUploadProgressBinding.f93b;
            Intrinsics3.checkNotNullExpressionValue(progressBar4, "progressBar");
            progressBar4.setProgressDrawable(progress == 100 ? this.drawableComplete : this.drawableInProgress);
            ProgressBar progressBar5 = viewUploadProgressBinding.f93b;
            Intrinsics3.checkNotNullExpressionValue(progressBar5, "progressBar");
            progressBar5.setVisibility(0);
        } else if (progress == -1) {
            ProgressBar progressBar6 = viewUploadProgressBinding.f93b;
            Intrinsics3.checkNotNullExpressionValue(progressBar6, "progressBar");
            progressBar6.setVisibility(0);
            ProgressBar progressBar7 = viewUploadProgressBinding.f93b;
            Intrinsics3.checkNotNullExpressionValue(progressBar7, "progressBar");
            progressBar7.setIndeterminate(true);
        } else {
            if (progress != -2) {
                throw new IllegalArgumentException(outline.q("invalid argument supplied to progress: ", progress));
            }
            ProgressBar progressBar8 = viewUploadProgressBinding.f93b;
            Intrinsics3.checkNotNullExpressionValue(progressBar8, "progressBar");
            progressBar8.setVisibility(4);
        }
        TextView textView2 = viewUploadProgressBinding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "progressSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView2, subtitle);
    }

    public final void setIcon(@DrawableRes int drawableResId) {
        this.binding.c.setImageResource(drawableResId);
    }
}

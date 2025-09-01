package com.discord.tooltips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import b.a.i.SparkleViewBinding;
import b.a.v.SparkleView2;
import b.a.v.SparkleView3;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;

/* compiled from: SparkleView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001f\u0010\u000e\u001a\u0004\u0018\u00010\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/discord/tooltips/SparkleView;", "Landroid/widget/FrameLayout;", "", "b", "()V", "", "k", "I", "sparkleAnimationResId", "Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "l", "Lkotlin/Lazy;", "getSparkleDrawable", "()Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "sparkleDrawable", "Lb/a/i/q1;", "j", "Lb/a/i/q1;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SparkleView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final SparkleViewBinding binding;

    /* renamed from: k, reason: from kotlin metadata */
    public int sparkleAnimationResId;

    /* renamed from: l, reason: from kotlin metadata */
    public final Lazy sparkleDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SparkleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(com.discord.R.layout.sparkle_view, this);
        ImageView imageView = (ImageView) findViewById(com.discord.R.id.sparkle_view_image);
        if (imageView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(com.discord.R.id.sparkle_view_image)));
        }
        SparkleViewBinding sparkleViewBinding = new SparkleViewBinding(this, imageView);
        Intrinsics3.checkNotNullExpressionValue(sparkleViewBinding, "SparkleViewBinding.infla…ater.from(context), this)");
        this.binding = sparkleViewBinding;
        this.sparkleAnimationResId = com.discord.R.drawable.sparkle_animated_vector;
        this.sparkleDrawable = LazyJVM.lazy(new SparkleView2(this));
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        imageView.setImageDrawable(getSparkleDrawable());
        AnimatedVectorDrawableCompat sparkleDrawable = getSparkleDrawable();
        if (sparkleDrawable != null) {
            sparkleDrawable.registerAnimationCallback(new SparkleView3(this));
        }
        AnimatedVectorDrawableCompat sparkleDrawable2 = getSparkleDrawable();
        if (sparkleDrawable2 != null) {
            sparkleDrawable2.start();
        }
    }

    public static final /* synthetic */ AnimatedVectorDrawableCompat a(SparkleView sparkleView) {
        return sparkleView.getSparkleDrawable();
    }

    private final AnimatedVectorDrawableCompat getSparkleDrawable() {
        return (AnimatedVectorDrawableCompat) this.sparkleDrawable.getValue();
    }

    public final void b() {
        AnimatedVectorDrawableCompat sparkleDrawable = getSparkleDrawable();
        if (sparkleDrawable != null) {
            sparkleDrawable.stop();
        }
    }
}

package com.discord.rlottie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import com.discord.rlottie.RLottieDrawable;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* compiled from: RLottieImageView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010#\u001a\u00020\u0015\u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\nJ\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0015H\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001b¨\u0006("}, d2 = {"Lcom/discord/rlottie/RLottieImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "resId", "w", "h", "", "c", "(III)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Lcom/discord/rlottie/RLottieDrawable$PlaybackMode;", "playbackMode", "setPlaybackMode", "(Lcom/discord/rlottie/RLottieDrawable$PlaybackMode;)V", "", "progress", "setProgress", "(F)V", "b", "Landroid/content/Context;", "Landroid/view/Display;", "a", "(Landroid/content/Context;)Landroid/view/Display;", "", "l", "Z", "playing", "Lcom/discord/rlottie/RLottieDrawable;", "j", "Lcom/discord/rlottie/RLottieDrawable;", "drawable", "k", "attachedToWindow", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "rlottie_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public class RLottieImageView extends AppCompatImageView {

    /* renamed from: j, reason: from kotlin metadata */
    public RLottieDrawable drawable;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean attachedToWindow;

    /* renamed from: l, reason: from kotlin metadata */
    public boolean playing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RLottieImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkParameterIsNotNull(context, "context");
        RLottieDrawable.PlaybackMode playbackMode = RLottieDrawable.PlaybackMode.FREEZE;
    }

    @SuppressLint({"AnnotateVersionCheck"})
    public final Display a(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            Display display = context.getDisplay();
            if (display == null) {
                Intrinsics3.throwNpe();
            }
            Intrinsics3.checkExpressionValueIsNotNull(display, "display!!");
            return display;
        }
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics3.checkExpressionValueIsNotNull(defaultDisplay, "(getSystemService(Contex…owManager).defaultDisplay");
        return defaultDisplay;
    }

    public final void b() {
        RLottieDrawable rLottieDrawable = this.drawable;
        if (rLottieDrawable == null) {
            return;
        }
        this.playing = true;
        if (!this.attachedToWindow || rLottieDrawable == null) {
            return;
        }
        rLottieDrawable.start();
    }

    public final void c(int resId, int w, int h) {
        RLottieDrawable.PlaybackMode playbackMode = RLottieDrawable.PlaybackMode.LOOP;
        Intrinsics3.checkParameterIsNotNull(playbackMode, "playbackMode");
        Context context = getContext();
        Intrinsics3.checkExpressionValueIsNotNull(context, "context");
        String strValueOf = String.valueOf(resId);
        Context context2 = getContext();
        Intrinsics3.checkExpressionValueIsNotNull(context2, "context");
        RLottieDrawable rLottieDrawable = new RLottieDrawable(context, resId, strValueOf, w, h, a(context2).getRefreshRate(), false, (int[]) null);
        this.drawable = rLottieDrawable;
        rLottieDrawable.f(playbackMode);
        RLottieDrawable rLottieDrawable2 = this.drawable;
        if (rLottieDrawable2 != null) {
            rLottieDrawable2.e(true);
        }
        setImageDrawable(this.drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        RLottieDrawable rLottieDrawable;
        super.onAttachedToWindow();
        this.attachedToWindow = true;
        if (!this.playing || (rLottieDrawable = this.drawable) == null) {
            return;
        }
        rLottieDrawable.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
        RLottieDrawable rLottieDrawable = this.drawable;
        if (rLottieDrawable != null) {
            rLottieDrawable.P = false;
        }
    }

    public final void setPlaybackMode(RLottieDrawable.PlaybackMode playbackMode) {
        Intrinsics3.checkParameterIsNotNull(playbackMode, "playbackMode");
        RLottieDrawable rLottieDrawable = this.drawable;
        if (rLottieDrawable != null) {
            rLottieDrawable.f(playbackMode);
        }
    }

    public final void setProgress(float progress) {
        RLottieDrawable rLottieDrawable = this.drawable;
        if (rLottieDrawable != null) {
            if (progress < 0.0f) {
                progress = 0.0f;
            } else if (progress > 1.0f) {
                progress = 1.0f;
            }
            rLottieDrawable.I = (int) (rLottieDrawable.r[0] * progress);
            rLottieDrawable.f2769z = false;
            rLottieDrawable.G = false;
            if (!rLottieDrawable.d()) {
                rLottieDrawable.H = true;
            }
            rLottieDrawable.invalidateSelf();
        }
    }
}

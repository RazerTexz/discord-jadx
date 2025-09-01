package com.discord.widgets.chat.input;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SmoothKeyboardReactionHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/input/SmoothKeyboardReactionHelper;", "", "Landroid/view/View;", "view", "", "install", "(Landroid/view/View;)V", "<init>", "()V", "Callback", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
@TargetApi(30)
/* loaded from: classes2.dex */
public final class SmoothKeyboardReactionHelper {
    public static final SmoothKeyboardReactionHelper INSTANCE = new SmoothKeyboardReactionHelper();

    /* compiled from: SmoothKeyboardReactionHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/chat/input/SmoothKeyboardReactionHelper$Callback;", "Landroid/view/WindowInsetsAnimation$Callback;", "Landroid/view/WindowInsetsAnimation;", "animation", "Landroid/view/WindowInsetsAnimation$Bounds;", "bounds", "onStart", "(Landroid/view/WindowInsetsAnimation;Landroid/view/WindowInsetsAnimation$Bounds;)Landroid/view/WindowInsetsAnimation$Bounds;", "Landroid/view/WindowInsets;", "insets", "", "runningAnimations", "onProgress", "(Landroid/view/WindowInsets;Ljava/util/List;)Landroid/view/WindowInsets;", "Landroid/view/View;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Callback extends WindowInsetsAnimation.Callback {
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Callback(View view) {
            super(0);
            Intrinsics3.checkNotNullParameter(view, "view");
            this.view = view;
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public WindowInsets onProgress(WindowInsets insets, List<WindowInsetsAnimation> runningAnimations) {
            Intrinsics3.checkNotNullParameter(insets, "insets");
            Intrinsics3.checkNotNullParameter(runningAnimations, "runningAnimations");
            return insets;
        }

        @Override // android.view.WindowInsetsAnimation.Callback
        public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation animation, WindowInsetsAnimation.Bounds bounds) {
            Intrinsics3.checkNotNullParameter(animation, "animation");
            Intrinsics3.checkNotNullParameter(bounds, "bounds");
            if (this.view.getRootWindowInsets().isVisible(WindowInsets.Type.ime())) {
                this.view.setTranslationY(bounds.getUpperBound().bottom);
            } else {
                this.view.setTranslationY(-bounds.getUpperBound().bottom);
            }
            this.view.animate().setDuration(animation.getDurationMillis()).setInterpolator(animation.getInterpolator()).translationY(0.0f);
            WindowInsetsAnimation.Bounds boundsOnStart = super.onStart(animation, bounds);
            Intrinsics3.checkNotNullExpressionValue(boundsOnStart, "super.onStart(animation, bounds)");
            return boundsOnStart;
        }
    }

    private SmoothKeyboardReactionHelper() {
    }

    public final void install(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        if (Build.VERSION.SDK_INT >= 30) {
            view.setWindowInsetsAnimationCallback(new Callback(view));
        }
    }
}

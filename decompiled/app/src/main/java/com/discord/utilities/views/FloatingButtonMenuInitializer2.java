package com.discord.utilities.views;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.res.Resources;
import android.view.View;
import com.discord.utilities.views.FloatingButtonMenuInitializer;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: FloatingButtonMenuInitializer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/utilities/views/FloatingButtonMenuInitializer$animatorFactoryFadeIn$1", "Lcom/discord/utilities/views/FloatingButtonMenuInitializer$AnimatorFactory;", "Landroid/view/View;", "view", "Landroid/animation/Animator;", "createAnimator", "(Landroid/view/View;)Landroid/animation/Animator;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.views.FloatingButtonMenuInitializer$animatorFactoryFadeIn$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer2 implements FloatingButtonMenuInitializer.AnimatorFactory<View> {
    public final /* synthetic */ FloatingButtonMenuInitializer this$0;

    public FloatingButtonMenuInitializer2(FloatingButtonMenuInitializer floatingButtonMenuInitializer) {
        this.this$0 = floatingButtonMenuInitializer;
    }

    @Override // com.discord.utilities.views.FloatingButtonMenuInitializer.AnimatorFactory
    public Animator createAnimator(View view) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(view, "view");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(FloatingButtonMenuInitializer.access$getContext$p(this.this$0), R.animator.fade_in);
        animatorLoadAnimator.setTarget(view);
        return animatorLoadAnimator;
    }
}

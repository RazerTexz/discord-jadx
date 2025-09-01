package com.discord.utilities.view.extensions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ViewExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeIn$viewPropertyAnimator$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewExtensions4 implements Runnable {
    public final /* synthetic */ Function0 $onAnimationEnd;

    public ViewExtensions4(Function0 function0) {
        this.$onAnimationEnd = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$onAnimationEnd.invoke();
    }
}

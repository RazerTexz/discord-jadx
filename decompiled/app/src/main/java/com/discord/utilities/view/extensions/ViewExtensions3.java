package com.discord.utilities.view.extensions;

import android.view.ViewPropertyAnimator;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ViewExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/view/extensions/FadeAnimation;", "", "Landroid/view/ViewPropertyAnimator;", "viewPropertyAnimator", "Landroid/view/ViewPropertyAnimator;", "getViewPropertyAnimator", "()Landroid/view/ViewPropertyAnimator;", "Lcom/discord/utilities/view/extensions/FadeAnimation$Type;", "type", "Lcom/discord/utilities/view/extensions/FadeAnimation$Type;", "getType", "()Lcom/discord/utilities/view/extensions/FadeAnimation$Type;", "<init>", "(Landroid/view/ViewPropertyAnimator;Lcom/discord/utilities/view/extensions/FadeAnimation$Type;)V", "Type", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.extensions.FadeAnimation, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewExtensions3 {
    private final Type type;
    private final ViewPropertyAnimator viewPropertyAnimator;

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/utilities/view/extensions/FadeAnimation$Type;", "", "<init>", "(Ljava/lang/String;I)V", "FADE_IN", "FADE_OUT", "utils_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.FadeAnimation$Type */
    public enum Type {
        FADE_IN,
        FADE_OUT
    }

    public ViewExtensions3(ViewPropertyAnimator viewPropertyAnimator, Type type) {
        Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "viewPropertyAnimator");
        Intrinsics3.checkNotNullParameter(type, "type");
        this.viewPropertyAnimator = viewPropertyAnimator;
        this.type = type;
    }

    public final Type getType() {
        return this.type;
    }

    public final ViewPropertyAnimator getViewPropertyAnimator() {
        return this.viewPropertyAnimator;
    }
}

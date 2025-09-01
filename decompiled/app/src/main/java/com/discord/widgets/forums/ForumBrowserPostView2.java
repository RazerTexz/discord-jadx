package com.discord.widgets.forums;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.discord.R;
import com.discord.utilities.drawable.DrawableCompat;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ForumBrowserPostView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/graphics/drawable/Drawable;", "invoke", "()Landroid/graphics/drawable/Drawable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.ForumBrowserPostView$cardPressHighlight$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ForumBrowserPostView2 extends Lambda implements Function0<Drawable> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBrowserPostView2(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Drawable invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Drawable invoke() {
        Context context = this.$context;
        return ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes$default(context, R.attr.bg_pressed_highlight, 0, 2, (Object) null));
    }
}

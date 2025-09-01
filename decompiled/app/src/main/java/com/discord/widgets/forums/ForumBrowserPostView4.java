package com.discord.widgets.forums;

import android.content.Context;
import android.content.res.ColorStateList;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ForumBrowserPostView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/content/res/ColorStateList;", "invoke", "()Landroid/content/res/ColorStateList;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.ForumBrowserPostView$reactionMeTextColor$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ForumBrowserPostView4 extends Lambda implements Function0<ColorStateList> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBrowserPostView4(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ColorStateList invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ColorStateList invoke() {
        return ColorStateList.valueOf(ColorCompat.getThemedColor(this.$context, R.attr.colorHeaderPrimary));
    }
}

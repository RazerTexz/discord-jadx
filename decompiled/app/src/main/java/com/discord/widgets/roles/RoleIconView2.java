package com.discord.widgets.roles;

import android.annotation.SuppressLint;
import android.content.Context;
import com.discord.utilities.textprocessing.node.EmojiNode;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: RoleIconView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0007\u001a\u00020\u00068\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/widgets/roles/RoleIconView$showRoleIconToast$renderContext$1", "Lcom/discord/utilities/textprocessing/node/EmojiNode$RenderContext;", "", "isAnimationEnabled", "Z", "()Z", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.roles.RoleIconView$showRoleIconToast$renderContext$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RoleIconView2 implements EmojiNode.RenderContext {
    public final /* synthetic */ Context $context;

    @SuppressLint({"StaticFieldLeak"})
    private final Context context;
    private final boolean isAnimationEnabled;

    public RoleIconView2(Context context) {
        this.$context = context;
        this.context = context;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    /* renamed from: isAnimationEnabled, reason: from getter */
    public boolean getIsAnimationEnabled() {
        return this.isAnimationEnabled;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    public void onEmojiClicked(EmojiNode.EmojiIdAndType emojiIdAndType) {
        Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
    }
}

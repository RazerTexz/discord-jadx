package com.discord.widgets.emoji;

import android.view.View;
import com.discord.models.guild.Guild;
import kotlin.Metadata;

/* compiled from: WidgetEmojiSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/emoji/WidgetEmojiSheet$configureButtons$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.emoji.WidgetEmojiSheet$configureButtons$$inlined$with$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetEmojiSheet3 implements View.OnClickListener {
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ boolean $isUserInGuild$inlined;
    public final /* synthetic */ boolean $isUserPremium$inlined;
    public final /* synthetic */ WidgetEmojiSheet this$0;

    public WidgetEmojiSheet3(WidgetEmojiSheet widgetEmojiSheet, Guild guild, boolean z2, boolean z3) {
        this.this$0 = widgetEmojiSheet;
        this.$guild$inlined = guild;
        this.$isUserPremium$inlined = z2;
        this.$isUserInGuild$inlined = z3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetEmojiSheet.access$getViewModel$p(this.this$0).joinGuild(this.$guild$inlined, this.this$0);
    }
}

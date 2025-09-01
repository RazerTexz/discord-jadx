package com.discord.widgets.stickers;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.models.guild.Guild;
import com.discord.utilities.analytics.Traits;
import com.discord.widgets.stickers.StickerPremiumUpsellDialog;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetGuildStickerSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/stickers/WidgetGuildStickerSheet$configureButtons$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stickers.WidgetGuildStickerSheet$configureButtons$$inlined$with$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGuildStickerSheet2 implements View.OnClickListener {
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ boolean $isUserInGuild$inlined;
    public final /* synthetic */ boolean $isUserPremium$inlined;
    public final /* synthetic */ WidgetGuildStickerSheet this$0;

    public WidgetGuildStickerSheet2(WidgetGuildStickerSheet widgetGuildStickerSheet, Guild guild, boolean z2, boolean z3) {
        this.this$0 = widgetGuildStickerSheet;
        this.$guild$inlined = guild;
        this.$isUserPremium$inlined = z2;
        this.$isUserInGuild$inlined = z3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        StickerPremiumUpsellDialog.Companion companion = StickerPremiumUpsellDialog.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, new Traits.Location(null, Traits.Location.Section.STICKER_POPOUT, null, null, null, 29, null));
    }
}

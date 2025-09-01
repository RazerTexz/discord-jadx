package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GuildRoleSubscriptionMemberPreview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionMemberPreview$defaultColor$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionMemberPreview2 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ GuildRoleSubscriptionMemberPreview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionMemberPreview2(GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview) {
        super(0);
        this.this$0 = guildRoleSubscriptionMemberPreview;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return ColorCompat.getColor(this.this$0, R.color.primary_300);
    }
}

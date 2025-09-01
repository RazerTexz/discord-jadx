package com.discord.widgets.user;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.widgets.user.WidgetUserMutualGuilds;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetUserMutualGuilds.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model;", "invoke", "()Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetUserMutualGuilds$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserMutualGuilds3 extends Lambda implements Function0<WidgetUserMutualGuilds.Model> {
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreGuildsSorted $storeGuildsSorted;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMutualGuilds3(StoreUserProfile storeUserProfile, long j, StoreGuildsSorted storeGuildsSorted, StoreUser storeUser, StoreGuilds storeGuilds) {
        super(0);
        this.$storeUserProfile = storeUserProfile;
        this.$userId = j;
        this.$storeGuildsSorted = storeGuildsSorted;
        this.$storeUser = storeUser;
        this.$storeGuilds = storeGuilds;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetUserMutualGuilds.Model invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetUserMutualGuilds.Model invoke() {
        return new WidgetUserMutualGuilds.Model(this.$storeUserProfile.getUserProfile(this.$userId), this.$storeGuildsSorted.getOrderedGuilds(), this.$storeUser.getUsers().get(Long.valueOf(this.$userId)), this.$storeGuilds.getMembers());
    }
}

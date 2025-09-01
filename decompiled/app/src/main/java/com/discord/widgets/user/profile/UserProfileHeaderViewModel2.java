package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import d0.t.Maps6;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: UserProfileHeaderViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\n\u001aj\u0012.\b\u0001\u0012*\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \u0007*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u0003 \u0007*4\u0012.\b\u0001\u0012*\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \u0007*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeComputedMembers$1, reason: use source file name */
/* loaded from: classes.dex */
public final class UserProfileHeaderViewModel2<T, R> implements Func1<Channel, Observable<? extends Map<Long, ? extends GuildMember>>> {
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ Collection $users;

    public UserProfileHeaderViewModel2(StoreGuilds storeGuilds, Collection collection) {
        this.$storeGuilds = storeGuilds;
        this.$users = collection;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends GuildMember>> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, GuildMember>> call2(Channel channel) {
        Observable<Map<Long, GuildMember>> observableObserveComputed;
        return (channel == null || (observableObserveComputed = this.$storeGuilds.observeComputed(channel.getGuildId(), this.$users)) == null) ? new ScalarSynchronousObservable(Maps6.emptyMap()) : observableObserveComputed;
    }
}

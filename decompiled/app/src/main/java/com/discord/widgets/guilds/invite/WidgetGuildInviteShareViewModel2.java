package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import com.discord.widgets.guilds.invite.InviteSuggestion;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import d0.Tuples;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import rx.functions.Func5;

/* compiled from: WidgetGuildInviteShareViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0012\u001a\n \u0001*\u0004\u0018\u00010\u000f0\u000f2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0001*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00060\u00062:\u0010\f\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\nj\u0002`\u000b0\t \u0001*\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\nj\u0002`\u000b0\t\u0018\u00010\b0\b2\u000e\u0010\u000e\u001a\n \u0001*\u0004\u0018\u00010\r0\rH\n¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "kotlin.jvm.PlatformType", "widgetInviteModel", "", "Lcom/discord/widgets/guilds/invite/InviteSuggestion;", "inviteSuggestions", "", "filter", "", "", "", "Lcom/discord/primitives/ChannelId;", "sentInvites", "", "<anonymous parameter 4>", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/guilds/invite/WidgetInviteModel;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Lkotlin/Unit;)Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$observeViewStateFromStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel2<T1, T2, T3, T4, T5, R> implements Func5<WidgetInviteModel, List<? extends InviteSuggestion>, String, Map<String, ? extends Set<? extends Long>>, Unit, WidgetGuildInviteShareViewModel.ViewState.Loaded> {
    public final /* synthetic */ WidgetGuildInviteShareViewModel this$0;

    public WidgetGuildInviteShareViewModel2(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
        this.this$0 = widgetGuildInviteShareViewModel;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetGuildInviteShareViewModel.ViewState.Loaded call(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestion> list, String str, Map<String, ? extends Set<? extends Long>> map, Unit unit) {
        return call2(widgetInviteModel, list, str, (Map<String, ? extends Set<Long>>) map, unit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.util.List] */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetGuildInviteShareViewModel.ViewState.Loaded call2(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestion> list, String str, Map<String, ? extends Set<Long>> map, Unit unit) {
        boolean zContains;
        ArrayList arrayListListOf;
        InviteSuggestionItem userItem;
        boolean z2;
        Intrinsics3.checkNotNullExpressionValue(map, "sentInvites");
        String strAccess$getInviteLink$p = WidgetGuildInviteShareViewModel.access$getInviteLink$p(this.this$0, widgetInviteModel.getInvite());
        Intrinsics3.checkNotNullExpressionValue(strAccess$getInviteLink$p, "widgetInviteModel.invite.inviteLink");
        Set<Long> setEmptySet = map.get(strAccess$getInviteLink$p);
        if (setEmptySet == null) {
            setEmptySet = Sets5.emptySet();
        }
        Set<Long> set = setEmptySet;
        boolean z3 = false;
        if (str == null || StringsJVM.isBlank(str)) {
            Intrinsics3.checkNotNullExpressionValue(list, "inviteSuggestions");
        } else {
            ArrayList arrayListA0 = outline.a0(list, "inviteSuggestions");
            for (Object obj : list) {
                InviteSuggestion inviteSuggestion = (InviteSuggestion) obj;
                if (inviteSuggestion instanceof InviteSuggestion.ChannelItem) {
                    zContains = Strings4.contains((CharSequence) ChannelUtils.c(((InviteSuggestion.ChannelItem) inviteSuggestion).getChannel()), (CharSequence) str, true);
                } else {
                    if (!(inviteSuggestion instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    zContains = Strings4.contains((CharSequence) ((InviteSuggestion.UserSuggestion) inviteSuggestion).getUser().getUsername(), (CharSequence) str, true);
                }
                if (zContains) {
                    arrayListA0.add(obj);
                }
            }
            list = arrayListA0;
        }
        List<Channel> dms = widgetInviteModel.getDms();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(dms, 10));
        for (Channel channel : dms) {
            User userA = ChannelUtils.a(channel);
            arrayList.add(Tuples.to(userA != null ? Long.valueOf(userA.getId()) : null, Long.valueOf(channel.getId())));
        }
        Map map2 = Maps6.toMap(arrayList);
        if (true ^ list.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (InviteSuggestion inviteSuggestion2 : list) {
                if (inviteSuggestion2 instanceof InviteSuggestion.ChannelItem) {
                    InviteSuggestion.ChannelItem channelItem = (InviteSuggestion.ChannelItem) inviteSuggestion2;
                    userItem = new InviteSuggestionItem.ChannelItem(channelItem.getChannel(), set.contains(Long.valueOf(channelItem.getChannel().getId())));
                } else {
                    if (!(inviteSuggestion2 instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InviteSuggestion.UserSuggestion userSuggestion = (InviteSuggestion.UserSuggestion) inviteSuggestion2;
                    userItem = new InviteSuggestionItem.UserItem(userSuggestion.getUser(), _Collections.contains(set, map2.get(Long.valueOf(userSuggestion.getUser().getId()))));
                }
                arrayList2.add(userItem);
            }
            arrayListListOf = arrayList2;
        } else if (!(str == null || StringsJVM.isBlank(str))) {
            arrayListListOf = CollectionsJVM.listOf(InviteSuggestionItem.INSTANCE);
        }
        if (widgetInviteModel.getInvite() != null) {
            if (!widgetInviteModel.getInvite().isStatic() && !widgetInviteModel.isInviteFromStore()) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = true;
        }
        Intrinsics3.checkNotNullExpressionValue(widgetInviteModel, "widgetInviteModel");
        Intrinsics3.checkNotNullExpressionValue(str, "filter");
        return new WidgetGuildInviteShareViewModel.ViewState.Loaded(widgetInviteModel, arrayListListOf, str, map, z2);
    }
}

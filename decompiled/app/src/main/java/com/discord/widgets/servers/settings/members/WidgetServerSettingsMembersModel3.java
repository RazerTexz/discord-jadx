package com.discord.widgets.servers.settings.members;

import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: WidgetServerSettingsMembersModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel$MemberItem;", "member1", "member2", "", "compare", "(Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel$MemberItem;Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel$MemberItem;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel$Companion$sortMembersComparator$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembersModel3<T> implements Comparator<WidgetServerSettingsMembersModel.MemberItem> {
    public static final WidgetServerSettingsMembersModel3 INSTANCE = new WidgetServerSettingsMembersModel3();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(WidgetServerSettingsMembersModel.MemberItem memberItem, WidgetServerSettingsMembersModel.MemberItem memberItem2) {
        return compare2(memberItem, memberItem2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(WidgetServerSettingsMembersModel.MemberItem memberItem, WidgetServerSettingsMembersModel.MemberItem memberItem2) {
        Intrinsics3.checkNotNullParameter(memberItem, "member1");
        Intrinsics3.checkNotNullParameter(memberItem2, "member2");
        int iCompareTo = StringsJVM.compareTo(memberItem.getUserDisplayName(), memberItem2.getUserDisplayName(), true);
        return iCompareTo != 0 ? iCompareTo : (memberItem.getUser().getId() > memberItem2.getUser().getId() ? 1 : (memberItem.getUser().getId() == memberItem2.getUser().getId() ? 0 : -1));
    }
}

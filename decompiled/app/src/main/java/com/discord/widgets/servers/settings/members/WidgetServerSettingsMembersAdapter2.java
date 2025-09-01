package com.discord.widgets.servers.settings.members;

import android.view.View;
import com.discord.api.role.GuildRole;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersAdapter;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel;
import d0.t.Iterables2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsMembersAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersAdapter$MemberListItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembersAdapter2 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsMembersModel.MemberItem $data;
    public final /* synthetic */ WidgetServerSettingsMembersAdapter.MemberListItem this$0;

    public WidgetServerSettingsMembersAdapter2(WidgetServerSettingsMembersAdapter.MemberListItem memberListItem, WidgetServerSettingsMembersModel.MemberItem memberItem) {
        this.this$0 = memberListItem;
        this.$data = memberItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2 function2Access$getMemberSelectedListener$p = WidgetServerSettingsMembersAdapter.access$getMemberSelectedListener$p(WidgetServerSettingsMembersAdapter.MemberListItem.access$getAdapter$p(this.this$0));
        Long lValueOf = Long.valueOf(this.$data.getUser().getId());
        List<GuildRole> roles = this.$data.getRoles();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(roles, 10));
        Iterator<T> it = roles.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((GuildRole) it.next()).getId()));
        }
        function2Access$getMemberSelectedListener$p.invoke(lValueOf, arrayList);
    }
}

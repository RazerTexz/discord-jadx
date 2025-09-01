package com.discord.widgets.guilds.list;

import android.view.View;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildListViewHolder;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildListViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.list.GuildListViewHolder$GuildViewHolder$configure$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildListViewHolder6 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ GuildListItem.GuildItem $data;
    public final /* synthetic */ GuildListViewHolder.GuildViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListViewHolder6(GuildListViewHolder.GuildViewHolder guildViewHolder, GuildListItem.GuildItem guildItem) {
        super(1);
        this.this$0 = guildViewHolder;
        this.$data = guildItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        GuildListViewHolder.GuildViewHolder.access$getOnLongPressed$p(this.this$0).invoke(this.$data);
    }
}

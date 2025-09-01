package com.discord.widgets.servers;

import android.view.View;
import com.discord.widgets.servers.SettingsChannelListAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: SettingsChannelListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/servers/SettingsChannelListAdapter$CategoryListItem$$special$$inlined$also$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$CategoryListItem$onConfigure$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsChannelListAdapter2 implements View.OnClickListener {
    public final /* synthetic */ SettingsChannelListAdapter.CategoryItem $it$inlined;
    public final /* synthetic */ Function1 $onClick;
    public final /* synthetic */ SettingsChannelListAdapter.CategoryListItem this$0;

    public SettingsChannelListAdapter2(Function1 function1, SettingsChannelListAdapter.CategoryItem categoryItem, SettingsChannelListAdapter.CategoryListItem categoryListItem) {
        this.$onClick = function1;
        this.$it$inlined = categoryItem;
        this.this$0 = categoryListItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onClick.invoke(Long.valueOf(this.$it$inlined.getId()));
    }
}

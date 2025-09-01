package com.discord.widgets.channels;

import android.view.View;
import com.discord.widgets.channels.SimpleRolesAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: SimpleRolesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.SimpleRolesAdapter$RoleAdapterItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SimpleRolesAdapter2 implements View.OnClickListener {
    public final /* synthetic */ SimpleRolesAdapter.RoleItem $data;
    public final /* synthetic */ SimpleRolesAdapter.RoleAdapterItem this$0;

    public SimpleRolesAdapter2(SimpleRolesAdapter.RoleAdapterItem roleAdapterItem, SimpleRolesAdapter.RoleItem roleItem) {
        this.this$0 = roleAdapterItem;
        this.$data = roleItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1Access$getOnRoleClickedListener$p = SimpleRolesAdapter.access$getOnRoleClickedListener$p(SimpleRolesAdapter.RoleAdapterItem.access$getAdapter$p(this.this$0));
        if (function1Access$getOnRoleClickedListener$p != null) {
        }
    }
}

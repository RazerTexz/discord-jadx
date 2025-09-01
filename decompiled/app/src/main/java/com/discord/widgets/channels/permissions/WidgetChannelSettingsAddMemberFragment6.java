package com.discord.widgets.channels.permissions;

import androidx.fragment.app.Fragment;
import androidx.view.ViewModelStoreOwner;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/lifecycle/ViewModelStoreOwner;", "invoke", "()Landroidx/lifecycle/ViewModelStoreOwner;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment6 extends Lambda implements Function0<ViewModelStoreOwner> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragment6(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        super(0);
        this.this$0 = widgetChannelSettingsAddMemberFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelStoreOwner invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStoreOwner invoke() {
        Fragment parentFragment = this.this$0.getParentFragment();
        Objects.requireNonNull(parentFragment, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return parentFragment;
    }
}

package com.discord.widgets.channels.permissions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelSettingsAddMemberBinding;
import com.discord.views.SearchInputView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsAddMemberFragment3 extends FunctionReferenceImpl implements Function1<View, WidgetChannelSettingsAddMemberBinding> {
    public static final WidgetChannelSettingsAddMemberFragment3 INSTANCE = new WidgetChannelSettingsAddMemberFragment3();

    public WidgetChannelSettingsAddMemberFragment3() {
        super(1, WidgetChannelSettingsAddMemberBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSettingsAddMemberBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsAddMemberBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        if (recyclerView != null) {
            i = R.id.search_input;
            SearchInputView searchInputView = (SearchInputView) view.findViewById(R.id.search_input);
            if (searchInputView != null) {
                return new WidgetChannelSettingsAddMemberBinding((CoordinatorLayout) view, recyclerView, searchInputView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

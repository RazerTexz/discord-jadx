package com.discord.widgets.quickmentions;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.R;
import com.discord.databinding.WidgetQuickMentionsDialogBinding;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetQuickMentionsDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.quickmentions.WidgetQuickMentionsDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetQuickMentionsDialog2 extends FunctionReferenceImpl implements Function1<View, WidgetQuickMentionsDialogBinding> {
    public static final WidgetQuickMentionsDialog2 INSTANCE = new WidgetQuickMentionsDialog2();

    public WidgetQuickMentionsDialog2() {
        super(1, WidgetQuickMentionsDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetQuickMentionsDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetQuickMentionsDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.tab_contents;
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.tab_contents);
        if (viewPager2 != null) {
            i = R.id.tabs;
            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
            if (tabLayout != null) {
                return new WidgetQuickMentionsDialogBinding((ConstraintLayout) view, viewPager2, tabLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

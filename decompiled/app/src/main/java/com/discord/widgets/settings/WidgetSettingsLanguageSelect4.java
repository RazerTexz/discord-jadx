package com.discord.widgets.settings;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsLanguageSelectBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsLanguageSelect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsLanguageSelectBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsLanguageSelectBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetSettingsLanguageSelect$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsLanguageSelect4 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsLanguageSelectBinding> {
    public static final WidgetSettingsLanguageSelect4 INSTANCE = new WidgetSettingsLanguageSelect4();

    public WidgetSettingsLanguageSelect4() {
        super(1, WidgetSettingsLanguageSelectBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsLanguageSelectBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsLanguageSelectBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsLanguageSelectBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R.id.settings_language_select_list);
        if (maxHeightRecyclerView != null) {
            return new WidgetSettingsLanguageSelectBinding((NestedScrollView) view, maxHeightRecyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.settings_language_select_list)));
    }
}

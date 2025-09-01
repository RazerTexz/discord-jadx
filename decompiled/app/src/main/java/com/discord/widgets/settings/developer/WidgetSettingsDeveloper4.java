package com.discord.widgets.settings.developer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.IconListItemTextViewBinding;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetSettingsDeveloper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/view/ViewGroup;", "parent", "Lcom/discord/widgets/settings/developer/WidgetSettingsDeveloper$NoticeViewHolder;", "invoke", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/discord/widgets/settings/developer/WidgetSettingsDeveloper$NoticeViewHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsDeveloper4 extends Lambda implements Function2<LayoutInflater, ViewGroup, WidgetSettingsDeveloper.NoticeViewHolder> {
    public static final WidgetSettingsDeveloper4 INSTANCE = new WidgetSettingsDeveloper4();

    public WidgetSettingsDeveloper4() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetSettingsDeveloper.NoticeViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsDeveloper.NoticeViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(layoutInflater, "layoutInflater");
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(R.layout.icon_list_item_text_view, viewGroup, false);
        Objects.requireNonNull(viewInflate, "rootView");
        IconListItemTextViewBinding iconListItemTextViewBinding = new IconListItemTextViewBinding((TextView) viewInflate);
        Intrinsics3.checkNotNullExpressionValue(iconListItemTextViewBinding, "IconListItemTextViewBind…tInflater, parent, false)");
        return new WidgetSettingsDeveloper.NoticeViewHolder(iconListItemTextViewBinding);
    }
}

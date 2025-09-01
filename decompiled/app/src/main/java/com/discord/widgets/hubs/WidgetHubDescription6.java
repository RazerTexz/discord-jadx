package com.discord.widgets.hubs;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.hubs.DirectoryEntryCategory;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubDescription.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/hubs/HubDescriptionState;", "state", "", "Lcom/discord/widgets/hubs/RadioSelectorItem;", "invoke", "(Lcom/discord/widgets/hubs/HubDescriptionState;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubDescription$selectorArgs$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubDescription6 extends Lambda implements Function1<WidgetHubDescriptionViewModel3, List<? extends WidgetRadioSelectorBottomSheet2>> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription6(WidgetHubDescription widgetHubDescription) {
        super(1);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends WidgetRadioSelectorBottomSheet2> invoke(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
        return invoke2(widgetHubDescriptionViewModel3);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<WidgetRadioSelectorBottomSheet2> invoke2(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
        Intrinsics3.checkNotNullParameter(widgetHubDescriptionViewModel3, "state");
        DirectoryEntryCategory.Companion companion = DirectoryEntryCategory.INSTANCE;
        Channel channel = widgetHubDescriptionViewModel3.getChannel();
        List<DirectoryEntryCategory> categories = companion.getCategories(channel != null && ChannelUtils.x(channel));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(categories, 10));
        for (DirectoryEntryCategory directoryEntryCategory : categories) {
            int key = directoryEntryCategory.getKey();
            DirectoryEntryCategory category = this.this$0.getViewModel().getCategory();
            arrayList.add(new WidgetRadioSelectorBottomSheet2(key, directoryEntryCategory.getTitle(this.this$0.requireContext()), category != null && category.getKey() == directoryEntryCategory.getKey()));
        }
        return arrayList;
    }
}

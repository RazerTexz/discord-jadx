package com.discord.widgets.channels.list;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetChannelListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ModelAuditLogEntry.CHANGE_KEY_POSITION, "threadCount", "Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType;", "invoke", "(II)Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType;", "getThreadSpineType"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$6$7$1 extends Lambda implements Function2<Integer, Integer, WidgetChannelListModel.ThreadSpineType> {
    public static final WidgetChannelListModel$Companion$guildListBuilder$6$7$1 INSTANCE = new WidgetChannelListModel$Companion$guildListBuilder$6$7$1();

    public WidgetChannelListModel$Companion$guildListBuilder$6$7$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetChannelListModel.ThreadSpineType invoke(Integer num, Integer num2) {
        return invoke(num.intValue(), num2.intValue());
    }

    public final WidgetChannelListModel.ThreadSpineType invoke(int i, int i2) {
        return i2 == 1 ? WidgetChannelListModel.ThreadSpineType.Single.INSTANCE : i == 0 ? WidgetChannelListModel.ThreadSpineType.Start.INSTANCE : i == i2 - 1 ? WidgetChannelListModel.ThreadSpineType.End.INSTANCE : WidgetChannelListModel.ThreadSpineType.Middle.INSTANCE;
    }
}

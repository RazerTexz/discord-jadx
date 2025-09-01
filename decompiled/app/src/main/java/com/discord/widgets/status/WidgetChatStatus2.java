package com.discord.widgets.status;

import com.discord.models.application.Unread;
import com.discord.widgets.status.WidgetChatStatus;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetChatStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "p1", "", "", "Lcom/discord/primitives/ChannelId;", "p2", "Lcom/discord/models/application/Unread;", "p3", "Lcom/discord/widgets/status/WidgetChatStatus$Model;", "invoke", "(ZLjava/util/Set;Lcom/discord/models/application/Unread;)Lcom/discord/widgets/status/WidgetChatStatus$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetChatStatus$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatStatus2 extends FunctionReferenceImpl implements Function3<Boolean, Set<? extends Long>, Unread, WidgetChatStatus.Model> {
    public WidgetChatStatus2(WidgetChatStatus.Model.Companion companion) {
        super(3, companion, WidgetChatStatus.Model.Companion.class, "createModel", "createModel(ZLjava/util/Set;Lcom/discord/models/application/Unread;)Lcom/discord/widgets/status/WidgetChatStatus$Model;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ WidgetChatStatus.Model invoke(Boolean bool, Set<? extends Long> set, Unread unread) {
        return invoke(bool.booleanValue(), (Set<Long>) set, unread);
    }

    public final WidgetChatStatus.Model invoke(boolean z2, Set<Long> set, Unread unread) {
        Intrinsics3.checkNotNullParameter(set, "p2");
        Intrinsics3.checkNotNullParameter(unread, "p3");
        return WidgetChatStatus.Model.Companion.access$createModel((WidgetChatStatus.Model.Companion) this.receiver, z2, set, unread);
    }
}

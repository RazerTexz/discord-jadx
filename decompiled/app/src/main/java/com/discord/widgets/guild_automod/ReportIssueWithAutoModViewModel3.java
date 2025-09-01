package com.discord.widgets.guild_automod;

import androidx.core.app.NotificationCompat;
import com.discord.models.message.Message;
import com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: ReportIssueWithAutoModViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "clientMessage", "Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/message/Message;)Lcom/discord/widgets/guild_automod/ReportIssueWithAutoModViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ReportIssueWithAutoModViewModel3<T, R> implements Func1<Message, ReportIssueWithAutoModViewModel.StoreState> {
    public static final ReportIssueWithAutoModViewModel3 INSTANCE = new ReportIssueWithAutoModViewModel3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ ReportIssueWithAutoModViewModel.StoreState call(Message message) {
        return call2(message);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ReportIssueWithAutoModViewModel.StoreState call2(Message message) {
        return new ReportIssueWithAutoModViewModel.StoreState(message);
    }
}

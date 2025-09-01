package com.discord.widgets.stage;

import com.discord.models.guild.Guild;
import d0.Result2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: StageChannelJoinHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/guild/Guild;", "<anonymous parameter 0>", "", "Lcom/discord/primitives/ChannelId;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "invoke", "(Lcom/discord/models/guild/Guild;Ljava/lang/Long;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$2$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageChannelJoinHelper4 extends Lambda implements Function3<Guild, Long, Boolean, Unit> {
    public final /* synthetic */ CancellableContinuation $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper4(CancellableContinuation cancellableContinuation) {
        super(3);
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild, Long l, Boolean bool) {
        invoke(guild, l, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(Guild guild, Long l, boolean z2) {
        Intrinsics3.checkNotNullParameter(guild, "<anonymous parameter 0>");
        CancellableContinuation cancellableContinuation = this.$continuation;
        Unit unit = Unit.a;
        Result2.a aVar = Result2.j;
        cancellableContinuation.resumeWith(Result2.m97constructorimpl(unit));
    }
}

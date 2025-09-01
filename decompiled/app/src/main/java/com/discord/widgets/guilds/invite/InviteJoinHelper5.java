package com.discord.widgets.guilds.invite;

import d0.Result2;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* compiled from: InviteJoinHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$4$hasMicrophonePermissions$1$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class InviteJoinHelper5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Continuation $cont;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteJoinHelper5(Continuation continuation) {
        super(0);
        this.$cont = continuation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Continuation continuation = this.$cont;
        Boolean bool = Boolean.TRUE;
        Result2.a aVar = Result2.j;
        continuation.resumeWith(Result2.m97constructorimpl(bool));
    }
}

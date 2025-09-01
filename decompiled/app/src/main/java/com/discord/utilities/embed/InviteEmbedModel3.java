package com.discord.utilities.embed;

import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import rx.functions.Func4;

/* compiled from: InviteEmbedModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.embed.InviteEmbedModel$sam$rx_functions_Func4$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class InviteEmbedModel3 implements Func4 {
    private final /* synthetic */ Function4 function;

    public InviteEmbedModel3(Function4 function4) {
        this.function = function4;
    }

    @Override // rx.functions.Func4
    public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4) {
        return this.function.invoke(obj, obj2, obj3, obj4);
    }
}

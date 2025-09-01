package com.discord.models.domain;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ModelApplicationStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/primitives/StreamKey;", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.ModelApplicationStream$encodedStreamKey$2, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelApplicationStream2 extends Lambda implements Function0<String> {
    public final /* synthetic */ ModelApplicationStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelApplicationStream2(ModelApplicationStream modelApplicationStream) {
        super(0);
        this.this$0 = modelApplicationStream;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return this.this$0.encodeStreamKey();
    }
}

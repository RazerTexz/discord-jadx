package com.discord.utilities.persister;

import com.esotericsoftware.kryo.Kryo;
import kotlin.Metadata;

/* compiled from: Persister.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/discord/utilities/persister/Persister$Companion$kryos$1", "Ljava/lang/ThreadLocal;", "Lcom/esotericsoftware/kryo/Kryo;", "initialValue", "()Lcom/esotericsoftware/kryo/Kryo;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.persister.Persister$Companion$kryos$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Persister5 extends ThreadLocal<Kryo> {
    @Override // java.lang.ThreadLocal
    public /* bridge */ /* synthetic */ Kryo initialValue() {
        return initialValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.ThreadLocal
    public Kryo initialValue() {
        Kryo kryo = new Kryo();
        Persister.INSTANCE.getKryoConfig().invoke(kryo);
        return kryo;
    }
}

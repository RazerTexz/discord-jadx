package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import com.esotericsoftware.kryo.Kryo;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Persister.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/esotericsoftware/kryo/Kryo;", "it", "", "invoke", "(Lcom/esotericsoftware/kryo/Kryo;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.persister.Persister$Companion$kryoConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Persister4 extends Lambda implements Function1<Kryo, Unit> {
    public static final Persister4 INSTANCE = new Persister4();

    public Persister4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Kryo kryo) {
        invoke2(kryo);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Kryo kryo) {
        Intrinsics3.checkNotNullParameter(kryo, "it");
    }
}

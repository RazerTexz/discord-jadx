package com.discord.utilities.kryo;

import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import d0.d0._Ranges;
import d0.t.Iterators4;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: LeastRecentlyAddedSetSerializer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ7\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/kryo/LeastRecentlyAddedSetSerializer;", "Lcom/esotericsoftware/kryo/Serializer;", "Lcom/discord/utilities/collections/LeastRecentlyAddedSet;", "Lcom/esotericsoftware/kryo/Kryo;", "kryo", "Lcom/esotericsoftware/kryo/io/Output;", "output", "target", "", "write", "(Lcom/esotericsoftware/kryo/Kryo;Lcom/esotericsoftware/kryo/io/Output;Lcom/discord/utilities/collections/LeastRecentlyAddedSet;)V", "Lcom/esotericsoftware/kryo/io/Input;", "input", "Ljava/lang/Class;", "type", "read", "(Lcom/esotericsoftware/kryo/Kryo;Lcom/esotericsoftware/kryo/io/Input;Ljava/lang/Class;)Lcom/discord/utilities/collections/LeastRecentlyAddedSet;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class LeastRecentlyAddedSetSerializer extends Serializer<LeastRecentlyAddedSet<?>> {
    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ LeastRecentlyAddedSet<?> read(Kryo kryo, Input input, Class<LeastRecentlyAddedSet<?>> cls) {
        return read(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, LeastRecentlyAddedSet<?> leastRecentlyAddedSet) throws KryoException {
        write2(kryo, output, leastRecentlyAddedSet);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public LeastRecentlyAddedSet<?> read(Kryo kryo, Input input, Class<LeastRecentlyAddedSet<?>> type) throws KryoException {
        Intrinsics3.checkNotNullParameter(kryo, "kryo");
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(type, "type");
        int i = input.readInt(true);
        int i2 = input.readInt(true);
        LeastRecentlyAddedSet<?> leastRecentlyAddedSet = new LeastRecentlyAddedSet<>(i, null, 2, null);
        Iterator<Integer> it = _Ranges.until(0, i2).iterator();
        while (it.hasNext()) {
            ((Iterators4) it).nextInt();
            Object classAndObject = kryo.readClassAndObject(input);
            Intrinsics3.checkNotNullExpressionValue(classAndObject, "kryo.readClassAndObject(input)");
            leastRecentlyAddedSet.add(classAndObject);
        }
        return leastRecentlyAddedSet;
    }

    /* renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, LeastRecentlyAddedSet<?> target) throws KryoException {
        Intrinsics3.checkNotNullParameter(kryo, "kryo");
        Intrinsics3.checkNotNullParameter(output, "output");
        Intrinsics3.checkNotNullParameter(target, "target");
        output.writeInt(target.getMaxSize(), true);
        output.writeInt(target.size(), true);
        Iterator<?> it = target.iterator();
        while (it.hasNext()) {
            kryo.writeClassAndObject(output, it.next());
        }
    }
}

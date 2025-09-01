package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NullSerializable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0005\u0007R\u001e\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/discord/nullserializable/NullSerializable;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "value", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "b", "Lcom/discord/nullserializable/NullSerializable$b;", "Lcom/discord/nullserializable/NullSerializable$a;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class NullSerializable<T> implements Serializable {
    private final T value;

    /* compiled from: NullSerializable.kt */
    public static final class a<T> extends NullSerializable<T> {
        private final T value;

        public a() {
            this(null, 1);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, int i) {
            super(null, null);
            int i2 = i & 1;
            this.value = null;
        }

        @Override // com.discord.nullserializable.NullSerializable
        public T a() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && Intrinsics3.areEqual(this.value, ((a) obj).value);
            }
            return true;
        }

        public int hashCode() {
            T t = this.value;
            if (t != null) {
                return t.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Null(value=");
            sbU.append(this.value);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: NullSerializable.kt */
    public static final class b<T> extends NullSerializable<T> {
        private final T value;

        public b(T t) {
            super(t, null);
            this.value = t;
        }

        @Override // com.discord.nullserializable.NullSerializable
        public T a() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && Intrinsics3.areEqual(this.value, ((b) obj).value);
            }
            return true;
        }

        public int hashCode() {
            T t = this.value;
            if (t != null) {
                return t.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Value(value=");
            sbU.append(this.value);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NullSerializable(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this.value = obj;
    }

    public T a() {
        return this.value;
    }
}

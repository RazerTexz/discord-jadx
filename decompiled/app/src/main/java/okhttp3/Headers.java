package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.d0._Ranges;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.MutableCollections;
import d0.z.d.ArrayIterator4;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import f0.e0.Util7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Progressions2;

/* compiled from: Headers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u0000  2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002!\"J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\nJ\"\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\fH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001f\u001a\u00020\u00078G@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018¨\u0006#"}, d2 = {"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "c", "(Ljava/lang/String;)Ljava/lang/String;", "", "index", "d", "(I)Ljava/lang/String;", "g", "", "iterator", "()Ljava/util/Iterator;", "Lokhttp3/Headers$a;", "e", "()Lokhttp3/Headers$a;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "", "k", "[Ljava/lang/String;", "namesAndValues", "size", "j", "a", "b", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Headers implements Iterable<Tuples2<? extends String, ? extends String>>, KMarkers {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    public final String[] namesAndValues;

    /* compiled from: Headers.kt */
    public static final class a {
        public final List<String> a = new ArrayList(20);

        public final a a(String str, String str2) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(str2, "value");
            Companion companion = Headers.INSTANCE;
            companion.a(str);
            companion.b(str2, str);
            b(str, str2);
            return this;
        }

        public final a b(String str, String str2) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(str2, "value");
            this.a.add(str);
            this.a.add(Strings4.trim(str2).toString());
            return this;
        }

        public final Headers c() {
            Object[] array = this.a.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final a d(String str) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            int i = 0;
            while (i < this.a.size()) {
                if (StringsJVM.equals(str, this.a.get(i), true)) {
                    this.a.remove(i);
                    this.a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }
    }

    /* compiled from: Headers.kt */
    /* renamed from: okhttp3.Headers$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(Util7.j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        public final void b(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (!(cCharAt == '\t' || (' ' <= cCharAt && '~' >= cCharAt))) {
                    throw new IllegalArgumentException(Util7.j("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str).toString());
                }
            }
        }

        public final Headers c(String... strArr) throws CloneNotSupportedException {
            Intrinsics3.checkParameterIsNotNull(strArr, "namesAndValues");
            if (!(strArr.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            String[] strArr2 = (String[]) objClone;
            int length = strArr2.length;
            for (int i = 0; i < length; i++) {
                if (!(strArr2[i] != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                String str = strArr2[i];
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                strArr2[i] = Strings4.trim(str).toString();
            }
            Progressions2 progressions2Step = _Ranges.step(_Ranges.until(0, strArr2.length), 2);
            int first = progressions2Step.getFirst();
            int last = progressions2Step.getLast();
            int step = progressions2Step.getStep();
            if (step < 0 ? first >= last : first <= last) {
                while (true) {
                    String str2 = strArr2[first];
                    String str3 = strArr2[first + 1];
                    a(str2);
                    b(str3, str2);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
            return new Headers(strArr2, null);
        }
    }

    public Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.namesAndValues = strArr;
    }

    public final String c(String name) {
        Intrinsics3.checkParameterIsNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String[] strArr = this.namesAndValues;
        Progressions2 progressions2Step = _Ranges.step(_Ranges.downTo(strArr.length - 2, 0), 2);
        int first = progressions2Step.getFirst();
        int last = progressions2Step.getLast();
        int step = progressions2Step.getStep();
        if (step < 0 ? first >= last : first <= last) {
            while (!StringsJVM.equals(name, strArr[first], true)) {
                if (first != last) {
                    first += step;
                }
            }
            return strArr[first + 1];
        }
        return null;
    }

    public final String d(int index) {
        return this.namesAndValues[index * 2];
    }

    public final a e() {
        a aVar = new a();
        MutableCollections.addAll(aVar.a, this.namesAndValues);
        return aVar;
    }

    public boolean equals(Object other) {
        return (other instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) other).namesAndValues);
    }

    public final String g(int index) {
        return this.namesAndValues[(index * 2) + 1];
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Tuples2<? extends String, ? extends String>> iterator() {
        int size = size();
        Tuples2[] tuples2Arr = new Tuples2[size];
        for (int i = 0; i < size; i++) {
            tuples2Arr[i] = Tuples.to(d(i), g(i));
        }
        return ArrayIterator4.iterator(tuples2Arr);
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(d(i));
            sb.append(": ");
            sb.append(g(i));
            sb.append("\n");
        }
        String string = sb.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}

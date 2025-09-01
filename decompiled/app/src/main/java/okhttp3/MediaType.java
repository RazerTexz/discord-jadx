package okhttp3;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.d0._Ranges;
import d0.g0.StringsJVM;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Progressions2;

/* compiled from: MediaType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\f\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0004J\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0019\u0010\u001a\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\b¨\u0006\u001c"}, d2 = {"Lokhttp3/MediaType;", "", "Ljava/nio/charset/Charset;", "defaultValue", "a", "(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "g", "[Ljava/lang/String;", "parameterNamesAndValues", "e", "Ljava/lang/String;", "type", "d", "mediaType", "f", "subtype", "c", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class MediaType {
    public static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f3808b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = null;

    /* renamed from: d, reason: from kotlin metadata */
    public final String mediaType;

    /* renamed from: e, reason: from kotlin metadata */
    public final String type;

    /* renamed from: f, reason: from kotlin metadata */
    public final String subtype;

    /* renamed from: g, reason: from kotlin metadata */
    public final String[] parameterNamesAndValues;

    /* compiled from: MediaType.kt */
    /* renamed from: okhttp3.MediaType$a, reason: from kotlin metadata */
    public static final class Companion {
        public static final MediaType a(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$toMediaType");
            Matcher matcher = MediaType.a.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
            }
            String strGroup = matcher.group(1);
            Intrinsics3.checkExpressionValueIsNotNull(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            Intrinsics3.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strGroup == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strGroup.toLowerCase(locale);
            Intrinsics3.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            Intrinsics3.checkExpressionValueIsNotNull(strGroup2, "typeSubtype.group(2)");
            Intrinsics3.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strGroup2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = strGroup2.toLowerCase(locale);
            Intrinsics3.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = MediaType.f3808b.matcher(str);
            int iEnd = matcher.end();
            while (iEnd < str.length()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sbU = outline.U("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(iEnd);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    sbU.append(strSubstring);
                    sbU.append("\" for: \"");
                    sbU.append(str);
                    sbU.append('\"');
                    throw new IllegalArgumentException(sbU.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (StringsJVM.startsWith$default(strGroup4, "'", false, 2, null) && StringsJVM.endsWith$default(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        Intrinsics3.checkExpressionValueIsNotNull(strGroup4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return new MediaType(str, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public static final MediaType b(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$toMediaTypeOrNull");
            try {
                return a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public MediaType(String str, String str2, String str3, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public static final MediaType b(String str) {
        return Companion.a(str);
    }

    public final Charset a(Charset defaultValue) {
        String str;
        Intrinsics3.checkParameterIsNotNull("charset", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Progressions2 progressions2Step = _Ranges.step(_Arrays.getIndices(this.parameterNamesAndValues), 2);
        int first = progressions2Step.getFirst();
        int last = progressions2Step.getLast();
        int step = progressions2Step.getStep();
        if (step < 0 ? first < last : first > last) {
            str = null;
            break;
        }
        while (!StringsJVM.equals(this.parameterNamesAndValues[first], "charset", true)) {
            if (first == last) {
                str = null;
                break;
            }
            first += step;
        }
        str = this.parameterNamesAndValues[first + 1];
        if (str == null) {
            return defaultValue;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return defaultValue;
        }
    }

    public boolean equals(Object other) {
        return (other instanceof MediaType) && Intrinsics3.areEqual(((MediaType) other).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    /* renamed from: toString, reason: from getter */
    public String getMediaType() {
        return this.mediaType;
    }
}

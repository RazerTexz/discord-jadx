package com.discord.utilities.string;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import b.a.k.FormatUtils;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utils.R;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.net.IDN;
import java.net.URL;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.text.Regex;

/* compiled from: StringUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000e\u001a\u00020\t*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\t*\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\u0012\u001a\u00020\t*\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0015\u001a\u00020\t*\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016\u001a-\u0010\u0019\u001a\u00020\t*\u0004\u0018\u00010\t2\u0018\u0010\u0018\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u00020\t*\u00020\t¢\u0006\u0004\b\u001b\u0010\u0013\"\u0019\u0010\u001c\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroid/content/Context;", "context", "Landroid/content/res/Resources;", "resources", "", "test", "(Landroid/content/Context;Landroid/content/res/Resources;)V", "", "resId", "", "locale", "", "getStringByLocale", "(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/CharSequence;", "format", "(ILandroid/content/Context;)Ljava/lang/String;", "filenameSanitized", "(Ljava/lang/CharSequence;)Ljava/lang/String;", "stripAccents", "(Ljava/lang/String;)Ljava/lang/String;", "", "encodeToBase32String", "([B)Ljava/lang/String;", "Lkotlin/Function1;", "transform", "transformOrEmpty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "toPunyCodeASCIIUrl", "STATIC_IMAGE_EXTENSION", "Ljava/lang/String;", "getSTATIC_IMAGE_EXTENSION", "()Ljava/lang/String;", "Lkotlin/text/Regex;", "STRIP_ACCENTS_REGEX", "Lkotlin/text/Regex;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.string.StringUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class StringUtils2 {
    private static final String STATIC_IMAGE_EXTENSION;
    private static final Regex STRIP_ACCENTS_REGEX = new Regex("[\\p{InCombiningDiacriticalMarks}]");

    static {
        STATIC_IMAGE_EXTENSION = Collections2.listOf((Object[]) new Integer[]{28, 29}).contains(Integer.valueOf(Build.VERSION.SDK_INT)) ? "png" : "webp";
    }

    public static final String encodeToBase32String(byte[] bArr) {
        int i;
        Intrinsics3.checkNotNullParameter(bArr, "$this$encodeToBase32String");
        StringBuffer stringBuffer = new StringBuffer(((bArr.length + 7) * 8) / 5);
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = bArr[i2] >= 0 ? bArr[i2] : bArr[i2] + 256;
            if (i3 > 3) {
                i2++;
                int i5 = i4 & (255 >> i3);
                i3 = (i3 + 5) % 8;
                i = (i5 << i3) | ((i2 < bArr.length ? bArr[i2] >= 0 ? bArr[i2] : bArr[i2] + 256 : 0) >> (8 - i3));
            } else {
                int i6 = i3 + 5;
                i = (i4 >> (8 - i6)) & 31;
                i3 = i6 % 8;
                if (i3 == 0) {
                    i2++;
                }
            }
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(i));
        }
        String string = stringBuffer.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "Base32.encodeOriginal(this)");
        return string;
    }

    public static final String filenameSanitized(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$filenameSanitized");
        return new Regex("[/\\\\]").replace(charSequence, "_");
    }

    public static final String format(int i, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String str = NumberFormat.getInstance(new LocaleManager().getPrimaryLocale(context)).format(Integer.valueOf(i));
        Intrinsics3.checkNotNullExpressionValue(str, "NumberFormat.getInstance…le(context)).format(this)");
        return str;
    }

    public static final String getSTATIC_IMAGE_EXTENSION() {
        return STATIC_IMAGE_EXTENSION;
    }

    public static final CharSequence getStringByLocale(Context context, int i, String str) {
        Intrinsics3.checkNotNullParameter(context, "$this$getStringByLocale");
        Intrinsics3.checkNotNullParameter(str, "locale");
        try {
            Resources resources = context.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            Configuration configuration = new Configuration(resources.getConfiguration());
            configuration.setLocale(new Locale(str));
            Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
            Intrinsics3.checkNotNullExpressionValue(contextCreateConfigurationContext, "createConfigurationContext(configuration)");
            Resources resources2 = contextCreateConfigurationContext.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "createConfigurationConte…(configuration).resources");
            return FormatUtils.i(resources2, i, new Object[0], null, 4);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static final String stripAccents(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$stripAccents");
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFKD);
        Intrinsics3.checkNotNullExpressionValue(strNormalize, "normalizedString");
        return STRIP_ACCENTS_REGEX.replace(strNormalize, "");
    }

    public static final void test(Context context, Resources resources) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(resources, "resources");
        context.getString(R.a.common_google_play_services_unknown_issue, 1);
        resources.getString(R.a.common_google_play_services_enable_button, 1);
    }

    public static final String toPunyCodeASCIIUrl(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$toPunyCodeASCIIUrl");
        URL url = new URL(str);
        StringBuilder sb = new StringBuilder(new URL(url.getProtocol(), IDN.toASCII(url.getHost(), 1), url.getPort(), url.getFile()).toString());
        if (url.getRef() != null) {
            sb.append(MentionUtils.CHANNELS_CHAR);
            sb.append(url.getRef());
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "safeUrlStringBuilder.toString()");
        return string;
    }

    public static final String transformOrEmpty(String str, Function1<? super String, String> function1) {
        String strInvoke;
        if (function1 != null && (strInvoke = function1.invoke(str)) != null) {
            str = strInvoke;
        }
        return str != null ? str : "";
    }
}

package com.discord.utilities.attachments;

import android.content.ClipDescription;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.core.app.NotificationCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.discord.api.message.LocalAttachment;
import com.discord.utilities.string.StringUtils2;
import com.lytefast.flexinput.model.Attachment;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import g0.Buffer3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;
import org.webrtc.MediaStreamTrack;

/* compiled from: AttachmentUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u0006\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\t\u001a+\u0010\u000b\u001a\u00020\n2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u000b\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000b\u0010\r\u001a+\u0010\u000e\u001a\u00020\n2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\f\u001a\u001f\u0010\u000e\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000e\u0010\r\u001a\u001f\u0010\u000f\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000f\u0010\r\u001a\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u001a-\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0015*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00152\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a'\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0015¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0015\u0010\u001d\u001a\u00020\u001c*\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\b*\u00020\u001c¢\u0006\u0004\b \u0010!\u001a\u0019\u0010\"\u001a\u00020\n*\u00020\u001c2\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0019\u0010$\u001a\u00020\n*\u00020\u001c2\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b$\u0010#\u001a\u0013\u0010%\u001a\u00020\u0004*\u00020\u0011H\u0002¢\u0006\u0004\b%\u0010&\u001a\u0013\u0010'\u001a\u00020\u0004*\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010(\"\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+\"\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+\"\u001d\u00102\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00066"}, d2 = {"Landroid/content/ContentResolver;", "contentResolver", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "displayName", "getMimeType", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;", "Lcom/lytefast/flexinput/model/Attachment;", "(Lcom/lytefast/flexinput/model/Attachment;Landroid/content/ContentResolver;)Ljava/lang/String;", "", "isImage", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;)Z", "(Lcom/lytefast/flexinput/model/Attachment;Landroid/content/ContentResolver;)Z", "isVideo", "isGif", "fileName", "Landroid/graphics/Bitmap$CompressFormat;", "compressFormat", "getSanitizedFileName", "(Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;", "", "extractLinks", "(Ljava/util/List;Landroid/content/ContentResolver;)Ljava/util/List;", "content", "links", "appendLinks", "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", "Lcom/discord/api/message/LocalAttachment;", "toLocalAttachment", "(Lcom/lytefast/flexinput/model/Attachment;)Lcom/discord/api/message/LocalAttachment;", "", "toAttachment", "(Lcom/discord/api/message/LocalAttachment;)Lcom/lytefast/flexinput/model/Attachment;", "isImageAttachment", "(Lcom/discord/api/message/LocalAttachment;Landroid/content/ContentResolver;)Z", "isVideoAttachment", "getExtension", "(Landroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;", "toHumanReadableAscii", "(Ljava/lang/String;)Ljava/lang/String;", "", "UTF_8_RANGE_END_EXCLUSIVE", "I", "UTF_8_RANGE_START_EXCLUSIVE", "Ljava/util/regex/Pattern;", "REGEX_FILE_NAME_PATTERN$delegate", "Lkotlin/Lazy;", "getREGEX_FILE_NAME_PATTERN", "()Ljava/util/regex/Pattern;", "REGEX_FILE_NAME_PATTERN", "Lkotlin/ranges/IntRange;", "UTF_8_RANGE_EXCLUSIVE", "Lkotlin/ranges/IntRange;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.attachments.AttachmentUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class AttachmentUtils {
    private static final int UTF_8_RANGE_END_EXCLUSIVE = 126;
    private static final int UTF_8_RANGE_START_EXCLUSIVE = 32;
    private static final Lazy REGEX_FILE_NAME_PATTERN$delegate = LazyJVM.lazy(AttachmentUtils2.INSTANCE);
    private static final Ranges2 UTF_8_RANGE_EXCLUSIVE = new Ranges2(32, 126);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.attachments.AttachmentUtilsKt$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Bitmap.CompressFormat.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            $EnumSwitchMapping$1 = iArr;
            iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            iArr[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            iArr[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
        }
    }

    /* compiled from: AttachmentUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/lytefast/flexinput/model/Attachment;", "it", "", "invoke", "(Lcom/lytefast/flexinput/model/Attachment;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.attachments.AttachmentUtilsKt$appendLinks$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Attachment<?>, CharSequence> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(Attachment<?> attachment) {
            Intrinsics3.checkNotNullParameter(attachment, "it");
            Object data = attachment.getData();
            Objects.requireNonNull(data, "null cannot be cast to non-null type androidx.core.view.inputmethod.InputContentInfoCompat");
            InputContentInfoCompat inputContentInfoCompat = (InputContentInfoCompat) data;
            String strValueOf = String.valueOf(inputContentInfoCompat.getLinkUri());
            inputContentInfoCompat.releasePermission();
            return strValueOf;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Attachment<?> attachment) {
            return invoke2(attachment);
        }
    }

    /* compiled from: AttachmentUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "file", "invoke", "(Ljava/lang/String;)Ljava/lang/String;", "getMimeTypeFromExtension"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.attachments.AttachmentUtilsKt$getMimeType$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(String str) {
            return invoke2(str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "file");
            Matcher matcher = AttachmentUtils.access$getREGEX_FILE_NAME_PATTERN$p().matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(matcher.group(2));
        }
    }

    public static final /* synthetic */ Pattern access$getREGEX_FILE_NAME_PATTERN$p() {
        return getREGEX_FILE_NAME_PATTERN();
    }

    public static final String appendLinks(String str, List<? extends Attachment<?>> list) {
        Intrinsics3.checkNotNullParameter(str, "content");
        Intrinsics3.checkNotNullParameter(list, "links");
        return str + "\n" + _Collections.joinToString$default(list, "\n", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null);
    }

    public static final List<Attachment<?>> extractLinks(List<? extends Attachment<?>> list, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(list, "$this$extractLinks");
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Attachment attachment = (Attachment) obj;
            Object data = attachment.getData();
            if (!(data instanceof InputContentInfoCompat)) {
                data = null;
            }
            InputContentInfoCompat inputContentInfoCompat = (InputContentInfoCompat) data;
            if ((inputContentInfoCompat == null || inputContentInfoCompat.getLinkUri() == null || !Intrinsics3.areEqual(getMimeType(attachment, contentResolver), "image/gif")) ? false : true) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static final String getExtension(Bitmap.CompressFormat compressFormat) {
        int i = WhenMappings.$EnumSwitchMapping$1[compressFormat.ordinal()];
        return i != 1 ? i != 2 ? "jpg" : "webp" : "png";
    }

    public static final String getMimeType(ContentResolver contentResolver, Uri uri, String str) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        String strInvoke2 = null;
        String type = contentResolver != null ? contentResolver.getType(uri) : null;
        if (type != null) {
            return type;
        }
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        try {
            String strInvoke22 = anonymousClass1.invoke2(String.valueOf(uri));
            strInvoke2 = strInvoke22 != null ? strInvoke22 : anonymousClass1.invoke2(String.valueOf(str));
        } catch (Exception unused) {
        }
        return strInvoke2 != null ? strInvoke2 : "application/octet-stream";
    }

    public static /* synthetic */ String getMimeType$default(ContentResolver contentResolver, Uri uri, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return getMimeType(contentResolver, uri, str);
    }

    private static final Pattern getREGEX_FILE_NAME_PATTERN() {
        return (Pattern) REGEX_FILE_NAME_PATTERN$delegate.getValue();
    }

    public static final String getSanitizedFileName(String str, Bitmap.CompressFormat compressFormat) {
        Intrinsics3.checkNotNullParameter(str, "fileName");
        if (compressFormat != null) {
            Matcher matcher = getREGEX_FILE_NAME_PATTERN().matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
            }
            str = str + '.' + getExtension(compressFormat);
        }
        return toHumanReadableAscii(StringUtils2.stripAccents(str));
    }

    public static final boolean isGif(Attachment<?> attachment, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(attachment, "$this$isGif");
        return Intrinsics3.areEqual(getMimeType(attachment, contentResolver), "image/gif");
    }

    public static final boolean isImage(ContentResolver contentResolver, Uri uri, String str) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        return StringsJVM.startsWith$default(getMimeType(contentResolver, uri, str), "image", false, 2, null);
    }

    public static /* synthetic */ boolean isImage$default(ContentResolver contentResolver, Uri uri, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return isImage(contentResolver, uri, str);
    }

    public static final boolean isImageAttachment(LocalAttachment localAttachment, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(localAttachment, "$this$isImageAttachment");
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Uri uri = Uri.parse(localAttachment.getUriString());
        Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(uriString)");
        return isImage(contentResolver, uri, localAttachment.getDisplayName());
    }

    public static final boolean isVideo(ContentResolver contentResolver, Uri uri, String str) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        return StringsJVM.startsWith$default(getMimeType(contentResolver, uri, str), MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null);
    }

    public static /* synthetic */ boolean isVideo$default(ContentResolver contentResolver, Uri uri, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return isVideo(contentResolver, uri, str);
    }

    public static final boolean isVideoAttachment(LocalAttachment localAttachment, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(localAttachment, "$this$isVideoAttachment");
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Uri uri = Uri.parse(localAttachment.getUriString());
        Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(uriString)");
        return isVideo(contentResolver, uri, localAttachment.getDisplayName());
    }

    public static final Attachment toAttachment(LocalAttachment localAttachment) {
        Intrinsics3.checkNotNullParameter(localAttachment, "$this$toAttachment");
        long id2 = localAttachment.getId();
        Uri uri = Uri.parse(localAttachment.getUriString());
        Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(uriString)");
        return new Attachment(id2, uri, localAttachment.getDisplayName(), null, false, 16, null);
    }

    private static final String toHumanReadableAscii(String str) {
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (!UTF_8_RANGE_EXCLUSIVE.contains(iCodePointAt)) {
                Buffer3 buffer3 = new Buffer3();
                buffer3.c0(str, 0, iCharCount);
                while (iCharCount < str.length()) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    buffer3.d0(UTF_8_RANGE_EXCLUSIVE.contains(iCodePointAt2) ? iCodePointAt2 : 63);
                    iCharCount += Character.charCount(iCodePointAt2);
                }
                return buffer3.D();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    public static final LocalAttachment toLocalAttachment(Attachment<?> attachment) {
        Intrinsics3.checkNotNullParameter(attachment, "$this$toLocalAttachment");
        long id2 = attachment.getId();
        String string = attachment.getUri().toString();
        Intrinsics3.checkNotNullExpressionValue(string, "uri.toString()");
        return new LocalAttachment(id2, string, attachment.getDisplayName());
    }

    public static final boolean isImage(Attachment<?> attachment, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(attachment, "$this$isImage");
        return StringsJVM.startsWith$default(getMimeType(attachment, contentResolver), "image", false, 2, null);
    }

    public static final boolean isVideo(Attachment<?> attachment, ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(attachment, "$this$isVideo");
        return StringsJVM.startsWith$default(getMimeType(attachment, contentResolver), MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null);
    }

    public static final String getMimeType(Attachment<?> attachment, ContentResolver contentResolver) {
        ClipDescription description;
        Intrinsics3.checkNotNullParameter(attachment, "$this$getMimeType");
        Object data = attachment.getData();
        String mimeType = null;
        if (!(data instanceof InputContentInfoCompat)) {
            data = null;
        }
        InputContentInfoCompat inputContentInfoCompat = (InputContentInfoCompat) data;
        if (inputContentInfoCompat != null && (description = inputContentInfoCompat.getDescription()) != null) {
            mimeType = description.getMimeType(0);
        }
        return mimeType != null ? mimeType : getMimeType(contentResolver, attachment.getUri(), attachment.getDisplayName());
    }
}

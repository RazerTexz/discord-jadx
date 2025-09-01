package com.lytefast.flexinput.model;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.Strings4;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Attachment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0016\u0018\u0000 /*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001/B5\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010%\u001a\u00020\u0005¢\u0006\u0004\b+\u0010,B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020\f¢\u0006\u0004\b+\u0010.J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u0004\u0018\u00018\u00008\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/lytefast/flexinput/model/Attachment;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "()J", "", "displayName", "Ljava/lang/String;", "getDisplayName", "()Ljava/lang/String;", "data", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "spoiler", "Z", "getSpoiler", "()Z", "setSpoiler", "(Z)V", "<init>", "(JLandroid/net/Uri;Ljava/lang/String;Ljava/lang/Object;Z)V", "parcelIn", "(Landroid/os/Parcel;)V", "Companion", "flexinput_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class Attachment<T> implements Parcelable {
    private static final String SPOILER_PREFIX = "SPOILER_";
    private final T data;
    private final String displayName;
    private final long id;
    private boolean spoiler;
    private final Uri uri;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<Attachment<?>> CREATOR = new a();

    /* compiled from: Attachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0015J\u0015\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ5\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002*\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R&\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/lytefast/flexinput/model/Attachment$Companion;", "", "Lcom/lytefast/flexinput/model/Attachment;", "", "a", "(Lcom/lytefast/flexinput/model/Attachment;)Ljava/lang/String;", "Landroid/net/Uri;", "Landroid/content/ContentResolver;", "resolver", "b", "(Landroid/net/Uri;Landroid/content/ContentResolver;)Lcom/lytefast/flexinput/model/Attachment;", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "", "appendExtension", "defaultName", "c", "(Landroidx/core/view/inputmethod/InputContentInfoCompat;Landroid/content/ContentResolver;ZLjava/lang/String;)Lcom/lytefast/flexinput/model/Attachment;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "getCREATOR$annotations", "()V", "SPOILER_PREFIX", "Ljava/lang/String;", "<init>", "flexinput_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final String a(Attachment<?> attachment) {
            Intrinsics3.checkNotNullParameter(attachment, "$this$getSendName");
            if (!attachment.getSpoiler()) {
                return attachment.getDisplayName();
            }
            StringBuilder sbU = outline.U("SPOILER_");
            sbU.append(attachment.getDisplayName());
            return sbU.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00a3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Attachment<Uri> b(Uri uri, ContentResolver contentResolver) throws IOException {
            String lastPathSegment;
            int columnIndex;
            Intrinsics3.checkNotNullParameter(uri, "$this$toAttachment");
            Intrinsics3.checkNotNullParameter(contentResolver, "resolver");
            Intrinsics3.checkNotNullParameter(uri, "$this$getFileName");
            Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
            String scheme = uri.getScheme();
            if (scheme == null) {
                lastPathSegment = uri.getLastPathSegment();
            } else {
                int iHashCode = scheme.hashCode();
                lastPathSegment = null;
                if (iHashCode != 3143036) {
                    if (iHashCode == 951530617 && scheme.equals("content")) {
                        try {
                            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
                            if (cursorQuery != null) {
                                try {
                                    if (!cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_display_name")) < 0) {
                                        Closeable.closeFinally(cursorQuery, null);
                                        lastPathSegment = uri.getLastPathSegment();
                                    } else {
                                        String string = cursorQuery.getString(columnIndex);
                                        if (string == null) {
                                            string = uri.getLastPathSegment();
                                        }
                                        Closeable.closeFinally(cursorQuery, null);
                                        lastPathSegment = string;
                                    }
                                } finally {
                                }
                            } else {
                                lastPathSegment = uri.getLastPathSegment();
                            }
                        } catch (NullPointerException e) {
                            StringBuilder sbU = outline.U("Error getting file name for: ");
                            sbU.append(uri.getPath());
                            Log.e("FileUtils", sbU.toString(), e);
                            lastPathSegment = uri.getLastPathSegment();
                        }
                    }
                } else if (scheme.equals("file")) {
                    String path = uri.getPath();
                    if (path != null) {
                        lastPathSegment = new File(path).getName();
                    }
                }
            }
            if (lastPathSegment == null) {
                lastPathSegment = String.valueOf(uri.hashCode());
            }
            return new Attachment<>(uri.hashCode(), uri, lastPathSegment, null, false, 16, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Attachment<InputContentInfoCompat> c(InputContentInfoCompat inputContentInfoCompat, ContentResolver contentResolver, boolean z2, String str) {
            String str2;
            Intrinsics3.checkNotNullParameter(inputContentInfoCompat, "$this$toAttachment");
            Intrinsics3.checkNotNullParameter(contentResolver, "resolver");
            Intrinsics3.checkNotNullParameter(str, "defaultName");
            String queryParameter = inputContentInfoCompat.getContentUri().getQueryParameter("fileName");
            if (queryParameter != null) {
                str = queryParameter;
            }
            Intrinsics3.checkNotNullExpressionValue(str, "contentUri.getQueryParam…fileName\") ?: defaultName");
            String strSubstringAfterLast$default = Strings4.substringAfterLast$default(str, File.separatorChar, null, 2, null);
            if (z2) {
                String mimeType = inputContentInfoCompat.getDescription().getMimeType(0);
                if (mimeType == null) {
                    mimeType = inputContentInfoCompat.getContentUri().getQueryParameter("mimeType");
                }
                if (mimeType == null) {
                    mimeType = contentResolver.getType(inputContentInfoCompat.getContentUri());
                }
                if (mimeType != null) {
                    String str3 = strSubstringAfterLast$default + '.' + Strings4.substringAfterLast$default(mimeType, MentionUtils.SLASH_CHAR, null, 2, null);
                    if (str3 != null) {
                        str2 = str3;
                    }
                }
            } else {
                str2 = strSubstringAfterLast$default;
            }
            long jHashCode = inputContentInfoCompat.getContentUri().hashCode();
            Uri contentUri = inputContentInfoCompat.getContentUri();
            Intrinsics3.checkNotNullExpressionValue(contentUri, "contentUri");
            return new Attachment<>(jHashCode, contentUri, str2, inputContentInfoCompat, false, 16, null);
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: Attachment.kt */
    public static final class a implements Parcelable.Creator<Attachment<?>> {
        @Override // android.os.Parcelable.Creator
        public Attachment<?> createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "parcelIn");
            return new Attachment<>(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Attachment<?>[] newArray(int i) {
            return new Attachment[i];
        }
    }

    public Attachment(long j, Uri uri, String str, T t, boolean z2) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(str, "displayName");
        this.id = j;
        this.uri = uri;
        this.displayName = str;
        this.data = t;
        this.spoiler = z2;
    }

    public static final Attachment<Uri> toAttachment(Uri uri, ContentResolver contentResolver) {
        return INSTANCE.b(uri, contentResolver);
    }

    public static final Attachment<InputContentInfoCompat> toAttachment(InputContentInfoCompat inputContentInfoCompat, ContentResolver contentResolver, boolean z2, String str) {
        return INSTANCE.c(inputContentInfoCompat, contentResolver, z2, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) other;
        return this.id == attachment.id && Intrinsics3.areEqual(this.uri, attachment.uri) && this.spoiler == attachment.spoiler;
    }

    public final T getData() {
        return this.data;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean getSpoiler() {
        return this.spoiler;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return AnimatableValueParser.K0(Long.valueOf(this.id), this.uri);
    }

    public final void setSpoiler(boolean z2) {
        this.spoiler = z2;
    }

    @Override // android.os.Parcelable
    @CallSuper
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics3.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeParcelable(this.uri, flags);
        dest.writeString(this.displayName);
        dest.writeInt(this.spoiler ? 1 : 0);
    }

    public /* synthetic */ Attachment(long j, Uri uri, String str, Object obj, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, uri, str, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? false : z2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Attachment(Parcel parcel) {
        Intrinsics3.checkNotNullParameter(parcel, "parcelIn");
        long j = parcel.readLong();
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (uri == null) {
            uri = Uri.EMPTY;
            Intrinsics3.checkNotNullExpressionValue(uri, "Uri.EMPTY");
        }
        Uri uri2 = uri;
        String string = parcel.readString();
        String str = string == null ? "" : string;
        Intrinsics3.checkNotNullExpressionValue(str, "parcelIn.readString() ?: \"\"");
        this(j, uri2, str, null, parcel.readInt() == 1);
    }
}

package com.discord.widgets.chat.input;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SourcedAttachment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B1\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017B\u001f\b\u0016\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/chat/input/SourcedAttachment;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lytefast/flexinput/model/Attachment;", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "source", "Ljava/lang/String;", "getSource", "", ModelAuditLogEntry.CHANGE_KEY_ID, "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "displayName", "data", "<init>", "(JLandroid/net/Uri;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "attachment", "(Lcom/lytefast/flexinput/model/Attachment;Ljava/lang/String;)V", "parcelIn", "(Landroid/os/Parcel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SourcedAttachment<T> extends Attachment<T> {
    private final String source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SourcedAttachment(long j, Uri uri, String str, T t, String str2) {
        super(j, uri, str, t, false, 16, null);
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(str, "displayName");
        Intrinsics3.checkNotNullParameter(str2, "source");
        this.source = str2;
    }

    public final String getSource() {
        return this.source;
    }

    public String toString() {
        StringBuilder sbU = outline.U("SourcedAttachment(uri=");
        sbU.append(getUri());
        sbU.append(", data=");
        sbU.append(getData());
        sbU.append(')');
        return sbU.toString();
    }

    @Override // com.lytefast.flexinput.model.Attachment, android.os.Parcelable
    @SuppressLint({"MissingSuperCall"})
    @CallSuper
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics3.checkNotNullParameter(dest, "dest");
        super.writeToParcel(dest, flags);
        dest.writeString(this.source);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SourcedAttachment(Attachment<? extends T> attachment, String str) {
        this(attachment.getId(), attachment.getUri(), attachment.getDisplayName(), attachment.getData(), str);
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        Intrinsics3.checkNotNullParameter(str, "source");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SourcedAttachment(Parcel parcel) {
        Intrinsics3.checkNotNullParameter(parcel, "parcelIn");
        long j = parcel.readLong();
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (uri == null) {
            uri = Uri.EMPTY;
            Intrinsics3.checkNotNullExpressionValue(uri, "Uri.EMPTY");
        }
        Uri uri2 = uri;
        String string = parcel.readString();
        String str = string != null ? string : "";
        Intrinsics3.checkNotNullExpressionValue(str, "parcelIn.readString() ?: \"\"");
        String string2 = parcel.readString();
        String str2 = string2 != null ? string2 : "";
        Intrinsics3.checkNotNullExpressionValue(str2, "parcelIn.readString() ?: \"\"");
        this(j, uri2, str, null, str2);
    }
}

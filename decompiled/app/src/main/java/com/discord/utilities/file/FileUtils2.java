package com.discord.utilities.file;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.utilities.drawable.DrawableCompat;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import org.webrtc.MediaStreamTrack;

/* compiled from: FileUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\n¨\u0006\u0010"}, d2 = {"Landroid/content/Context;", "context", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "getFileSizeBytes", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/Long;", "bytes", "", "getSizeSubtitle", "(J)Ljava/lang/String;", "mimeType", "", "getIconForFiletype", "(Landroid/content/Context;Ljava/lang/String;)I", "getHumanReadableByteCount", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.file.FileUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class FileUtils2 {
    public static final Long getFileSizeBytes(Context context, Uri uri) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (Build.VERSION.SDK_INT < 26) {
            try {
                return Long.valueOf(androidx.core.net.Uri.toFile(uri).length());
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null);
        if (cursorQuery != null) {
            cursorQuery.moveToFirst();
        }
        Long lValueOf = cursorQuery != null ? Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("_size"))) : null;
        if (cursorQuery == null) {
            return lValueOf;
        }
        cursorQuery.close();
        return lValueOf;
    }

    private static final String getHumanReadableByteCount(long j) {
        if (j < 1024) {
            return j + " B";
        }
        double d = j;
        double d2 = 1024;
        int iLog = (int) (Math.log(d) / Math.log(d2));
        return outline.P(new Object[]{Double.valueOf(d / Math.pow(d2, iLog)), Character.valueOf("KMGTPE".charAt(iLog - 1))}, 2, "%.1f %sB", "java.lang.String.format(format, *args)");
    }

    @DrawableRes
    public static final int getIconForFiletype(Context context, String str) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(str, "mimeType");
        return DrawableCompat.getThemedDrawableRes$default(context, StringsJVM.startsWith$default(str, "image", false, 2, null) ? R.attr.ic_uploads_image : StringsJVM.startsWith$default(str, MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null) ? R.attr.ic_uploads_video : R.attr.ic_uploads_file, 0, 2, (Object) null);
    }

    public static final String getSizeSubtitle(long j) {
        if (j != -1) {
            return getHumanReadableByteCount(j);
        }
        return null;
    }
}

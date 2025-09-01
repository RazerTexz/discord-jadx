package co.discord.media_engine.internal;

import android.content.Context;
import android.util.Log;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.hammerandchisel.libdiscord.R;
import d0.y.IOStreams;
import d0.y.Utils7;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;

/* compiled from: AssetManagement.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lco/discord/media_engine/internal/AssetManagement;", "", "Ljava/io/File;", "dir", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "copy", "(Ljava/io/File;Ljava/lang/String;)V", "cleanup", "()V", "", "enabled", "ensureKrispModelsCopied", "(Z)V", "Landroid/content/Context;", "ctx", "Landroid/content/Context;", "getCtx", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AssetManagement {
    private final Context ctx;

    public AssetManagement(Context context) {
        Intrinsics3.checkNotNullParameter(context, "ctx");
        this.ctx = context;
    }

    private final void cleanup() {
        try {
            File file = new File(this.ctx.getFilesDir(), "thz");
            if (file.exists()) {
                Utils7.deleteRecursively(file);
            }
        } catch (Exception e) {
            StringBuilder sbU = outline.U("Failed removing krisp model files: ");
            sbU.append(e.getMessage());
            sbU.append(": ");
            sbU.append(e.toString());
            Log.e("DiscordKrisp", sbU.toString());
        }
    }

    private final void copy(File dir, String name) throws IOException {
        InputStream inputStreamOpen = this.ctx.getAssets().open("thz/" + name);
        Intrinsics3.checkNotNullExpressionValue(inputStreamOpen, "ctx.assets.open(\"thz/\" + name)");
        FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, name));
        IOStreams.copyTo(inputStreamOpen, fileOutputStream, 1024);
        inputStreamOpen.close();
        fileOutputStream.close();
    }

    public final void ensureKrispModelsCopied(boolean enabled) throws IOException {
        if (!enabled) {
            cleanup();
            return;
        }
        try {
            File file = new File(this.ctx.getFilesDir(), "thz");
            String string = this.ctx.getString(R.string.krisp_model_version);
            Intrinsics3.checkNotNullExpressionValue(string, "ctx.getString(R.string.krisp_model_version)");
            if (new File(file, string).exists()) {
                return;
            }
            cleanup();
            File file2 = new File(this.ctx.getFilesDir(), "thz");
            file2.mkdir();
            File file3 = new File(file2, string);
            file3.mkdir();
            String[] list = this.ctx.getAssets().list("thz");
            if (list == null) {
                list = new String[0];
            }
            for (String str : list) {
                Intrinsics3.checkNotNullExpressionValue(str, "file");
                copy(file3, str);
            }
        } catch (Exception e) {
            StringBuilder sbU = outline.U("Failed copying krisp model files: ");
            sbU.append(e.getMessage());
            sbU.append(": ");
            sbU.append(e.toString());
            Log.e("DiscordKrisp", sbU.toString());
            cleanup();
        }
    }

    public final Context getCtx() {
        return this.ctx;
    }
}

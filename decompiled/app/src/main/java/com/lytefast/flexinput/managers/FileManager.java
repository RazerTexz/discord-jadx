package com.lytefast.flexinput.managers;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import kotlin.Metadata;

/* compiled from: FileManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/lytefast/flexinput/managers/FileManager;", "", "Ljava/io/File;", "b", "()Ljava/io/File;", "Landroid/content/Context;", "context", "file", "Landroid/net/Uri;", "a", "(Landroid/content/Context;Ljava/io/File;)Landroid/net/Uri;", "flexinput_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface FileManager {
    Uri a(Context context, File file);

    File b();
}

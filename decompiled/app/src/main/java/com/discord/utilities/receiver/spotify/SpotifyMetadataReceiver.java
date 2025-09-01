package com.discord.utilities.receiver.spotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b.d.b.a.outline;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import d0.g0.Strings4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SpotifyMetadataReceiver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/receiver/spotify/SpotifyMetadataReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SpotifyMetadataReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(ModelAuditLogEntry.CHANGE_KEY_ID)) == null) {
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(\"id\") ?: return");
        try {
            StoreStream.INSTANCE.getSpotify().setCurrentTrackId((String) _Collections.last(Strings4.split$default((CharSequence) stringExtra, new String[]{":"}, false, 0, 6, (Object) null)));
        } catch (Exception unused) {
            Logger.e$default(AppLog.g, outline.w("Error parsing spotify track id: ", stringExtra), null, null, 6, null);
        }
    }
}

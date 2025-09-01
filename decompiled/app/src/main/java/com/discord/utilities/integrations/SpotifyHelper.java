package com.discord.utilities.integrations;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityMetadata;
import com.discord.utilities.receiver.spotify.SpotifyMetadataReceiver;
import com.discord.utilities.receiver.spotify.SpotifyPlayingStateReceiver;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.IOException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: SpotifyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u0006J\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0006R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 ¨\u0006$"}, d2 = {"Lcom/discord/utilities/integrations/SpotifyHelper;", "", "Landroid/content/Context;", "context", "", "registerSpotifyBroadcastReceivers", "(Landroid/content/Context;)V", "Lkotlin/Function0;", "action", "runIfSpotifyInstalled", "(Lkotlin/jvm/functions/Function0;Landroid/content/Context;)V", "Landroid/content/Intent;", "intent", "launchSpotifyIntent", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lcom/discord/api/activity/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "launchTrack", "(Landroid/content/Context;Lcom/discord/api/activity/Activity;)V", "", "Lcom/discord/primitives/UserId;", "userId", "", "isMe", "launchAlbum", "(Landroid/content/Context;Lcom/discord/api/activity/Activity;JZ)V", "isSpotifyInstalled", "(Landroid/content/Context;)Z", "openPlayStoreForSpotify", "openSpotifyApp", "", "SPOTIFY_UTM_PARAMS", "Ljava/lang/String;", "SPOTIFY_PACKAGE_NAME", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SpotifyHelper {
    public static final SpotifyHelper INSTANCE = new SpotifyHelper();
    private static final String SPOTIFY_PACKAGE_NAME = "com.spotify.music";
    private static final String SPOTIFY_UTM_PARAMS = "utm_source=discord&utm_medium=mobile";

    /* compiled from: SpotifyHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.integrations.SpotifyHelper$launchAlbum$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $applicationId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $sessionId;
        public final /* synthetic */ long $userId;

        /* compiled from: SpotifyHelper.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/activity/ActivityMetadata;", "metaData", "", "invoke", "(Lcom/discord/api/activity/ActivityMetadata;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.integrations.SpotifyHelper$launchAlbum$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02161 extends Lambda implements Function1<ActivityMetadata, Unit> {
            public C02161() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityMetadata activityMetadata) {
                invoke2(activityMetadata);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ActivityMetadata activityMetadata) {
                String albumId;
                if (activityMetadata == null || (albumId = activityMetadata.getAlbumId()) == null) {
                    return;
                }
                SpotifyHelper.access$launchSpotifyIntent(SpotifyHelper.INSTANCE, AnonymousClass1.this.$context, new Intent("android.intent.action.VIEW", Uri.parse("spotify:album:" + Uri.encode(albumId) + "?utm_source=discord&utm_medium=mobile")));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, String str, long j2, Context context) {
            super(0);
            this.$userId = j;
            this.$sessionId = str;
            this.$applicationId = j2;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getActivityMetadata(this.$userId, this.$sessionId, this.$applicationId), false, 1, null)), this.$context, "REST: Spotify GetActivityMetadata", (Function1) null, new C02161(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        }
    }

    /* compiled from: SpotifyHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.integrations.SpotifyHelper$openPlayStoreForSpotify$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Context $context;

        public AnonymousClass1(Context context) {
            this.$context = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Closeable.closeFinally(new URL("https://app.adjust.com/ndjczk?campaign=" + this.$context.getPackageName()).openStream(), null);
            } catch (IOException e) {
                Log.w("SPOTIFY", "Couldn't open tracking url", e);
            }
        }
    }

    private SpotifyHelper() {
    }

    public static final /* synthetic */ void access$launchSpotifyIntent(SpotifyHelper spotifyHelper, Context context, Intent intent) {
        spotifyHelper.launchSpotifyIntent(context, intent);
    }

    private final void launchSpotifyIntent(Context context, Intent intent) {
        try {
            intent.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + context.getPackageName()));
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            if (isSpotifyInstalled(context)) {
                return;
            }
            openPlayStoreForSpotify(context);
        }
    }

    public static final void registerSpotifyBroadcastReceivers(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        context.registerReceiver(new SpotifyMetadataReceiver(), new IntentFilter("com.spotify.music.metadatachanged"));
        context.registerReceiver(new SpotifyPlayingStateReceiver(), new IntentFilter("com.spotify.music.playbackstatechanged"));
    }

    private final void runIfSpotifyInstalled(Function0<Unit> action, Context context) {
        try {
            action.invoke();
        } catch (ActivityNotFoundException unused) {
            if (isSpotifyInstalled(context)) {
                return;
            }
            openPlayStoreForSpotify(context);
        }
    }

    public final boolean isSpotifyInstalled(Context context) throws PackageManager.NameNotFoundException {
        Intrinsics3.checkNotNullParameter(context, "context");
        try {
            context.getPackageManager().getPackageInfo(SPOTIFY_PACKAGE_NAME, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void launchAlbum(Context context, Activity activity, long userId, boolean isMe) {
        String sessionId;
        Long applicationId;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (isMe) {
            openSpotifyApp(context);
        } else {
            if (activity == null || (sessionId = activity.getSessionId()) == null || (applicationId = activity.getApplicationId()) == null) {
                return;
            }
            runIfSpotifyInstalled(new AnonymousClass1(userId, sessionId, applicationId.longValue(), context), context);
        }
    }

    public final void launchTrack(Context context, Activity activity) {
        String syncId;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (activity == null || (syncId = activity.getSyncId()) == null) {
            return;
        }
        INSTANCE.runIfSpotifyInstalled(new SpotifyHelper2(syncId, context), context);
    }

    public final void openPlayStoreForSpotify(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        new Thread(new AnonymousClass1(context)).start();
        UriHandler.handle$default(UriHandler.INSTANCE, context, "https://play.google.com/store/apps/details?id=com.spotify.music&utm_source=discord&utm_medium=mobile", false, false, null, 28, null);
    }

    public final void openSpotifyApp(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(SPOTIFY_PACKAGE_NAME);
        if (launchIntentForPackage != null) {
            context.startActivity(launchIntentForPackage);
        }
    }
}

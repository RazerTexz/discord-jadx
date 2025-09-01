package com.discord.utilities.media;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.LazyJVM;
import d0.Result2;
import d0.Result3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: AppSoundManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/discord/utilities/media/AppSoundManager;", "", "Lcom/discord/utilities/media/AppSound;", "sound", "", "play", "(Lcom/discord/utilities/media/AppSound;)V", "stop", "", "isPlaying", "(Lcom/discord/utilities/media/AppSound;)Z", "", "", "Lcom/discord/utilities/media/AppSoundManager$SoundPlayer;", "soundPlayers", "Ljava/util/Map;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "Provider", "SoundPlayer", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AppSoundManager {
    private final Context context;
    private Map<Integer, SoundPlayer> soundPlayers;

    /* compiled from: AppSoundManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\b\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/media/AppSoundManager$Provider;", "", "Lcom/discord/utilities/media/AppSoundManager;", "get", "()Lcom/discord/utilities/media/AppSoundManager;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "INSTANCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Provider {
        public static final Provider INSTANCE = new Provider();

        /* renamed from: INSTANCE$delegate, reason: from kotlin metadata */
        private static final Lazy INSTANCE = LazyJVM.lazy(AppSoundManager3.INSTANCE);

        private Provider() {
        }

        private final AppSoundManager getINSTANCE() {
            return (AppSoundManager) INSTANCE.getValue();
        }

        public final AppSoundManager get() {
            return getINSTANCE();
        }
    }

    /* compiled from: AppSoundManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/discord/utilities/media/AppSoundManager$SoundPlayer;", "", "", "start", "()V", "stop", "release", "()Lkotlin/Unit;", "", "isPlaying", "()Z", "Landroid/media/MediaPlayer;", "mediaPlayer", "Landroid/media/MediaPlayer;", "Landroid/content/Context;", "context", "Lcom/discord/utilities/media/AppSound;", "sound", "Lkotlin/Function0;", "onCompletion", "<init>", "(Landroid/content/Context;Lcom/discord/utilities/media/AppSound;Lkotlin/jvm/functions/Function0;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class SoundPlayer {
        private MediaPlayer mediaPlayer;

        public SoundPlayer(Context context, AppSound appSound, Function0<Unit> function0) throws IllegalStateException, Resources.NotFoundException, IOException, IllegalArgumentException {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(appSound, "sound");
            Intrinsics3.checkNotNullParameter(function0, "onCompletion");
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(appSound.getContentType()).setUsage(appSound.getUsage()).build());
                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = context.getResources().openRawResourceFd(appSound.getResId());
                Intrinsics3.checkNotNullExpressionValue(assetFileDescriptorOpenRawResourceFd, "assetFileDescriptor");
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                mediaPlayer.setLooping(appSound.getShouldLoop());
                mediaPlayer.setOnCompletionListener(new AppSoundManager2(this, appSound, context, function0));
                try {
                    mediaPlayer.prepare();
                } catch (IOException unused) {
                    this.mediaPlayer = null;
                }
            }
        }

        public final boolean isPlaying() {
            Object objM97constructorimpl;
            try {
                Result2.a aVar = Result2.j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                boolean z2 = true;
                if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                    z2 = false;
                }
                objM97constructorimpl = Result2.m97constructorimpl(Boolean.valueOf(z2));
            } catch (Throwable th) {
                Result2.a aVar2 = Result2.j;
                objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
            }
            Throwable thM99exceptionOrNullimpl = Result2.m99exceptionOrNullimpl(objM97constructorimpl);
            if (thM99exceptionOrNullimpl != null) {
                AppLog.g.w("Error checking if MediaPlayer is playing", thM99exceptionOrNullimpl);
            }
            Boolean bool = Boolean.FALSE;
            if (Result2.m101isFailureimpl(objM97constructorimpl)) {
                objM97constructorimpl = bool;
            }
            return ((Boolean) objM97constructorimpl).booleanValue();
        }

        public final Unit release() {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer == null) {
                return null;
            }
            mediaPlayer.release();
            return Unit.a;
        }

        public final void start() {
            Object objM97constructorimpl;
            Unit unit;
            try {
                Result2.a aVar = Result2.j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                    unit = Unit.a;
                } else {
                    unit = null;
                }
                objM97constructorimpl = Result2.m97constructorimpl(unit);
            } catch (Throwable th) {
                Result2.a aVar2 = Result2.j;
                objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
            }
            Throwable thM99exceptionOrNullimpl = Result2.m99exceptionOrNullimpl(objM97constructorimpl);
            if (thM99exceptionOrNullimpl != null) {
                Logger.e$default(AppLog.g, "Error starting MediaPlayer in invalid state", thM99exceptionOrNullimpl, null, 4, null);
            }
        }

        public final void stop() {
            Object objM97constructorimpl;
            Unit unit;
            try {
                Result2.a aVar = Result2.j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    unit = Unit.a;
                } else {
                    unit = null;
                }
                objM97constructorimpl = Result2.m97constructorimpl(unit);
            } catch (Throwable th) {
                Result2.a aVar2 = Result2.j;
                objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
            }
            Throwable thM99exceptionOrNullimpl = Result2.m99exceptionOrNullimpl(objM97constructorimpl);
            if (thM99exceptionOrNullimpl != null) {
                AppLog.g.w("Called stop on uninitialized MediaPlayer", thM99exceptionOrNullimpl);
            }
        }
    }

    /* compiled from: AppSoundManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.media.AppSoundManager$play$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppSound $sound;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AppSound appSound) {
            super(0);
            this.$sound = appSound;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$sound.getShouldLoop()) {
                return;
            }
            AppSoundManager.this.stop(this.$sound);
        }
    }

    public AppSoundManager(Application application) {
        Intrinsics3.checkNotNullParameter(application, "application");
        this.context = application;
        this.soundPlayers = new LinkedHashMap();
    }

    public final boolean isPlaying(AppSound sound) {
        Intrinsics3.checkNotNullParameter(sound, "sound");
        return this.soundPlayers.containsKey(Integer.valueOf(sound.getResId()));
    }

    public final void play(AppSound sound) {
        Intrinsics3.checkNotNullParameter(sound, "sound");
        if (isPlaying(sound)) {
            SoundPlayer soundPlayer = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
            if (soundPlayer != null) {
                soundPlayer.stop();
            }
            SoundPlayer soundPlayer2 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
            if (soundPlayer2 != null) {
                soundPlayer2.release();
            }
        }
        this.soundPlayers.put(Integer.valueOf(sound.getResId()), new SoundPlayer(this.context, sound, new AnonymousClass1(sound)));
        SoundPlayer soundPlayer3 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (soundPlayer3 != null) {
            soundPlayer3.start();
        }
    }

    public final void stop(AppSound sound) {
        SoundPlayer soundPlayer;
        Intrinsics3.checkNotNullParameter(sound, "sound");
        SoundPlayer soundPlayer2 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (soundPlayer2 != null && soundPlayer2.isPlaying() && (soundPlayer = this.soundPlayers.get(Integer.valueOf(sound.getResId()))) != null) {
            soundPlayer.stop();
        }
        SoundPlayer soundPlayer3 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (soundPlayer3 != null) {
            soundPlayer3.release();
        }
        this.soundPlayers.remove(Integer.valueOf(sound.getResId()));
    }
}

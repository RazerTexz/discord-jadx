package com.discord.utilities.media;

import android.content.Context;
import android.media.MediaPlayer;
import com.discord.utilities.media.AppSoundManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: AppSoundManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "it", "", "onCompletion", "(Landroid/media/MediaPlayer;)V", "com/discord/utilities/media/AppSoundManager$SoundPlayer$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.media.AppSoundManager$SoundPlayer$$special$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AppSoundManager2 implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function0 $onCompletion$inlined;
    public final /* synthetic */ AppSound $sound$inlined;
    public final /* synthetic */ AppSoundManager.SoundPlayer this$0;

    public AppSoundManager2(AppSoundManager.SoundPlayer soundPlayer, AppSound appSound, Context context, Function0 function0) {
        this.this$0 = soundPlayer;
        this.$sound$inlined = appSound;
        this.$context$inlined = context;
        this.$onCompletion$inlined = function0;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.$onCompletion$inlined.invoke();
    }
}

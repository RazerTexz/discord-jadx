package com.discord.stores;

import android.content.SharedPreferences;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreMediaSettings;
import com.discord.utilities.cache.SharedPreferenceExtensions;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;

/* compiled from: VoiceConfigurationCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/stores/VoiceConfigurationCache;", "", "Lcom/discord/stores/StoreMediaSettings$NoiseProcessing;", "readNoiseProcessing", "()Lcom/discord/stores/StoreMediaSettings$NoiseProcessing;", "Lcom/discord/stores/StoreMediaSettings$VadUseKrisp;", "readVadUseKrisp", "()Lcom/discord/stores/StoreMediaSettings$VadUseKrisp;", "value", "", "intFromNoiseProcessing", "(Lcom/discord/stores/StoreMediaSettings$NoiseProcessing;)I", "", "booleanFromVadUseKrisp", "(Lcom/discord/stores/StoreMediaSettings$VadUseKrisp;)Z", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "read", "()Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "voiceConfiguration", "", "write", "(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;)V", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VoiceConfigurationCache {
    private final SharedPreferences sharedPreferences;

    /* compiled from: VoiceConfigurationCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "key", "value", "Lkotlin/Pair;", "", "Lcom/discord/primitives/UserId;", "", "invoke", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.VoiceConfigurationCache$read$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<String, String, Tuples2<? extends Long, ? extends Boolean>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Tuples2<? extends Long, ? extends Boolean> invoke(String str, String str2) {
            return invoke2(str, str2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Tuples2<Long, Boolean> invoke2(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "key");
            Intrinsics3.checkNotNullParameter(str2, "value");
            return Tuples.to(Long.valueOf(Long.parseLong(str)), Boolean.valueOf(Boolean.parseBoolean(str2)));
        }
    }

    /* compiled from: VoiceConfigurationCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "key", "value", "Lkotlin/Pair;", "", "Lcom/discord/primitives/UserId;", "", "invoke", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.VoiceConfigurationCache$read$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<String, String, Tuples2<? extends Long, ? extends Float>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Tuples2<? extends Long, ? extends Float> invoke(String str, String str2) {
            return invoke2(str, str2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Tuples2<Long, Float> invoke2(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "key");
            Intrinsics3.checkNotNullParameter(str2, "value");
            return Tuples.to(Long.valueOf(Long.parseLong(str)), Float.valueOf(Float.parseFloat(str2)));
        }
    }

    public VoiceConfigurationCache(SharedPreferences sharedPreferences) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.sharedPreferences = sharedPreferences;
    }

    private final boolean booleanFromVadUseKrisp(StoreMediaSettings.VadUseKrisp value) {
        return value != StoreMediaSettings.VadUseKrisp.Disabled;
    }

    private final int intFromNoiseProcessing(StoreMediaSettings.NoiseProcessing value) {
        return value == StoreMediaSettings.NoiseProcessing.CancellationTemporarilyDisabled ? StoreMediaSettings.NoiseProcessing.Cancellation.ordinal() : value.ordinal();
    }

    private final StoreMediaSettings.NoiseProcessing readNoiseProcessing() {
        try {
            return StoreMediaSettings.NoiseProcessing.values()[this.sharedPreferences.getInt("CACHE_KEY_VOICE_SETTINGS_NOISE_PROCESSING", StoreMediaSettings.VoiceConfiguration.INSTANCE.getDEFAULT_NOISE_PROCESSING())];
        } catch (Exception unused) {
            return StoreMediaSettings.NoiseProcessing.Cancellation;
        }
    }

    private final StoreMediaSettings.VadUseKrisp readVadUseKrisp() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        StoreMediaSettings.VadUseKrisp vadUseKrisp = StoreMediaSettings.VoiceConfiguration.INSTANCE.getDEFAULT_VOICE_CONFIG().getVadUseKrisp();
        StoreMediaSettings.VadUseKrisp vadUseKrisp2 = StoreMediaSettings.VadUseKrisp.Enabled;
        return sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_VAD_USE_KRISP", vadUseKrisp == vadUseKrisp2) ? vadUseKrisp2 : StoreMediaSettings.VadUseKrisp.Disabled;
    }

    public final StoreMediaSettings.VoiceConfiguration read() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        StoreMediaSettings.VoiceConfiguration.Companion companion = StoreMediaSettings.VoiceConfiguration.INSTANCE;
        boolean z2 = sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_IS_MUTED", companion.getDEFAULT_VOICE_CONFIG().isSelfMuted());
        boolean z3 = this.sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_IS_DEAFENED", companion.getDEFAULT_VOICE_CONFIG().isSelfDeafened());
        boolean z4 = this.sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_AUTOMATIC_VAD", companion.getDEFAULT_VOICE_CONFIG().getAutomaticVad());
        StoreMediaSettings.VadUseKrisp vadUseKrisp = readVadUseKrisp();
        boolean z5 = this.sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_AUTOMATIC_GAIN_CONTROL", companion.getDEFAULT_VOICE_CONFIG().getAutomaticGainControl());
        boolean z6 = this.sharedPreferences.getBoolean("CACHE_KEY_VOICE_SETTINGS_ECHO_CANCELLATION", companion.getDEFAULT_VOICE_CONFIG().getEchoCancellation());
        StoreMediaSettings.NoiseProcessing noiseProcessing = readNoiseProcessing();
        float f = this.sharedPreferences.getFloat("CACHE_KEY_VOICE_SETTINGS_SENSITIVITY", companion.getDEFAULT_VOICE_CONFIG().getSensitivity());
        MediaEngineConnection.InputMode.Companion companion2 = MediaEngineConnection.InputMode.INSTANCE;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        MediaEngineConnection.InputMode inputMode = MediaEngineConnection.InputMode.VOICE_ACTIVITY;
        int i = sharedPreferences2.getInt("CACHE_KEY_VOICE_SETTINGS_INPUT_MODE", inputMode.getNumeral());
        Objects.requireNonNull(companion2);
        return new StoreMediaSettings.VoiceConfiguration(z2, z3, z4, vadUseKrisp, z5, z6, noiseProcessing, f, (i == 1 || i != 2) ? inputMode : MediaEngineConnection.InputMode.PUSH_TO_TALK, this.sharedPreferences.getFloat("CACHE_KEY_VOICE_SETTINGS_OUTPUT_VOLUME", companion.getDEFAULT_VOICE_CONFIG().getOutputVolume()), SharedPreferenceExtensions.getStringEntrySetAsMap$default(this.sharedPreferences, "MUTED_USERS_V2", null, AnonymousClass1.INSTANCE, 2, null), SharedPreferenceExtensions.getStringEntrySetAsMap$default(this.sharedPreferences, "USER_OUTPUT_VOLUMES_V2", null, AnonymousClass2.INSTANCE, 2, null), null, this.sharedPreferences.getBoolean("VIDEO_ENABLE_HARDWARE_SCALING", companion.getDEFAULT_VOICE_CONFIG().getEnableVideoHardwareScaling()), this.sharedPreferences.getBoolean("CACHE_KEY_HIDE_VOICE_PARTICIPANTS", companion.getDEFAULT_VOICE_CONFIG().getVoiceParticipantsHidden()), 4096, null);
    }

    public final void write(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
        Intrinsics3.checkNotNullParameter(voiceConfiguration, "voiceConfiguration");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_IS_MUTED", voiceConfiguration.isSelfMuted());
        editorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_IS_DEAFENED", voiceConfiguration.isSelfDeafened());
        editorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_AUTOMATIC_VAD", voiceConfiguration.getAutomaticVad());
        editorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_VAD_USE_KRISP", booleanFromVadUseKrisp(voiceConfiguration.getVadUseKrisp()));
        editorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_AUTOMATIC_GAIN_CONTROL", voiceConfiguration.getAutomaticGainControl());
        editorEdit.putInt("CACHE_KEY_VOICE_SETTINGS_NOISE_PROCESSING", intFromNoiseProcessing(voiceConfiguration.getNoiseProcessing()));
        editorEdit.putBoolean("CACHE_KEY_VOICE_SETTINGS_ECHO_CANCELLATION", voiceConfiguration.getEchoCancellation());
        editorEdit.putFloat("CACHE_KEY_VOICE_SETTINGS_SENSITIVITY", voiceConfiguration.getSensitivity());
        editorEdit.putInt("CACHE_KEY_VOICE_SETTINGS_INPUT_MODE", voiceConfiguration.getInputMode().getNumeral());
        editorEdit.putFloat("CACHE_KEY_VOICE_SETTINGS_OUTPUT_VOLUME", voiceConfiguration.getOutputVolume());
        SharedPreferenceExtensions.putStringEntrySetAsMap$default(editorEdit, "MUTED_USERS_V2", voiceConfiguration.getMutedUsers(), null, null, 12, null);
        SharedPreferenceExtensions.putStringEntrySetAsMap$default(editorEdit, "USER_OUTPUT_VOLUMES_V2", voiceConfiguration.getUserOutputVolumes(), null, null, 12, null);
        editorEdit.putBoolean("VIDEO_ENABLE_HARDWARE_SCALING", voiceConfiguration.getEnableVideoHardwareScaling());
        editorEdit.putBoolean("CACHE_KEY_HIDE_VOICE_PARTICIPANTS", voiceConfiguration.getVoiceParticipantsHidden());
        editorEdit.apply();
    }
}

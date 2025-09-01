package b.i.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.provider.Settings;
import b.i.a.c.b3.TextOutput;
import b.i.a.c.b3.TextRenderer;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.MediaCodecVideoRenderer;
import b.i.a.c.g3.VideoRendererEventListener2;
import b.i.a.c.g3.z.CameraMotionRenderer;
import b.i.a.c.t2.AudioCapabilities;
import b.i.a.c.t2.AudioRendererEventListener2;
import b.i.a.c.t2.MediaCodecAudioRenderer;
import b.i.a.c.y2.DefaultMediaCodecAdapterFactory;
import b.i.a.c.y2.MediaCodecSelector;
import b.i.a.c.z2.MetadataOutput;
import b.i.a.c.z2.MetadataRenderer;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import java.util.ArrayList;

/* compiled from: DefaultRenderersFactory.java */
/* renamed from: b.i.a.c.b1, reason: use source file name */
/* loaded from: classes3.dex */
public class DefaultRenderersFactory implements RenderersFactory {
    public final Context a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultMediaCodecAdapterFactory f836b = new DefaultMediaCodecAdapterFactory();
    public MediaCodecSelector c;

    public DefaultRenderersFactory(Context context) {
        this.a = context;
        int i = MediaCodecSelector.a;
        this.c = b.i.a.c.y2.k.f1305b;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    @Override // b.i.a.c.RenderersFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Renderer2[] a(Handler handler, VideoRendererEventListener2 videoRendererEventListener2, AudioRendererEventListener2 audioRendererEventListener2, TextOutput textOutput, MetadataOutput metadataOutput) {
        boolean z2;
        AudioCapabilities audioCapabilities;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaCodecVideoRenderer(this.a, this.f836b, this.c, 5000L, false, handler, videoRendererEventListener2, 50));
        Context context = this.a;
        AudioCapabilities audioCapabilities2 = AudioCapabilities.a;
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        int i = Util2.a;
        if (i >= 17) {
            String str = Util2.c;
            z2 = "Amazon".equals(str) || "Xiaomi".equals(str);
        }
        if (z2 && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            audioCapabilities = AudioCapabilities.f1125b;
        } else if (i < 29) {
            audioCapabilities = (intentRegisterReceiver == null || intentRegisterReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? AudioCapabilities.a : new AudioCapabilities(intentRegisterReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), intentRegisterReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        } else {
            if (!Util2.A(context)) {
                if (i >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                }
            }
            audioCapabilities = new AudioCapabilities(AudioCapabilities.a.a(), 8);
        }
        arrayList.add(new MediaCodecAudioRenderer(this.a, this.f836b, this.c, false, handler, audioRendererEventListener2, new DefaultAudioSink(audioCapabilities, new DefaultAudioSink.d(new AudioProcessor[0]), false, false, 0)));
        arrayList.add(new TextRenderer(textOutput, handler.getLooper()));
        arrayList.add(new MetadataRenderer(metadataOutput, handler.getLooper()));
        arrayList.add(new CameraMotionRenderer());
        return (Renderer2[]) arrayList.toArray(new Renderer2[0]);
    }
}

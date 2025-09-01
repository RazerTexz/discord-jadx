package b.i.a.c;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.SimpleExoPlayer;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.AudioAttributes;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;

/* compiled from: AudioFocusManager.java */
/* renamed from: b.i.a.c.t0, reason: use source file name */
/* loaded from: classes3.dex */
public final class AudioFocusManager {
    public final AudioManager a;

    /* renamed from: b, reason: collision with root package name */
    public final a f1114b;

    @Nullable
    public b c;

    @Nullable
    public AudioAttributes d;
    public int e;
    public int f;
    public float g = 1.0f;
    public AudioFocusRequest h;

    /* compiled from: AudioFocusManager.java */
    /* renamed from: b.i.a.c.t0$a */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        public final Handler j;

        public a(Handler handler) {
            this.j = handler;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            this.j.post(new c(this, i));
        }
    }

    /* compiled from: AudioFocusManager.java */
    /* renamed from: b.i.a.c.t0$b */
    public interface b {
    }

    public AudioFocusManager(Context context, Handler handler, b bVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Objects.requireNonNull(audioManager);
        this.a = audioManager;
        this.c = bVar;
        this.f1114b = new a(handler);
        this.e = 0;
    }

    public final void a() {
        if (this.e == 0) {
            return;
        }
        if (Util2.a >= 26) {
            AudioFocusRequest audioFocusRequest = this.h;
            if (audioFocusRequest != null) {
                this.a.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            this.a.abandonAudioFocus(this.f1114b);
        }
        d(0);
    }

    public final void b(int i) {
        b bVar = this.c;
        if (bVar != null) {
            SimpleExoPlayer.b bVar2 = (SimpleExoPlayer.b) bVar;
            boolean zJ = SimpleExoPlayer.this.j();
            SimpleExoPlayer.this.m0(zJ, i, SimpleExoPlayer.g0(zJ, i));
        }
    }

    public void c(@Nullable AudioAttributes audioAttributes) {
        if (Util2.a(this.d, null)) {
            return;
        }
        this.d = null;
        this.f = 0;
        AnimatableValueParser.m(true, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final void d(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.g == f) {
            return;
        }
        this.g = f;
        b bVar = this.c;
        if (bVar != null) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.j0(1, 2, Float.valueOf(simpleExoPlayer.B * simpleExoPlayer.k.g));
        }
    }

    public int e(boolean z2, int i) {
        int iRequestAudioFocus;
        int i2 = 1;
        if (i == 1 || this.f != 1) {
            a();
            return z2 ? 1 : -1;
        }
        if (!z2) {
            return -1;
        }
        if (this.e != 1) {
            if (Util2.a >= 26) {
                AudioFocusRequest audioFocusRequest = this.h;
                if (audioFocusRequest == null) {
                    AudioFocusRequest.Builder builder = audioFocusRequest == null ? new AudioFocusRequest.Builder(this.f) : new AudioFocusRequest.Builder(this.h);
                    AudioAttributes audioAttributes = this.d;
                    boolean z3 = audioAttributes != null && audioAttributes.k == 1;
                    Objects.requireNonNull(audioAttributes);
                    this.h = builder.setAudioAttributes(audioAttributes.a()).setWillPauseWhenDucked(z3).setOnAudioFocusChangeListener(this.f1114b).build();
                }
                iRequestAudioFocus = this.a.requestAudioFocus(this.h);
            } else {
                AudioManager audioManager = this.a;
                a aVar = this.f1114b;
                AudioAttributes audioAttributes2 = this.d;
                Objects.requireNonNull(audioAttributes2);
                iRequestAudioFocus = audioManager.requestAudioFocus(aVar, Util2.t(audioAttributes2.m), this.f);
            }
            if (iRequestAudioFocus == 1) {
                d(1);
            } else {
                d(0);
                i2 = -1;
            }
        }
        return i2;
    }
}

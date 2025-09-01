package b.i.a.c;

import b.d.b.a.outline;
import b.i.a.c.AudioFocusManager;
import b.i.a.c.t2.AudioAttributes;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ AudioFocusManager.a j;
    public final /* synthetic */ int k;

    public /* synthetic */ c(AudioFocusManager.a aVar, int i) {
        this.j = aVar;
        this.k = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioFocusManager.a aVar = this.j;
        int i = this.k;
        AudioFocusManager audioFocusManager = AudioFocusManager.this;
        Objects.requireNonNull(audioFocusManager);
        if (i == -3 || i == -2) {
            if (i != -2) {
                AudioAttributes audioAttributes = audioFocusManager.d;
                if (!(audioAttributes != null && audioAttributes.k == 1)) {
                    audioFocusManager.d(3);
                    return;
                }
            }
            audioFocusManager.b(0);
            audioFocusManager.d(2);
            return;
        }
        if (i == -1) {
            audioFocusManager.b(-1);
            audioFocusManager.a();
        } else if (i != 1) {
            outline.g0(38, "Unknown focus change type: ", i, "AudioFocusManager");
        } else {
            audioFocusManager.d(1);
            audioFocusManager.b(1);
        }
    }
}

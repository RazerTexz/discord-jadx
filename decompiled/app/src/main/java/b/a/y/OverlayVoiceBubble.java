package b.a.y;

import com.discord.stores.StoreVoiceParticipants;
import j0.k.Func1;
import java.util.Iterator;
import java.util.Map;

/* compiled from: OverlayVoiceBubble.kt */
/* renamed from: b.a.y.v, reason: use source file name */
/* loaded from: classes2.dex */
public final class OverlayVoiceBubble<T, R> implements Func1<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, StoreVoiceParticipants.VoiceUser> {
    public static final OverlayVoiceBubble j = new OverlayVoiceBubble();

    @Override // j0.k.Func1
    public StoreVoiceParticipants.VoiceUser call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map) {
        T next;
        Iterator<T> it = map.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            }
            next = it.next();
            if (((StoreVoiceParticipants.VoiceUser) next).getIsSpeaking()) {
                break;
            }
        }
        return next;
    }
}

package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.calls.VideoCallParticipantView;

/* compiled from: VideoCallGridItemBinding.java */
/* renamed from: b.a.i.w1, reason: use source file name */
/* loaded from: classes.dex */
public final class VideoCallGridItemBinding implements ViewBinding {

    @NonNull
    public final VideoCallParticipantView a;

    public VideoCallGridItemBinding(@NonNull VideoCallParticipantView videoCallParticipantView) {
        this.a = videoCallParticipantView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}

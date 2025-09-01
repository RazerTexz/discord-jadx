package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.stages.SpeakersAdapter2;

/* compiled from: ViewStageCardSpeakersBinding.java */
/* renamed from: b.a.i.v3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewStageCardSpeakersBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SpeakersAdapter2 f217b;

    public ViewStageCardSpeakersBinding(@NonNull View view, @NonNull SpeakersAdapter2 speakersAdapter2) {
        this.a = view;
        this.f217b = speakersAdapter2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}

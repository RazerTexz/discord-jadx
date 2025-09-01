package b.a.f;

import android.view.View;
import com.discord.chips_view.ChipsView;

/* compiled from: ChipsView.kt */
/* renamed from: b.a.f.g, reason: use source file name */
/* loaded from: classes.dex */
public final class ChipsView3 implements View.OnClickListener {
    public final /* synthetic */ ChipsView j;

    public ChipsView3(ChipsView chipsView) {
        this.j = chipsView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.j.mEditText.requestFocus();
        this.j.f(null);
    }
}

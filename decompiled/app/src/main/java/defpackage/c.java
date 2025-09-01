package defpackage;

import android.view.View;
import com.discord.views.TernaryCheckBox;

/* compiled from: java-style lambda group */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public c(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            TernaryCheckBox ternaryCheckBox = (TernaryCheckBox) this.k;
            TernaryCheckBox.Companion aVar = TernaryCheckBox.INSTANCE;
            TernaryCheckBox.a(ternaryCheckBox, 1);
        } else if (i == 1) {
            TernaryCheckBox ternaryCheckBox2 = (TernaryCheckBox) this.k;
            TernaryCheckBox.Companion aVar2 = TernaryCheckBox.INSTANCE;
            TernaryCheckBox.a(ternaryCheckBox2, -1);
        } else {
            if (i != 2) {
                throw null;
            }
            TernaryCheckBox ternaryCheckBox3 = (TernaryCheckBox) this.k;
            TernaryCheckBox.Companion aVar3 = TernaryCheckBox.INSTANCE;
            TernaryCheckBox.a(ternaryCheckBox3, 0);
        }
    }
}

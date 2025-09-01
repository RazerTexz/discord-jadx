package b.a.y;

import android.view.View;
import com.discord.views.CodeVerificationView;

/* compiled from: CodeVerificationView.kt */
/* renamed from: b.a.y.c, reason: use source file name */
/* loaded from: classes2.dex */
public final class CodeVerificationView3 implements View.OnClickListener {
    public final /* synthetic */ CodeVerificationView j;

    public CodeVerificationView3(CodeVerificationView codeVerificationView) {
        this.j = codeVerificationView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CodeVerificationView.a(this.j);
    }
}

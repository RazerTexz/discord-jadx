package b.q.a;

import android.view.View;
import com.yalantis.ucrop.UCropActivity;

/* compiled from: UCropActivity.java */
/* renamed from: b.q.a.e, reason: use source file name */
/* loaded from: classes3.dex */
public class UCropActivity5 implements View.OnClickListener {
    public final /* synthetic */ UCropActivity j;

    public UCropActivity5(UCropActivity uCropActivity) {
        this.j = uCropActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UCropActivity uCropActivity = this.j;
        uCropActivity.w.k(90);
        uCropActivity.w.setImageToWrapCropBounds(true);
    }
}

package b.b.a.a;

import android.util.Log;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: FlexInputFragment.kt */
/* loaded from: classes3.dex */
public final class j extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ FlexInputFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(FlexInputFragment flexInputFragment) {
        super(1);
        this.this$0 = flexInputFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        try {
            FlexInputFragment.g(this.this$0, num.intValue());
        } catch (Exception e) {
            Log.d(FlexInputFragment.k, "Could not open AddContentDialogFragment", e);
        }
        return Unit.a;
    }
}
